package TheBombBoy;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
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
		try {
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
				
				ingame.s = new Socket(ingame.ipNum, 7777);
				
				ingame.writer = new PrintWriter(ingame.s.getOutputStream(), true);
				ingame.reader = new BufferedReader(new InputStreamReader(ingame.s.getInputStream()));
				
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
							break;
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					if(ingame.QuitGameNum == 1) {
						break;
					}
				
					if(ingame.LoginNum == 2) { // 로그인 화면에서 회원가입 버튼 눌렀을
						ingame.LoginNum = 0;
						
						while(true) { // 회원가입 패널
							
							ingame.closePane();
							ingame.SignUpPanel();
							
							while(ingame.signNum == 0) {
								
								if(ingame.QuitGameNum == 1) {
									break;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							if(ingame.QuitGameNum == 1) {
								break;
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
											
											ingame.writer.println("chId/c;"+signIdtext+"/c;"+signPwtext+"/c;"+signNametext);
											
											while(ingame.signCollectNum == 0) {
												try {
													Thread.sleep(100);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}
											
											if(ingame.signCollectNum == 1) {
												ingame.signCollectNum = 0;
												ingame.signNum = 0;
												break;
												
											}else {
												System.out.println("아이디 중복됨");
												ingame.signCollectNum = 0;
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
								
								String LoginMessage = "Login/c;"+LoginIdtext+"/c;"+LoginPwtext;
								ingame.writer.println(LoginMessage);
								
								while(ingame.LoginCollectNum == 0) {
									if(ingame.QuitGameNum == 1) {
										break;
									}
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								if(ingame.QuitGameNum == 1) {
									break;
								}
								
								if(ingame.LoginCollectNum == 1) {
									System.out.println("페르페");
									ingame.LoginNum = 0;
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
				if(ingame.QuitGameNum == 1) {
					ingame.QuitGameNum = 0;
					ingame.writer.println("QuiteGame/c;"+ingame.InformationId);
					break;
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
							break;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(ingame.QuitGameNum == 1) {
						break;
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
								break;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						ingame.InGameButton.setForeground(Color.DARK_GRAY);
						if(ingame.QuitGameNum == 1) {
							break;
						}
						
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
								break;
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
						if(ingame.QuitGameNum == 1) {
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
								
								ingame.writer.println("UpLe/c;"+ingame.InformationLevel+"/c;"+ingame.InformationId);
								
								
								if(ingame.InformationStage <= 1 ) {
									ingame.writer.println("UpSt/c;"+ingame.InformationStage+"/c;"+ingame.InformationId);
									
									System.out.println("스테이지 업데이트");
									}
								
								ingame.writer.println("UpdInfo/c;"+ingame.InformationId);
								
								while(ingame.updateinfNum == 0) {
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								ingame.updateinfNum = 0;
								
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
									
									ingame.writer.println("UpLe/c;"+ingame.InformationLevel+"/c;"+ingame.InformationId);
									
									if(ingame.InformationStage <= 2 ) {
										ingame.writer.println("UpSt/c;"+ingame.InformationStage+"/c;"+ingame.InformationId);
										}
									
									ingame.writer.println("UpdInfo/c;"+ingame.InformationId);
									
									while(ingame.updateinfNum == 0) {
										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									ingame.updateinfNum = 0;
									
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
									
									ingame.writer.println("UpLe/c;"+ingame.InformationLevel+"/c;"+ingame.InformationId);
									
									if(ingame.InformationStage <= 3 ) {
										ingame.writer.println("UpSt/c;"+ingame.InformationStage+"/c;"+ingame.InformationId);
										}
									
									if(ingame.InformationAlias.equals("Beginner")) {
										ingame.writer.println("UpAl/c;"+"HERO/c;"+ingame.InformationId);
									}
									
									ingame.writer.println("UpdInfo/c;"+ingame.InformationId);
									
									while(ingame.updateinfNum == 0) {
										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									ingame.updateinfNum = 0;
									
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
						
						String BPjoinM = "BPjoin/c;"+ingame.InformationName;
						ingame.writer.println(BPjoinM);
						
						while(ingame.joinNum == 0) {
							if(ingame.QuitGameNum == 1) {
								break;
							}
							if(ingame.LogoutNum == 1) {
								break;
							}
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(ingame.QuitGameNum == 1) {
							break;
						}
						if(ingame.LogoutNum == 1) {
							ingame.LogoutNum = 0;
							break;
						}
						
						if(ingame.joinNum == 18) {
							ingame.joinNum = 0;
							ingame.closePane();
							ingame.BombPassMyRoomPanel();
							
							while(ingame.joinNum == 0) {
								if(ingame.QuitGameNum == 1) {
									break;
								}
								if(ingame.LogoutNum == 1) {
									break;
								}
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								if(ingame.BPCgroundNum == 1) {
									ingame.BPCgroundNum = 0;
									if(ingame.MakeRoomName.getText().length() > 1) {
										if(ingame.StandardNum == 1) {
											ingame.joinNum = 19;
										}else if(ingame.SurvivalNum == 1) {
											System.out.println("서바이벌 모드 선택");
											ingame.joinNum = 17;
										}else {
											System.out.println("모드를 선택해주세요.");
											ingame.joinNum = 17;
										}
									}
								}
							}
							if(ingame.QuitGameNum == 1) {
								break;
							}
							if(ingame.LogoutNum == 1) {
								ingame.LogoutNum = 0;
								break;
							}
						}
						//========================================
						if(ingame.joinNum == 19) {
							ingame.MyStandardStart = 1;
							ingame.joinNum = 0;
							ingame.closePane();
							ingame.BarPane.setVisible(false);
							ingame.BPMyStandardPanel();
							ingame.writer.println("BPCRoom/c;"+ingame.MakeRoomName.getText());
							ingame.UserAvatar.setLocation(600, 490);
							ingame.User1Name.setText("Name : "+ingame.InformationName);
							ingame.User1Level.setText("Level : "+ingame.InformationLevel);
							ingame.User1Alias.setText("Alias : "+ingame.InformationAlias);
							
							while(ingame.joinMyRoomOtherUser == 0) {
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							if(ingame.joinMyRoomOtherUser == 1) {
								ingame.joinMyRoomOtherUser = 0;
								ingame.User2Name.setText("Name : "+ingame.OtherUserName);
								ingame.User2Level.setText("Level : "+ingame.OtherUserLevel);
								ingame.User2Alias.setText("Alias : "+ingame.OtherUserAlias);
								
								ingame.writer.println("BPwelcom/c;"+ingame.OtherUserId);
							}
							
							if(ingame.OtherUserAvatar == 1) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1()));
							}else if(ingame.OtherUserAvatar == 2) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2()));
							}else if(ingame.OtherUserAvatar == 3) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3()));
							}else if(ingame.OtherUserAvatar == 4) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4()));
							}else if(ingame.OtherUserAvatar == 5) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5()));
							}
							ingame.OtherAvatar.setLocation(600, 110);
							ingame.OtherAvatar.setVisible(true);
							
							while(ingame.RedScoreNum != 10 && ingame.BlueScoreNum != 10) {
								if(ingame.NewBPBombNum == 1) {
									ingame.BPGameStartButton.setIcon(new ImageIcon(ingame.BPgsb.MakeStartButton1()));
									ingame.NewBPBombNum = 0;
									ingame.BPBomb.setLocation(625, 400);
									ingame.BPBomb.setVisible(true);
									ingame.writer.println("NewBPBomb/c;"
									+ingame.BPBomb.getLocation().x+"/c;"+ingame.BPBomb.getLocation().y
									+"/c;"+ingame.OtherUserId);
									ingame.BPGameStartButton.setVisible(false);
								}
								
								if(ingame.AvatarMove != 0) {
									ingame.writer.println("User1move/c;"+ingame.UserAvatar.getLocation().x+"/c;"
									+ingame.UserAvatar.getLocation().y+"/c;"+ingame.OtherUserId+"/c;"+ingame.AvatarMove);
								}
								
								if(ingame.touchBombNum == 1) {
									ingame.writer.println("BPBombMove/c;"+ingame.BPBomb.getLocation().x+
											"/c;"+ingame.BPBomb.getLocation().y+
											"/c;"+ingame.OtherUserId+"/c;"+ingame.randomNum+"/c;"+ingame.BPturnNum);
								}
								
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							if(ingame.RedScoreNum == 10) {
								ingame.closePane();
								ingame.StageFailePanel();
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}else if(ingame.BlueScoreNum == 10) {
								ingame.closePane();
								ingame.StageClearPanel();
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							ingame.BPGameStartNum = 0;
							ingame.MyStandardStart = 0;
							ingame.RedScoreNum = 0;
							ingame.BlueScoreNum = 0;
							ingame.joinNum = 17;
							
							ingame.BarPane.setVisible(true);	
						}
						//-------------------------------------------------------------------------------------
						if(ingame.joinNum == 20) {
							ingame.JoinStandardStart = 1;
							ingame.joinNum = 0;
							ingame.closePane();
							ingame.BarPane.setVisible(false);
							ingame.BPJoinStandardPanel();
							ingame.writer.println("BPJRoom/c;"+ingame.joinRoomName);
							ingame.UserAvatar.setLocation(600, 110);
							ingame.JUser2Name.setText("Name : "+ingame.InformationName);
							ingame.JUser2Level.setText("Level : "+ingame.InformationLevel);
							ingame.JUser2Alias.setText("Alias : "+ingame.InformationAlias);
							
							while(ingame.WelcomRoomOtherUser == 0) {
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							if(ingame.WelcomRoomOtherUser == 1) {
								ingame.WelcomRoomOtherUser = 0;
								ingame.JUser1Name.setText("Name : "+ingame.OtherUserName);
								ingame.JUser1Level.setText("Level : "+ingame.OtherUserLevel);
								ingame.JUser1Alias.setText("Alias : "+ingame.OtherUserAlias);
							}
							
							if(ingame.OtherUserAvatar == 1) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar1()));
							}else if(ingame.OtherUserAvatar == 2) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar2()));
							}else if(ingame.OtherUserAvatar == 3) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar3()));
							}else if(ingame.OtherUserAvatar == 4) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar4()));
							}else if(ingame.OtherUserAvatar == 5) {
								ingame.OtherAvatar.setIcon(new ImageIcon(ingame.mav.makeAvatar5()));
							}
							ingame.OtherAvatar.setLocation(600, 490);
							ingame.OtherAvatar.setVisible(true);
							
							while(ingame.RedScoreNum != 10 && ingame.BlueScoreNum != 10) {
								if(ingame.AvatarMove != 0) {
									ingame.writer.println("User1move/c;"+ingame.UserAvatar.getLocation().x+"/c;"
									+ingame.UserAvatar.getLocation().y+"/c;"+ingame.OtherUserId+"/c;"+ingame.AvatarMove);
								}
								
								if(ingame.touchBombNum == 1) {
									ingame.writer.println("BPBombMove/c;"+ingame.BPBomb.getLocation().x+
											"/c;"+ingame.BPBomb.getLocation().y+
											"/c;"+ingame.OtherUserId+"/c;"+ingame.randomNum+"/c;"+ingame.BPturnNum);
								}
								
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							if(ingame.RedScoreNum == 10) {
								ingame.closePane();
								ingame.StageClearPanel();
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}else if(ingame.BlueScoreNum == 10) {
								ingame.closePane();
								ingame.StageFailePanel();
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							ingame.BPGameStartNum = 0;
							ingame.JoinStandardStart = 0;
							ingame.RedScoreNum = 0;
							ingame.BlueScoreNum = 0;
							ingame.joinNum = 17;
							
							ingame.BarPane.setVisible(true);	
						}
						//================================================================
						String BPexM = "BPexite/c;"+ingame.InformationName;
						ingame.writer.println(BPexM);
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
								break;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(ingame.QuitGameNum == 1) {
							break;
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
									break;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							if(ingame.QuitGameNum == 1) {
								break;
							}
							
							while(ingame.joinNum == 0) {
								
								if(ingame.LogoutNum == 1) {
									break;
								}
								
								if(ingame.QuitGameNum == 1) {
									break;
								}
								
								if(ingame.ChangeNameNum == 2) {
									ingame.ChangeNameNum = 0;
									
									if(ingame.ChangeNamefield.getText().length() != 0) {
										
										String newName = ingame.ChangeNamefield.getText();
										
										ingame.writer.println("UpNa/c;"+newName+"/c;"+ingame.InformationId);
										
										ingame.writer.println("UpdInfo/c;"+ingame.InformationId);
										
										while(ingame.updateinfNum == 0) {
											try {
												Thread.sleep(100);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										ingame.updateinfNum = 0;
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
							if(ingame.QuitGameNum == 1) {
								break;
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
									break;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							if(ingame.QuitGameNum == 1) {
								break;
							}
							
							while(ingame.joinNum == 0) {
								
								if(ingame.LogoutNum == 1) {
									break;
								}
								
								if(ingame.QuitGameNum == 1) {
									break;
								}
								
								if(ingame.ChangePwNum == 2) {
									ingame.ChangePwNum = 0;
									
									char[] getcheckChangePw = ingame.ChangeCurrentPwfield.getPassword();
									String checkChangePw = new String(getcheckChangePw);
									
									char[] getChangeNewPw = ingame.ChangePwfield.getPassword();
									String ChangeNewPw = new String(getChangeNewPw);
									
									ingame.writer.println("UpPs/c;"+ingame.InformationId+"/c;"+checkChangePw+"/c;"+ChangeNewPw);
									
									while(ingame.updatePsNum == 0) {
										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									
									if(ingame.updatePsNum == 1) {
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
								break;
							}
							
							if(ingame.BuyAvatarNum != 0) {
								int BuyoutCoin = 0;
								int AvNumber = 0;
								if(ingame.BuyAvatarNum == 1) {
									BuyoutCoin = 1000;
									AvNumber = 2;
								}else if(ingame.BuyAvatarNum == 2) {
									BuyoutCoin = 2000;
									AvNumber = 3;
								}else if(ingame.BuyAvatarNum == 3) {
									BuyoutCoin = 3000;
									AvNumber = 4;
								}else if(ingame.BuyAvatarNum == 4) {
									BuyoutCoin = 4000;
									AvNumber = 5;
								}
								
								if(ingame.InformationCoin >= BuyoutCoin) {
									ingame.BuyAvatarNum = 0;
									ingame.writer.println("UpAv/c;"+AvNumber+"/c;"+ingame.InformationCoin+"/c;"+
															BuyoutCoin+"/c;"+ingame.InformationId);
								}else {
									System.out.println("코인부족");
								}
								
								if(ingame.BuyAvatarNum == 0) {
									ingame.writer.println("UpdInfo/c;"+ingame.InformationId);
									
									while(ingame.updateinfNum == 0) {
										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									ingame.updateinfNum = 0;
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
						if(ingame.QuitGameNum == 1) {
							break;
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
								break;
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
						
						if(ingame.QuitGameNum == 1) {
							break;
						}
						
						if(ingame.LogoutNum == 1) {
							ingame.LogoutNum = 0;
							break;
						}
						continue;
					}
					
				}
				if(ingame.QuitGameNum == 1) {
					ingame.QuitGameNum = 0;
					ingame.writer.println("QuiteGame/c;"+ingame.InformationId);
					break;
				}
			}
			
		} catch (IOException e) {
			System.out.println("서버 주소 오류");
			
		} finally {
			System.out.println("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			try {
				ingame.writer.println("QuiteGame/c;"+ingame.InformationId);
				ingame.s.close();
				ingame.reader.close();
				ingame.writer.close();
				System.exit(0);
			} catch (IOException e1) {
				System.out.println("소켓 닫기 에러");
			}
		}
	}
	
}