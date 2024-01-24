package TheBombBoy;

import java.io.IOException;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class MessageReadThread implements Runnable{
	Boolean Thread_ToF = true;
	InGame ingame;
	MessageReadThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		try {
			while(Thread_ToF) {
				String message = ingame.reader.readLine();
				String[] messageCut = message.split("/c;");
				
				switch(messageCut[0]) {
				case "join" : 
					ingame.MessengerArea.append("\n ***** "+messageCut[1]+" has entered the room. ***** \n\n");
					break;
					
				case "speak":
					ingame.MessengerArea.append(" >> "+messageCut[1]+" : "+messageCut[2]+"\n");
					break;
					
				case "left":
					ingame.MessengerArea.append("\n ***** "+messageCut[1]+" has left the room. ***** \n\n");
				    break;
				    
				case "BPjoin":
					ingame.BPUserModel.removeAllElements();
					String[] BPUserlist1 = Arrays.copyOfRange(messageCut, 1, messageCut.length);
					ingame.BPUserModel.addAll(Arrays.asList(BPUserlist1));
					break;
					
				case "BPexite":
					ingame.BPUserModel.removeAllElements();
					String[] BPUserlist2 = Arrays.copyOfRange(messageCut, 1, messageCut.length);
					ingame.BPUserModel.addAll(Arrays.asList(BPUserlist2));
					break;
					
				case "BPCR":
					ingame.BPRoomModel.removeAllElements();
					String[] BPRoomlist = Arrays.copyOfRange(messageCut, 1, messageCut.length);
					ingame.BPRoomModel.addAll(Arrays.asList(BPRoomlist));
					break;
					
				case "BPJU" :
					ingame.OtherUserId = messageCut[1];
					ingame.OtherUserName = messageCut[2];
					ingame.OtherUserLevel = Integer.parseInt(messageCut[3]);
					ingame.OtherUserAlias = messageCut[4];
					ingame.OtherUserAvatar = Integer.parseInt(messageCut[5]);
					
					ingame.joinMyRoomOtherUser = 1;
					break;
					
				case "BPwel" : 
					ingame.OtherUserId = messageCut[1];
					ingame.OtherUserName = messageCut[2];
					ingame.OtherUserLevel = Integer.parseInt(messageCut[3]);
					ingame.OtherUserAlias = messageCut[4];
					ingame.OtherUserAvatar = Integer.parseInt(messageCut[5]);
					
					ingame.WelcomRoomOtherUser = 1;
					break;
					
				case "U1M" :
					int userX = Integer.parseInt(messageCut[1]);
					int userY = Integer.parseInt(messageCut[2]);
					int MoveN = Integer.parseInt(messageCut[3]);
					ingame.OtherAvatar.setLocation(userX, userY);
					if(ingame.OtherUserAvatar == 1) {
						if(MoveN == 1) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1()));
						}else if(MoveN == 2) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1_up()));
						}else if(MoveN == 3) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1_right()));
						}else if(MoveN == 4) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1_left()));
						}
					}else if(ingame.OtherUserAvatar == 2) {
						if(MoveN == 1) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2()));
						}else if(MoveN == 2) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2_up()));
						}else if(MoveN == 3) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2_right()));
						}else if(MoveN == 4) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2_left()));
						}
					}else if(ingame.OtherUserAvatar == 3) {
						if(MoveN == 1) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3()));
						}else if(MoveN == 2) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3_up()));
						}else if(MoveN == 3) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3_right()));
						}else if(MoveN == 4) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3_left()));
						}
					}else if(ingame.OtherUserAvatar == 4) {
						if(MoveN == 1) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4()));
						}else if(MoveN == 2) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4_up()));
						}else if(MoveN == 3) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4_right()));
						}else if(MoveN == 4) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4_left()));
						}
					}else if(ingame.OtherUserAvatar == 5) {
						if(MoveN == 1) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5()));
						}else if(MoveN == 2) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5_up()));
						}else if(MoveN == 3) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5_right()));
						}else if(MoveN == 4) {
							ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5_left()));
						}
					}
					
					break;
					
				case "ChSu" :
					ingame.InformationId = messageCut[1];
					ingame.InformationPw = messageCut[2];
					ingame.InformationName = messageCut[3];
					ingame.InformationLevel = Integer.parseInt(messageCut[4]);
					ingame.InformationAlias = messageCut[5];
					ingame.InformationStage = Integer.parseInt(messageCut[6]);
					ingame.InformationCoin = Integer.parseInt(messageCut[7]);
					ingame.InformationAvatar = Integer.parseInt(messageCut[8]);
					
					ingame.LoginCollectNum = 1;
					break;
					
				case "ChFF":
					ingame.LoginCollectNum = 2;
					break;
					
				case "CTIDok":
					ingame.signCollectNum = 1;
					break;
					
				case "CTIDno":
					ingame.signCollectNum = 2;
					break;
				case "UpIf":
					ingame.InformationId = messageCut[1];
					ingame.InformationPw = messageCut[2];
					ingame.InformationName = messageCut[3];
					ingame.InformationLevel = Integer.parseInt(messageCut[4]);
					ingame.InformationAlias = messageCut[5];
					ingame.InformationStage = Integer.parseInt(messageCut[6]);
					ingame.InformationCoin = Integer.parseInt(messageCut[7]);
					ingame.InformationAvatar = Integer.parseInt(messageCut[8]);
					
					ingame.updateinfNum = 1;
					break;
					
				case "UpNaok":
					ingame.updatePsNum = 1;
					break;
					
				case "UpNano":
					ingame.updatePsNum = 2;
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}