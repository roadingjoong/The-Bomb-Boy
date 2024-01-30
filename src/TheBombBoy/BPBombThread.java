package TheBombBoy;

import java.util.Random;

public class BPBombThread implements Runnable {
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Random random = new Random();
	int randomNum = 0;
	
	BPBombThread(InGame ingame){
		this.ingame = ingame;
	}
	
	@Override
	public void run() {
		while(Thread_ToF) {
			if(ingame.BPMyStandardPane.isVisible()==false && ingame.BPJoinStandardPane.isVisible()==false) {
				Thread_ToF = false;
				return;
			}
			
			if(ingame.BPBomb.getBounds().intersects(ingame.UserAvatar.getBounds())) {
				randomNum = random.nextInt(2)+1;
				ingame.touchBombNum = 1;
			}
			
			if(ingame.MyStandardStart == 1) {
				
				if(randomNum == 1) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x-5, ingame.BPBomb.getLocation().y-5);
				}else if(randomNum == 2) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x+5, ingame.BPBomb.getLocation().y-5);
				}else if(randomNum == 3) {
					ingame.BPBomb.setLocation(625,250);
				}else if(randomNum == 4) {
					ingame.BPBomb.setLocation(625,400);
				}
				
			}else if(ingame.JoinStandardStart == 1) {
				
				if(randomNum == 1) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x-5, ingame.BPBomb.getLocation().y+5);
				}else if(randomNum == 2) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x+5, ingame.BPBomb.getLocation().y+5);
				}else if(randomNum == 3) {
					ingame.BPBomb.setLocation(625,250);
				}else if(randomNum == 4) {
					ingame.BPBomb.setLocation(625,400);
				}
				
			}
			
			if(ingame.BPBomb.getBounds().intersects(ingame.OtherAvatar.getBounds())) {
				ingame.touchBombNum = 0;
			}
			
			if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame1.getBounds())) {
				randomNum = 2;
			}else if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame2.getBounds())) {
				randomNum = 1;
			}else if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame3.getBounds())) {
				randomNum = 3;
			}else if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame4.getBounds())) {
				randomNum = 4;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
