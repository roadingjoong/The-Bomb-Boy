package TheBombBoy;

import java.util.ArrayList;

public class GoldCoin2Thread2 implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	GoldCoin2Thread2(InGame ingame){
		this.ingame = ingame;
	}

	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
							
			if(ingame.Villain2.isVisible() == false) {
				ingame.GoldCoin2.setLocation(ingame.SaveVillain2_x+50, ingame.SaveVillain2_y+50);
				ingame.GoldCoin2.setVisible(true);
			}
			
			if(ingame.UserAvatar.getBounds().intersects(ingame.GoldCoin2.getBounds())) {
				ingame.GoldCoin2.setVisible(false);
				ingame.GoldCoin2.setLocation(0,0);
				
				ingame.writer.println("UpCo/c;"+ingame.InformationCoin+"/c;"+150+"/c;"+ingame.InformationId);
				
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