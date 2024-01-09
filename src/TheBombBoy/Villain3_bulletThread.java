package TheBombBoy;

import javax.swing.ImageIcon;

public class Villain3_bulletThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Villain3_bulletThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.Villain3_bullet.setVisible(false);
				ingame.Villain3_bullet.setLocation(0,0);
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.isVisible() == false) {
				ingame.Villain3_bullet.setVisible(false);
				ingame.Villain3_bullet.setLocation(0,0);
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3_Shot == 1) {
				
				ingame.Villain3_bullet.setLocation(ingame.Villain3.getLocation().x, ingame.Villain3.getLocation().y + 40);
				ingame.Villain3_bullet.setVisible(true);
				
				while(ingame.Villain3_bullet.getLocation().x > 200) {
					
					if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
						ingame.Villain3_bullet.setVisible(false);
						ingame.Villain3_bullet.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(ingame.Villain3.isVisible() == false) {
						ingame.Villain3_bullet.setVisible(false);
						ingame.Villain3_bullet.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					ingame.Villain3_bullet.setLocation(ingame.Villain3_bullet.getLocation().x - 10, ingame.Villain3_bullet.getLocation().y);
					
					if(ingame.Villain3_bullet.getBounds().intersects(ingame.UserAvatar.getBounds())) {
						
						ingame.setFocusable(false);
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ingame.UserAvatar.setVisible(false);
						ingame.UserAvatar.setLocation(0, 200);
						
						ingame.Villain3_bullet.setVisible(false);
						ingame.Villain3_bullet.setLocation(0,0);
						Thread_ToF = false;
						return;
						
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}else {
				ingame.Villain3_bullet.setLocation(0,0);
				ingame.Villain3_bullet.setVisible(false);
				while(ingame.Villain3_Shot == 0) {
					
					if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
						ingame.Villain3_bullet.setVisible(false);
						ingame.Villain3_bullet.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
}