package TheBombBoy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class InGame extends JFrame {
	
	String ipNum = "localhost";
	
	JPanel BarPane = new JPanel();
	JPanel DarkPane = new JPanel();
	JPanel FirstPane = new JPanel();
	JPanel ProjectGuidPane = new JPanel();
	JPanel LoginPane = new JPanel();
	JPanel SignUpPane = new JPanel();
	JPanel StartGamePane = new JPanel();
	JPanel GamePlayPane = new JPanel();
	JPanel MyPagePane = new JPanel();
	JPanel ChangeNamePane = new JPanel();
	JPanel ChangePwPane = new JPanel();
	JPanel ShopPane = new JPanel();
	JPanel MessengerPane = new JPanel();
	
	JPanel StageRoadingPane = new JPanel();
	
	JPanel Stage1EASYPane = new JPanel();
	JPanel Stage1MEDIUMPane = new JPanel();
	JPanel Stage1HARDPane = new JPanel();
	
	JPanel StageClearPane = new JPanel();
	JPanel StageFailePane = new JPanel();
	
	JButton QuitGameButton;
	int QuitGameNum = 0;
	
	JButton LogoutButton;
	int LogoutNum = 0;
	
	JButton InGameButton;
	JButton MyPageButton;
	JButton ShopButton;
	JButton MessengerButton;
	
	JFrame Gameframe;
	
	int LoginNum = 0;
	int signNum = 0;
	int joinNum = 0;
	int ChangeNameNum = 0;
	int ChangePwNum = 0;
	int BuyAvatarNum = 0;
	
	JTextField signIdField;  //회원가입
	JPasswordField signPwField;
	JTextField signNameField;
	
	JTextField Idfield; //로그인
	JPasswordField Pwfield;
	
	JTextField MyPageIdText; //마페
	JTextField MyPageNameText;
	JTextField MyPageLevelText;
	JTextField MyPageAliasText;
	JTextField MyPageCoinfield;
	JLabel MyPageAvatar;
	
	JTextField ChangeNamefield;
	
	JPasswordField ChangePwfield;
	JPasswordField ChangeCurrentPwfield;
	
	ExitGameButtonG egb = new ExitGameButtonG();
	GameProfileBoxG gpbg = new GameProfileBoxG(this);
	MyAvatar mav = new MyAvatar();
	vLair vla = new vLair();
	MyBomb mb = new MyBomb();
	StageSkyG ssg = new StageSkyG();
	Villain1G vl1g = new Villain1G();
	Villain2G vl2g = new Villain2G();
	Villain3G vl3g = new Villain3G();
	Villain3_bulletG v3bg = new Villain3_bulletG();
	Stage1BossG s1b = new Stage1BossG();
	
	GoldCoinG gcg = new GoldCoinG();
	GoldCoin2G gc2g = new GoldCoin2G();
	GoldCoin3G gc3g = new GoldCoin3G();
	GoldBox1G gb1g = new GoldBox1G();
	
	GameUserDAO GUD = new GameUserDAO();
	
	String InformationId;
	String InformationPw;
	String InformationName;
	int InformationLevel;
	String InformationAlias;
	int InformationStage;
	int InformationCoin;
	int InformationAvatar;
	
	JLabel UserAvatar = new JLabel();
	int AvatarMove = 0;
	
	JLabel villainsLair = new JLabel();
	int LairDamageNum = 0;
	
	JLabel UserBomb = new JLabel();
	int BombTime = 0;
	
	JLabel Stage1Sky = new JLabel();
	
	JLabel Villain1 = new JLabel();
	JLabel Villain2 = new JLabel();
	JLabel Villain3 = new JLabel();
	int Villain3_Shot;
	JLabel Villain3_bullet = new JLabel();
	JLabel Stage1Boss = new JLabel();
	
	int medium1start;
	int easy1start;
	int hard1start;
	
	JLabel GoldCoin = new JLabel();
	int SaveVillain1_x;
	int SaveVillain1_y;
	
	JLabel GoldCoin2 = new JLabel();
	int SaveVillain2_x;
	int SaveVillain2_y;
	
	JLabel GoldCoin3 = new JLabel();
	int SaveVillain3_x;
	int SaveVillain3_y;
	
	JLabel GoldBox1 = new JLabel();
	int Stage1Boss_x;
	int Stage1Boss_y;
	int Stage1Boss_dead;
	
	JLabel ExitGameButton;
	int ExitGameNum = 0;
	
	JLabel GameTimer;
	int TimeOverNum = 0;
	
	JLabel GameProfileBox;
	
	//-----------------------------------
	
	Socket s;
	PrintWriter writer;
	BufferedReader reader;
	
	JTextArea MessengerArea;
	JTextField MessengerField;
	
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> MessengerList;
	
	InGame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("The Bomb Boy");
		this.setBackground(Color.BLACK);
		this.setSize(1300,750);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Gameframe = this;

		Stage1HARDPanel();
		Stage1MEDIUMPanel();
		Stage1EASYPanel();
		StageRoadingPanel();
		StageClearPanel();
		StageFailePanel();
		
		BarPanel();
		MessengerPanel();
		ShopPanel();
		ChangePwPanel();
		ChangeNamePanel();
		MyPagePanel();
		GamePlayPanel();
		StartGamePanel();
		SignUpPanel();
		LoginPanel();
		ProjectGuidPanel();
		FirstPanel();
		DarkPanel();
		
		this.setVisible(true);
		
		GameThread gt = new GameThread(this);
		Thread gt_Thread = new Thread(gt);
		gt_Thread.start();
	}
	
	void BarPanel() {
		BarPane = new JPanel();
		BarPane.setBackground(Color.DARK_GRAY);
		BarPane.setLayout(new GridLayout(1, 4));
		
		Font BarButtonFont = new Font("Arial", Font.BOLD, 25);
		
		InGameButton = new JButton("Home");
		InGameButton.setForeground(Color.DARK_GRAY);
		InGameButton.setFont(BarButtonFont);
		
		MyPageButton = new JButton("My Page");
		MyPageButton.setForeground(Color.DARK_GRAY);
		MyPageButton.setFont(BarButtonFont);
		
		ShopButton = new JButton("Shop");
		ShopButton.setForeground(Color.DARK_GRAY);
		ShopButton.setFont(BarButtonFont);
		
		MessengerButton = new JButton("Messenger");
		MessengerButton.setForeground(Color.DARK_GRAY);
		MessengerButton.setFont(BarButtonFont);
		
		BarPane.add(InGameButton);
		BarPane.add(MyPageButton);
		BarPane.add(ShopButton);
		BarPane.add(MessengerButton);
		
		add(BarPane, BorderLayout.SOUTH);
		
		InGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joinNum = 1;
			}
		});
		
		MyPageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joinNum = 3;
			}
		});
		
		ShopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joinNum = 4;
			}
		});
		
		MessengerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				joinNum = 5;
			}
		});
		
	}
	
	void closePane() {
		FirstPane.setVisible(false);
		DarkPane.setVisible(false);
		ProjectGuidPane.setVisible(false);
		LoginPane.setVisible(false);
		SignUpPane.setVisible(false);
		StartGamePane.setVisible(false);
		GamePlayPane.setVisible(false);
		MyPagePane.setVisible(false);
		ChangeNamePane.setVisible(false);
		ChangePwPane.setVisible(false);
		ShopPane.setVisible(false);
		MessengerPane.setVisible(false);
		
		StageRoadingPane.setVisible(false);
		Stage1EASYPane.setVisible(false);
		Stage1MEDIUMPane.setVisible(false);
		Stage1HARDPane.setVisible(false);
		StageClearPane.setVisible(false);
		StageFailePane.setVisible(false);
	}
	
	void DarkPanel() {
		DarkPane = new JPanel();
		DarkPane.setBackground(Color.BLACK);
		DarkPane.setLayout(null);
		
		add(DarkPane);
		
		closePane();
		DarkPane.setVisible(true);
	}
	
	void FirstPanel() {
		FirstPane = new JPanel();
		FirstPane.setBackground(Color.RED);
		FirstPane.setLayout(null);
		
		JLabel FirstPaneText = new JLabel("The Bomb Boy");
		Font FirstPaneTextFont = new Font("Arial", Font.BOLD , 100);
		FirstPaneText.setFont(FirstPaneTextFont);
		FirstPaneText.setForeground(Color.WHITE);
		FirstPaneText.setSize(750,200);
		FirstPaneText.setLocation(300,200);
		FirstPane.add(FirstPaneText);
		
		JLabel GwonText = new JLabel("Made by. Kim-GwonHyeok");
		Font GwonTextFont = new Font("Arial", Font.ITALIC , 50);
		GwonText.setFont(GwonTextFont);
		GwonText.setForeground(Color.WHITE);
		GwonText.setSize(600,100);
		GwonText.setLocation(350,400);
		FirstPane.add(GwonText);
		
		add(FirstPane);
		
		closePane();
		FirstPane.setVisible(true);
	}
	
	void ProjectGuidPanel() {
		
		ProjectGuidPane = new JPanel();
		ProjectGuidPane.setBackground(Color.BLACK);
		ProjectGuidPane.setLayout(null);
		
		Font GuidFont = new Font("Arial", Font.PLAIN, 40);
		
		JLabel GuidText1 = new JLabel("Developer");
		GuidText1.setForeground(Color.WHITE);
		GuidText1.setFont(GuidFont);
		GuidText1.setSize(200, 100);
		GuidText1.setLocation(570,100);
		
		JLabel GuidText2 = new JLabel("Dept. of Artificial Intelligence Convergence Software");
		GuidText2.setForeground(Color.WHITE);
		GuidText2.setFont(GuidFont);
		GuidText2.setSize(1000,100);
		GuidText2.setLocation(200,200);
		
		JLabel GuidText3 = new JLabel("********** / Kim - Gwon Hyeok");
		GuidText3.setForeground(Color.WHITE);
		GuidText3.setFont(GuidFont);
		GuidText3.setSize(700,100);
		GuidText3.setLocation(360,300);
		
		ProjectGuidPane.add(GuidText1);
		ProjectGuidPane.add(GuidText2);
		ProjectGuidPane.add(GuidText3);
		
		add(ProjectGuidPane);
		
		closePane();
		ProjectGuidPane.setVisible(true);
		
	}
	
	void LoginPanel() {
		
		LoginPane = new JPanel();
		LoginPane.setBackground(Color.DARK_GRAY);
		LoginPane.setLayout(null);
		
		Font LoginTitlefont = new Font("Alial", Font.ITALIC, 70);
		JLabel LoginTitleText = new JLabel("The Bomb Boy");
		LoginTitleText.setForeground(Color.RED);
		LoginTitleText.setFont(LoginTitlefont);
		LoginTitleText.setSize(500, 200);
		LoginTitleText.setLocation(410, 40);
		LoginPane.add(LoginTitleText);
		
		JPanel LoginTool = new JPanel();
		LoginTool.setLayout(new GridLayout(7,2));
		LoginTool.setBackground(Color.WHITE);
		LoginTool.setSize(500,200);
		LoginTool.setLocation(400,220);
		
		Font LoginFont1 = new Font("Alial", Font.ITALIC, 20);
		Font LoginFont2 = new Font("Alial", Font.BOLD, 15);
		
		JLabel Idlabel = new JLabel("ID : ");
		Idlabel.setFont(LoginFont1);
		Idlabel.setHorizontalAlignment(JLabel.CENTER);
		Idlabel.setVerticalAlignment(JLabel.CENTER);
		
		Idfield = new JTextField();
		Idfield.setBackground(Color.LIGHT_GRAY);
		
		JLabel Pwlabel = new JLabel("PW : ");
		Pwlabel.setFont(LoginFont1);
		Pwlabel.setHorizontalAlignment(JLabel.CENTER);
		Pwlabel.setVerticalAlignment(JLabel.CENTER);
		
		Pwfield = new JPasswordField();
		Pwfield.setBackground(Color.LIGHT_GRAY);
		
		JButton SignUpButton = new JButton("Sign up");
		SignUpButton.setFont(LoginFont2);
		
		JButton LoginButton = new JButton("Log in");
		LoginButton.setFont(LoginFont2);
		
		JLabel nolabel1 = new JLabel("");
		JLabel nolabel2 = new JLabel("");
		JLabel nolabel3 = new JLabel("");
		JLabel nolabel4 = new JLabel("");
		JLabel nolabel5 = new JLabel("");
		JLabel nolabel6 = new JLabel("");
		JLabel nolabel7 = new JLabel("");
		JLabel nolabel8 = new JLabel("");
		
		LoginTool.add(nolabel1);
		LoginTool.add(nolabel2);
		
		LoginTool.add(Idlabel);
		LoginTool.add(Idfield);
		
		LoginTool.add(nolabel3);
		LoginTool.add(nolabel4);
		
		LoginTool.add(Pwlabel);
		LoginTool.add(Pwfield);
		
		LoginTool.add(nolabel5);
		LoginTool.add(nolabel6);
		
		LoginTool.add(SignUpButton);
		LoginTool.add(LoginButton);
		
		LoginTool.add(nolabel7);
		LoginTool.add(nolabel8);
		
		LoginPane.add(LoginTool);
		
		QuitGameButtonM();
		LoginPane.add(QuitGameButton);
		
		add(LoginPane);
		
		closePane();
		LoginPane.setVisible(true);
		
		LoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginNum = 1;
			}
		});
		
		SignUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginNum = 2;
			}
		});
		
		Idfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					LoginNum = 1;
				}
			}
		});
		
		Pwfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					LoginNum = 1;
				}
			}
		});
		
	}
	
	void SignUpPanel() {
		
		SignUpPane = new JPanel();
		SignUpPane.setBackground(Color.DARK_GRAY);
		SignUpPane.setLayout(null);
		
		Font LoginTitlefont = new Font("Alial", Font.ITALIC, 70);
		JLabel LoginTitleText = new JLabel("The Bomb Boy");
		LoginTitleText.setForeground(Color.RED);
		LoginTitleText.setFont(LoginTitlefont);
		LoginTitleText.setSize(500, 200);
		LoginTitleText.setLocation(410, 40);
		SignUpPane.add(LoginTitleText);
		
		JPanel SignUpTool = new JPanel();
		SignUpTool.setBackground(Color.WHITE);
		SignUpTool.setSize(500,200);
		SignUpTool.setLocation(400,220);
		SignUpTool.setLayout(new GridLayout(9,2));
		
		Font SignFont1 = new Font("Alial", Font.ITALIC, 20);
		Font SignFont2 = new Font("Alial", Font.BOLD, 15);
		
		JLabel signId = new JLabel("ID :");
		signId.setFont(SignFont1);
		signId.setHorizontalAlignment(JLabel.CENTER);
		signId.setVerticalAlignment(JLabel.CENTER);
		
		signIdField = new JTextField();
		signIdField.setBackground(Color.LIGHT_GRAY);
		
		JLabel signPw = new JLabel("PW :");
		signPw.setFont(SignFont1);
		signPw.setHorizontalAlignment(JLabel.CENTER);
		signPw.setVerticalAlignment(JLabel.CENTER);
		
		signPwField = new JPasswordField();
		signPwField.setBackground(Color.LIGHT_GRAY);
		
		JLabel signName = new JLabel("Name : ");
		signName.setFont(SignFont1);
		signName.setHorizontalAlignment(JLabel.CENTER);
		signName.setVerticalAlignment(JLabel.CENTER);
		
		signNameField = new JTextField();
		signNameField.setBackground(Color.LIGHT_GRAY);
		
		JButton signButton = new JButton("Sign Up");
		signButton.setFont(SignFont2);
		
		JButton signBackButton = new JButton("Back");
		signBackButton.setFont(SignFont2);
		
		JLabel nonLabel1 = new JLabel("");
		JLabel nonLabel2 = new JLabel("");
		JLabel nonLabel3 = new JLabel("");
		JLabel nonLabel4 = new JLabel("");
		JLabel nonLabel5 = new JLabel("");
		JLabel nonLabel6 = new JLabel("");
		JLabel nonLabel7 = new JLabel("");
		JLabel nonLabel8 = new JLabel("");
		JLabel nonLabel9 = new JLabel("");
		JLabel nonLabel10 = new JLabel("");
		
		SignUpTool.add(nonLabel1);
		SignUpTool.add(nonLabel2);
		
		SignUpTool.add(signId);
		SignUpTool.add(signIdField);
		
		SignUpTool.add(nonLabel3);
		SignUpTool.add(nonLabel4);
		
		SignUpTool.add(signPw);
		SignUpTool.add(signPwField);
		
		SignUpTool.add(nonLabel5);
		SignUpTool.add(nonLabel6);
		
		SignUpTool.add(signName);
		SignUpTool.add(signNameField);
		
		SignUpTool.add(nonLabel7);
		SignUpTool.add(nonLabel8);
		
		SignUpTool.add(signBackButton);
		SignUpTool.add(signButton);
		
		SignUpTool.add(nonLabel9);
		SignUpTool.add(nonLabel10);
		
		SignUpPane.add(SignUpTool);
		
		QuitGameButtonM();
		SignUpPane.add(QuitGameButton);
		
		add(SignUpPane);
		
		closePane();
		SignUpPane.setVisible(true);
		
		signButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signNum = 1;
			}
		});
		
		signBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signNum = 2;
			}
		});
		
		signIdField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					signNum = 1;
				}
			}
		});
		
		signPwField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					signNum = 1;
				}
			}
		});
		
		signNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					signNum = 1;
				}
			}
		});
		
	}
	
	void StartGamePanel() {
		
		StartGamePane = new JPanel();
		StartGamePane.setBackground(Color.DARK_GRAY);
		StartGamePane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		StartGamePane.add(GameTitleText);
		
		Font StartGameFont1 = new Font("Alial", Font.ITALIC, 20);
		Font StartGameFont2 = new Font("Alial", Font.BOLD, 60);
		
		JLabel StartGameText = new JLabel();
		StartGameText.setText("To start the game, please click this button.");
		StartGameText.setSize(700, 100);
		StartGameText.setLocation(450, 170);
		StartGameText.setFont(StartGameFont1);
		StartGameText.setForeground(Color.LIGHT_GRAY);
		StartGamePane.add(StartGameText);
		
		JButton StartGameButton1 = new JButton();
		StartGameButton1.setSize(400, 100);
		StartGameButton1.setLocation(450,240);
		StartGameButton1.setForeground(Color.BLACK);
		StartGameButton1.setFont(StartGameFont2);
		StartGameButton1.setText("Adventure");
		StartGameButton1.setForeground(Color.GREEN);
		StartGamePane.add(StartGameButton1);
		
		JButton StartGameButton2 = new JButton();
		StartGameButton2.setSize(400, 100);
		StartGameButton2.setLocation(450,360);
		StartGameButton2.setForeground(Color.BLACK);
		StartGameButton2.setFont(StartGameFont2);
		StartGameButton2.setText("Bomb Pass");
		StartGameButton2.setForeground(Color.BLUE);
		StartGamePane.add(StartGameButton2);
		
		QuitGameButtonM();
		StartGamePane.add(QuitGameButton);
		
		LogoutButtonM();
		StartGamePane.add(LogoutButton);
		
		add(StartGamePane);
		
		closePane();
		StartGamePane.setVisible(true);
		
		
		StartGameButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 2;
				
			}
		});
		
	}
	
	void GamePlayPanel() {
		
		GamePlayPane = new JPanel();
		GamePlayPane.setBackground(Color.DARK_GRAY);
		GamePlayPane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		GamePlayPane.add(GameTitleText);
		
		Font GamePlayFont1 = new Font("Arial", Font.BOLD, 20);
		Font GamePlayFont2 = new Font("Arial", Font.BOLD, 30);
		Font GamePlayFont3 = new Font("Alial", Font.ITALIC, 20);
		
		JLabel GamePlayGuidText = new JLabel();
		GamePlayGuidText.setText("Please choose a stage.");
		GamePlayGuidText.setSize(700, 100);
		GamePlayGuidText.setLocation(550, 100);
		GamePlayGuidText.setFont(GamePlayFont3);
		GamePlayGuidText.setForeground(Color.LIGHT_GRAY);
		GamePlayPane.add(GamePlayGuidText);
		
		JPanel GamePlayStageType = new JPanel();
		GamePlayStageType.setSize(150, 400);
		GamePlayStageType.setLocation(430,180);
		GamePlayStageType.setLayout(new GridLayout(3,1));
		GamePlayStageType.setBackground(Color.DARK_GRAY);
		
		JLabel Stage1Type = new JLabel("STAGE 1");
		Stage1Type.setBackground(Color.GREEN);
		Stage1Type.setOpaque(true);
		Stage1Type.setHorizontalAlignment(JLabel.CENTER);
		Stage1Type.setVerticalAlignment(JLabel.CENTER);
		Stage1Type.setForeground(Color.WHITE);
		Stage1Type.setFont(GamePlayFont2);
		
		JLabel Stage2Type = new JLabel("STAGE 2");
		Stage2Type.setBackground(Color.BLUE);
		Stage2Type.setOpaque(true);
		Stage2Type.setHorizontalAlignment(JLabel.CENTER);
		Stage2Type.setVerticalAlignment(JLabel.CENTER);
		Stage2Type.setForeground(Color.WHITE);
		Stage2Type.setFont(GamePlayFont2);
		
		JLabel Stage3Type = new JLabel("STAGE 3");
		Stage3Type.setBackground(Color.RED);
		Stage3Type.setOpaque(true);
		Stage3Type.setHorizontalAlignment(JLabel.CENTER);
		Stage3Type.setVerticalAlignment(JLabel.CENTER);
		Stage3Type.setForeground(Color.WHITE);
		Stage3Type.setFont(GamePlayFont2);
		
		GamePlayStageType.add(Stage1Type);
		GamePlayStageType.add(Stage2Type);
		GamePlayStageType.add(Stage3Type);
		
		GamePlayPane.add(GamePlayStageType);
		
		JPanel GamePlaySelect = new JPanel();
		GamePlaySelect.setSize(300, 400);
		GamePlaySelect.setLocation(580,180);
		GamePlaySelect.setBackground(Color.DARK_GRAY);
		GamePlaySelect.setLayout(new GridLayout(19,2));
		
		JLabel Stage1EASY = new JLabel("EASY");
		Stage1EASY.setHorizontalAlignment(JLabel.CENTER);
		Stage1EASY.setVerticalAlignment(JLabel.CENTER);
		Stage1EASY.setBackground(Color.GREEN);
		Stage1EASY.setOpaque(true);
		Stage1EASY.setForeground(Color.WHITE);
		Stage1EASY.setFont(GamePlayFont1);
		JButton Stage1EASYButton = new JButton("START");
		Stage1EASYButton.setFont(GamePlayFont1);
		
		JLabel Stage1MEDIUM = new JLabel("MEDIUM");
		Stage1MEDIUM.setHorizontalAlignment(JLabel.CENTER);
		Stage1MEDIUM.setVerticalAlignment(JLabel.CENTER);
		Stage1MEDIUM.setBackground(Color.GREEN);
		Stage1MEDIUM.setOpaque(true);
		Stage1MEDIUM.setForeground(Color.WHITE);
		Stage1MEDIUM.setFont(GamePlayFont1);
		JButton Stage1MEDIUMButton = new JButton("START");
		Stage1MEDIUMButton.setFont(GamePlayFont1);
		
		JLabel Stage1HARD = new JLabel("HARD");
		Stage1HARD.setHorizontalAlignment(JLabel.CENTER);
		Stage1HARD.setVerticalAlignment(JLabel.CENTER);
		Stage1HARD.setBackground(Color.GREEN);
		Stage1HARD.setOpaque(true);
		Stage1HARD.setForeground(Color.WHITE);
		Stage1HARD.setFont(GamePlayFont1);
		JButton Stage1HARDButton = new JButton("START");
		Stage1HARDButton.setFont(GamePlayFont1);
		
		JLabel Stage2EASY = new JLabel("EASY");
		Stage2EASY.setHorizontalAlignment(JLabel.CENTER);
		Stage2EASY.setVerticalAlignment(JLabel.CENTER);
		Stage2EASY.setBackground(Color.BLUE);
		Stage2EASY.setOpaque(true);
		Stage2EASY.setForeground(Color.WHITE);
		Stage2EASY.setFont(GamePlayFont1);
		JButton Stage2EASYButton = new JButton("START");
		Stage2EASYButton.setFont(GamePlayFont1);
		
		JLabel Stage2MEDIUM = new JLabel("MEDIUM");
		Stage2MEDIUM.setHorizontalAlignment(JLabel.CENTER);
		Stage2MEDIUM.setVerticalAlignment(JLabel.CENTER);
		Stage2MEDIUM.setBackground(Color.BLUE);
		Stage2MEDIUM.setOpaque(true);
		Stage2MEDIUM.setForeground(Color.WHITE);
		Stage2MEDIUM.setFont(GamePlayFont1);
		JButton Stage2MEDIUMButton = new JButton("START");
		Stage2MEDIUMButton.setFont(GamePlayFont1);
		
		JLabel Stage2HARD = new JLabel("HARD");
		Stage2HARD.setHorizontalAlignment(JLabel.CENTER);
		Stage2HARD.setVerticalAlignment(JLabel.CENTER);
		Stage2HARD.setBackground(Color.BLUE);
		Stage2HARD.setOpaque(true);
		Stage2HARD.setForeground(Color.WHITE);
		Stage2HARD.setFont(GamePlayFont1);
		JButton Stage2HARDButton = new JButton("START");
		Stage2HARDButton.setFont(GamePlayFont1);
		
		JLabel Stage3EASY = new JLabel("EASY");
		Stage3EASY.setHorizontalAlignment(JLabel.CENTER);
		Stage3EASY.setVerticalAlignment(JLabel.CENTER);
		Stage3EASY.setBackground(Color.RED);
		Stage3EASY.setOpaque(true);
		Stage3EASY.setForeground(Color.WHITE);
		Stage3EASY.setFont(GamePlayFont1);
		JButton Stage3EASYButton = new JButton("START");
		Stage3EASYButton.setFont(GamePlayFont1);
		
		JLabel Stage3MEDIUM = new JLabel("MEDIUM");
		Stage3MEDIUM.setHorizontalAlignment(JLabel.CENTER);
		Stage3MEDIUM.setVerticalAlignment(JLabel.CENTER);
		Stage3MEDIUM.setBackground(Color.RED);
		Stage3MEDIUM.setOpaque(true);
		Stage3MEDIUM.setForeground(Color.WHITE);
		Stage3MEDIUM.setFont(GamePlayFont1);
		JButton Stage3MEDIUMButton = new JButton("START");
		Stage3MEDIUMButton.setFont(GamePlayFont1);
		
		JLabel Stage3HARD = new JLabel("HARD");
		Stage3HARD.setHorizontalAlignment(JLabel.CENTER);
		Stage3HARD.setVerticalAlignment(JLabel.CENTER);
		Stage3HARD.setBackground(Color.RED);
		Stage3HARD.setOpaque(true);
		Stage3HARD.setForeground(Color.WHITE);
		Stage3HARD.setFont(GamePlayFont1);
		JButton Stage3HARDButton = new JButton("START");
		Stage3HARDButton.setFont(GamePlayFont1);
		
		JLabel gpnolabel1 = new JLabel("");
		JLabel gpnolabel2 = new JLabel("");
		JLabel gpnolabel3 = new JLabel("");
		JLabel gpnolabel4 = new JLabel("");
		JLabel gpnolabel5 = new JLabel("");
		JLabel gpnolabel6 = new JLabel("");
		JLabel gpnolabel7 = new JLabel("");
		JLabel gpnolabel8 = new JLabel("");
		JLabel gpnolabel9 = new JLabel("");
		JLabel gpnolabel10 = new JLabel("");
		JLabel gpnolabel11 = new JLabel("");
		JLabel gpnolabel12 = new JLabel("");
		JLabel gpnolabel13 = new JLabel("");
		JLabel gpnolabel14 = new JLabel("");
		JLabel gpnolabel15 = new JLabel("");
		JLabel gpnolabel16 = new JLabel("");
		JLabel gpnolabel17 = new JLabel("");
		JLabel gpnolabel18 = new JLabel("");
		JLabel gpnolabel19 = new JLabel("");
		JLabel gpnolabel20 = new JLabel("");
		
		GamePlaySelect.add(gpnolabel1);
		GamePlaySelect.add(gpnolabel2);
		
		GamePlaySelect.add(Stage1EASY);
		GamePlaySelect.add(Stage1EASYButton);
		
		GamePlaySelect.add(gpnolabel3);
		GamePlaySelect.add(gpnolabel4);
		
		GamePlaySelect.add(Stage1MEDIUM);
		GamePlaySelect.add(Stage1MEDIUMButton);
		
		GamePlaySelect.add(gpnolabel5);
		GamePlaySelect.add(gpnolabel6);
		
		GamePlaySelect.add(Stage1HARD);
		GamePlaySelect.add(Stage1HARDButton);
		
		GamePlaySelect.add(gpnolabel7);
		GamePlaySelect.add(gpnolabel8);
		
		GamePlaySelect.add(Stage2EASY);
		GamePlaySelect.add(Stage2EASYButton);
		
		GamePlaySelect.add(gpnolabel9);
		GamePlaySelect.add(gpnolabel10);
		
		GamePlaySelect.add(Stage2MEDIUM);
		GamePlaySelect.add(Stage2MEDIUMButton);
		
		GamePlaySelect.add(gpnolabel11);
		GamePlaySelect.add(gpnolabel12);
		
		GamePlaySelect.add(Stage2HARD);
		GamePlaySelect.add(Stage2HARDButton);
		
		GamePlaySelect.add(gpnolabel13);
		GamePlaySelect.add(gpnolabel14);
		
		GamePlaySelect.add(Stage3EASY);
		GamePlaySelect.add(Stage3EASYButton);
		
		GamePlaySelect.add(gpnolabel15);
		GamePlaySelect.add(gpnolabel16);
		
		GamePlaySelect.add(Stage3MEDIUM);
		GamePlaySelect.add(Stage3MEDIUMButton);
		
		GamePlaySelect.add(gpnolabel17);
		GamePlaySelect.add(gpnolabel18);
		
		GamePlaySelect.add(Stage3HARD);
		GamePlaySelect.add(Stage3HARDButton);
		
		GamePlaySelect.add(gpnolabel19);
		GamePlaySelect.add(gpnolabel20);
		
		GamePlayPane.add(GamePlaySelect);
		
		JButton GamePlayExiteButton = new JButton("BACK");
		GamePlayExiteButton.setSize(100,50);
		GamePlayExiteButton.setLocation(600,600);
		GamePlayExiteButton.setFont(GamePlayFont1);
		GamePlayPane.add(GamePlayExiteButton);
		
		QuitGameButtonM();
		GamePlayPane.add(QuitGameButton);
		
		LogoutButtonM();
		GamePlayPane.add(LogoutButton);
		
		add(GamePlayPane);
		
		closePane();
		GamePlayPane.setVisible(true);
		
		Stage1EASYButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 8;
				
			}
		});
		
		Stage1MEDIUMButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 9;
				
			}
		});
		
		Stage1HARDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 10;
				
			}
		});
		
		Stage2EASYButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 11;
				
			}
		});
		
		Stage2MEDIUMButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 12;
				
			}
		});
		
		Stage2HARDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 13;
				
			}
		});
		
		Stage3EASYButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 14;
				
			}
		});
		
		Stage3MEDIUMButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 15;
				
			}
		});
		
		Stage3HARDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 16;
				
			}
		});
		
		GamePlayExiteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 1;
				
			}
		});
		
	}
	
	void StageRoadingPanel() {
		
		StageRoadingPane = new JPanel();
		StageRoadingPane.setBackground(Color.BLACK);
		StageRoadingPane.setLayout(null);
		
		Font StageRoadingFont = new Font("Alial", Font.ITALIC, 100);
		JLabel StageRoadingText = new JLabel("Game Start!");
		StageRoadingText.setSize(600, 100);
		StageRoadingText.setLocation(330,300);
		StageRoadingText.setHorizontalAlignment(JLabel.CENTER);
		StageRoadingText.setVerticalAlignment(JLabel.CENTER);
		StageRoadingText.setForeground(Color.CYAN);
		StageRoadingText.setFont(StageRoadingFont);
		StageRoadingPane.add(StageRoadingText);
		
		add(StageRoadingPane);
		
		closePane();
		StageRoadingPane.setVisible(true);
		
	}
	
	void UserAvatarM() {
		
		UserAvatar = new JLabel();
		UserAvatar.setSize(100, 110);
		
		int x = 100;
		int y = 500;
		
		UserAvatar.setLocation(x,y);
		UserAvatar.setOpaque(false);
		
		UserAvatarThread uat = new UserAvatarThread(this);
		Thread AvatarT = new Thread(uat);
		AvatarT.start();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					AvatarMove = 4;
					if(UserAvatar.getLocation().x >= 20) {
						UserAvatar.setLocation(UserAvatar.getLocation().x-5, UserAvatar.getLocation().y);
					}else if(UserAvatar.getLocation().x <= 20) {
						UserAvatar.setLocation(UserAvatar.getLocation().x, UserAvatar.getLocation().y);
					}
					
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					AvatarMove = 3;
					if(UserAvatar.getLocation().x <= 1180) {
						UserAvatar.setLocation(UserAvatar.getLocation().x+5, UserAvatar.getLocation().y);
					}else if(UserAvatar.getLocation().x >= 1180) {
						UserAvatar.setLocation(UserAvatar.getLocation().x, UserAvatar.getLocation().y);
					}
					
				}else if(e.getKeyCode() == KeyEvent.VK_UP) {
					AvatarMove = 2;
					if(UserAvatar.getLocation().y >= 175) {
						UserAvatar.setLocation(UserAvatar.getLocation().x, UserAvatar.getLocation().y-5);
					}else if(UserAvatar.getLocation().y <= 175){
						UserAvatar.setLocation(UserAvatar.getLocation().x, UserAvatar.getLocation().y);
					}
					
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					AvatarMove = 1;
					if(UserAvatar.getLocation().y <= 500) {
						UserAvatar.setLocation(UserAvatar.getLocation().x, UserAvatar.getLocation().y+5);
					}else if(UserAvatar.getLocation().y >= 500) {
						UserAvatar.setLocation(UserAvatar.getLocation().x, UserAvatar.getLocation().y);
					}
										
				}
				
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					if(BombTime == 0) {
						UserBomb.setLocation(UserAvatar.getLocation().x+25, UserAvatar.getLocation().y+50);
						BombTime = 1;
					}
					
				}
			}
		});
		setFocusable(true);
		requestFocus();
		
	}
		
	void UserBombM() {
		UserBomb = new JLabel();
		UserBomb.setSize(50,50);
		UserBomb.setLocation(0,0);
		UserBomb.setOpaque(false);
		UserBomb.setVisible(false);
		
		UserBombThread ubt = new UserBombThread(this);
		Thread UserBombT = new Thread(ubt);
		UserBombT.start();
	}
	
	void villainsLairM() {
		villainsLair = new JLabel();
		villainsLair.setSize(200,250);
		villainsLair.setLocation(1000,30);
		villainsLair.setOpaque(false);
		
		villainsLairThread vlt = new villainsLairThread(this);
		Thread lairT = new Thread(vlt);
		lairT.start();
	}
	
	void Villain1M() {
		
		Villain1 = new JLabel();
		
		Villain1.setSize(100,110);
		
		int v1x = 700;
		int v1y = 300;
		
		Villain1.setLocation(v1x,v1y);
		Villain1.setOpaque(false);
		
		Villain1Thread vl1t = new Villain1Thread(this);
		Thread Villain1T = new Thread(vl1t);
		Villain1T.start();
		
	}
	
	void Villain2M() {
		
		Villain2 = new JLabel();
		
		Villain2.setSize(100,110);
		
		int v1x = 800;
		int v1y = 500;
		
		Villain2.setLocation(v1x,v1y);
		Villain2.setOpaque(false);
		
		Villain2Thread vl2t = new Villain2Thread(this);
		Thread Villain2T = new Thread(vl2t);
		Villain2T.start();
		
	}
	
	void Villain3M() {
		Villain3 = new JLabel();
		Villain3.setSize(100,110);
		
		int v1x = 1100;
		int v1y = 500;
		
		Villain3.setLocation(v1x,v1y);
		Villain3.setOpaque(false);
		
		Villain3Thread vl3t = new Villain3Thread(this);
		Thread Villain3T = new Thread(vl3t);
		Villain3T.start();
	}
	
	void Villain3_bulletM() {
		Villain3_bullet = new JLabel();
		Villain3_bullet.setSize(30,30);
		Villain3_bullet.setOpaque(false);
		Villain3_bullet.setIcon(new ImageIcon(v3bg.makeBullet()));
		Villain3_bullet.setVisible(true);

		Villain3_bulletThread Villain3_BT = new Villain3_bulletThread(this);
		Thread v3bt = new Thread(Villain3_BT);
		v3bt.start();
	}
	
	void Stage1BossM() {
		Stage1Boss = new JLabel();
		Stage1Boss.setSize(300, 110);
		Stage1Boss.setOpaque(false);
		Stage1Boss.setVisible(false);
		
		Stage1BossThread s1bt = new Stage1BossThread(this);
		Thread Stage1BossT = new Thread(s1bt);
		Stage1BossT.start();
	}
	
	void GoldCoinM() {
		GoldCoin = new JLabel();
		GoldCoin.setSize(30,30);
		GoldCoin.setLocation(0,0);
		GoldCoin.setOpaque(false);
		GoldCoin.setVisible(false);
		
		GoldCoinThread gct = new GoldCoinThread(this);
		Thread GoldCoinT = new Thread(gct);
		GoldCoinT.start();
		
		GoldCoinThread2 gct2 = new GoldCoinThread2(this);
		Thread GoldCoinT2 = new Thread(gct2);
		GoldCoinT2.start();
	}
	
	void GoldCoin2M() {
		GoldCoin2 = new JLabel();
		GoldCoin2.setSize(30,30);
		GoldCoin2.setLocation(0,0);
		GoldCoin2.setOpaque(false);
		GoldCoin2.setVisible(false);
		
		GoldCoin2Thread gct2 = new GoldCoin2Thread(this);
		Thread GoldCoin2T = new Thread(gct2);
		GoldCoin2T.start();
		
		GoldCoin2Thread2 gc2t2 = new GoldCoin2Thread2(this);
		Thread GoldCoin2T2 = new Thread(gc2t2);
		GoldCoin2T2.start();
	}
	
	void GoldCoin3M() {
		GoldCoin3 = new JLabel();
		GoldCoin3.setSize(30,30);
		GoldCoin3.setLocation(0,0);
		GoldCoin3.setOpaque(false);
		GoldCoin3.setVisible(false);
		
		GoldCoin3Thread gct3 = new GoldCoin3Thread(this);
		Thread GoldCoin3T = new Thread(gct3);
		GoldCoin3T.start();
		
		GoldCoin3Thread2 gc3t2 = new GoldCoin3Thread2(this);
		Thread GoldCoin3T2 = new Thread(gc3t2);
		GoldCoin3T2.start();
	}
	
	void GoldBox1M() {
		GoldBox1 = new JLabel();
		GoldBox1.setSize(100,100);
		GoldBox1.setLocation(0,0);
		GoldBox1.setOpaque(false);
		GoldBox1.setVisible(false);
		
		GoldBox1Thread gb1t = new GoldBox1Thread(this);
		Thread GoldBox1T = new Thread(gb1t);
		GoldBox1T.start();
		
		GoldBox1Thread2 gb1t2 = new GoldBox1Thread2(this);
		Thread GoldBox1T2 = new Thread(gb1t2);
		GoldBox1T2.start();
	}
	
	void Stage1SkyM() {
		Stage1Sky = new JLabel();
		Stage1Sky.setSize(800, 150);
		Stage1Sky.setLocation(100,0);
		Stage1Sky.setOpaque(false);
		
		Stage1SkyThread s1st = new Stage1SkyThread(this);
		Thread Stage1SkyT = new Thread(s1st);
		Stage1SkyT.start();
	}
	
	void ExitGameButtonM() {
		ExitGameButton = new JLabel();
		ExitGameButton.setSize(80, 80);
		ExitGameButton.setLocation(1210, 630);
		ExitGameButton.setOpaque(false);
		ExitGameButton.setIcon(new ImageIcon(egb.makeButton1()));
		
		ExitGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExitGameNum = 1;
			}
		});
		ExitGameButtonThread egbt = new ExitGameButtonThread(this);
		Thread ExitBTT = new Thread(egbt);
		ExitBTT.start();
	}
	
	void GameTimerM() {
		GameTimer = new JLabel();
		GameTimer.setSize(200, 80);
		GameTimer.setLocation(985,630);
		GameTimer.setOpaque(false);
		GameTimer.setHorizontalAlignment(JLabel.CENTER);
		GameTimer.setVerticalAlignment(JLabel.CENTER);
		GameTimer.setForeground(Color.WHITE);
		Font GameTimerFont = new Font("Arial", Font.BOLD, 70);
		GameTimer.setFont(GameTimerFont);
		
		GameTimerThread gtt = new GameTimerThread(this);
		Thread TimerT = new Thread(gtt);
		TimerT.start();
	}
	
	void GameProfileBoxM() {
		GameProfileBox = new JLabel();
		GameProfileBox.setSize(900, 80);
		GameProfileBox.setLocation(60,630);
		GameProfileBox.setOpaque(false);
		GameProfileBox.setIcon(new ImageIcon(gpbg.makeProfile()));
	}
	
	void Stage1EASYPanel() {
		
		Stage1SkyM();
		UserAvatarM();
		villainsLairM();
		UserBombM();
		Villain1M();
		Villain2M();
		GoldCoinM();
		GoldCoin2M();
		
		Stage1EASYPane = new JPanel();
		Stage1EASYPane.setBackground(Color.GRAY);
		Stage1EASYPane.setLayout(null);
		Stage1EASYPane.add(Stage1Sky);
		
		Stage1EASYPane.add(UserAvatar);
		
		Stage1EASYPane.add(UserBomb);
		
		Stage1EASYPane.add(villainsLair);
		
		Stage1EASYPane.add(Villain1);
		Stage1EASYPane.add(Villain2);
		
		Stage1EASYPane.add(GoldCoin);
		Stage1EASYPane.add(GoldCoin2);
		
		ExitGameButtonM();
		Stage1EASYPane.add(ExitGameButton);
		GameTimerM();
		Stage1EASYPane.add(GameTimer);
		GameProfileBoxM();
		Stage1EASYPane.add(GameProfileBox);
		
		add(Stage1EASYPane);
		
		closePane();
		Stage1EASYPane.setVisible(true);
		
	}
	
	
	
	void Stage1MEDIUMPanel() {
		
		Stage1SkyM();
		UserAvatarM();
		villainsLairM();
		UserBombM();
		Villain1M();
		Villain2M();
		Villain3M();		
		GoldCoinM();
		GoldCoin2M();
		GoldCoin3M();
		Villain3_bulletM();
		
		Stage1MEDIUMPane = new JPanel();
		Stage1MEDIUMPane.setBackground(Color.GRAY);
		Stage1MEDIUMPane.setLayout(null);
		Stage1MEDIUMPane.add(Stage1Sky);
		
		Stage1MEDIUMPane.add(UserAvatar);
		
		Stage1MEDIUMPane.add(UserBomb);
		
		Stage1MEDIUMPane.add(villainsLair);
		
		Stage1MEDIUMPane.add(Villain1);
		Stage1MEDIUMPane.add(Villain2);
		Stage1MEDIUMPane.add(Villain3);
		Stage1MEDIUMPane.add(Villain3_bullet);
		
		Stage1MEDIUMPane.add(GoldCoin);
		Stage1MEDIUMPane.add(GoldCoin2);
		Stage1MEDIUMPane.add(GoldCoin3);
		
		ExitGameButtonM();
		Stage1MEDIUMPane.add(ExitGameButton);
		
		GameTimerM();
		Stage1MEDIUMPane.add(GameTimer);
		
		GameProfileBoxM();
		Stage1MEDIUMPane.add(GameProfileBox);
		
		add(Stage1MEDIUMPane);
		
		closePane();
		Stage1MEDIUMPane.setVisible(true);
		
	}
	
	void Stage1HARDPanel() {
		
		Stage1SkyM();
		UserAvatarM();
		villainsLairM();
		UserBombM();
		Villain1M();
		Villain2M();
		Villain3M();		
		GoldCoinM();
		GoldCoin2M();
		GoldCoin3M();
		GoldBox1M();
		Villain3_bulletM();
		Stage1BossM();
		
		Stage1HARDPane = new JPanel();
		Stage1HARDPane.setBackground(Color.GRAY);
		Stage1HARDPane.setLayout(null);
		
		Stage1HARDPane.add(Stage1Sky);
		
		Stage1HARDPane.add(UserAvatar);
		
		Stage1HARDPane.add(UserBomb);
		
		Stage1HARDPane.add(villainsLair);
		
		Stage1HARDPane.add(Villain1);
		Stage1HARDPane.add(Villain2);
		Stage1HARDPane.add(Villain3);
		Stage1HARDPane.add(Villain3_bullet);
		Stage1HARDPane.add(Stage1Boss);
		
		Stage1HARDPane.add(GoldCoin);
		Stage1HARDPane.add(GoldCoin2);
		Stage1HARDPane.add(GoldCoin3);
		Stage1HARDPane.add(GoldBox1);
		
		ExitGameButtonM();
		Stage1HARDPane.add(ExitGameButton);
		
		GameTimerM();
		Stage1HARDPane.add(GameTimer);
		
		GameProfileBoxM();
		Stage1HARDPane.add(GameProfileBox);
		
		add(Stage1HARDPane);
		
		closePane();
		Stage1HARDPane.setVisible(true);
		
	}
	
	void StageClearPanel() {
		
		StageClearPane = new JPanel();
		StageClearPane.setBackground(Color.BLACK);
		StageClearPane.setLayout(null);
		
		Font StageClearFont = new Font("Alial", Font.ITALIC, 100);
		JLabel StageClearText = new JLabel("Game Clear!");
		StageClearText.setSize(600, 100);
		StageClearText.setLocation(330,300);
		StageClearText.setHorizontalAlignment(JLabel.CENTER);
		StageClearText.setVerticalAlignment(JLabel.CENTER);
		StageClearText.setForeground(Color.CYAN);
		StageClearText.setFont(StageClearFont);
		StageClearPane.add(StageClearText);
		
		add(StageClearPane);
		
		closePane();
		StageClearPane.setVisible(true);
		
	}
	
	void StageFailePanel() {
		
		StageFailePane = new JPanel();
		StageFailePane.setBackground(Color.BLACK);
		StageFailePane.setLayout(null);
		
		Font StageFaileFont = new Font("Alial", Font.ITALIC, 100);
		JLabel StageFaileText = new JLabel("Game Faile!");
		StageFaileText.setSize(600, 100);
		StageFaileText.setLocation(330,300);
		StageFaileText.setHorizontalAlignment(JLabel.CENTER);
		StageFaileText.setVerticalAlignment(JLabel.CENTER);
		StageFaileText.setForeground(Color.RED);
		StageFaileText.setFont(StageFaileFont);
		StageFailePane.add(StageFaileText);
		
		add(StageFailePane);
		
		closePane();
		StageFailePane.setVisible(true);
		
	}
	
	
	void MyPagePanel() {
		
		MyPagePane = new JPanel();
		MyPagePane.setBackground(Color.DARK_GRAY);
		MyPagePane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		MyPagePane.add(GameTitleText);
		
		Font MyPageFont1 = new Font("Arial", Font.BOLD, 60);
		
		Font MyPageFont2 = new Font("Arial", Font.BOLD, 20);
		
		JLabel MyPageTitle = new JLabel("My Page");
		MyPageTitle.setSize(300, 100);
		MyPageTitle.setLocation(500, 30);
		MyPageTitle.setFont(MyPageFont1);
		MyPageTitle.setOpaque(true);
		MyPageTitle.setBackground(Color.LIGHT_GRAY);
		MyPageTitle.setForeground(Color.BLUE);
		MyPageTitle.setHorizontalAlignment(JLabel.CENTER);
		MyPageTitle.setVerticalAlignment(JLabel.CENTER);
		MyPagePane.add(MyPageTitle);
		
		MyPageAvatar = new JLabel();
		MyPageAvatar.setSize(300,300);
		MyPageAvatar.setLocation(500,150);
		MyPageAvatar.setOpaque(true);
		MyPageAvatar.setBackground(Color.GRAY);
		MyPageAvatar.setHorizontalAlignment(JLabel.CENTER);
		MyPageAvatar.setVerticalAlignment(JLabel.CENTER);
		MyPagePane.add(MyPageAvatar);
		
		JPanel MyPageInformation = new JPanel();
		MyPageInformation.setSize(300, 200);
		MyPageInformation.setLocation(500,470);
		MyPageInformation.setLayout(new GridLayout(4,2));
		MyPageInformation.setBackground(Color.WHITE);
		
		JLabel MyPageIdlabel = new JLabel("ID       :");
		MyPageIdlabel.setHorizontalAlignment(JLabel.CENTER);
		MyPageIdlabel.setVerticalAlignment(JLabel.CENTER);
		MyPageIdlabel.setFont(MyPageFont2);
		
		MyPageIdText = new JTextField("");
		MyPageIdText.setEditable(false);
		MyPageIdText.setHorizontalAlignment(JLabel.CENTER);
		MyPageIdText.setFont(MyPageFont2);
		JScrollPane MyPageIdScroll = new JScrollPane(MyPageIdText);
		MyPageIdScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		JLabel MyPageNamelabel = new JLabel("NAME :");
		MyPageNamelabel.setHorizontalAlignment(JLabel.CENTER);
		MyPageNamelabel.setVerticalAlignment(JLabel.CENTER);
		MyPageNamelabel.setFont(MyPageFont2);
		
		MyPageNameText = new JTextField("");
		MyPageNameText.setEditable(false);
		MyPageNameText.setHorizontalAlignment(JLabel.CENTER);
		MyPageNameText.setFont(MyPageFont2);
		JScrollPane MyPageNameScroll = new JScrollPane(MyPageNameText);
		MyPageNameScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		JLabel MyPageLevellabel = new JLabel("LEVEL :");
		MyPageLevellabel.setHorizontalAlignment(JLabel.CENTER);
		MyPageLevellabel.setVerticalAlignment(JLabel.CENTER);
		MyPageLevellabel.setFont(MyPageFont2);
		
		MyPageLevelText = new JTextField("");
		MyPageLevelText.setEditable(false);
		MyPageLevelText.setHorizontalAlignment(JLabel.CENTER);
		MyPageLevelText.setFont(MyPageFont2);
		JScrollPane MyPageLevelScroll = new JScrollPane(MyPageLevelText);
		MyPageLevelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		JLabel MyPageAliaslabel = new JLabel("ALIAS :");
		MyPageAliaslabel.setHorizontalAlignment(JLabel.CENTER);
		MyPageAliaslabel.setVerticalAlignment(JLabel.CENTER);
		MyPageAliaslabel.setFont(MyPageFont2);
		
		MyPageAliasText = new JTextField("");
		MyPageAliasText.setEditable(false);
		MyPageAliasText.setHorizontalAlignment(JLabel.CENTER);
		MyPageAliasText.setFont(MyPageFont2);
		JScrollPane MyPageAliasScroll = new JScrollPane(MyPageAliasText);
		MyPageAliasScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		MyPageInformation.add(MyPageIdlabel);
		MyPageInformation.add(MyPageIdScroll);
		MyPageInformation.add(MyPageNamelabel);
		MyPageInformation.add(MyPageNameScroll);
		MyPageInformation.add(MyPageLevellabel);
		MyPageInformation.add(MyPageLevelScroll);
		MyPageInformation.add(MyPageAliaslabel);
		MyPageInformation.add(MyPageAliasScroll);
		
		MyPagePane.add(MyPageInformation);
		
		JPanel MyPageCoin = new JPanel();
		MyPageCoin.setSize(320,50);
		MyPageCoin.setLocation(80, 150);
		MyPageCoin.setBackground(Color.ORANGE);
		MyPageCoin.setLayout(new GridLayout(1,2));
		
		JLabel MyPageCoinlabel = new JLabel("COIN :");
		MyPageCoinlabel.setHorizontalAlignment(JLabel.CENTER);
		MyPageCoinlabel.setVerticalAlignment(JLabel.CENTER);
		MyPageCoinlabel.setFont(MyPageFont2);
		MyPageCoin.add(MyPageCoinlabel);
		
		MyPageCoinfield = new JTextField("");
		MyPageCoinfield.setEditable(false);
		MyPageCoinfield.setHorizontalAlignment(JTextField.CENTER);
		MyPageCoinfield.setFont(MyPageFont2);
		JScrollPane MyPageCoinfieldscroll = new JScrollPane(MyPageCoinfield);
		MyPageCoinfieldscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);;
		MyPageCoin.add(MyPageCoinfieldscroll);
		
		MyPagePane.add(MyPageCoin);
		
		JButton MyPageNameChangeButton = new JButton("Change Name");
		MyPageNameChangeButton.setSize(200,70);
		MyPageNameChangeButton.setLocation(950, 250);
		MyPageNameChangeButton.setFont(MyPageFont2);
		MyPagePane.add(MyPageNameChangeButton);
		
		JButton MyPagePwChangeButton = new JButton("Change PW");
		MyPagePwChangeButton.setSize(200,70);
		MyPagePwChangeButton.setLocation(950, 350);
		MyPagePwChangeButton.setFont(MyPageFont2);
		MyPagePane.add(MyPagePwChangeButton);
		
		QuitGameButtonM();
		MyPagePane.add(QuitGameButton);
		
		LogoutButtonM();
		MyPagePane.add(LogoutButton);
		
		add(MyPagePane);
		
		closePane();
		MyPagePane.setVisible(true);
		
		MyPageNameChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 6;
				
			}
		});
		
		MyPagePwChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				joinNum = 7;
				
			}
		});
		
	}
	
	void ChangeNamePanel() {
		
		ChangeNamePane = new JPanel();
		ChangeNamePane.setBackground(Color.DARK_GRAY);
		ChangeNamePane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		ChangeNamePane.add(GameTitleText);
		
		JPanel ChangeNameTool = new JPanel();
		ChangeNameTool.setLayout(new GridLayout(7,2));
		ChangeNameTool.setBackground(Color.WHITE);
		ChangeNameTool.setSize(500,200);
		ChangeNameTool.setLocation(400,220);
		
		Font CNFont1 = new Font("Alial", Font.BOLD, 20);
		Font CNFont2 = new Font("Alial", Font.BOLD, 15);
		
		JLabel ChangeNamelabel = new JLabel("CHANGE NAME : ");
		ChangeNamelabel.setFont(CNFont1);
		ChangeNamelabel.setHorizontalAlignment(JLabel.CENTER);
		ChangeNamelabel.setVerticalAlignment(JLabel.CENTER);
		
		ChangeNamefield = new JTextField();
		ChangeNamefield.setBackground(Color.LIGHT_GRAY);
		
		JButton ChangeNameButton = new JButton("Change");
		ChangeNameButton.setFont(CNFont2);
		
		JLabel cnnolabel1 = new JLabel("");
		JLabel cnnolabel2 = new JLabel("");
		JLabel cnnolabel3 = new JLabel("");
		JLabel cnnolabel4 = new JLabel("");
		JLabel cnnolabel5 = new JLabel("");
		JLabel cnnolabel6 = new JLabel("");
		JLabel cnnolabel7 = new JLabel("");
		JLabel cnnolabel8 = new JLabel("");
		JLabel cnnolabel9 = new JLabel("");
		JLabel cnnolabel10 = new JLabel("");
		JLabel cnnolabel11 = new JLabel("");
		
		ChangeNameTool.add(cnnolabel1);
		ChangeNameTool.add(cnnolabel2);
		
		ChangeNameTool.add(cnnolabel3);
		ChangeNameTool.add(cnnolabel4);
		
		ChangeNameTool.add(cnnolabel10);
		ChangeNameTool.add(cnnolabel11);
		
		ChangeNameTool.add(ChangeNamelabel);
		ChangeNameTool.add(ChangeNamefield);
		
		ChangeNameTool.add(cnnolabel5);
		ChangeNameTool.add(cnnolabel6);
		
		ChangeNameTool.add(cnnolabel9);
		ChangeNameTool.add(ChangeNameButton);
		
		ChangeNameTool.add(cnnolabel7);
		ChangeNameTool.add(cnnolabel8);
		
		ChangeNamePane.add(ChangeNameTool);
		
		JButton CNExiteButton = new JButton("BACK");
		CNExiteButton.setSize(100,50);
		CNExiteButton.setLocation(600,450);
		CNExiteButton.setFont(CNFont1);
		ChangeNamePane.add(CNExiteButton);
		
		QuitGameButtonM();
		ChangeNamePane.add(QuitGameButton);
		
		add(ChangeNamePane);
		
		closePane();
		
		ChangeNamePane.setVisible(true);
		
		ChangeNameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeNameNum = 2;
			}
		});
		
		CNExiteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeNameNum = 1;
			}
		});
		
		ChangeNamefield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ChangeNameNum = 2;
				}
			}
		});
		
	}
	
	void ChangePwPanel() {
		
		ChangePwPane = new JPanel();
		ChangePwPane.setBackground(Color.DARK_GRAY);
		ChangePwPane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		ChangePwPane.add(GameTitleText);
		
		JPanel ChangePwTool = new JPanel();
		ChangePwTool.setLayout(new GridLayout(7,2));
		ChangePwTool.setBackground(Color.WHITE);
		ChangePwTool.setSize(500,200);
		ChangePwTool.setLocation(400,220);
		
		Font CPFont1 = new Font("Alial", Font.BOLD, 20);
		Font CPFont2 = new Font("Alial", Font.BOLD, 15);
		
		JLabel ChangePwlabel = new JLabel("CHANGE PW : ");
		ChangePwlabel.setFont(CPFont1);
		ChangePwlabel.setHorizontalAlignment(JLabel.CENTER);
		ChangePwlabel.setVerticalAlignment(JLabel.CENTER);
		
		ChangePwfield = new JPasswordField();
		ChangePwfield.setBackground(Color.LIGHT_GRAY);
		
		JLabel ChangeCurrentPwlabel = new JLabel("PW : ");
		ChangeCurrentPwlabel.setFont(CPFont1);
		ChangeCurrentPwlabel.setHorizontalAlignment(JLabel.CENTER);
		ChangeCurrentPwlabel.setVerticalAlignment(JLabel.CENTER);
		
		ChangeCurrentPwfield = new JPasswordField();
		ChangeCurrentPwfield.setBackground(Color.LIGHT_GRAY);
		
		JButton ChangePwButton = new JButton("Change");
		ChangePwButton.setFont(CPFont2);
		
		JLabel cpnolabel1 = new JLabel("");
		JLabel cpnolabel2 = new JLabel("");
		JLabel cpnolabel3 = new JLabel("");
		JLabel cpnolabel4 = new JLabel("");
		JLabel cpnolabel5 = new JLabel("");
		JLabel cpnolabel6 = new JLabel("");
		JLabel cpnolabel7 = new JLabel("");
		JLabel cpnolabel8 = new JLabel("");
		JLabel cpnolabel9 = new JLabel("");
		
		ChangePwTool.add(cpnolabel1);
		ChangePwTool.add(cpnolabel2);
		
		ChangePwTool.add(ChangeCurrentPwlabel);
		ChangePwTool.add(ChangeCurrentPwfield);
		
		ChangePwTool.add(cpnolabel3);
		ChangePwTool.add(cpnolabel4);
		
		ChangePwTool.add(ChangePwlabel);
		ChangePwTool.add(ChangePwfield);
		
		ChangePwTool.add(cpnolabel5);
		ChangePwTool.add(cpnolabel6);
		
		ChangePwTool.add(cpnolabel9);
		ChangePwTool.add(ChangePwButton);
		
		ChangePwTool.add(cpnolabel7);
		ChangePwTool.add(cpnolabel8);
		
		ChangePwPane.add(ChangePwTool);
		
		JButton CPExiteButton = new JButton("BACK");
		CPExiteButton.setSize(100,50);
		CPExiteButton.setLocation(600,450);
		CPExiteButton.setFont(CPFont1);
		ChangePwPane.add(CPExiteButton);
		
		QuitGameButtonM();
		ChangePwPane.add(QuitGameButton);
		
		add(ChangePwPane);
		
		closePane();
		
		ChangePwPane.setVisible(true);
		
		ChangePwButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePwNum = 2;
			}
		});
		CPExiteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePwNum = 1;
			}
		});
		ChangePwfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ChangePwNum = 2;
				}
			}
		});
		ChangeCurrentPwfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ChangePwNum = 2;
				}
			}
		});
		
	}
	
	void ShopPanel() {
		
		ShopPane = new JPanel();
		ShopPane.setBackground(Color.DARK_GRAY);
		ShopPane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		ShopPane.add(GameTitleText);
		
		Font ShopFont1 = new Font("Arial", Font.BOLD, 60);
		Font ShopFont2 = new Font("Arial", Font.BOLD, 12);
		Font ShopFont3 = new Font("Arial", Font.BOLD, 20);
		
		JLabel ShopTitle = new JLabel("Shop");
		ShopTitle.setSize(300, 100);
		ShopTitle.setLocation(500, 30);
		ShopTitle.setFont(ShopFont1);
		ShopTitle.setOpaque(true);
		ShopTitle.setBackground(Color.LIGHT_GRAY);
		ShopTitle.setForeground(Color.ORANGE);
		ShopTitle.setHorizontalAlignment(JLabel.CENTER);
		ShopTitle.setVerticalAlignment(JLabel.CENTER);
		ShopPane.add(ShopTitle);
		
		JLabel ShopAvatar1 = new JLabel();
		ShopAvatar1.setBackground(Color.LIGHT_GRAY);
		ShopAvatar1.setOpaque(true);
		ShopAvatar1.setSize(230, 450);
		ShopAvatar1.setLocation(90, 190);
		
		JLabel ShopAvatar1Title = new JLabel("BLUE BOMB BOY");
		ShopAvatar1Title.setSize(150, 50);
		ShopAvatar1Title.setLocation(40, 20);
		ShopAvatar1Title.setOpaque(true);
		ShopAvatar1Title.setBackground(Color.gray);
		ShopAvatar1Title.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar1Title.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar1Title.setFont(ShopFont2);
		ShopAvatar1Title.setForeground(Color.BLUE);
		ShopAvatar1.add(ShopAvatar1Title);
		
		JLabel ShopAvatar1here = new JLabel(new ImageIcon(mav.makeAvatar2()));
		ShopAvatar1here.setSize(150, 150);
		ShopAvatar1here.setLocation(40, 90);
		ShopAvatar1here.setOpaque(true);
		ShopAvatar1here.setBackground(Color.DARK_GRAY);
		ShopAvatar1here.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar1here.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar1.add(ShopAvatar1here);
		
		JTextArea ShopAvatar1Text = new JTextArea("\nTry this cool blue skin.\nThis item is \npriced at 1000 Coins.");
		ShopAvatar1Text.setSize(150,100);
		ShopAvatar1Text.setLocation(40,260);
		ShopAvatar1Text.setOpaque(true);
		ShopAvatar1Text.setBackground(Color.GRAY);
		ShopAvatar1Text.setFont(ShopFont2);
		ShopAvatar1Text.setEditable(false);
		ShopAvatar1.add(ShopAvatar1Text);
		
		JButton ShopAvatar1BuyButton = new JButton("BUY");
		ShopAvatar1BuyButton.setSize(100, 50);
		ShopAvatar1BuyButton.setLocation(65, 380);
		ShopAvatar1BuyButton.setFont(ShopFont3);
		ShopAvatar1.add(ShopAvatar1BuyButton);
		
		
		ShopPane.add(ShopAvatar1);
		
		JLabel ShopAvatar2 = new JLabel();
		ShopAvatar2.setBackground(Color.LIGHT_GRAY);
		ShopAvatar2.setOpaque(true);
		ShopAvatar2.setSize(230, 450);
		ShopAvatar2.setLocation(390, 190);
		
		JLabel ShopAvatar2Title = new JLabel("RED BOMB BOY");
		ShopAvatar2Title.setSize(150, 50);
		ShopAvatar2Title.setLocation(40, 20);
		ShopAvatar2Title.setOpaque(true);
		ShopAvatar2Title.setBackground(Color.gray);
		ShopAvatar2Title.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar2Title.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar2Title.setFont(ShopFont2);
		ShopAvatar2Title.setForeground(Color.RED);
		ShopAvatar2.add(ShopAvatar2Title);
		
		JLabel ShopAvatar2here = new JLabel(new ImageIcon(mav.makeAvatar3()));
		ShopAvatar2here.setSize(150, 150);
		ShopAvatar2here.setLocation(40, 90);
		ShopAvatar2here.setOpaque(true);
		ShopAvatar2here.setBackground(Color.DARK_GRAY);
		ShopAvatar2here.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar2here.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar2.add(ShopAvatar2here);
		
		JTextArea ShopAvatar2Text = new JTextArea("\nTry this cool red skin.\nThis item is \npriced at 2000 Coins.");
		ShopAvatar2Text.setSize(150,100);
		ShopAvatar2Text.setLocation(40,260);
		ShopAvatar2Text.setOpaque(true);
		ShopAvatar2Text.setBackground(Color.GRAY);
		ShopAvatar2Text.setFont(ShopFont2);
		ShopAvatar2Text.setEditable(false);
		ShopAvatar2.add(ShopAvatar2Text);
		
		JButton ShopAvatar2BuyButton = new JButton("BUY");
		ShopAvatar2BuyButton.setSize(100, 50);
		ShopAvatar2BuyButton.setLocation(65, 380);
		ShopAvatar2BuyButton.setFont(ShopFont3);
		ShopAvatar2.add(ShopAvatar2BuyButton);
		
		ShopPane.add(ShopAvatar2);
		
		JLabel ShopAvatar3 = new JLabel();
		ShopAvatar3.setBackground(Color.LIGHT_GRAY);
		ShopAvatar3.setOpaque(true);
		ShopAvatar3.setSize(230, 450);
		ShopAvatar3.setLocation(690, 190);
		
		JLabel ShopAvatar3Title = new JLabel("EMERALD BOMB BOY");
		ShopAvatar3Title.setSize(150, 50);
		ShopAvatar3Title.setLocation(40, 20);
		ShopAvatar3Title.setOpaque(true);
		ShopAvatar3Title.setBackground(Color.gray);
		ShopAvatar3Title.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar3Title.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar3Title.setFont(ShopFont2);
		ShopAvatar3Title.setForeground(Color.GREEN);
		ShopAvatar3.add(ShopAvatar3Title);
		
		JLabel ShopAvatar3here = new JLabel(new ImageIcon(mav.makeAvatar4()));
		ShopAvatar3here.setSize(150, 150);
		ShopAvatar3here.setLocation(40, 90);
		ShopAvatar3here.setOpaque(true);
		ShopAvatar3here.setBackground(Color.DARK_GRAY);
		ShopAvatar3here.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar3here.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar3.add(ShopAvatar3here);
		
		JTextArea ShopAvatar3Text = new JTextArea("\nWear the sparkling\nemerald armor and\ntake a stroll \nthrough the streets!\nThis item is \npriced at 3000 Coins.");
		ShopAvatar3Text.setSize(150,100);
		ShopAvatar3Text.setLocation(40,260);
		ShopAvatar3Text.setOpaque(true);
		ShopAvatar3Text.setBackground(Color.GRAY);
		ShopAvatar3Text.setFont(ShopFont2);
		ShopAvatar3Text.setEditable(false);
		ShopAvatar3.add(ShopAvatar3Text);
		
		JButton ShopAvatar3BuyButton = new JButton("BUY");
		ShopAvatar3BuyButton.setSize(100, 50);
		ShopAvatar3BuyButton.setLocation(65, 380);
		ShopAvatar3BuyButton.setFont(ShopFont3);
		ShopAvatar3.add(ShopAvatar3BuyButton);
		
		ShopPane.add(ShopAvatar3);
		
		JLabel ShopAvatar4 = new JLabel();
		ShopAvatar4.setBackground(Color.LIGHT_GRAY);
		ShopAvatar4.setOpaque(true);
		ShopAvatar4.setSize(230, 450);
		ShopAvatar4.setLocation(990, 190);
		
		JLabel ShopAvatar4Title = new JLabel("MAGIC BOMB BOY");
		ShopAvatar4Title.setSize(150, 50);
		ShopAvatar4Title.setLocation(40, 20);
		ShopAvatar4Title.setOpaque(true);
		ShopAvatar4Title.setBackground(Color.gray);
		ShopAvatar4Title.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar4Title.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar4Title.setFont(ShopFont2);
		ShopAvatar4Title.setForeground(Color.MAGENTA);
		ShopAvatar4.add(ShopAvatar4Title);
		
		JLabel ShopAvatar4here = new JLabel(new ImageIcon(mav.makeAvatar5()));
		ShopAvatar4here.setSize(150, 150);
		ShopAvatar4here.setLocation(40, 90);
		ShopAvatar4here.setOpaque(true);
		ShopAvatar4here.setBackground(Color.DARK_GRAY);
		ShopAvatar4here.setHorizontalAlignment(JLabel.CENTER);
		ShopAvatar4here.setVerticalAlignment(JLabel.CENTER);
		ShopAvatar4.add(ShopAvatar4here);
		
		JTextArea ShopAvatar4Text = new JTextArea("\nThe mystical purple \nmagic bead armor.\nIt cannot actually\n cast spells.\nThis item is \npriced at 4000 Coins.");
		ShopAvatar4Text.setSize(150,100);
		ShopAvatar4Text.setLocation(40,260);
		ShopAvatar4Text.setOpaque(true);
		ShopAvatar4Text.setBackground(Color.GRAY);
		ShopAvatar4Text.setFont(ShopFont2);
		ShopAvatar4Text.setEditable(false);
		ShopAvatar4.add(ShopAvatar4Text);
		
		JButton ShopAvatar4BuyButton = new JButton("BUY");
		ShopAvatar4BuyButton.setSize(100, 50);
		ShopAvatar4BuyButton.setLocation(65, 380);
		ShopAvatar4BuyButton.setFont(ShopFont3);
		ShopAvatar4.add(ShopAvatar4BuyButton);
		
		ShopPane.add(ShopAvatar4);
		
		QuitGameButtonM();
		ShopPane.add(QuitGameButton);
		
		LogoutButtonM();
		ShopPane.add(LogoutButton);
		
		add(ShopPane);
		
		closePane();
		ShopPane.setVisible(true);
		
		ShopAvatar1BuyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyAvatarNum = 1;
			}
		});
		
		ShopAvatar2BuyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyAvatarNum = 2;
			}
		});
		
		ShopAvatar3BuyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyAvatarNum = 3;
			}
		});
		
		ShopAvatar4BuyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyAvatarNum = 4;
			}
		});
		
	}
	
	
	void MessengerPanel() {
		
		MessengerPane = new JPanel();
		MessengerPane.setBackground(Color.DARK_GRAY);
		MessengerPane.setLayout(null);
		
		Font GameTitlefont = new Font("Alial", Font.ITALIC, 50);
		JLabel GameTitleText = new JLabel("The Bomb Boy");
		GameTitleText.setBackground(Color.BLACK);
		GameTitleText.setOpaque(true);
		GameTitleText.setForeground(Color.RED);
		GameTitleText.setFont(GameTitlefont);
		GameTitleText.setSize(400, 100);
		GameTitleText.setLocation(30, 30);
		GameTitleText.setHorizontalAlignment(JLabel.CENTER);
		GameTitleText.setVerticalAlignment(JLabel.CENTER);
		MessengerPane.add(GameTitleText);
		
		Font MessengerFont1 = new Font("Arial", Font.BOLD, 50);
		Font MessengerFont2 = new Font("Arial", Font.BOLD, 70);
		Font MessengerFont3 = new Font("Arial", Font.BOLD, 20);
		
		JLabel ShopTitle = new JLabel("Messenger");
		ShopTitle.setSize(300, 100);
		ShopTitle.setLocation(500, 30);
		ShopTitle.setFont(MessengerFont1);
		ShopTitle.setOpaque(true);
		ShopTitle.setBackground(Color.LIGHT_GRAY);
		ShopTitle.setForeground(Color.GREEN);
		ShopTitle.setHorizontalAlignment(JLabel.CENTER);
		ShopTitle.setVerticalAlignment(JLabel.CENTER);
		MessengerPane.add(ShopTitle);
		
		MessengerArea = new JTextArea();
		MessengerArea.setBackground(Color.BLACK);
		MessengerArea.setForeground(Color.WHITE);
		MessengerArea.setEditable(false);
		MessengerArea.setFont(MessengerFont3);
		JScrollPane MessengerAreaScroll = new JScrollPane(MessengerArea);
		MessengerAreaScroll.setSize(1000,300);
		MessengerAreaScroll.setLocation(150,160);
		MessengerAreaScroll.setBackground(Color.BLACK);
		MessengerPane.add(MessengerAreaScroll);
		
		JLabel MessengerTo = new JLabel(">");
		MessengerTo.setBackground(Color.LIGHT_GRAY);
		MessengerTo.setForeground(Color.DARK_GRAY);
		MessengerTo.setOpaque(true);
		MessengerTo.setSize(50,50);
		MessengerTo.setLocation(150, 460);
		MessengerTo.setFont(MessengerFont2);
		MessengerTo.setHorizontalAlignment(JLabel.CENTER);
		MessengerTo.setVerticalAlignment(JLabel.CENTER);
		MessengerPane.add(MessengerTo);
		
		MessengerField = new JTextField();
		MessengerField.setBackground(Color.WHITE);
		MessengerField.setForeground(Color.BLACK);
		MessengerField.setSize(950, 50);
		MessengerField.setLocation(200, 460);
		MessengerField.setFont(MessengerFont3);
		MessengerPane.add(MessengerField);
		
		JLabel MessengerAvatar1 = new JLabel();
		MessengerAvatar1.setSize(100,110);
		MessengerAvatar1.setLocation(300, 540);
		MessengerAvatar1.setOpaque(false);
		MessengerAvatar1.setIcon(new ImageIcon(mav.makeAvatar1_right()));
		MessengerPane.add(MessengerAvatar1);
		
		JLabel MessengerAvatar2 = new JLabel();
		MessengerAvatar2.setSize(100,110);
		MessengerAvatar2.setLocation(450, 540);
		MessengerAvatar2.setOpaque(false);
		MessengerAvatar2.setIcon(new ImageIcon(mav.makeAvatar2()));
		MessengerPane.add(MessengerAvatar2);
		
		JLabel MessengerAvatar3 = new JLabel();
		MessengerAvatar3.setSize(100,110);
		MessengerAvatar3.setLocation(600, 540);
		MessengerAvatar3.setOpaque(false);
		MessengerAvatar3.setIcon(new ImageIcon(mav.makeAvatar3_left()));
		MessengerPane.add(MessengerAvatar3);
		
		JLabel MessengerAvatar4 = new JLabel();
		MessengerAvatar4.setSize(100,110);
		MessengerAvatar4.setLocation(750, 540);
		MessengerAvatar4.setOpaque(false);
		MessengerAvatar4.setIcon(new ImageIcon(mav.makeAvatar4_right()));
		MessengerPane.add(MessengerAvatar4);
		
		JLabel MessengerAvatar5 = new JLabel();
		MessengerAvatar5.setSize(100,110);
		MessengerAvatar5.setLocation(900, 540);
		MessengerAvatar5.setOpaque(false);
		MessengerAvatar5.setIcon(new ImageIcon(mav.makeAvatar5_left()));
		MessengerPane.add(MessengerAvatar5);
		
		QuitGameButtonM();
		MessengerPane.add(QuitGameButton);
		
		LogoutButtonM();
		MessengerPane.add(LogoutButton);
		
		add(MessengerPane);
		closePane();
		MessengerPane.setVisible(true);
		
		MessengerField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String writeMessage = "speak/c;"+InformationName+"/c;"+MessengerField.getText();
				writer.println(writeMessage);
				MessengerField.setText("");
			}
		});
		
		MessageReadThread MRT = new MessageReadThread(this);
		Thread MessageRead = new Thread(MRT);
		MessageRead.start();
	}
	
	void QuitGameButtonM() {
		QuitGameButton = new JButton("Quit Game");
		QuitGameButton.setSize(100, 50);
		QuitGameButton.setLocation(1190, 10);
		QuitGameButton.setForeground(Color.RED);
		Font QuitGameButtonFont = new Font("Arial", Font.BOLD, 15 );
		QuitGameButton.setFont(QuitGameButtonFont);
		
		QuitGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				QuitGameNum = 1;
			}
		});
	}
	
	void LogoutButtonM() {
		LogoutButton = new JButton("Logout");
		LogoutButton.setSize(100, 50);
		LogoutButton.setLocation(1085, 10);
		LogoutButton.setForeground(Color.BLACK);
		Font LogoutButtonFont = new Font("Arial", Font.BOLD, 15 );
		LogoutButton.setFont(LogoutButtonFont);
		
		LogoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogoutNum = 1;
			}
		});
	}
	
	public static void main(String[] args) {
		new InGame();
	}
}
