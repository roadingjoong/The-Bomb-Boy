package TheBombBoy;

import javax.swing.ImageIcon;

public class Villain1Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	Villain1Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.UserAvatar.isVisible() == false || ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1()));
			
			if(ingame.Villain1.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				
				ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_die()));
				
				ingame.SaveVillain1_x = ingame.Villain1.getLocation().x;
				ingame.SaveVillain1_y = ingame.Villain1.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain1.setVisible(false);
				ingame.Villain1.setLocation(0,0);
				
				Thread_ToF = false;
				return;
				
			}
			
			if(ingame.Villain1.getBounds().intersects(ingame.UserAvatar.getBounds())) {
				ingame.setFocusable(false);
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.UserAvatar.setVisible(false);
				ingame.UserAvatar.setLocation(0, 200);
				
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain1.getLocation().y > 180) {
				ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_up()));
				ingame.Villain1.setLocation(ingame.Villain1.getLocation().x, ingame.Villain1.getLocation().y - 10);
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					
					ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_die()));
					
					ingame.SaveVillain1_x = ingame.Villain1.getLocation().x;
					ingame.SaveVillain1_y = ingame.Villain1.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain1.setVisible(false);
					ingame.Villain1.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserAvatar.getBounds())) {
					ingame.setFocusable(false);
					ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.UserAvatar.setVisible(false);
					ingame.UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.UserAvatar.isVisible() == false || ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain1.getLocation().x > 200) {
				ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_left()));
				ingame.Villain1.setLocation(ingame.Villain1.getLocation().x - 10, ingame.Villain1.getLocation().y);
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					
					ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_die()));
					
					ingame.SaveVillain1_x = ingame.Villain1.getLocation().x;
					ingame.SaveVillain1_y = ingame.Villain1.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain1.setVisible(false);
					ingame.Villain1.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserAvatar.getBounds())) {
					ingame.setFocusable(false);
					ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.UserAvatar.setVisible(false);
					ingame.UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.UserAvatar.isVisible() == false || ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain1.getLocation().y < 300) {
				ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1()));
				ingame.Villain1.setLocation(ingame.Villain1.getLocation().x, ingame.Villain1.getLocation().y +10);
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					
					ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_die()));
					
					ingame.SaveVillain1_x = ingame.Villain1.getLocation().x;
					ingame.SaveVillain1_y = ingame.Villain1.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain1.setVisible(false);
					ingame.Villain1.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserAvatar.getBounds())) {
					ingame.setFocusable(false);
					ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.UserAvatar.setVisible(false);
					ingame.UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.UserAvatar.isVisible() == false || ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain1.getLocation().x < 700) {
				ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_right()));
				ingame.Villain1.setLocation(ingame.Villain1.getLocation().x + 10, ingame.Villain1.getLocation().y);
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					
					ingame.Villain1.setIcon(new ImageIcon(ingame.vl1g.makeVillain1_die()));
					
					ingame.SaveVillain1_x = ingame.Villain1.getLocation().x;
					ingame.SaveVillain1_y = ingame.Villain1.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain1.setVisible(false);
					ingame.Villain1.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain1.getBounds().intersects(ingame.UserAvatar.getBounds())) {
					ingame.setFocusable(false);
					ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.UserAvatar.setVisible(false);
					ingame.UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.UserAvatar.isVisible() == false || ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
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