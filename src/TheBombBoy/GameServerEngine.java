package TheBombBoy;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class GameServerEngine extends Thread{
	Socket s;
	BufferedReader reader;
	PrintWriter writer;
	GameServer GS;
	Boolean Thread_ToF = true;
	String tryId;
	String Id;
	String Pw;
	String Name;
	int Level;
	String Alias;
	int Stage;
	int Coin;
	int Avatar;
	int QuiteNum = 0;
	String MyRoomName;
	String JoinRoomName;
	
	GameServerEngine(Socket s, GameServer GS){
		this.s = s;
		this.GS = GS;
		try {
			reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			writer = new PrintWriter(s.getOutputStream(), true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			while(Thread_ToF) {
				
				String message = reader.readLine();
				String[] messageCut = message.split("/c;");
				
				switch(messageCut[0]) {
				case "Login" :
					tryId = messageCut[1];
					boolean LoginCheck = GS.GUD.LoginUser(messageCut[1], messageCut[2]);
					
					if(LoginCheck == true) {
						
						StringBuffer CheckSuccess = new StringBuffer("ChSu/c;");
						
						ArrayList<GameUser> GUList = GS.GUD.InputUser(messageCut[1]);
						
						for(GameUser gu : GUList ) {
							Id = gu.getUserid();
							Pw = gu.getUserpw();
							Name = gu.getUsername();
							Level = gu.getUserlevel();
							Alias = gu.getUseralias();
							Stage = gu.getUserStage();
							Coin = gu.getUsercoin();
							Avatar = gu.getUseravatar();
						}
						
						for(GameServerEngine ese : GS.GSEList) {
							if(ese.tryId.equals(Id)) {
								CheckSuccess.append(Id+"/c;"+Pw+"/c;"+Name+"/c;"+Level+"/c;"+
													Alias+"/c;"+Stage+"/c;"+Coin+"/c;"+Avatar);
								System.out.println(CheckSuccess);
								ese.writeMessage(CheckSuccess.toString());
							}
						}
						
					}else {
						System.out.println("유저의 정보가 맞지 않습니다.");
						for(GameServerEngine ese : GS.GSEList) {
							if(ese.tryId.equals(Id)) {
								ese.writeMessage("ChFF/c;failded");
							}
						}
					}
					break;
					
				case "chId":
					tryId = messageCut[1];
					
					boolean CTID = GS.GUD.CheckUser(messageCut[1]);
					if(CTID == false) {
						GS.GUD.SignUpUser(messageCut[1], messageCut[2], messageCut[3]);
						writeMessage("CTIDok/c;Success");
					}else {
						writeMessage("CTIDno/c;faild");
					}
					
					break;
					
				case "UpLe":
					GS.GUD.updateLevel( Integer.parseInt(messageCut[1]), messageCut[2]);
					break;
					
				case "UpSt":
					GS.GUD.updateStage(Integer.parseInt(messageCut[1]), messageCut[2]);
					break;
					
				case "UpAl":
					GS.GUD.updateAlias(messageCut[1], messageCut[2]);
					break;
					
				case "UpNa":
					GS.GUD.updateName(messageCut[1], messageCut[2]);
					boolean ChePas = GS.GUD.LoginUser(messageCut[1], messageCut[2]);
					if(ChePas == true) {
						GS.GUD.updatePw(messageCut[3], messageCut[1]);
						writer.println("UpNaok/c;UpdateOk");
					}else {
						writer.println("UpNaok/c;UpdateNo");
					}
					break;
					
				case "UpAv":
					GS.GUD.updateAvatar(Integer.parseInt(messageCut[1]), Integer.parseInt(messageCut[2]),
										Integer.parseInt(messageCut[3]), messageCut[4]);
					break;
					
				case "UpCo":
					GS.GUD.updateCoin(Integer.parseInt(messageCut[1]), Integer.parseInt(messageCut[2]), messageCut[3]);
					break;
					
				case "UpdInfo":
					StringBuffer updateinfo = new StringBuffer("UpIf/c;");
					ArrayList<GameUser> GUList = GS.GUD.InputUser(messageCut[1]);
					
					for(GameUser gu : GUList ) {
						Id = gu.getUserid();
						Pw = gu.getUserpw();
						Name = gu.getUsername();
						Level = gu.getUserlevel();
						Alias = gu.getUseralias();
						Stage = gu.getUserStage();
						Coin = gu.getUsercoin();
						Avatar = gu.getUseravatar();
					}
					
					for(GameServerEngine ese : GS.GSEList) {
						if(ese.tryId.equals(Id)) {
							updateinfo.append(Id+"/c;"+Pw+"/c;"+Name+"/c;"+Level+"/c;"+
												Alias+"/c;"+Stage+"/c;"+Coin+"/c;"+Avatar);
							ese.writeMessage(updateinfo.toString());
						}
					}
					System.out.println(tryId+", "+Coin);
					break;
					
				case "join" : 
					returnMessage(message);
					break;
					
				case "speak":
					returnMessage(message);
					break;
					
				case "left" :
					returnMessage(message);
					break;
					
				case "BPjoin" :
					String joinName = messageCut[1];
					GS.Namelist.add(joinName+"/c;");
					BPjoinList();
					BPCreateRoom();
					break;
					
				case "BPexite":
					String exiteName = messageCut[1];
					GS.Namelist.remove(exiteName+"/c;");
					BPexiteList();
					break;
					
				case "BPCRoom":
					MyRoomName = messageCut[1];
					GS.RoomList.add(MyRoomName+"/c;");
					BPCreateRoom();
					break;
					
				case "BPJRoom":
					JoinRoomName = messageCut[1];
					BPJoinRoom();
					break;
					
				case "BPwelcom" :
					String joinUserId = messageCut[1].toString();
					BPwelcomMyRoom(joinUserId);
					break;
					
				case "QuiteGame":
					QuiteNum = 1;
					break;
				}
				
				if(QuiteNum == 1) {
					break;
				}
				
			}
		} catch (IOException e) {
			System.out.println("오류");
		} finally {
			try {
				if(QuiteNum == 1) {
					System.out.println("==================< S >=================");
					System.out.println(GS.GSEList);
					GS.GSEList.remove(this);
					System.out.println(GS.GSEList);
					GS.Namelist.remove(Id+"/c;");
					BPexiteList();
					reader.close();
					writer.close();
					s.close();
					Thread_ToF = false;
					System.out.println("==================< E >=================");
					return;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	void BPjoinList() {
		StringBuffer BPlist = new StringBuffer("BPjoin/c;");
		
		for(String name : GS.Namelist) {
			BPlist.append(name);
		}
		returnMessage(BPlist.toString());
	}
	
	void BPexiteList() {
		StringBuffer BPlist = new StringBuffer("BPexite/c;");
		
		for(String name : GS.Namelist) {
			BPlist.append(name);
		}
		returnMessage(BPlist.toString());
	}
	
	void BPCreateRoom() {
		StringBuffer BPRlist = new StringBuffer("BPCR/c;");
		for(String room : GS.RoomList) {
			BPRlist.append(room);
		}
		returnMessage(BPRlist.toString());
	}
	
	void BPJoinRoom() {
		StringBuffer BPJoinUser = new StringBuffer("BPJU/c;");
		for(GameServerEngine gse : GS.GSEList) {
			if(gse.MyRoomName.equals(JoinRoomName)) {
				BPJoinUser.append(Id+"/c;"+Name+"/c;"+Level+"/c;"+Alias+"/c;"+Avatar);
				gse.writeMessage(BPJoinUser.toString());
				System.out.println(JoinRoomName+"과, ? "+Id+", 그리고, "+Name +"또한, 디어..."+gse.Name+"에게..");
			}
		}
	}
	
	void BPwelcomMyRoom(String joinUserId) {
		StringBuffer BPwel = new StringBuffer("BPwel/c;");
		for(GameServerEngine gse : GS.GSEList) {
			System.out.println(GS.GSEList+"입니다.");
			if(gse.Id.equals(joinUserId)) {
				BPwel.append(Id+"/c;"+Name+"/c;"+Level+"/c;"+Alias+"/c;"+Avatar);
				gse.writeMessage(BPwel.toString());
				System.out.println("보내는 과정이 이것입니다. : "+BPwel.toString());
			}
		}
	}
	
	void returnMessage(String message) {
		for(GameServerEngine GSE : GS.GSEList) {
			GSE.writeMessage(message);
		}
	}
	
	void writeMessage(String Message){
		writer.println(Message);
	}

}
