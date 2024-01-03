package TheBombBoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameServerEngine extends Thread{
	Socket s;
	BufferedReader reader;
	PrintWriter writer;
	GameServer GS;
	
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
				case "join" : 
					GS.returnMessage(message);
					break;
					
				case "speak":
					GS.returnMessage(message);
					break;
					
				case "left" :
					GS.returnMessage(message);
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void writeMessage(String Message){
		writer.println(Message);
	}

}
