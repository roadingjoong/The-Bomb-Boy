package TheBombBoy;

import javax.swing.ImageIcon;

public class TrainingBotThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	TrainingBotThread(InGame ingame){
		this.ingame = ingame;
	}
	
	@Override
	public void run() {
		while(Thread_ToF) {
			if(ingame.BPTrainingPane.isVisible() == false) {
				Thread_ToF = false;
				return;
			}
			
			while(ingame.TrainingBot.getLocation().x <= 790) {
				ingame.TrainingBot.setIcon(new ImageIcon(ingame.tbg.makeBot_right()));
				ingame.TrainingBot.setLocation(ingame.TrainingBot.getLocation().x+10, ingame.TrainingBot.getLocation().y);
				if(ingame.BPTrainingPane.isVisible() == false) {
					Thread_ToF = false;
					return;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			while(ingame.TrainingBot.getLocation().y <= 200) {
				ingame.TrainingBot.setIcon(new ImageIcon(ingame.tbg.makeBot()));
				ingame.TrainingBot.setLocation(ingame.TrainingBot.getLocation().x, ingame.TrainingBot.getLocation().y+10);
				if(ingame.BPTrainingPane.isVisible() == false) {
					Thread_ToF = false;
					return;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			while(ingame.TrainingBot.getLocation().x >= 410) {
				ingame.TrainingBot.setIcon(new ImageIcon(ingame.tbg.makeBot_left()));
				ingame.TrainingBot.setLocation(ingame.TrainingBot.getLocation().x-10, ingame.TrainingBot.getLocation().y);
				if(ingame.BPTrainingPane.isVisible() == false) {
					Thread_ToF = false;
					return;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			while(ingame.TrainingBot.getLocation().y >= 110) {
				ingame.TrainingBot.setIcon(new ImageIcon(ingame.tbg.makeBot_up()));
				ingame.TrainingBot.setLocation(ingame.TrainingBot.getLocation().x, ingame.TrainingBot.getLocation().y-10);
				if(ingame.BPTrainingPane.isVisible() == false) {
					Thread_ToF = false;
					return;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
