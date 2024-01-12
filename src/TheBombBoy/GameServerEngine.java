package TheBombBoy;

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
	String tryId;
	String Id;
	String Pw;
	String Name;
	int Level;
	String Alias;
	int Stage;
	int Coin;
	int Avatar;
	
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
			while(true) {
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
					break;
					
				case "BPexite":
					String exiteName = messageCut[1];
					GS.Namelist.remove(exiteName+"/c;");
					BPexiteList();
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void LoginUser() {
		
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
	
	void returnMessage(String message) {
		for(GameServerEngine GSE : GS.GSEList) {
			GSE.writeMessage(message);
		}
	}
	
	void writeMessage(String Message){
		writer.println(Message);
	}

}
