package TheBombBoy;

import java.util.Random;

import javax.swing.ImageIcon;

public class Villain4Thread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Random random = new Random();
	int randomX = 0;
	int randomY = 0;
	
	Villain4Thread(InGame ingame){
		this.ingame = ingame;
	}
	
	@Override
	public void run() { //랜덤값을 통해 정해진 x,y 좌표가 되도록 x,y 값을 반복을 통하여 조정시키게 하고, 값이 동일하게 되면 새로 반복
		while(Thread_ToF) {
			if(ingame.easy2start == 0) {
				Thread_ToF = false;
				return;
			}
			
			randomX = random.nextInt(70)*10;
			randomY = random.nextInt(50)*10;
			
			if(ingame.Villain4.getLocation().x > randomX && ingame.Villain4.getLocation().y > randomY) {
				ingame.Villain4.setIcon(new ImageIcon(ingame.vl4g.makeVillain4_up()));
				
				while(ingame.Villain4.getLocation().x > randomX && ingame.Villain4.getLocation().y > randomY) {
					
					if(ingame.Villain4.getLocation().x < 300 || ingame.Villain4.getLocation().y < 200) {
						break;
					}
					
					ingame.Villain4.setLocation(ingame.Villain4.getLocation().x - 10, ingame.Villain4.getLocation().y - 10);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}else if(ingame.Villain4.getLocation().x > randomX) {
				ingame.Villain4.setIcon(new ImageIcon(ingame.vl4g.makeVillain4_left()));
				
				while(ingame.Villain4.getLocation().x > randomX) {
					
					if(ingame.Villain4.getLocation().x < 300) {
						break;
					}
					
					ingame.Villain4.setLocation(ingame.Villain4.getLocation().x - 10, ingame.Villain4.getLocation().y);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}else if(ingame.Villain4.getLocation().y > randomY) {
				ingame.Villain4.setIcon(new ImageIcon(ingame.vl4g.makeVillain4_up()));
				
				while(ingame.Villain4.getLocation().y > randomY) {
					
					if(ingame.Villain4.getLocation().y < 200) {
						break;
					}
					
					ingame.Villain4.setLocation(ingame.Villain4.getLocation().x, ingame.Villain4.getLocation().y-10);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}else if(ingame.Villain4.getLocation().x < randomX && ingame.Villain4.getLocation().y < randomY) {
				ingame.Villain4.setIcon(new ImageIcon(ingame.vl4g.makeVillain4()));
				
				while(ingame.Villain4.getLocation().x < randomX && ingame.Villain4.getLocation().y < randomY) {
					
					if(ingame.Villain4.getLocation().x > 700 || ingame.Villain4.getLocation().y > 500) {
						break;
					}
					
					ingame.Villain4.setLocation(ingame.Villain4.getLocation().x + 10, ingame.Villain4.getLocation().y + 10);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}else if(ingame.Villain4.getLocation().x < randomX) {
				ingame.Villain4.setIcon(new ImageIcon(ingame.vl4g.makeVillain4_right()));
				while(ingame.Villain4.getLocation().x < randomX) {
					
					if(ingame.Villain4.getLocation().x > 700) {
						break;
					}
					
					ingame.Villain4.setLocation(ingame.Villain4.getLocation().x + 10, ingame.Villain4.getLocation().y);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}else if(ingame.Villain4.getLocation().y < randomY) {
				ingame.Villain4.setIcon(new ImageIcon(ingame.vl4g.makeVillain4()));
				while(ingame.Villain4.getLocation().y < randomX) {
					
					if(ingame.Villain4.getLocation().y > 500) {
						break;
					}
					
					ingame.Villain4.setLocation(ingame.Villain4.getLocation().x, ingame.Villain4.getLocation().y + 10);
					
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
