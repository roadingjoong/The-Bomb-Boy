package TheBombBoy;

import javax.swing.ImageIcon;

public class ExitGameButtonThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	ExitGameButtonThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		while(Thread_ToF) {
			if(ingame.ExitGameNum == 1) {
				ingame.ExitGameButton.setIcon(new ImageIcon(ingame.egb.makeButton2()));
			}
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && 
					ingame.MyStandardStart == 0 && ingame.JoinStandardStart == 0 ) {
				ingame.ExitGameButton.setIcon(new ImageIcon(ingame.egb.makeButton1()));
				Thread_ToF = false;
				return;
			}
			
			if(ingame.BPGameStartNum == 1) {
				ingame.ExitGameButton.setVisible(false);
				Thread_ToF = false;
				return;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}