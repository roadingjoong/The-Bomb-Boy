package TheBombBoy;

import java.util.ArrayList;

public class GoldCoin3Thread2 implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	GoldCoin3Thread2(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain3.isVisible() == false) {
				ingame.GoldCoin3.setLocation(ingame.SaveVillain3_x+50, ingame.SaveVillain3_y+50);
				ingame.GoldCoin3.setVisible(true);
			}
			
			if(ingame.UserAvatar.getBounds().intersects(ingame.GoldCoin3.getBounds())) {
				ingame.GoldCoin3.setVisible(false);
				ingame.GoldCoin3.setLocation(0,0);
				
				ingame.GUD.updateCoin(ingame.InformationCoin, 300, ingame.InformationId);
				
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