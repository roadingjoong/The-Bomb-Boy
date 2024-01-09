package TheBombBoy;

import javax.swing.ImageIcon;

public class GoldCoin3Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	GoldCoin3Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin3.setIcon(new ImageIcon(ingame.gc3g.makeGoldCoin()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin3.setIcon(new ImageIcon(ingame.gc3g.makeGoldCoin2()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin3.setIcon(new ImageIcon(ingame.gc3g.makeGoldCoin3()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}