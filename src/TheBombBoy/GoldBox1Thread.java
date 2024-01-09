package TheBombBoy;

import javax.swing.ImageIcon;

public class GoldBox1Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	GoldBox1Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldBox1.setIcon(new ImageIcon(ingame.gb1g.makeGoldBox1()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldBox1.setIcon(new ImageIcon(ingame.gb1g.makeGoldBox2()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldBox1.setIcon(new ImageIcon(ingame.gb1g.makeGoldBox3()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}