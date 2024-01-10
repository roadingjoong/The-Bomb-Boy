package TheBombBoy;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameThread implements Runnable{
	InGame ingame;
	Boolean Thread_ToF = true;
	
	GameThread(InGame ingame){
		this.ingame = ingame;
	}

	public void run() {
		
		while(Thread_ToF) {
			ingame.BarPane.setVisible(false);
			ingame.closePane();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.DarkPanel();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.FirstPanel();
			
			try {
				ingame.s = new Socket(ingame.ipNum, 7777);
				
				ingame.writer = new PrintWriter(ingame.s.getOutputStream(), true);
				ingame.reader = new BufferedReader(new InputStreamReader(ingame.s.getInputStream()));
				
			} catch (UnknownHostException e) {
				System.out.println("서버 주소 오류");
				while(true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			} catch (IOException e) {
				System.out.println("서버 연결 오휴");
				while(true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ingame.ProjectGuidPanel();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(true) { // 로그인 화면
				
				ingame.closePane();
				
				ingame.LoginPanel();
				
				while(ingame.LoginNum == 0){
					
					if(ingame.QuitGameNum == 1) {
						ingame.QuitGameNum = 0;
						Thread_ToF = false;
						ingame.Gameframe.dispose();
						System.exit(0);
						return;
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
				if(ingame.LoginNum == 2) { // 로그인 화면에서 회원가입 버튼 눌렀을
					ingame.LoginNum = 0;
					
					while(true) { // 회원가입 패널
						
						ingame.closePane();
						ingame.SignUpPanel();
						
						while(ingame.signNum == 0) {
							
							if(ingame.QuitGameNum == 1) {
								ingame.QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								ingame.Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					
						if(ingame.signNum == 2) { // 로그인 화면으로 돌아가기
							ingame.signNum = 0;
							
							ingame.signIdField.setText("");
							ingame.signPwField.setText("");
							ingame.signNameField.setText("");
							
							break;
						}
						else if(ingame.signNum == 1) { // 가입 버튼 클릭
								
							if(ingame.signIdField.getText().length() == 0) {
								ingame.signNum = 0;
								continue;
									
							}else {
								if(ingame.signPwField.getPassword().length == 0) {
									ingame.signNum = 0;
									continue;
										
								}else {
									if(ingame.signNameField.getText().length() == 0) {
										ingame.signNum = 0;
										continue;
											
									}else {
										
										String signIdtext = ingame.signIdField.getText();
										char[] signPwpass = ingame.signPwField.getPassword();
										String signPwtext = new String(signPwpass);
										String signNametext = ingame.signNameField.getText();
										
										boolean checkSignId = ingame.GUD.CheckUser(signIdtext);
										
										if(checkSignId == false) {
											ingame.GUD.SignUpUser(signIdtext, signPwtext, signNametext);
											ingame.signNum = 0;
											break;
											
										}else {
											System.out.println("아이디 중복됨");
											ingame.signNum = 0;
											continue;
										}
									}
								}
							}
						}
					}
				}else if(ingame.LoginNum == 1) {
					ingame.LoginNum = 0;
					
					if(ingame.Idfield.getText().length() == 0) {
						ingame.LoginNum = 0;
						continue;
						
					}else {
						if(ingame.Pwfield.getPassword().length == 0) {
							ingame.LoginNum = 0;
							continue;
							
						}else {
							String LoginIdtext = ingame.Idfield.getText();
							char[] LoginPwpass = ingame.Pwfield.getPassword();
							String LoginPwtext = new String(LoginPwpass);
							
							boolean LoginCheck = ingame.GUD.LoginUser(LoginIdtext, LoginPwtext);
							
							if(LoginCheck == true) {
								ingame.LoginNum = 0;
								System.out.println("로그인 성공");
								
								ArrayList<GameUser> GUList = ingame.GUD.InputUser(LoginIdtext);
								
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
								
								break;
							}else {
								ingame.LoginNum = 0;
								System.out.println("로그인 실패");
								continue;
							}
						}
					}
				}
			} 
			// 로그인 패널 빠져나옴
			ingame.BarPane.setVisible(true);
			
			while(true) {
				ingame.BarPane.setVisible(true);
				ingame.closePane();
				ingame.StartGamePanel();
				ingame.InGameButton.setForeground(Color.RED);
				
				while(ingame.joinNum == 0) {
					
					if(ingame.LogoutNum == 1) {
						break;
					}
					
					if(ingame.QuitGameNum == 1) {
						ingame.QuitGameNum = 0;
						Thread_ToF = false;
						System.exit(0);
						ingame.Gameframe.dispose();
						return;
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				ingame.InGameButton.setForeground(Color.DARK_GRAY);
				
				if(ingame.LogoutNum == 1) {
					ingame.joinNum = 0;
					ingame.LogoutNum = 0;
					break;
				}
				
				if(ingame.joinNum == 1) {
					ingame.joinNum = 0;
					ingame.InGameButton.setForeground(Color.RED);
					
					while(ingame.joinNum == 0) {
						
						if(ingame.LogoutNum == 1) {
							break;
						}
						
						if(ingame.QuitGameNum == 1) {
							ingame.QuitGameNum = 0;
							Thread_ToF = false;
							System.exit(0);
							ingame.Gameframe.dispose();
							return;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					ingame.InGameButton.setForeground(Color.DARK_GRAY);
					
					if(ingame.LogoutNum == 1) {
						ingame.LogoutNum = 0;
						break;
					}
					continue;
					
				}
				else if(ingame.joinNum == 2) {
					ingame.joinNum = 0;
					
					ingame.closePane();
					ingame.GamePlayPanel();
					
					while(ingame.joinNum == 0) {
						
						if(ingame.LogoutNum == 1) {
							break;
						}
						
						if(ingame.QuitGameNum == 1) {
							ingame.QuitGameNum = 0;
							Thread_ToF = false;
							System.exit(0);
							ingame.Gameframe.dispose();
							return;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.LogoutNum == 1) {
						ingame.LogoutNum = 0;
						break;
					}
					
					if(ingame.joinNum == 8) {
						ingame.joinNum = 0;
						
						ingame.easy1start = 1;
						
						ingame.BarPane.setVisible(false);
						
						ingame.closePane();
						
						ingame.StageRoadingPanel();
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						ingame.closePane();
						
						ingame.Stage1EASYPanel();

						while(ingame.villainsLair.isVisible() == true && ingame.UserAvatar.isVisible() == true && ingame.ExitGameNum == 0 && ingame.TimeOverNum == 0){
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						ingame.closePane();
						
						if(ingame.UserAvatar.isVisible() == true && ingame.ExitGameNum == 0 && ingame.TimeOverNum == 0) {
							ingame.StageClearPanel();
							ingame.easy1start = 0;
							
							ingame.GUD.updateLevel(ingame.InformationLevel, ingame.InformationId);
							
							if(ingame.InformationStage <= 1 ) {
								ingame.GUD.updateStage(ingame.InformationStage, ingame.InformationId);
								
								System.out.println("스테이지 업데이트");
								}
							
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
							
						}else{
							ingame.StageFailePanel();
							ingame.easy1start = 0;
							ingame.ExitGameNum = 0;
							ingame.TimeOverNum = 0;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						ingame.joinNum = 2;
						
						continue;
						
					}else if(ingame.joinNum == 9) {
						ingame.joinNum = 0;
						
						if(ingame.InformationStage >= 2) {
							
							ingame.medium1start = 1;
							
							ingame.BarPane.setVisible(false);
							
							ingame.closePane();
							
							ingame.StageRoadingPanel();
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							ingame.closePane();
							
							ingame.Stage1MEDIUMPanel();

							while(ingame.villainsLair.isVisible() == true && ingame.UserAvatar.isVisible() == true && ingame.ExitGameNum == 0 && ingame.TimeOverNum == 0){
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							ingame.closePane();
							
							if(ingame.UserAvatar.isVisible() == true && ingame.ExitGameNum == 0 && ingame.TimeOverNum == 0) {
								ingame.StageClearPanel();
								ingame.medium1start = 0;
								
								ingame.GUD.updateLevel(ingame.InformationLevel, ingame.InformationId);
								
								if(ingame.InformationStage <= 2 ) {
									ingame.GUD.updateStage(ingame.InformationStage, ingame.InformationId);
									}
								
								if(ingame.InformationAlias.equals("Beginner")) {
									ingame.GUD.updateAlias("Warrior", ingame.InformationId);
								}
								
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
								
							}else {
								ingame.StageFailePanel();
								ingame.medium1start = 0;
								ingame.ExitGameNum = 0;
								ingame.TimeOverNum = 0;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}else {
							ingame.closePane();
						}
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 10) {
						ingame.joinNum = 0;
						
						if(ingame.InformationStage >= 3) {
							
							ingame.hard1start = 1;
							
							ingame.BarPane.setVisible(false);
							
							ingame.closePane();
							
							ingame.StageRoadingPanel();
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							ingame.closePane();
							
							ingame.Stage1HARDPanel();

							while(ingame.villainsLair.isVisible() == true && ingame.UserAvatar.isVisible() == true && ingame.ExitGameNum == 0 && ingame.TimeOverNum == 0){
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							ingame.closePane();
							
							if(ingame.UserAvatar.isVisible() == true && ingame.ExitGameNum == 0 && ingame.TimeOverNum == 0) {
								ingame.StageClearPanel();
								ingame.hard1start = 0;
								
								ingame.GUD.updateLevel(ingame.InformationLevel, ingame.InformationId);
								
								if(ingame.InformationStage <= 3 ) {
									ingame.GUD.updateStage(ingame.InformationStage, ingame.InformationId);
									}
								
								if(ingame.InformationAlias.equals("Warrior")) {
									ingame.GUD.updateAlias("Hero", ingame.InformationId);
								}
								
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
								
							}else {
								ingame.StageFailePanel();
								ingame.hard1start = 0;
								ingame.ExitGameNum = 0;
								ingame.TimeOverNum = 0;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}else {
							ingame.closePane();
						}
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 11) {
						
						ingame.joinNum = 0;
						ingame.closePane();
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 12) {
						
						ingame.joinNum = 0;
						ingame.closePane();
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 13) {
						
						ingame.joinNum = 0;
						ingame.closePane();
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 14) {
						
						ingame.joinNum = 0;
						ingame.closePane();
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 15) {
						
						ingame.joinNum = 0;
						ingame.closePane();
						
						ingame.joinNum = 2;
						continue;
						
					}else if(ingame.joinNum == 16) {
						
						ingame.joinNum = 0;
						ingame.closePane();
						
						ingame.joinNum = 2;
						continue;
						
					}
					
					continue;
					
				}else if(ingame.joinNum == 17) {
					ingame.joinNum = 0;
					
					ingame.closePane();
					ingame.BombPassLobbyPanel();
					
					while(ingame.joinNum == 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					continue;
					
				}
				else if(ingame.joinNum == 3) {
					ingame.joinNum = 0;
					
					ingame.closePane();
					ingame.MyPagePanel();
					ingame.MyPageButton.setForeground(Color.RED);
					
					ingame.MyPageIdText.setText(ingame.InformationId);
					ingame.MyPageNameText.setText(ingame.InformationName);
					ingame.MyPageLevelText.setText(""+ingame.InformationLevel);
					ingame.MyPageAliasText.setText(ingame.InformationAlias);
					ingame.MyPageCoinfield.setText(""+ingame.InformationCoin);
					if(ingame.InformationAvatar == 1) {
						ingame.MyPageAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1()));
					}else if(ingame.InformationAvatar == 2) {
						ingame.MyPageAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2()));
					}else if(ingame.InformationAvatar == 3) {
						ingame.MyPageAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3()));
					}else if(ingame.InformationAvatar == 4) {
						ingame.MyPageAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4()));
					}else if(ingame.InformationAvatar == 5) {
						ingame.MyPageAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5()));
					}
					
					while(ingame.joinNum == 0) {
						
						if(ingame.LogoutNum == 1) {
							break;
						}
						
						if(ingame.QuitGameNum == 1) {
							ingame.QuitGameNum = 0;
							Thread_ToF = false;
							System.exit(0);
							ingame.Gameframe.dispose();
							return;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					ingame.MyPageButton.setForeground(Color.DARK_GRAY);
					
					if(ingame.LogoutNum == 1) {
						ingame.LogoutNum = 0;
						break;
					}
					
					if(ingame.joinNum == 6) {
						ingame.joinNum = 0;
						
						ingame.closePane();
						ingame.ChangeNamePanel();
						ingame.MyPageButton.setForeground(Color.RED);
						
						while(ingame.ChangeNameNum == 0) {
							
							if(ingame.LogoutNum == 1) {
								break;
							}
							
							if(ingame.QuitGameNum == 1) {
								ingame.QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								ingame.Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						while(ingame.joinNum == 0) {
							
							if(ingame.LogoutNum == 1) {
								break;
							}
							
							if(ingame.QuitGameNum == 1) {
								ingame.QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								ingame.Gameframe.dispose();
								return;
							}
							
							if(ingame.ChangeNameNum == 2) {
								ingame.ChangeNameNum = 0;
								
								if(ingame.ChangeNamefield.getText().length() != 0) {
									
									String newName = ingame.ChangeNamefield.getText();
									
									ingame.GUD.updateName(newName, ingame.InformationId);
									
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
									
									ingame.joinNum = 3;
									
								}else {
									System.out.println("문자를 입력하지 않음");
								}
								
							}else if(ingame.ChangeNameNum == 1) {
								ingame.ChangeNameNum = 0;
								ingame.joinNum = 3;
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}
						
						if(ingame.LogoutNum == 1) {
							ingame.LogoutNum = 0;
							break;
						}
						
						continue;
						
					}else if(ingame.joinNum == 7) {
						ingame.joinNum = 0;
						
						ingame.closePane();
						ingame.ChangePwPanel();
						ingame.MyPageButton.setForeground(Color.RED);
						
						while(ingame.ChangePwNum == 0) {
							
							if(ingame.LogoutNum == 1) {
								break;
							}
							
							if(ingame.QuitGameNum == 1) {
								ingame.QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								ingame.Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						while(ingame.joinNum == 0) {
							
							if(ingame.LogoutNum == 1) {
								break;
							}
							
							if(ingame.QuitGameNum == 1) {
								ingame.QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								ingame.Gameframe.dispose();
								return;
							}
							
							if(ingame.ChangePwNum == 2) {
								ingame.ChangePwNum = 0;
								
								char[] getcheckChangePw = ingame.ChangeCurrentPwfield.getPassword();
								String checkChangePw = new String(getcheckChangePw);
								
								boolean checkChangeThisPw = ingame.GUD.LoginUser(ingame.InformationId, checkChangePw);
								
								if(checkChangeThisPw == true) {
									
									char[] getChangeNewPw = ingame.ChangePwfield.getPassword();
									String ChangeNewPw = new String(getChangeNewPw);
									
									ingame.GUD.updatePw(ChangeNewPw, ingame.InformationId);
									
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
									
									ingame.joinNum = 3;
									
								}else {
									System.out.println("현재 비밀번호가 맞지 않습니다.");
								}
								
							}else if(ingame.ChangePwNum == 1) {
								ingame.ChangePwNum = 0;
								ingame.joinNum = 3;
								
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}
						
						if(ingame.LogoutNum == 1) {
							ingame.LogoutNum = 0;
							break;
						}
													
						continue;
						
					}
					
					continue;
					
				}
				else if(ingame.joinNum == 4) {
					ingame.joinNum = 0;
					
					ingame.closePane();
					ingame.ShopPanel();
					ingame.ShopButton.setForeground(Color.RED);
					
					while(ingame.joinNum == 0) {
						
						if(ingame.LogoutNum == 1) {
							break;
						}
						
						if(ingame.QuitGameNum == 1) {
							ingame.QuitGameNum = 0;
							Thread_ToF = false;
							System.exit(0);
							ingame.Gameframe.dispose();
							return;
						}
						
						if(ingame.BuyAvatarNum != 0) {
							if(ingame.BuyAvatarNum == 1) {
								if(ingame.InformationCoin >= 1000) {
									ingame.BuyAvatarNum = 0;
									ingame.GUD.updateAvatar(2, ingame.InformationCoin, 1000, ingame.InformationId);
									System.out.println("구매성공");
								}else {
									System.out.println("코인부족");
								}
							}else if(ingame.BuyAvatarNum == 2) {
								if(ingame.InformationCoin >= 2000) {
									ingame.BuyAvatarNum = 0;
									ingame.GUD.updateAvatar(3, ingame.InformationCoin, 2000, ingame.InformationId);
									System.out.println("구매성공");
								}else {
									System.out.println("코인부족");
								}
							}else if(ingame.BuyAvatarNum == 3) {
								if(ingame.InformationCoin >= 3000) {
									ingame.BuyAvatarNum = 0;
									ingame.GUD.updateAvatar(4, ingame.InformationCoin, 3000, ingame.InformationId);
									System.out.println("구매성공");
								}else {
									System.out.println("코인부족");
								}
							}else if(ingame.BuyAvatarNum == 4) {
								if(ingame.InformationCoin >= 4000) {
									ingame.BuyAvatarNum = 0;
									ingame.GUD.updateAvatar(5, ingame.InformationCoin, 4000, ingame.InformationId);
									System.out.println("구매성공");
								}else {
									System.out.println("코인부족");
								}
							}
							
							if(ingame.BuyAvatarNum == 0) {
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
								System.out.println("구매 성공");
							}else {
								ingame.BuyAvatarNum = 0;
								System.out.println("구매실패");
							}
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					ingame.ShopButton.setForeground(Color.DARK_GRAY);
					
					if(ingame.LogoutNum == 1) {
						ingame.LogoutNum = 0;
						break;
					}
					
					continue;
					
				}else if(ingame.joinNum == 5) {
					ingame.joinNum = 0;
					
					ingame.closePane();
					ingame.MessengerPanel();
					ingame.MessengerButton.setForeground(Color.RED);
					
					String message = "join/c;"+"[ Level : "+ingame.InformationLevel+" ] "+ingame.InformationName;
					ingame.writer.println(message);
					
					while(ingame.joinNum == 0) {
						
						if(ingame.LogoutNum == 1) {
							break;
						}
						
						if(ingame.QuitGameNum == 1) {
							ingame.QuitGameNum = 0;
							Thread_ToF = false;
							System.exit(0);
							ingame.Gameframe.dispose();
							return;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					String message2 = "left/c;"+"[ Level : "+ingame.InformationLevel+" ] "+ingame.InformationName;
					ingame.writer.println(message2);
					
					ingame.MessengerButton.setForeground(Color.DARK_GRAY);
					
					if(ingame.LogoutNum == 1) {
						ingame.LogoutNum = 0;
						break;
					}
					
					continue;
					
				}
				
			}
			
		}
		
	}
	
}