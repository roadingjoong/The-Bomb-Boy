package TheBombBoy;

import javax.swing.ImageIcon;

public class GoldCoinThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	GoldCoinThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin.setIcon(new ImageIcon(ingame.gcg.makeGoldCoin()));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin.setIcon(new ImageIcon(ingame.gcg.makeGoldCoin2()));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.GoldCoin.setIcon(new ImageIcon(ingame.gcg.makeGoldCoin3()));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}