package TheBombBoy;

import java.util.ArrayList;

public class GoldCoinThread2 implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;

	GoldCoinThread2(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				Thread_ToF = false;
				return;
			}
			
			if(ingame.Villain1.isVisible() == false) {
				ingame.GoldCoin.setLocation(ingame.SaveVillain1_x+50, ingame.SaveVillain1_y+50);
				ingame.GoldCoin.setVisible(true);
			}
			
			if(ingame.UserAvatar.getBounds().intersects(ingame.GoldCoin.getBounds())) {
				ingame.GoldCoin.setVisible(false);
				ingame.GoldCoin.setLocation(0,0);
				
				ingame.GUD.updateCoin(ingame.InformationCoin, 100, ingame.InformationId);
				
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
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}