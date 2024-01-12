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
				if(ingame.MessengerPane.isVisible() == false && ingame.BombPassLobbyPane.isVisible() == false) {
					Thread_ToF = false;
					return;
				}
				
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
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}