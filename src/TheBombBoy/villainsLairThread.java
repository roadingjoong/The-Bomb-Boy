package TheBombBoy;

import javax.swing.ImageIcon;

public class villainsLairThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	villainsLairThread(InGame ingame){
		this.ingame = ingame;
	}

	public void run() {
		
		while(Thread_ToF) {
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair1()));
			
			if(ingame.Stage1EASYPane.isVisible() == true ) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair2()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair3()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair4()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair5()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair6()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair7()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair8()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair9()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ingame.easy1start == 0 && ingame.medium1start == 0 && ingame.hard1start == 0) {
				ingame.LairDamageNum = 0;
				Thread_ToF = false;
				return;
			}
			
			ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair10()));
			
			if(ingame.Stage1EASYPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1MEDIUMPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}else if(ingame.Stage1HARDPane.isVisible() == true) {
				
				if(ingame.Villain1.isVisible() == false && ingame.Villain2.isVisible() == false && ingame.Villain3.isVisible() == false && ingame.Stage1Boss.isVisible() == false) {
					if(ingame.villainsLair.getBounds().intersects(ingame.UserBomb.getBounds()) && ingame.BombTime == 2 ) {
						ingame.villainsLair.setIcon(new ImageIcon(ingame.vla.makeLair_damage()));
						ingame.LairDamageNum += 1;
						
						if(ingame.LairDamageNum == 5) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							ingame.villainsLair.setVisible(false);
							
							ingame.LairDamageNum = 0;
							Thread_ToF = false;
							return;
						}
						
					}
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}