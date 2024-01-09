package TheBombBoy;

import javax.swing.ImageIcon;

public class UserBombThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	UserBombThread(InGame ingame){
		this.ingame = ingame;
	}

	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			while(ingame.BombTime == 0) {
				
				if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			ingame.UserBomb.setIcon(new ImageIcon(ingame.mb.makeBomb1()));
			ingame.UserBomb.setVisible(true);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.UserBomb.setIcon(new ImageIcon(ingame.mb.makeBomb2()));
			ingame.BombTime = 2;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.UserBomb.setVisible(false);
			ingame.BombTime = 0;
			
		}
		
	}
	
}
