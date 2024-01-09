package TheBombBoy;

import javax.swing.ImageIcon;

public class GoldCoin2Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	GoldCoin2Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin2.setIcon(new ImageIcon(ingame.gc2g.makeGoldCoin()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin2.setIcon(new ImageIcon(ingame.gc2g.makeGoldCoin2()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin2.setIcon(new ImageIcon(ingame.gc2g.makeGoldCoin3()));
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}