package TheBombBoy;

import java.io.IOException;
import java.util.Arrays;

public class MessageReadThread implements Runnable{
	Boolean Thread_ToF = true;
	InGame ingame;
	MessageReadThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		try {
			while(Thread_ToF) {
				System.out.println("마이턴");
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
				case "ChSu":
					System.out.println("오나료완료");
					ingame.InformationId = messageCut[1];
					ingame.InformationPw = messageCut[2];
					ingame.InformationName = messageCut[3];
					ingame.InformationLevel = Integer.parseInt(messageCut[4]);
					ingame.InformationAlias = messageCut[5];
					ingame.InformationStage = Integer.parseInt(messageCut[6]);
					ingame.InformationCoin = Integer.parseInt(messageCut[7]);
					ingame.InformationAvatar = Integer.parseInt(messageCut[8]);
					ingame.LoginCollectNum = 1;
					
					System.out.println(ingame.InformationName+"이야이야호");
					break;
				case "ChFF":
					ingame.LoginCollectNum = 2;
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}