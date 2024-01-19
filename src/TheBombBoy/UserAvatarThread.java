package TheBombBoy;

import javax.swing.ImageIcon;

public class UserAvatarThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	UserAvatarThread(InGame ingame){
		this.ingame = ingame;
	}

	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
				Thread_ToF = false;
				return;
			}
			
			if(ingame.InformationAvatar == 1) {
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1()));
				
				while(true) {
					
					if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
						Thread_ToF = false;
						return;
					}
					
					while(ingame.AvatarMove == 0) {
						
						if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
							Thread_ToF = false;
							return;
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.AvatarMove == 1) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1()));
						continue;
						
					}else if(ingame.AvatarMove == 2) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1_up()));
						continue;
						
					}else if(ingame.AvatarMove == 3) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1_right()));
						continue;
						
					}else if(ingame.AvatarMove == 4) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1_left()));
						continue;
						
					}
					
				}
				
				
			}else if(ingame.InformationAvatar == 2) {
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2()));
				
				while(true) {
					
					if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
						Thread_ToF = false;
						return;
					}
					
					while(ingame.AvatarMove == 0) {
						
						if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
							Thread_ToF = false;
							return;
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.AvatarMove == 1) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2()));
						continue;
						
					}else if(ingame.AvatarMove == 2) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2_up()));
						continue;
						
					}else if(ingame.AvatarMove == 3) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2_right()));
						continue;
						
					}else if(ingame.AvatarMove == 4) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2_left()));
						continue;
						
					}
					
				}
				
			}else if(ingame.InformationAvatar == 3) {
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3()));
				
				while(true) {
					
					if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
						Thread_ToF = false;
						return;
					}
					
					while(ingame.AvatarMove == 0) {
						
						if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
							Thread_ToF = false;
							return;
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.AvatarMove == 1) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3()));
						continue;
						
					}else if(ingame.AvatarMove == 2) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3_up()));
						continue;
						
					}else if(ingame.AvatarMove == 3) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3_right()));
						continue;
						
					}else if(ingame.AvatarMove == 4) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3_left()));
						continue;
						
					}
					
				}
				
			}else if(ingame.InformationAvatar == 4) {
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4()));
				
				while(true) {
					
					if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
						Thread_ToF = false;
						return;
					}
					
					while(ingame.AvatarMove == 0) {
						
						if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
							Thread_ToF = false;
							return;
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.AvatarMove == 1) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4()));
						continue;
						
					}else if(ingame.AvatarMove == 2) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4_up()));
						continue;
						
					}else if(ingame.AvatarMove == 3) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4_right()));
						continue;
						
					}else if(ingame.AvatarMove == 4) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4_left()));
						continue;
						
					}
					
				}
				
			}else if(ingame.InformationAvatar == 5) {
				ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5()));
				
				while(true) {
					
					if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
						Thread_ToF = false;
						return;
					}
					
					while(ingame.AvatarMove == 0) {
						
						if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0 && ingame.MyStandardStart == 0) {
							Thread_ToF = false;
							return;
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.AvatarMove == 1) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5()));
						continue;
						
					}else if(ingame.AvatarMove == 2) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5_up()));
						continue;
						
					}else if(ingame.AvatarMove == 3) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5_right()));
						continue;
						
					}else if(ingame.AvatarMove == 4) {
						ingame.AvatarMove = 0;
						ingame.UserAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5_left()));
						continue;
						
					}
					
				}
			}
			
		}
		
	}
	
}