package TheBombBoy;

import java.util.Random;

import javax.swing.ImageIcon;

public class Stage1BossThread implements Runnable {
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Random random = new Random();
	int BossRandomNum = 0;
	
	Stage1BossThread(InGame ingame){
		this.ingame = ingame;
	}

	public void run() {
		
		while(Thread_ToF) {
			
			ingame.Stage1Boss_dead = 0;
			
			if(ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain1.isVisible() == true || ingame.Villain2.isVisible() == true || ingame.Villain3.isVisible() == true) {
				while(ingame.Villain1.isVisible() == true || ingame.Villain2.isVisible() == true || ingame.Villain3.isVisible() == true) {
					
					if(ingame.hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					ingame.Stage1Boss.setVisible(false);
					ingame.Stage1Boss.setLocation(0,0);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			BossRandomNum = random.nextInt(8)+1;
			if(BossRandomNum == 1) {
				ingame.Stage1Boss.setLocation(1300,500);
			}else if(BossRandomNum == 2) {
				ingame.Stage1Boss.setLocation(1300,400);
			}else if(BossRandomNum == 3) {
				ingame.Stage1Boss.setLocation(1300,300);
			}else if(BossRandomNum == 4) {
				ingame.Stage1Boss.setLocation(1300,180);
			}else if(BossRandomNum == 5) {
				ingame.Stage1Boss.setLocation(-300,500);
			}else if(BossRandomNum == 6) {
				ingame.Stage1Boss.setLocation(-300,400);
			}else if(BossRandomNum == 7) {
				ingame.Stage1Boss.setLocation(-300,300);
			}else if(BossRandomNum == 8) {
				ingame.Stage1Boss.setLocation(-300,180);
			}
			
			ingame.Stage1Boss.setVisible(true);
			if(BossRandomNum == 1 || BossRandomNum == 2 || BossRandomNum == 3 || BossRandomNum == 4) {
				
				ingame.Stage1Boss.setIcon(new ImageIcon(ingame.s1b.makeBoss_left()));
				while(ingame.Stage1Boss.getLocation().x >= -300) {
					
					ingame.Stage1Boss.setLocation(ingame.Stage1Boss.getLocation().x - 10, ingame.Stage1Boss.getLocation().y);
					
					if(ingame.Stage1Boss.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.Stage1Boss.setIcon(new ImageIcon(ingame.s1b.makeBoss_left_die()));
						
						ingame.Stage1Boss_x = ingame.Stage1Boss.getLocation().x;
						ingame.Stage1Boss_y = ingame.Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ingame.Stage1Boss.setVisible(false);
						ingame.Stage1Boss.setLocation(0,0);
						ingame.Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(ingame.Stage1Boss.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
					
					if(ingame.hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}else if(BossRandomNum == 5 || BossRandomNum == 6 || BossRandomNum == 7 || BossRandomNum == 8) {
				
				ingame.Stage1Boss.setIcon(new ImageIcon(ingame.s1b.makeBoss_right()));
				
				while(ingame.Stage1Boss.getLocation().x <= 1300) {
					
					ingame.Stage1Boss.setLocation(ingame.Stage1Boss.getLocation().x + 10, ingame.Stage1Boss.getLocation().y);
					
					
					if(ingame.Stage1Boss.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.Stage1Boss.setIcon(new ImageIcon(ingame.s1b.makeBoss_right_die()));
						
						ingame.Stage1Boss_x = ingame.Stage1Boss.getLocation().x;
						ingame.Stage1Boss_y = ingame.Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ingame.Stage1Boss.setVisible(false);
						ingame.Stage1Boss.setLocation(0,0);
						ingame.Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(ingame.Stage1Boss.getBounds().intersects(ingame.UserAvatar.getBounds())) {
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
					
					if(ingame.hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}