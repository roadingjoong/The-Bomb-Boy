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
				
				ingame.GUD.updateCoin(ingame.InformationCoin, 200, ingame.InformationId);
				
				ArrayList<GameUser> GUList = ingame.GUD.InputUser(ingame.InformationId);
				
				for(GameUser gu : GUList ) {
					ingame.InformationId = gu.getUserid();
					ingame.InformationPw = gu.getUserpw();
					ingame.InformationName = gu.getUsername();
					ingame.InformationLevel = gu.getUserlevel();
					ingame.InformationAlias = gu.getUseralias();
					ingame.InformationStage = gu.getUserStage();
					ingame.InformationCoin = gu.getUsercoin();
					ingame.InformationAvatar = gu.getUseravatar();
				}
				
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