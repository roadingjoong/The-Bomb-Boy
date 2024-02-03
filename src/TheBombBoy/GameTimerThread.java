package TheBombBoy;

import java.awt.Color;

public class GameTimerThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	int minute = 1;
	int second = 59;
	
	GameTimerThread(InGame ingame){
		this.ingame = ingame;
	}
	
	public void run() {
		while(Thread_ToF) {
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && 
					ingame.MyStandardStart == 0 && ingame.JoinStandardStart == 0) {
				minute = 1;
				second = 59;
				Thread_ToF = false;
				return;
			}
			
			while((ingame.MyStandardStart == 1 || ingame.JoinStandardStart == 1) && ingame.BPGameStartNum == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			ingame.GameTimer.setText("0"+minute+":"+second);
			if(second < 10) {
				ingame.GameTimer.setText("0"+minute+":"+"0"+second);
			}
			if(minute == 0 && second <= 30) {
				ingame.GameTimer.setForeground(Color.RED);
			}
			if(second == 0) {
				if(minute == 1) {
					minute -= 1;
					second += 59;
				}else if(minute == 0 && second == 0) {
					ingame.TimeOverNum = 1;
					ingame.GameTimer.setForeground(Color.WHITE);
					Thread_ToF = false;
					return;
				}
			}
			second -= 1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}