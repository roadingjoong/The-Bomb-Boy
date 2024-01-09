package TheBombBoy;

import java.io.IOException;

public 	class MessageReadThread implements Runnable{
	InGame ingame;
	MessageReadThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		try {
			while(true) {
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
				    
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}