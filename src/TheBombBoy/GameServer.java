package TheBombBoy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer{
	ServerSocket ss;
	List<GameServerEngine> GSEList;
	
	GameServer(){
		GSEList = new ArrayList<GameServerEngine>();
		
		try {
			ss = new ServerSocket(7777);
			
			Socket s = new Socket();
			
			while(true) {
				s = ss.accept();
				System.out.println("클라이언트 한개 연결성공");
				
				GameServerEngine GSE = new GameServerEngine(s, this);
				
				GSE.start();
				
				GSEList.add(GSE);
			}
			
		} catch (IOException e) {
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e1) {
					System.out.println("서버소켓 닫기 실패");
				}
			}
		}
	}
	
	void returnMessage(String message) {
		for(GameServerEngine GSE : GSEList) {
			GSE.writeMessage(message);
		}
	}
	public static void main(String[] args) {
		new GameServer();
	}
}
