package TheBombBoy;

import javax.swing.ImageIcon;

public class Villain3Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Villain3Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3()));
			ingame.Villain3_Shot = 0;
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
				
				ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
				ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain3.setVisible(false);
				ingame.Villain3.setLocation(0,0);
				ingame.Villain3_Shot = 0;
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_up()));
			ingame.Villain3_Shot = 0;
			while(ingame.Villain3.getLocation().y > 400) {
				ingame.Villain3.setLocation(ingame.Villain3.getLocation().x, ingame.Villain3.getLocation().y - 10);
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
					
					ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
					ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain3.setVisible(false);
					ingame.Villain3.setLocation(0,0);
					ingame.Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				
				if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_left()));
			ingame.Villain3_Shot = 1;
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
				
				ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
				ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain3.setVisible(false);
				ingame.Villain3.setLocation(0,0);
				ingame.Villain3_Shot = 0;
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_up()));
			ingame.Villain3_Shot = 0;
			while(ingame.Villain3.getLocation().y > 300) {
				ingame.Villain3.setLocation(ingame.Villain3.getLocation().x, ingame.Villain3.getLocation().y - 10);
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
					
					ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
					ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain3.setVisible(false);
					ingame.Villain3.setLocation(0,0);
					ingame.Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				
				if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_left()));
			ingame.Villain3_Shot = 1;
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
				
				ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
				ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain3.setVisible(false);
				ingame.Villain3.setLocation(0,0);
				ingame.Villain3_Shot = 0;
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3()));
			ingame.Villain3_Shot = 0;
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
				
				ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
				ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain3.setVisible(false);
				ingame.Villain3.setLocation(0,0);
				ingame.Villain3_Shot = 0;
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3()));
			ingame.Villain3_Shot = 0;
			while(ingame.Villain3.getLocation().y < 400) {
				ingame.Villain3.setLocation(ingame.Villain3.getLocation().x, ingame.Villain3.getLocation().y + 10);
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
					
					ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
					ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain3.setVisible(false);
					ingame.Villain3.setLocation(0,0);
					ingame.Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				
				if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_left()));
			ingame.Villain3_Shot = 1;
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
				
				ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
				ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain3.setVisible(false);
				ingame.Villain3.setLocation(0,0);
				ingame.Villain3_Shot = 0;
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3()));
			ingame.Villain3_Shot = 0;
			while(ingame.Villain3.getLocation().y < 500) {
				ingame.Villain3.setLocation(ingame.Villain3.getLocation().x, ingame.Villain3.getLocation().y + 10);
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
					
					ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
					ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain3.setVisible(false);
					ingame.Villain3.setLocation(0,0);
					ingame.Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				
				if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_left()));
			ingame.Villain3_Shot = 1;
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain3.setIcon(new ImageIcon(ingame.vl3g.makeVillain3_die()));
				
				ingame.SaveVillain3_x = ingame.Villain3.getLocation().x;
				ingame.SaveVillain3_y = ingame.Villain3.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain3.setVisible(false);
				ingame.Villain3.setLocation(0,0);
				ingame.Villain3_Shot = 0;
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
			
			if(ingame.UserAvatar.isVisible() == false || ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}