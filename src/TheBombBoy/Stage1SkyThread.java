package TheBombBoy;

import javax.swing.ImageIcon;

public class Stage1SkyThread implements Runnable {
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Stage1SkyThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Stage1Sky.setIcon(new ImageIcon(ingame.ssg.makeSky1()));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Stage1Sky.setIcon(new ImageIcon(ingame.ssg.makeSky2()));
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Stage1Sky.setIcon(new ImageIcon(ingame.ssg.makeSky1()));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Stage1Sky.setIcon(new ImageIcon(ingame.ssg.makeSky2()));
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}