package TheBombBoy;

import javax.swing.ImageIcon;

public class Villain2Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Villain2Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.UserAvatar.isVisible() == false || ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2()));
			
			if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
				
				ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
				ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.Villain2.setVisible(false);
				ingame.Villain2.setLocation(0,0);
				
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
				ingame.setFocusable(false);
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ingame.UserAvatar.setVisible(false);
				ingame.	UserAvatar.setLocation(0, 200);
				
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x > 700 && ingame.Villain2.getLocation().y > 400) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_up()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x - 10, ingame.Villain2.getLocation().y - 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x > 600 && ingame.Villain2.getLocation().y < 500) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x - 10, ingame.Villain2.getLocation().y + 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
					ingame.setFocusable(false);
					ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.UserAvatar.setVisible(false);
					ingame.	UserAvatar.setLocation(0, 200);
					
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x > 500 && ingame.Villain2.getLocation().y > 400) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_up()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x - 10, ingame.Villain2.getLocation().y - 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x > 400 && ingame.Villain2.getLocation().y < 500) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x - 10, ingame.Villain2.getLocation().y + 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x > 300 && ingame.Villain2.getLocation().y > 400) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_up()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x - 10, ingame.Villain2.getLocation().y - 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x < 400 && ingame.Villain2.getLocation().y < 500) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x + 10, ingame.Villain2.getLocation().y + 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x < 500 && ingame.Villain2.getLocation().y > 400) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_up()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x + 10, ingame.Villain2.getLocation().y - 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x < 600 && ingame.Villain2.getLocation().y < 500) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x + 10, ingame.Villain2.getLocation().y + 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x < 700 && ingame.Villain2.getLocation().y > 400) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_up()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x + 10, ingame.Villain2.getLocation().y - 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(ingame.Villain2.getLocation().x < 800 && ingame.Villain2.getLocation().y < 500) {
				ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2()));
				ingame.Villain2.setLocation(ingame.Villain2.getLocation().x + 10, ingame.Villain2.getLocation().y + 10);
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
					ingame.Villain2.setIcon(new ImageIcon(ingame.vl2g.makeVillain2_die()));
					
					ingame.SaveVillain2_x = ingame.Villain2.getLocation().x;
					ingame.SaveVillain2_y = ingame.Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ingame.Villain2.setVisible(false);
					ingame.Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(ingame.Villain2.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}