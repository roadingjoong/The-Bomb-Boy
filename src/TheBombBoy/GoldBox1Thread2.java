package TheBombBoy;

import java.util.ArrayList;

public class GoldBox1Thread2 implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	GoldBox1Thread2(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.hard1start == 0) {
				ingame.Stage1Boss_dead = 0;
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Stage1Boss_dead == 1) {
				ingame.GoldBox1.setLocation(ingame.Stage1Boss_x+50, ingame.Stage1Boss_y+50);
				ingame.GoldBox1.setVisible(true);
			}
			
			if(ingame.UserAvatar.getBounds().intersects(ingame.GoldBox1.getBounds())) {
				ingame.Stage1Boss_dead = 0;
				
				ingame.GoldBox1.setVisible(false);
				ingame.GoldBox1.setLocation(0,0);
				
				ingame.writer.println("UpCo/c;"+ingame.InformationCoin+"/c;"+500+"/c;"+ingame.InformationId);
				
				ingame.writer.println("UpdInfo/c;"+ingame.InformationId);
				
				while(ingame.updateinfNum == 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				ingame.updateinfNum = 0;
				
				Thread_ToF = false;
				return;
				
			}
			
			try {
				Thread.sleep(210);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}