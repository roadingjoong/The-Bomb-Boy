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
	String Id;
	
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
