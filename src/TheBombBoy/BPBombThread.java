package TheBombBoy;

import java.util.Random;

import javax.swing.ImageIcon;

public class BPBombThread implements Runnable {
	InGame ingame;
	Boolean Thread_ToF = true;
	
	Random random = new Random();
	
	BPBombThread(InGame ingame){
		this.ingame = ingame;
	}
	
	@Override
	public void run() {
		while(Thread_ToF) {
			if(ingame.BPMyStandardPane.isVisible()==false && ingame.BPJoinStandardPane.isVisible()==false &&
					ingame.BPTrainingPane.isVisible()==false) {
				Thread_ToF = false;
				return;
			}
			
			if(ingame.BPBomb.getBounds().intersects(ingame.UserAvatar.getBounds())) {
				ingame.randomNum = random.nextInt(2)+1;
				ingame.touchBombNum = 1;
				
				if(ingame.MyStandardStart == 1 || ingame.BPTrainingNum == 1) {
					ingame.BPturnNum = 1;
				}else if(ingame.JoinStandardStart == 1) {
					ingame.BPturnNum = 2;
				}
			}
			
			if(ingame.BPturnNum == 1) {
				
				if(ingame.randomNum == 1) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x-5, ingame.BPBomb.getLocation().y-5);
				}else if(ingame.randomNum == 2) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x+5, ingame.BPBomb.getLocation().y-5);
				}else if(ingame.randomNum == 3) {
					ingame.BPBomb.setLocation(625,250);
				}else if(ingame.randomNum == 4) {
					ingame.BPBomb.setLocation(625,400);
				}
				
			}else if(ingame.BPturnNum == 2) {
				
				if(ingame.randomNum == 1) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x-5, ingame.BPBomb.getLocation().y+5);
				}else if(ingame.randomNum == 2) {
					ingame.BPBomb.setLocation(ingame.BPBomb.getLocation().x+5, ingame.BPBomb.getLocation().y+5);
				}else if(ingame.randomNum == 3) {
					ingame.BPBomb.setLocation(625,250);
				}else if(ingame.randomNum == 4) {
					ingame.BPBomb.setLocation(625,400);
				}
				
			}
			
			if(ingame.BPBomb.getBounds().intersects(ingame.OtherAvatar.getBounds())) {
				ingame.touchBombNum = 0;
			}
			
			if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame1.getBounds())) {
				ingame.randomNum = 2;
			}else if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame2.getBounds())) {
				ingame.randomNum = 1;
			}else if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame3.getBounds())) { //red 하
				ingame.BPBomb.setIcon(new ImageIcon(ingame.mb.makeBomb2()));
				ingame.randomNum = 3;
				if(ingame.MyStandardStart == 1) {
					ingame.BlueScoreNum += 1;
					ingame.BPBlueScore.setText("Score : "+ingame.BlueScoreNum);
					ingame.writer.println("BPScore/c;"+ingame.BlueScoreNum+"/c;"+ingame.OtherUserId+"/c;"+1);
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if(ingame.BPBomb.getBounds().intersects(ingame.SpaceFrame4.getBounds())) { //blue 상
				ingame.BPBomb.setIcon(new ImageIcon(ingame.mb.makeBomb2()));
				ingame.randomNum = 4;
				if(ingame.MyStandardStart == 1) {
					ingame.RedScoreNum += 1;
					ingame.BPRedScore.setText("Score : "+ingame.RedScoreNum);
					ingame.writer.println("BPScore/c;"+ingame.RedScoreNum+"/c;"+ingame.OtherUserId+"/c;"+2);
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ingame.BPBomb.setIcon(new ImageIcon(ingame.mb.makeBomb1()));
			
		}
	}

}
