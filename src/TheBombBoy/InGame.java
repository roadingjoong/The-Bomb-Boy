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
		
		GameThread gt = new GameThread();
		Thread GameT = new Thread(gt);
		GameT.start();
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
		
		JButton StartGameButton = new JButton();
		StartGameButton.setSize(400, 200);
		StartGameButton.setLocation(450,250);
		StartGameButton.setForeground(Color.BLACK);
		StartGameButton.setFont(StartGameFont2);
		StartGameButton.setText("Game Start");
		StartGamePane.add(StartGameButton);
		
		QuitGameButtonM();
		StartGamePane.add(QuitGameButton);
		
		add(StartGamePane);
		
		closePane();
		StartGamePane.setVisible(true);
		
		
		StartGameButton.addActionListener(new ActionListener() {
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
		
		UserAvatarThread uat = new UserAvatarThread();
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
	
	class UserAvatarThread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				if(InformationAvatar == 1) {
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar1()));
					
					while(true) {
						
						if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
							Thread_ToF = false;
							return;
						}
						
						while(AvatarMove == 0) {
							
							if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
								Thread_ToF = false;
								return;
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						if(AvatarMove == 1) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar1()));
							continue;
							
						}else if(AvatarMove == 2) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar1_up()));
							continue;
							
						}else if(AvatarMove == 3) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar1_right()));
							continue;
							
						}else if(AvatarMove == 4) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar1_left()));
							continue;
							
						}
						
					}
					
					
				}else if(InformationAvatar == 2) {
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar2()));
					
					while(true) {
						
						if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
							Thread_ToF = false;
							return;
						}
						
						while(AvatarMove == 0) {
							
							if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
								Thread_ToF = false;
								return;
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						if(AvatarMove == 1) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar2()));
							continue;
							
						}else if(AvatarMove == 2) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar2_up()));
							continue;
							
						}else if(AvatarMove == 3) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar2_right()));
							continue;
							
						}else if(AvatarMove == 4) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar2_left()));
							continue;
							
						}
						
					}
					
				}else if(InformationAvatar == 3) {
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar3()));
					
					while(true) {
						
						if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
							Thread_ToF = false;
							return;
						}
						
						while(AvatarMove == 0) {
							
							if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
								Thread_ToF = false;
								return;
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						if(AvatarMove == 1) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar3()));
							continue;
							
						}else if(AvatarMove == 2) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar3_up()));
							continue;
							
						}else if(AvatarMove == 3) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar3_right()));
							continue;
							
						}else if(AvatarMove == 4) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar3_left()));
							continue;
							
						}
						
					}
					
				}else if(InformationAvatar == 4) {
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar4()));
					
					while(true) {
						
						if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
							Thread_ToF = false;
							return;
						}
						
						while(AvatarMove == 0) {
							
							if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
								Thread_ToF = false;
								return;
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						if(AvatarMove == 1) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar4()));
							continue;
							
						}else if(AvatarMove == 2) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar4_up()));
							continue;
							
						}else if(AvatarMove == 3) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar4_right()));
							continue;
							
						}else if(AvatarMove == 4) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar4_left()));
							continue;
							
						}
						
					}
					
				}else if(InformationAvatar == 5) {
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar5()));
					
					while(true) {
						
						if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
							Thread_ToF = false;
							return;
						}
						
						while(AvatarMove == 0) {
							
							if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
								Thread_ToF = false;
								return;
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						if(AvatarMove == 1) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar5()));
							continue;
							
						}else if(AvatarMove == 2) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar5_up()));
							continue;
							
						}else if(AvatarMove == 3) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar5_right()));
							continue;
							
						}else if(AvatarMove == 4) {
							AvatarMove = 0;
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar5_left()));
							continue;
							
						}
						
					}
				}
				
			}
			
		}
		
	}
	
	void UserBombM() {
		
		UserBomb = new JLabel();
		UserBomb.setSize(50,50);
		UserBomb.setLocation(0,0);
		UserBomb.setOpaque(false);
		UserBomb.setVisible(false);
		
		UserBombThread ubt = new UserBombThread();
		Thread UserBombT = new Thread(ubt);
		UserBombT.start();
		
	}
	
	class UserBombThread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				while(BombTime == 0) {
					
					if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				UserBomb.setIcon(new ImageIcon(mb.makeBomb1()));
				UserBomb.setVisible(true);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				UserBomb.setIcon(new ImageIcon(mb.makeBomb2()));
				BombTime = 2;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				UserBomb.setVisible(false);
				BombTime = 0;
				
			}
			
		}
		
	}
	
	void villainsLairM() {
		
		villainsLair = new JLabel();
		villainsLair.setSize(200,250);
		villainsLair.setLocation(1000,30);
		villainsLair.setOpaque(false);
		
		villainsLairThread vlt = new villainsLairThread();
		Thread lairT = new Thread(vlt);
		lairT.start();
	}
	
	class villainsLairThread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair1()));
				
				if(Stage1EASYPane.isVisible() == true ) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair2()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair3()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair4()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair5()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair6()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair7()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair8()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair9()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					LairDamageNum = 0;
					Thread_ToF = false;
					return;
				}
				
				villainsLair.setIcon(new ImageIcon(vla.makeLair10()));
				
				if(Stage1EASYPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1MEDIUMPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
								Thread_ToF = false;
								return;
							}
							
						}
					}
					
				}else if(Stage1HARDPane.isVisible() == true) {
					
					if(Villain1.isVisible() == false && Villain2.isVisible() == false && Villain3.isVisible() == false && Stage1Boss.isVisible() == false) {
						if(villainsLair.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
							villainsLair.setIcon(new ImageIcon(vla.makeLair_damage()));
							LairDamageNum += 1;
							
							if(LairDamageNum == 5) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								villainsLair.setVisible(false);
								
								LairDamageNum = 0;
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
	
	void Villain1M() {
		
		Villain1 = new JLabel();
		
		Villain1.setSize(100,110);
		
		int v1x = 700;
		int v1y = 300;
		
		Villain1.setLocation(v1x,v1y);
		Villain1.setOpaque(false);
		
		Villain1Thread vl1t = new Villain1Thread();
		Thread Villain1T = new Thread(vl1t);
		Villain1T.start();
		
	}
	
	class Villain1Thread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Villain1.setIcon(new ImageIcon(vl1g.makeVillain1()));
				
				if(Villain1.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					
					Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_die()));
					
					SaveVillain1_x = Villain1.getLocation().x;
					SaveVillain1_y = Villain1.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain1.setVisible(false);
					Villain1.setLocation(0,0);
					
					Thread_ToF = false;
					return;
					
				}
				
				if(Villain1.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain1.getLocation().y > 180) {
					Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_up()));
					Villain1.setLocation(Villain1.getLocation().x, Villain1.getLocation().y - 10);
					
					if(Villain1.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						
						Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_die()));
						
						SaveVillain1_x = Villain1.getLocation().x;
						SaveVillain1_y = Villain1.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain1.setVisible(false);
						Villain1.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain1.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain1.getLocation().x > 200) {
					Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_left()));
					Villain1.setLocation(Villain1.getLocation().x - 10, Villain1.getLocation().y);
					
					if(Villain1.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						
						Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_die()));
						
						SaveVillain1_x = Villain1.getLocation().x;
						SaveVillain1_y = Villain1.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain1.setVisible(false);
						Villain1.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain1.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain1.getLocation().y < 300) {
					Villain1.setIcon(new ImageIcon(vl1g.makeVillain1()));
					Villain1.setLocation(Villain1.getLocation().x, Villain1.getLocation().y +10);
					
					if(Villain1.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						
						Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_die()));
						
						SaveVillain1_x = Villain1.getLocation().x;
						SaveVillain1_y = Villain1.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain1.setVisible(false);
						Villain1.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain1.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain1.getLocation().x < 700) {
					Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_right()));
					Villain1.setLocation(Villain1.getLocation().x + 10, Villain1.getLocation().y);
					
					if(Villain1.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						
						Villain1.setIcon(new ImageIcon(vl1g.makeVillain1_die()));
						
						SaveVillain1_x = Villain1.getLocation().x;
						SaveVillain1_y = Villain1.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain1.setVisible(false);
						Villain1.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain1.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
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
		
	}
	
	void Villain2M() {
		
		Villain2 = new JLabel();
		
		Villain2.setSize(100,110);
		
		int v1x = 800;
		int v1y = 500;
		
		Villain2.setLocation(v1x,v1y);
		Villain2.setOpaque(false);
		
		Villain2Thread vl2t = new Villain2Thread();
		Thread Villain2T = new Thread(vl2t);
		Villain2T.start();
		
	}
	
	class Villain2Thread implements Runnable{
		
		Boolean Thread_ToF = true;
		
		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Villain2.setIcon(new ImageIcon(vl2g.makeVillain2()));
				
				if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
					
					SaveVillain2_x = Villain2.getLocation().x;
					SaveVillain2_y = Villain2.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain2.setVisible(false);
					Villain2.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x > 700 && Villain2.getLocation().y > 400) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_up()));
					Villain2.setLocation(Villain2.getLocation().x - 10, Villain2.getLocation().y - 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x > 600 && Villain2.getLocation().y < 500) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2()));
					Villain2.setLocation(Villain2.getLocation().x - 10, Villain2.getLocation().y + 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x > 500 && Villain2.getLocation().y > 400) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_up()));
					Villain2.setLocation(Villain2.getLocation().x - 10, Villain2.getLocation().y - 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x > 400 && Villain2.getLocation().y < 500) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2()));
					Villain2.setLocation(Villain2.getLocation().x - 10, Villain2.getLocation().y + 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x > 300 && Villain2.getLocation().y > 400) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_up()));
					Villain2.setLocation(Villain2.getLocation().x - 10, Villain2.getLocation().y - 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x < 400 && Villain2.getLocation().y < 500) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2()));
					Villain2.setLocation(Villain2.getLocation().x + 10, Villain2.getLocation().y + 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x < 500 && Villain2.getLocation().y > 400) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_up()));
					Villain2.setLocation(Villain2.getLocation().x + 10, Villain2.getLocation().y - 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x < 600 && Villain2.getLocation().y < 500) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2()));
					Villain2.setLocation(Villain2.getLocation().x + 10, Villain2.getLocation().y + 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x < 700 && Villain2.getLocation().y > 400) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_up()));
					Villain2.setLocation(Villain2.getLocation().x + 10, Villain2.getLocation().y - 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(Villain2.getLocation().x < 800 && Villain2.getLocation().y < 500) {
					Villain2.setIcon(new ImageIcon(vl2g.makeVillain2()));
					Villain2.setLocation(Villain2.getLocation().x + 10, Villain2.getLocation().y + 10);
					
					if(Villain2.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain2.setIcon(new ImageIcon(vl2g.makeVillain2_die()));
						
						SaveVillain2_x = Villain2.getLocation().x;
						SaveVillain2_y = Villain2.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain2.setVisible(false);
						Villain2.setLocation(0,0);
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain2.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || easy1start == 0 && medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
	void Villain3M() {
		
		Villain3 = new JLabel();
		
		Villain3.setSize(100,110);
		
		int v1x = 1100;
		int v1y = 500;
		
		Villain3.setLocation(v1x,v1y);
		Villain3.setOpaque(false);
		
		Villain3Thread vl3t = new Villain3Thread();
		Thread Villain3T = new Thread(vl3t);
		Villain3T.start();
		
	}
	
	class Villain3Thread implements Runnable{
		
		Boolean Thread_ToF = true;
		
		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3()));
				Villain3_Shot = 0;
				
				if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
					
					SaveVillain3_x = Villain3.getLocation().x;
					SaveVillain3_y = Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain3.setVisible(false);
					Villain3.setLocation(0,0);
					Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_up()));
				Villain3_Shot = 0;
				while(Villain3.getLocation().y > 400) {
					Villain3.setLocation(Villain3.getLocation().x, Villain3.getLocation().y - 10);
					
					if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
						
						SaveVillain3_x = Villain3.getLocation().x;
						SaveVillain3_y = Villain3.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain3.setVisible(false);
						Villain3.setLocation(0,0);
						Villain3_Shot = 0;
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_left()));
				Villain3_Shot = 1;
				
				if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
					
					SaveVillain3_x = Villain3.getLocation().x;
					SaveVillain3_y = Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain3.setVisible(false);
					Villain3.setLocation(0,0);
					Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_up()));
				Villain3_Shot = 0;
				while(Villain3.getLocation().y > 300) {
					Villain3.setLocation(Villain3.getLocation().x, Villain3.getLocation().y - 10);
					
					if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
						
						SaveVillain3_x = Villain3.getLocation().x;
						SaveVillain3_y = Villain3.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain3.setVisible(false);
						Villain3.setLocation(0,0);
						Villain3_Shot = 0;
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_left()));
				Villain3_Shot = 1;
				
				if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
					
					SaveVillain3_x = Villain3.getLocation().x;
					SaveVillain3_y = Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain3.setVisible(false);
					Villain3.setLocation(0,0);
					Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3()));
				Villain3_Shot = 0;
				
				if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
					
					SaveVillain3_x = Villain3.getLocation().x;
					SaveVillain3_y = Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain3.setVisible(false);
					Villain3.setLocation(0,0);
					Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3()));
				Villain3_Shot = 0;
				while(Villain3.getLocation().y < 400) {
					Villain3.setLocation(Villain3.getLocation().x, Villain3.getLocation().y + 10);
					
					if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
						
						SaveVillain3_x = Villain3.getLocation().x;
						SaveVillain3_y = Villain3.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain3.setVisible(false);
						Villain3.setLocation(0,0);
						Villain3_Shot = 0;
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_left()));
				Villain3_Shot = 1;
				
				if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
					
					SaveVillain3_x = Villain3.getLocation().x;
					SaveVillain3_y = Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain3.setVisible(false);
					Villain3.setLocation(0,0);
					Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3()));
				Villain3_Shot = 0;
				while(Villain3.getLocation().y < 500) {
					Villain3.setLocation(Villain3.getLocation().x, Villain3.getLocation().y + 10);
					
					if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
						
						SaveVillain3_x = Villain3.getLocation().x;
						SaveVillain3_y = Villain3.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Villain3.setVisible(false);
						Villain3.setLocation(0,0);
						Villain3_Shot = 0;
						
						Thread_ToF = false;
						return;
					}
					
					if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_left()));
				Villain3_Shot = 1;
				
				if(Villain3.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
					Villain3.setIcon(new ImageIcon(vl3g.makeVillain3_die()));
					
					SaveVillain3_x = Villain3.getLocation().x;
					SaveVillain3_y = Villain3.getLocation().y;
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Villain3.setVisible(false);
					Villain3.setLocation(0,0);
					Villain3_Shot = 0;
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.getBounds().intersects(UserAvatar.getBounds())) {
					setFocusable(false);
					UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UserAvatar.setVisible(false);
					UserAvatar.setLocation(0, 200);
					
					Thread_ToF = false;
					return;
				}
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
	void Villain3_bulletM() {
		
		Villain3_bullet = new JLabel();
		Villain3_bullet.setSize(30,30);
		Villain3_bullet.setOpaque(false);
		Villain3_bullet.setIcon(new ImageIcon(v3bg.makeBullet()));
		Villain3_bullet.setVisible(true);

		Villain3_bulletThread Villain3_BT = new Villain3_bulletThread();
		Thread v3bt = new Thread(Villain3_BT);
		v3bt.start();
		
	}
	
	class Villain3_bulletThread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
					Villain3_bullet.setVisible(false);
					Villain3_bullet.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.isVisible() == false) {
					Villain3_bullet.setVisible(false);
					Villain3_bullet.setLocation(0,0);
					
					Thread_ToF = false;
					return;
				}
				
				if(Villain3_Shot == 1) {
					
					Villain3_bullet.setLocation(Villain3.getLocation().x, Villain3.getLocation().y + 40);
					Villain3_bullet.setVisible(true);
					
					while(Villain3_bullet.getLocation().x > 200) {
						
						if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
							Villain3_bullet.setVisible(false);
							Villain3_bullet.setLocation(0,0);
							
							Thread_ToF = false;
							return;
						}
						
						if(Villain3.isVisible() == false) {
							Villain3_bullet.setVisible(false);
							Villain3_bullet.setLocation(0,0);
							
							Thread_ToF = false;
							return;
						}
						
						Villain3_bullet.setLocation(Villain3_bullet.getLocation().x - 10, Villain3_bullet.getLocation().y);
						
						if(Villain3_bullet.getBounds().intersects(UserAvatar.getBounds())) {
							
							setFocusable(false);
							UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							UserAvatar.setVisible(false);
							UserAvatar.setLocation(0, 200);
							
							Villain3_bullet.setVisible(false);
							Villain3_bullet.setLocation(0,0);
							Thread_ToF = false;
							return;
							
						}
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}else {
					Villain3_bullet.setLocation(0,0);
					Villain3_bullet.setVisible(false);
					while(Villain3_Shot == 0) {
						
						if(UserAvatar.isVisible() == false || medium1start == 0 && hard1start == 0) {
							Villain3_bullet.setVisible(false);
							Villain3_bullet.setLocation(0,0);
							
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
			
		}
		
	}
	
	void Stage1BossM() {
		
		Stage1Boss = new JLabel();
		Stage1Boss.setSize(300, 110);
		Stage1Boss.setOpaque(false);
		Stage1Boss.setVisible(false);
		
		Stage1BossThread s1bt = new Stage1BossThread();
		Thread Stage1BossT = new Thread(s1bt);
		Stage1BossT.start();
		
	}
	
	class Stage1BossThread implements Runnable {
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				Stage1Boss_dead = 0;
				
				if(hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				if(Villain1.isVisible() == true || Villain2.isVisible() == true || Villain3.isVisible() == true) {
					while(Villain1.isVisible() == true || Villain2.isVisible() == true || Villain3.isVisible() == true) {
						
						if(hard1start == 0) {
							Thread_ToF = false;
							return;
						}
						
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Stage1Boss.setVisible(true);
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left()));
				Stage1Boss.setLocation(1300,500);
				while(Stage1Boss.getLocation().x >= -300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x - 10, Stage1Boss.getLocation().y);
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right()));
				Stage1Boss.setLocation(-300,180);
				while(Stage1Boss.getLocation().x <= 1300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x + 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left()));
				Stage1Boss.setLocation(1300,300);
				while(Stage1Boss.getLocation().x >= -300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x - 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right()));
				Stage1Boss.setLocation(-300,400);
				while(Stage1Boss.getLocation().x <= 1300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x + 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left()));
				Stage1Boss.setLocation(1300,600);
				while(Stage1Boss.getLocation().x >= -300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x - 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right()));
				Stage1Boss.setLocation(-300,300);
				while(Stage1Boss.getLocation().x <= 1300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x + 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left()));
				Stage1Boss.setLocation(1300,600);
				while(Stage1Boss.getLocation().x >= -300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x - 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right()));
				Stage1Boss.setLocation(-300,180);
				while(Stage1Boss.getLocation().x <= 1300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x + 10, Stage1Boss.getLocation().y);
					
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left()));
				Stage1Boss.setLocation(1300,400);
				while(Stage1Boss.getLocation().x >= -300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x - 10, Stage1Boss.getLocation().y);
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_left_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right()));
				Stage1Boss.setLocation(-300,300);
				while(Stage1Boss.getLocation().x <= 1300) {
					
					Stage1Boss.setLocation(Stage1Boss.getLocation().x + 10, Stage1Boss.getLocation().y);
					
					if(Stage1Boss.getBounds().intersects(UserBomb.getBounds()) && BombTime == 2 ) {
						Stage1Boss.setIcon(new ImageIcon(s1b.makeBoss_right_die()));
						
						Stage1Boss_x = Stage1Boss.getLocation().x;
						Stage1Boss_y = Stage1Boss.getLocation().y;
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Stage1Boss.setVisible(false);
						Stage1Boss.setLocation(0,0);
						Stage1Boss_dead = 1;
						
						Thread_ToF = false;
						return;
					}
					
					if(Stage1Boss.getBounds().intersects(UserAvatar.getBounds())) {
						setFocusable(false);
						UserAvatar.setIcon(new ImageIcon(mav.makeAvatar_die()));
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						UserAvatar.setVisible(false);
						UserAvatar.setLocation(0, 200);
						
						Thread_ToF = false;
						return;
					}
					
					if(hard1start == 0) {
						Thread_ToF = false;
						return;
					}
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
			
		}
		
	}
	
	void GoldCoinM() {
		
		GoldCoin = new JLabel();
		GoldCoin.setSize(30,30);
		GoldCoin.setLocation(0,0);
		GoldCoin.setOpaque(false);
		GoldCoin.setVisible(false);
		
		GoldCoinThread gct = new GoldCoinThread();
		Thread GoldCoinT = new Thread(gct);
		GoldCoinT.start();
		
		GoldCoinThread2 gct2 = new GoldCoinThread2();
		Thread GoldCoinT2 = new Thread(gct2);
		GoldCoinT2.start();
		
	}
	
	class GoldCoinThread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin.setIcon(new ImageIcon(gcg.makeGoldCoin()));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin.setIcon(new ImageIcon(gcg.makeGoldCoin2()));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin.setIcon(new ImageIcon(gcg.makeGoldCoin3()));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	class GoldCoinThread2 implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				if(Villain1.isVisible() == false) {
					GoldCoin.setLocation(SaveVillain1_x+50, SaveVillain1_y+50);
					GoldCoin.setVisible(true);
				}
				
				if(UserAvatar.getBounds().intersects(GoldCoin.getBounds())) {
					GoldCoin.setVisible(false);
					GoldCoin.setLocation(0,0);
					
					GUD.updateCoin(InformationCoin, 100, InformationId);
					
					ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
					
					for(GameUser gu : GUList ) {
						InformationId = gu.getUserid();
						InformationPw = gu.getUserpw();
						InformationName = gu.getUsername();
						InformationLevel = gu.getUserlevel();
						InformationAlias = gu.getUseralias();
						InformationStage = gu.getUserStage();
						InformationCoin = gu.getUsercoin();
						InformationAvatar = gu.getUseravatar();
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
	
	void GoldCoin2M() {
		
		GoldCoin2 = new JLabel();
		GoldCoin2.setSize(30,30);
		GoldCoin2.setLocation(0,0);
		GoldCoin2.setOpaque(false);
		GoldCoin2.setVisible(false);
		
		GoldCoin2Thread gct2 = new GoldCoin2Thread();
		Thread GoldCoin2T = new Thread(gct2);
		GoldCoin2T.start();
		
		GoldCoin2Thread2 gc2t2 = new GoldCoin2Thread2();
		Thread GoldCoin2T2 = new Thread(gc2t2);
		GoldCoin2T2.start();
		
	}
	
	class GoldCoin2Thread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin2.setIcon(new ImageIcon(gc2g.makeGoldCoin()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin2.setIcon(new ImageIcon(gc2g.makeGoldCoin2()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin2.setIcon(new ImageIcon(gc2g.makeGoldCoin3()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	class GoldCoin2Thread2 implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
								
				if(Villain2.isVisible() == false) {
					GoldCoin2.setLocation(SaveVillain2_x+50, SaveVillain2_y+50);
					GoldCoin2.setVisible(true);
				}
				
				if(UserAvatar.getBounds().intersects(GoldCoin2.getBounds())) {
					GoldCoin2.setVisible(false);
					GoldCoin2.setLocation(0,0);
					
					GUD.updateCoin(InformationCoin, 200, InformationId);
					
					ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
					
					for(GameUser gu : GUList ) {
						InformationId = gu.getUserid();
						InformationPw = gu.getUserpw();
						InformationName = gu.getUsername();
						InformationLevel = gu.getUserlevel();
						InformationAlias = gu.getUseralias();
						InformationStage = gu.getUserStage();
						InformationCoin = gu.getUsercoin();
						InformationAvatar = gu.getUseravatar();
					}
					
					Thread_ToF = false;
					return;
					
				}
				
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	void GoldCoin3M() {
		
		GoldCoin3 = new JLabel();
		GoldCoin3.setSize(30,30);
		GoldCoin3.setLocation(0,0);
		GoldCoin3.setOpaque(false);
		GoldCoin3.setVisible(false);
		
		GoldCoin3Thread gct3 = new GoldCoin3Thread();
		Thread GoldCoin3T = new Thread(gct3);
		GoldCoin3T.start();
		
		GoldCoin3Thread2 gc3t2 = new GoldCoin3Thread2();
		Thread GoldCoin3T2 = new Thread(gc3t2);
		GoldCoin3T2.start();
		
	}
	
	class GoldCoin3Thread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin3.setIcon(new ImageIcon(gc3g.makeGoldCoin()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin3.setIcon(new ImageIcon(gc3g.makeGoldCoin2()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldCoin3.setIcon(new ImageIcon(gc3g.makeGoldCoin3()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	class GoldCoin3Thread2 implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				if(Villain3.isVisible() == false) {
					GoldCoin3.setLocation(SaveVillain3_x+50, SaveVillain3_y+50);
					GoldCoin3.setVisible(true);
				}
				
				if(UserAvatar.getBounds().intersects(GoldCoin3.getBounds())) {
					GoldCoin3.setVisible(false);
					GoldCoin3.setLocation(0,0);
					
					GUD.updateCoin(InformationCoin, 300, InformationId);
					
					ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
					
					for(GameUser gu : GUList ) {
						InformationId = gu.getUserid();
						InformationPw = gu.getUserpw();
						InformationName = gu.getUsername();
						InformationLevel = gu.getUserlevel();
						InformationAlias = gu.getUseralias();
						InformationStage = gu.getUserStage();
						InformationCoin = gu.getUsercoin();
						InformationAvatar = gu.getUseravatar();
					}
					
					Thread_ToF = false;
					return;
					
				}
				
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	void GoldBox1M() {
		
		GoldBox1 = new JLabel();
		GoldBox1.setSize(100,100);
		GoldBox1.setLocation(0,0);
		GoldBox1.setOpaque(false);
		GoldBox1.setVisible(false);
		
		GoldBox1Thread gb1t = new GoldBox1Thread();
		Thread GoldBox1T = new Thread(gb1t);
		GoldBox1T.start();
		
		GoldBox1Thread2 gb1t2 = new GoldBox1Thread2();
		Thread GoldBox1T2 = new Thread(gb1t2);
		GoldBox1T2.start();
		
	}
	
	class GoldBox1Thread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldBox1.setIcon(new ImageIcon(gb1g.makeGoldBox1()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldBox1.setIcon(new ImageIcon(gb1g.makeGoldBox2()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				GoldBox1.setIcon(new ImageIcon(gb1g.makeGoldBox3()));
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	class GoldBox1Thread2 implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(hard1start == 0) {
					Stage1Boss_dead = 0;
					Thread_ToF = false;
					return;
				}
				
				if(Stage1Boss_dead == 1) {
					GoldBox1.setLocation(Stage1Boss_x+50, Stage1Boss_y+50);
					GoldBox1.setVisible(true);
				}
				
				if(UserAvatar.getBounds().intersects(GoldBox1.getBounds())) {
					Stage1Boss_dead = 0;
					
					GoldBox1.setVisible(false);
					GoldBox1.setLocation(0,0);
					
					GUD.updateCoin(InformationCoin, 1000, InformationId);
					
					ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
					
					for(GameUser gu : GUList ) {
						InformationId = gu.getUserid();
						InformationPw = gu.getUserpw();
						InformationName = gu.getUsername();
						InformationLevel = gu.getUserlevel();
						InformationAlias = gu.getUseralias();
						InformationStage = gu.getUserStage();
						InformationCoin = gu.getUsercoin();
						InformationAvatar = gu.getUseravatar();
					}
					
					Thread_ToF = false;
					return;
					
				}
				
				try {
					Thread.sleep(210);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	void Stage1SkyM() {
		
		Stage1Sky = new JLabel();
		Stage1Sky.setSize(800, 150);
		Stage1Sky.setLocation(100,0);
		Stage1Sky.setOpaque(false);
		
		Stage1SkyThread s1st = new Stage1SkyThread();
		Thread Stage1SkyT = new Thread(s1st);
		Stage1SkyT.start();
		
	}
	
	class Stage1SkyThread implements Runnable {
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Stage1Sky.setIcon(new ImageIcon(ssg.makeSky1()));
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Stage1Sky.setIcon(new ImageIcon(ssg.makeSky2()));
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Stage1Sky.setIcon(new ImageIcon(ssg.makeSky1()));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					Thread_ToF = false;
					return;
				}
				
				Stage1Sky.setIcon(new ImageIcon(ssg.makeSky2()));
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
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
		ExitGameButtonThread egbt = new ExitGameButtonThread();
		Thread ExitBTT = new Thread(egbt);
		ExitBTT.start();
	}
	
	class ExitGameButtonThread implements Runnable{
		Boolean Thread_ToF = true;
		@Override
		public void run() {
			while(Thread_ToF) {
				if(ExitGameNum == 1) {
					ExitGameButton.setIcon(new ImageIcon(egb.makeButton2()));
				}
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					ExitGameButton.setIcon(new ImageIcon(egb.makeButton1()));
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
	
	void GameTimerM() {
		GameTimer = new JLabel();
		GameTimer.setSize(200, 80);
		GameTimer.setLocation(1000,630);
		GameTimer.setOpaque(false);
		GameTimer.setHorizontalAlignment(JLabel.CENTER);
		GameTimer.setVerticalAlignment(JLabel.CENTER);
		GameTimer.setForeground(Color.WHITE);
		Font GameTimerFont = new Font("Arial", Font.BOLD, 70);
		GameTimer.setFont(GameTimerFont);
		
		GameTimerThread gtt = new GameTimerThread();
		Thread TimerT = new Thread(gtt);
		TimerT.start();
	}
	
	class GameTimerThread implements Runnable{
		Boolean Thread_ToF = true;
		int minute = 1;
		int second = 59;
		@Override
		public void run() {
			while(Thread_ToF) {
				if(easy1start == 0 && medium1start == 0 && hard1start == 0) {
					minute = 1;
					second = 59;
					Thread_ToF = false;
					return;
				}
				GameTimer.setText("0"+minute+":"+second);
				if(second < 10) {
					GameTimer.setText("0"+minute+":"+"0"+second);
				}
				if(minute == 0 && second <= 30) {
					GameTimer.setForeground(Color.RED);
				}
				if(second == 0) {
					if(minute == 1) {
						minute -= 1;
						second += 59;
					}else if(minute == 0 && second == 0) {
						TimeOverNum = 1;
						GameTimer.setForeground(Color.WHITE);
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
	
	class ExitGameButtonG {
		
		public Image makeButton1() {
			
			Image newButton = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
			Graphics g = newButton.getGraphics();
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 80, 80);
			
			g.setColor(Color.RED);
			g.fillOval(5, 5, 70, 70);
			
			Font buttonFont = new Font("Arial", Font.BOLD, 30);
			g.setFont(buttonFont);
			
			g.setColor(Color.BLACK);
			g.drawString("EXIT", 7, 52);
			
			return newButton;
		}
		
		public Image makeButton2() {
			
			Image newButton = new BufferedImage(80,80,BufferedImage.TYPE_INT_ARGB);
			Graphics g = newButton.getGraphics();
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 0, 80, 80);
			
			g.setColor(Color.RED);
			g.fillOval(5, 5, 70, 70);
			
			Font buttonFont = new Font("Arial", Font.BOLD, 30);
			g.setFont(buttonFont);
			
			g.setColor(Color.WHITE);
			g.drawString("EXIT", 7, 52);
			
			return newButton;
		}
		
	}
	
	class MyAvatar {
		
		public Image makeAvatar1() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 40, 30, 20);
			g.fillOval(50, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 45, 10, 10);
			g.fillOval(60, 45, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(40, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar1_up() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar1_right() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(70, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(85, 45, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(70, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar1_left() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 45, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(10, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar2() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 40, 30, 20);
			g.fillOval(50, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 45, 10, 10);
			g.fillOval(60, 45, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(40, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar2_up() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar2_right() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(70, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(85, 45, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(70, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar2_left() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 45, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(10, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar3() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 40, 30, 20);
			g.fillOval(50, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 45, 10, 10);
			g.fillOval(60, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(40, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar3_up() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar3_right() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(70, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(85, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(70, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar3_left() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(10, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar4() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 40, 30, 20);
			g.fillOval(50, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 45, 10, 10);
			g.fillOval(60, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(40, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar4_up() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar4_right() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(70, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(85, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(70, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar4_left() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(10, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar5() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 40, 30, 20);
			g.fillOval(50, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 45, 10, 10);
			g.fillOval(60, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(40, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar5_up() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar5_right() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(70, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(85, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(70, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar5_left() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 40, 30, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 45, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(10, 70, 20, 10);
			
			g.dispose();
			
			return newAvatar;
		}
		
		public Image makeAvatar_die() {
			
			Image newAvatar = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newAvatar.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 0, 100, 100);
			
			g.dispose();
			
			return newAvatar;
		}
		
	}
	
	class MyBomb {
		
		public Image makeBomb1() {
			
			Image newBomb = new BufferedImage(50,50, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBomb.getGraphics();
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 50, 50);
			
			g.setColor(Color.WHITE);
			g.fillOval(10, 5, 15, 15);
			
			g.setColor(Color.WHITE);
			g.fillOval(3, 19, 9, 9);
			
			g.setColor(Color.RED);
			g.fillOval(40, 5, 10, 10);
			
			g.dispose();
			
			return newBomb;
		}
		
		public Image makeBomb2() {
			
			Image newBomb = new BufferedImage(50,50, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBomb.getGraphics();
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 50, 50);
			
			g.dispose();
			
			return newBomb;
		}
		
	}
	
	class vLair {
		
		public Image makeLair1() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.RED);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair2() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.RED);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair3() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair4() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair5() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair6() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair7() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair8() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair9() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair10() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.RED);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
		public Image makeLair_damage() {
			
			Image newLair = new BufferedImage(200,250, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newLair.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(25, 210, 150, 30);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 0, 200, 200);
			
			g.setColor(Color.GRAY);
			g.fillOval(20, 60, 40, 40);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 20, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(100, 20, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 40, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(160, 60, 5, 5);
			
			
			g.setColor(Color.GRAY);
			g.fillOval(30, 130, 5, 5);
			
			g.setColor(Color.GRAY);
			g.fillOval(50, 150, 10, 10);
			
			g.setColor(Color.GRAY);
			g.fillOval(80, 160, 20, 20);
			
			g.setColor(Color.GRAY);
			g.fillOval(120, 140, 30, 30);
			
			g.setColor(Color.GRAY);
			g.fillOval(140, 90, 40, 40);
			
			g.dispose();
			
			return newLair;
		}
		
	}
	
	
	class StageSkyG {
		
		public Image makeSky1() {
			
			Image newSky = new BufferedImage(800, 150, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newSky.getGraphics();
			
			g.setColor(Color.BLACK);
			g.fillRect(50, 10, 100, 140);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(60, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(110, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(60, 90, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(110, 90, 30, 50);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(250, 10, 100, 140);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(260, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(310, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(260, 90, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(310, 90, 30, 50);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(450, 10, 100, 140);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(460, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(510, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(460, 90, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(510, 90, 30, 50);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(650, 10, 100, 140);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(660, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(710, 20, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(660, 90, 30, 50);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(710, 90, 30, 50);
			
			return newSky;
		}
		
		public Image makeSky2() {
			
			Image newSky = new BufferedImage(800, 150, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newSky.getGraphics();
			
			g.setColor(Color.BLACK);
			g.fillRect(50, 10, 100, 140);
			
			g.setColor(Color.RED);
			g.fillRect(60, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(110, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(60, 90, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(110, 90, 30, 50);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(250, 10, 100, 140);
			
			g.setColor(Color.RED);
			g.fillRect(260, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(310, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(260, 90, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(310, 90, 30, 50);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(450, 10, 100, 140);
			
			g.setColor(Color.RED);
			g.fillRect(460, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(510, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(460, 90, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(510, 90, 30, 50);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(650, 10, 100, 140);
			
			g.setColor(Color.RED);
			g.fillRect(660, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(710, 20, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(660, 90, 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(710, 90, 30, 50);
			
			return newSky;
		}
		
	}
	
	class Villain1G {
		
		public Image makeVillain1() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillRect(5, 5, 90, 50);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(20, 40, 30, 20);
			g.fillOval(50, 40, 30, 20);
			
			g.setColor(Color.RED);
			g.fillOval(40, 70, 20, 10);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain1_up() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillRect(5, 5, 90, 50);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain1_right() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(70, 40, 30, 20);
			
			g.setColor(Color.RED);
			g.fillOval(70, 70, 20, 10);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain1_left() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(20, 9, 25, 20);
			g.fillOval(10, 25, 10, 10);
			
			g.setColor(Color.RED);
			g.fillOval(0, 40, 30, 20);
			
			g.setColor(Color.RED);
			g.fillOval(10, 70, 20, 10);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain1_die() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillRect(5, 5, 90, 50);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 100, 100);
			
			g.dispose();
			
			return newVillain;
		}
		
	}
	
	class Villain2G {
		
		public Image makeVillain2() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 60);
			
			g.setColor(Color.WHITE);
			g.fillOval(17, 7, 25, 10);
			g.fillOval(8, 19, 10, 6);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 50, 100, 50);
			
			g.setColor(Color.WHITE);
			g.fillOval(10, 60, 25, 10);
			g.fillOval(4, 72, 10, 6);
			
			g.setColor(Color.RED);
			g.fillOval(25, 20, 20, 20);
			g.fillOval(55, 20, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(45, 40, 10, 5);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain2_up() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 100, 60);
			
			g.setColor(Color.WHITE);
			g.fillOval(17, 7, 25, 10);
			g.fillOval(8, 19, 10, 6);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 50, 100, 50);
			
			g.setColor(Color.WHITE);
			g.fillOval(10, 60, 25, 10);
			g.fillOval(4, 72, 10, 6);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain2_die() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 100, 60);
			
			g.setColor(Color.RED);
			g.fillOval(0, 50, 100, 50);
			
			g.dispose();
			
			return newVillain;
		}
		
	}
	
	
	class Villain3G {
		
		public Image makeVillain3() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(10, 60, 20, 40);
			g.fillOval(70, 60, 20, 40);
			
			g.setColor(Color.WHITE);
			g.fillOval(15, 65, 5, 15);
			g.fillOval(75, 65, 5, 15);
			
			g.setColor(Color.WHITE);
			g.fillOval(17, 85, 5, 5);
			g.fillOval(77, 85, 5, 5);
			
			g.setColor(Color.BLACK);
			g.fillOval(20, 30, 60, 50);
			
			g.setColor(Color.WHITE);
			g.fillOval(25, 35, 30, 20);
			
			g.setColor(Color.WHITE);
			g.fillOval(22, 55, 5, 5);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 15, 10, 30);
			g.fillOval(60, 15, 10, 30);
			
			g.setColor(Color.RED);
			g.fillOval(25, 0, 20, 20);
			g.fillOval(55, 0, 20, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 5, 10, 10);
			g.fillOval(60, 5, 10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 35, 40, 40);
			
			g.setColor(Color.RED);
			g.fillOval(35, 40, 30, 30);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain3_up() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(10, 60, 20, 40);
			g.fillOval(70, 60, 20, 40);
			
			g.setColor(Color.WHITE);
			g.fillOval(15, 65, 5, 15);
			g.fillOval(75, 65, 5, 15);
			
			g.setColor(Color.WHITE);
			g.fillOval(17, 85, 5, 5);
			g.fillOval(77, 85, 5, 5);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 15, 10, 30);
			g.fillOval(60, 15, 10, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(25, 0, 20, 20);
			g.fillOval(55, 0, 20, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(20, 30, 60, 50);
			
			g.setColor(Color.WHITE);
			g.fillOval(25, 35, 30, 20);
			
			g.setColor(Color.WHITE);
			g.fillOval(22, 55, 5, 5);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain3_left() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 40, 30, 30);
			
			g.setColor(Color.BLACK);
			g.fillRect(15, 35, 30, 40);
			
			g.setColor(Color.BLACK);
			g.fillOval(25, 30, 50, 50);
			
			g.setColor(Color.WHITE);
			g.fillOval(30, 35, 30, 20);
			
			g.setColor(Color.WHITE);
			g.fillOval(27, 55, 5, 5);
			
			g.setColor(Color.BLACK);
			g.fillOval(40, 15, 10, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(35, 0, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(35, 0, 10, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(35, 5, 5, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(30, 60, 40, 40);
			
			g.setColor(Color.WHITE);
			g.fillOval(36, 63, 10, 10);
			
			g.setColor(Color.WHITE);
			g.fillOval(34, 65, 10, 15);
			
			g.setColor(Color.WHITE);
			g.fillOval(33, 84, 5, 5);
			
			g.dispose();
			
			return newVillain;
		}
		
		public Image makeVillain3_die() {
			
			Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newVillain.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(5, 85, 90, 20);
			
			g.setColor(Color.RED);
			g.fillOval(10, 60, 20, 40);
			g.fillOval(70, 60, 20, 40);
			
			g.setColor(Color.RED);
			g.fillOval(30, 15, 10, 30);
			g.fillOval(60, 15, 10, 30);
			
			g.setColor(Color.RED);
			g.fillOval(25, 0, 20, 20);
			g.fillOval(55, 0, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(20, 30, 60, 50);
			
			g.dispose();
			
			return newVillain;
		}
		
		
	}
	
	class Villain3_bulletG {
		
		public Image makeBullet() {
			
			Image newBullet = new BufferedImage(30,30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBullet.getGraphics();
			
			g.setColor(Color.RED);
			g.fillOval(0,0,30,30);
			
			return newBullet;
		}
		
	}
	
	class Stage1BossG {
		
		public Image makeBoss_left() {
			
			Image newBoss = new BufferedImage(300, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBoss.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(30, 90, 270, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 200, 100);
			g.fillRect(100, 0, 200, 100);
			
			g.setColor(Color.RED);
			g.fillOval(20, 35, 40, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(18, 31, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(20, 70, 50, 10);
			g.fillOval(55, 68, 15, 10);
			g.fillOval(60, 65, 10, 10);
			g.fillOval(63, 61, 10, 15);
			
			g.setColor(Color.RED);
			g.fillRect(150, 0, 10, 100);
			g.fillRect(200, 0, 10, 100);
			g.fillRect(250, 0, 10, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(55, 10 , 100, 10);
			g.fillOval(165, 12, 20, 5);
			
			return newBoss;
		}
		
		public Image makeBoss_right() {
			
			Image newBoss = new BufferedImage(300, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBoss.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(30, 90, 270, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(100, 0, 200, 100);
			g.fillRect(0, 0, 200, 100);
			
			g.setColor(Color.RED);
			g.fillOval(240, 35, 40, 20);
			
			g.setColor(Color.BLACK);
			g.fillOval(262, 31, 20, 20);
			
			g.setColor(Color.RED);
			g.fillOval(230, 70, 50, 10);
			g.fillOval(230, 68, 15, 10);
			g.fillOval(230, 65, 10, 10);
			g.fillOval(227, 61, 10, 15);
			
			g.setColor(Color.RED);
			g.fillRect(50, 0, 10, 100);
			g.fillRect(100, 0, 10, 100);
			g.fillRect(150, 0, 10, 100);
			
			g.setColor(Color.WHITE);
			g.fillOval(55, 10 , 100, 10);
			g.fillOval(165, 12, 20, 5);
			
			return newBoss;
		}
		
		public Image makeBoss_left_die() {
			
			Image newBoss = new BufferedImage(300, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBoss.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(30, 90, 270, 20);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 200, 100);
			g.fillRect(100, 0, 200, 100);
			
			return newBoss;
		}
		
		public Image makeBoss_right_die() {
			
			Image newBoss = new BufferedImage(300, 110, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBoss.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(30, 90, 270, 20);
			
			g.setColor(Color.RED);
			g.fillOval(100, 0, 200, 100);
			g.fillRect(0, 0, 200, 100);
			
			return newBoss;
		}
		
	}
	
	class GoldCoinG {
		
		public Image makeGoldCoin() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.ORANGE);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			return newCoin;
		}
		
		public Image makeGoldCoin2() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 0, 5, 5);
			
			g.setColor(Color.WHITE);
			g.fillOval(25, 25, 5, 5);
			
			g.setColor(Color.WHITE);
			g.fillOval(25, 10, 5, 5);
			
			g.setColor(Color.WHITE);
			g.fillOval(5, 25, 5, 5);
			
			return newCoin;
		}
		
		public Image makeGoldCoin3() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.BLACK);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 5, 5, 5);
			
			g.setColor(Color.WHITE);
			g.fillOval(25, 20, 5, 5);
			
			g.setColor(Color.WHITE);
			g.fillOval(25, 0, 5, 5);
			
			g.setColor(Color.WHITE);
			g.fillOval(0, 25, 5, 5);
			
			return newCoin;
		}
		
	}
	
	
	class GoldCoin2G {
		
		public Image makeGoldCoin() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.ORANGE);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.BLUE);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			return newCoin;
		}
		
		public Image makeGoldCoin2() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.BLUE);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			g.setColor(Color.CYAN);
			g.fillOval(0, 0, 5, 5);
			
			g.setColor(Color.CYAN);
			g.fillOval(25, 25, 5, 5);
			
			g.setColor(Color.CYAN);
			g.fillOval(25, 10, 5, 5);
			
			g.setColor(Color.CYAN);
			g.fillOval(5, 25, 5, 5);
			
			return newCoin;
		}
		
		public Image makeGoldCoin3() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.BLUE);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			g.setColor(Color.CYAN);
			g.fillOval(0, 5, 5, 5);
			
			g.setColor(Color.CYAN);
			g.fillOval(25, 20, 5, 5);
			
			g.setColor(Color.CYAN);
			g.fillOval(25, 0, 5, 5);
			
			g.setColor(Color.CYAN);
			g.fillOval(0, 25, 5, 5);
			
			return newCoin;
		}
		
	}
	
	
	class GoldCoin3G {
		
		public Image makeGoldCoin() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.ORANGE);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			return newCoin;
		}
		
		public Image makeGoldCoin2() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			g.setColor(Color.RED);
			g.fillOval(0, 0, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(25, 25, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(25, 10, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(5, 25, 5, 5);
			
			return newCoin;
		}
		
		public Image makeGoldCoin3() {
			
			Image newCoin = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newCoin.getGraphics();
			
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(5, 5, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(12, 7, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(7, 12, 15, 6);
			
			g.setColor(Color.RED);
			g.fillOval(0, 5, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(25, 20, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(25, 0, 5, 5);
			
			g.setColor(Color.RED);
			g.fillOval(0, 25, 5, 5);
			
			return newCoin;
		}
		
	}
	
	class GoldBox1G {
		
		public Image makeGoldBox1() {
			
			Image newBox = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBox.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(0, 80, 100, 20);
			
			//-------
			
			g.setColor(Color.ORANGE);
			g.fillOval(20, 10, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(25, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(32, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(27, 22, 15, 6);
			
			//------
			
			g.setColor(Color.ORANGE);
			g.fillOval(30, 10, 30, 30);
			
			g.setColor(Color.BLUE);
			g.fillOval(35, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(42, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(37, 22, 15, 6);
			
			//--------
			
			g.setColor(Color.ORANGE);
			g.fillOval(40, 10, 30, 30);
			
			g.setColor(Color.GREEN);
			g.fillOval(45, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(52, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(47, 22, 15, 6);
			
			//--------
			
			g.setColor(Color.ORANGE);
			g.fillOval(50, 10, 30, 30);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(55, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(62, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(57, 22, 15, 6);
			
			//---------
			
			g.setColor(Color.BLACK); //상자
			g.fillRect(10, 30, 80, 60);
			
			g.setColor(Color.GREEN);
			g.fillOval(35, 45, 30, 30);
			
			g.setColor(Color.WHITE);
			g.fillOval(40, 50, 15, 15);
			g.fillOval(55, 65, 5, 5);
			
			return newBox;
		}
		
		public Image makeGoldBox2() {
			
			Image newBox = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBox.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(0, 80, 100, 20);
			
			//-------
			
			g.setColor(Color.ORANGE);
			g.fillOval(20, 10, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(25, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(32, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(27, 22, 15, 6);
			
			//------
			
			g.setColor(Color.ORANGE);
			g.fillOval(30, 10, 30, 30);
			
			g.setColor(Color.BLUE);
			g.fillOval(35, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(42, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(37, 22, 15, 6);
			
			//--------
			
			g.setColor(Color.ORANGE);
			g.fillOval(40, 10, 30, 30);
			
			g.setColor(Color.GREEN);
			g.fillOval(45, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(52, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(47, 22, 15, 6);
			
			//--------
			
			g.setColor(Color.ORANGE);
			g.fillOval(50, 10, 30, 30);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(55, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(62, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(57, 22, 15, 6);
			
			//---------
			
			g.setColor(Color.BLACK); //상자
			g.fillRect(10, 30, 80, 60);
			
			g.setColor(Color.GREEN);
			g.fillOval(35, 45, 30, 30);
			
			g.setColor(Color.WHITE);
			g.fillOval(40, 50, 15, 15);
			g.fillOval(55, 65, 5, 5);
			
			//-------
			
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, 5, 5);
			g.fillOval(10, 5, 5, 5);
			g.fillOval(15, 10, 5, 5);
			g.fillOval(25, 5, 5, 5);
			g.fillOval(85, 5, 5, 5);
			g.fillOval(35, 10, 5, 5);
			g.fillOval(60, 20, 5, 5);
			g.fillOval(60, 20, 5, 5);
			g.fillOval(70, 5, 5, 5);
			g.fillOval(50, 25, 5, 5);
			g.fillOval(90, 15, 5, 5);
			g.fillOval(95, 30, 5, 5);
			g.fillOval(10, 15, 5, 5);
			g.fillOval(20, 40, 5, 5);
			g.fillOval(70, 50, 5, 5);
			g.fillOval(30, 70, 5, 5);
			g.fillOval(80, 75, 5, 5);
			g.fillOval(15, 60, 5, 5);
			g.fillOval(5, 50, 5, 5);
			g.fillOval(10, 90, 5, 5);
			g.fillOval(95, 60, 5, 5);
			g.fillOval(100, 65, 5, 5);
			
			return newBox;
		}
		
		public Image makeGoldBox3() {
			
			Image newBox = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
			Graphics g = newBox.getGraphics();
			
			g.setColor(Color.DARK_GRAY);
			g.fillOval(0, 80, 100, 20);
			
			//-------
			
			g.setColor(Color.ORANGE);
			g.fillOval(20, 10, 30, 30);
			
			g.setColor(Color.RED);
			g.fillOval(25, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(32, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(27, 22, 15, 6);
			
			//------
			
			g.setColor(Color.ORANGE);
			g.fillOval(30, 10, 30, 30);
			
			g.setColor(Color.BLUE);
			g.fillOval(35, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(42, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(37, 22, 15, 6);
			
			//--------
			
			g.setColor(Color.ORANGE);
			g.fillOval(40, 10, 30, 30);
			
			g.setColor(Color.GREEN);
			g.fillOval(45, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(52, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(47, 22, 15, 6);
			
			//--------
			
			g.setColor(Color.ORANGE);
			g.fillOval(50, 10, 30, 30);
			
			g.setColor(Color.MAGENTA);
			g.fillOval(55, 15, 20, 20);
			
			g.setColor(Color.YELLOW);
			g.fillOval(62, 17, 6, 15);
			
			g.setColor(Color.YELLOW);
			g.fillOval(57, 22, 15, 6);
			
			//---------
			
			g.setColor(Color.BLACK); //상자
			g.fillRect(10, 30, 80, 60);
			
			g.setColor(Color.GREEN);
			g.fillOval(35, 45, 30, 30);
			
			g.setColor(Color.WHITE);
			g.fillOval(40, 50, 15, 15);
			g.fillOval(55, 65, 5, 5);
			
			//-------
			
			g.setColor(Color.GREEN);
			g.fillOval(0, 5, 5, 5);
			g.fillOval(10, 10, 5, 5);
			g.fillOval(15, 5, 5, 5);
			g.fillOval(25, 0, 5, 5);
			g.fillOval(85, 0, 5, 5);
			g.fillOval(35, 15, 5, 5);
			g.fillOval(60, 25, 5, 5);
			g.fillOval(60, 15, 5, 5);
			g.fillOval(70, 0, 5, 5);
			g.fillOval(50, 30, 5, 5);
			g.fillOval(90, 10, 5, 5);
			g.fillOval(95, 35, 5, 5);
			g.fillOval(10, 20, 5, 5);
			g.fillOval(20, 45, 5, 5);
			g.fillOval(70, 55, 5, 5);
			g.fillOval(30, 65, 5, 5);
			g.fillOval(80, 70, 5, 5);
			g.fillOval(15, 65, 5, 5);
			g.fillOval(5, 55, 5, 5);
			g.fillOval(10, 85, 5, 5);
			g.fillOval(95, 65, 5, 5);
			g.fillOval(100, 60, 5, 5);
			
			return newBox;
		}
		
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
		
		MessageReadThread MRT = new MessageReadThread();
		Thread MessageRead = new Thread(MRT);
		MessageRead.start();
	}
	
	class MessageReadThread implements Runnable{
		@Override
		public void run() {
			try {
				while(true) {
					String message = reader.readLine();
					String[] messageCut = message.split("/c;");
					
					switch(messageCut[0]) {
					case "join" : 
						MessengerArea.append("\n ***** "+messageCut[1]+" has entered the room. ***** \n\n");
						break;
						
					case "speak":
						MessengerArea.append(" >> "+messageCut[1]+" : "+messageCut[2]+"\n");
						break;
						
					case "left":
						MessengerArea.append("\n ***** "+messageCut[1]+" has left the room. ***** \n\n");
					    break;
					    
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	class GameThread implements Runnable{
		
		Boolean Thread_ToF = true;

		@Override
		public void run() {
			
			while(Thread_ToF) {
				
				if(QuitGameNum == 1) {
					QuitGameNum = 0;
					Thread_ToF = false;
					System.exit(0);
					Gameframe.dispose();
					return;
				}
				
				BarPane.setVisible(false);
				closePane();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				DarkPanel();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				FirstPanel();
				
				try {
					s = new Socket(ipNum, 7777);
					
					writer = new PrintWriter(s.getOutputStream(), true);
					reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
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
				
				ProjectGuidPanel();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(true) { // 로그인 화면
					
					closePane();
					
					LoginPanel();
					
					while(LoginNum == 0){
						
						if(QuitGameNum == 1) {
							QuitGameNum = 0;
							Thread_ToF = false;
							Gameframe.dispose();
							System.exit(0);
							return;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
					if(LoginNum == 2) { // 로그인 화면에서 회원가입 버튼 눌렀을
						LoginNum = 0;
						
						while(true) { // 회원가입 패널
							
							closePane();
							SignUpPanel();
							
							while(signNum == 0) {
								
								if(QuitGameNum == 1) {
									QuitGameNum = 0;
									Thread_ToF = false;
									System.exit(0);
									Gameframe.dispose();
									return;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						
							if(signNum == 2) { // 로그인 화면으로 돌아가기
								signNum = 0;
								
								signIdField.setText("");
								signPwField.setText("");
								signNameField.setText("");
								
								break;
							}
							else if(signNum == 1) { // 가입 버튼 클릭
									
								if(signIdField.getText().length() == 0) {
									signNum = 0;
									continue;
										
								}else {
									if(signPwField.getPassword().length == 0) {
										signNum = 0;
										continue;
											
									}else {
										if(signNameField.getText().length() == 0) {
											signNum = 0;
											continue;
												
										}else {
											
											String signIdtext = signIdField.getText();
											char[] signPwpass = signPwField.getPassword();
											String signPwtext = new String(signPwpass);
											String signNametext = signNameField.getText();
											
											boolean checkSignId = GUD.CheckUser(signIdtext);
											
											if(checkSignId == false) {
												GUD.SignUpUser(signIdtext, signPwtext, signNametext);
												signNum = 0;
												break;
												
											}else {
												System.out.println("아이디 중복됨");
												signNum = 0;
												continue;
											}
										}
									}
								}
							}
						}
					}else if(LoginNum == 1) {
						LoginNum = 0;
						
						if(Idfield.getText().length() == 0) {
							LoginNum = 0;
							continue;
							
						}else {
							if(Pwfield.getPassword().length == 0) {
								LoginNum = 0;
								continue;
								
							}else {
								String LoginIdtext = Idfield.getText();
								char[] LoginPwpass = Pwfield.getPassword();
								String LoginPwtext = new String(LoginPwpass);
								
								boolean LoginCheck = GUD.LoginUser(LoginIdtext, LoginPwtext);
								
								if(LoginCheck == true) {
									LoginNum = 0;
									System.out.println("로그인 성공");
									
									ArrayList<GameUser> GUList = GUD.InputUser(LoginIdtext);
									
									for(GameUser gu : GUList ) {
										InformationId = gu.getUserid();
										InformationPw = gu.getUserpw();
										InformationName = gu.getUsername();
										InformationLevel = gu.getUserlevel();
										InformationAlias = gu.getUseralias();
										InformationStage = gu.getUserStage();
										InformationCoin = gu.getUsercoin();
										InformationAvatar = gu.getUseravatar();
									}
									
									break;
								}else {
									LoginNum = 0;
									System.out.println("로그인 실패");
									continue;
								}
							}
						}
					}
				} 
				// 로그인 패널 빠져나옴
				BarPane.setVisible(true);
				
				while(true) {
					BarPane.setVisible(true);
					closePane();
					StartGamePanel();
					InGameButton.setForeground(Color.RED);
					
					while(joinNum == 0) {
						
						if(QuitGameNum == 1) {
							QuitGameNum = 0;
							Thread_ToF = false;
							System.exit(0);
							Gameframe.dispose();
							return;
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					InGameButton.setForeground(Color.DARK_GRAY);
					
					if(joinNum == 1) {
						joinNum = 0;
						InGameButton.setForeground(Color.RED);
						
						while(joinNum == 0) {
							
							if(QuitGameNum == 1) {
								QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						InGameButton.setForeground(Color.DARK_GRAY);
						continue;
						
					}
					else if(joinNum == 2) {
						joinNum = 0;
						
						closePane();
						GamePlayPanel();
						
						while(joinNum == 0) {
							
							if(QuitGameNum == 1) {
								QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						if(joinNum == 8) {
							joinNum = 0;
							
							easy1start = 1;
							
							BarPane.setVisible(false);
							
							closePane();
							
							StageRoadingPanel();
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							closePane();
							
							Stage1EASYPanel();

							while(villainsLair.isVisible() == true && UserAvatar.isVisible() == true && ExitGameNum == 0 && TimeOverNum == 0){
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
							
							closePane();
							
							if(UserAvatar.isVisible() == true && ExitGameNum == 0 && TimeOverNum == 0) {
								StageClearPanel();
								easy1start = 0;
								
								GUD.updateLevel(InformationLevel, InformationId);
								
								if(InformationStage <= 1 ) {
									GUD.updateStage(InformationStage, InformationId);
									
									System.out.println("스테이지 업데이트");
									}
								
								ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
								
								for(GameUser gu : GUList ) {
									InformationId = gu.getUserid();
									InformationPw = gu.getUserpw();
									InformationName = gu.getUsername();
									InformationLevel = gu.getUserlevel();
									InformationAlias = gu.getUseralias();
									InformationStage = gu.getUserStage();
									InformationCoin = gu.getUsercoin();
									InformationAvatar = gu.getUseravatar();
								}
								
							}else{
								StageFailePanel();
								easy1start = 0;
								ExitGameNum = 0;
								TimeOverNum = 0;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							joinNum = 2;
							
							continue;
							
						}else if(joinNum == 9) {
							joinNum = 0;
							
							if(InformationStage >= 2) {
								
								medium1start = 1;
								
								BarPane.setVisible(false);
								
								closePane();
								
								StageRoadingPanel();
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
								closePane();
								
								Stage1MEDIUMPanel();

								while(villainsLair.isVisible() == true && UserAvatar.isVisible() == true && ExitGameNum == 0 && TimeOverNum == 0){
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
								
								closePane();
								
								if(UserAvatar.isVisible() == true && ExitGameNum == 0 && TimeOverNum == 0) {
									StageClearPanel();
									medium1start = 0;
									
									GUD.updateLevel(InformationLevel, InformationId);
									
									if(InformationStage <= 2 ) {
										GUD.updateStage(InformationStage, InformationId);
										}
									
									if(InformationAlias.equals("Beginner")) {
										GUD.updateAlias("Warrior", InformationId);
									}
									
									ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
									
									for(GameUser gu : GUList ) {
										InformationId = gu.getUserid();
										InformationPw = gu.getUserpw();
										InformationName = gu.getUsername();
										InformationLevel = gu.getUserlevel();
										InformationAlias = gu.getUseralias();
										InformationStage = gu.getUserStage();
										InformationCoin = gu.getUsercoin();
										InformationAvatar = gu.getUseravatar();
									}
									
								}else {
									StageFailePanel();
									medium1start = 0;
									ExitGameNum = 0;
									TimeOverNum = 0;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
							}else {
								closePane();
							}
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 10) {
							joinNum = 0;
							
							if(InformationStage >= 3) {
								
								hard1start = 1;
								
								BarPane.setVisible(false);
								
								closePane();
								
								StageRoadingPanel();
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
								closePane();
								
								Stage1HARDPanel();

								while(villainsLair.isVisible() == true && UserAvatar.isVisible() == true && ExitGameNum == 0 && TimeOverNum == 0){
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
								
								closePane();
								
								if(UserAvatar.isVisible() == true && ExitGameNum == 0 && TimeOverNum == 0) {
									StageClearPanel();
									hard1start = 0;
									
									GUD.updateLevel(InformationLevel, InformationId);
									
									if(InformationStage <= 3 ) {
										GUD.updateStage(InformationStage, InformationId);
										}
									
									if(InformationAlias.equals("Warrior")) {
										GUD.updateAlias("Hero", InformationId);
									}
									
									ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
									
									for(GameUser gu : GUList ) {
										InformationId = gu.getUserid();
										InformationPw = gu.getUserpw();
										InformationName = gu.getUsername();
										InformationLevel = gu.getUserlevel();
										InformationAlias = gu.getUseralias();
										InformationStage = gu.getUserStage();
										InformationCoin = gu.getUsercoin();
										InformationAvatar = gu.getUseravatar();
									}
									
								}else {
									StageFailePanel();
									hard1start = 0;
									ExitGameNum = 0;
									TimeOverNum = 0;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
							}else {
								closePane();
							}
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 11) {
							
							joinNum = 0;
							closePane();
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 12) {
							
							joinNum = 0;
							closePane();
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 13) {
							
							joinNum = 0;
							closePane();
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 14) {
							
							joinNum = 0;
							closePane();
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 15) {
							
							joinNum = 0;
							closePane();
							
							joinNum = 2;
							continue;
							
						}else if(joinNum == 16) {
							
							joinNum = 0;
							closePane();
							
							joinNum = 2;
							continue;
							
						}
						
						continue;
						
					}
					else if(joinNum == 3) {
						joinNum = 0;
						
						closePane();
						MyPagePanel();
						MyPageButton.setForeground(Color.RED);
						
						MyPageIdText.setText(InformationId);
						MyPageNameText.setText(InformationName);
						MyPageLevelText.setText(""+InformationLevel);
						MyPageAliasText.setText(InformationAlias);
						MyPageCoinfield.setText(""+InformationCoin);
						if(InformationAvatar == 1) {
							MyPageAvatar.setIcon(new ImageIcon(mav.makeAvatar1()));
						}else if(InformationAvatar == 2) {
							MyPageAvatar.setIcon(new ImageIcon(mav.makeAvatar2()));
						}else if(InformationAvatar == 3) {
							MyPageAvatar.setIcon(new ImageIcon(mav.makeAvatar3()));
						}else if(InformationAvatar == 4) {
							MyPageAvatar.setIcon(new ImageIcon(mav.makeAvatar4()));
						}else if(InformationAvatar == 5) {
							MyPageAvatar.setIcon(new ImageIcon(mav.makeAvatar5()));
						}
						
						while(joinNum == 0) {
							
							if(QuitGameNum == 1) {
								QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						MyPageButton.setForeground(Color.DARK_GRAY);
						
						if(joinNum == 6) {
							joinNum = 0;
							
							closePane();
							ChangeNamePanel();
							MyPageButton.setForeground(Color.RED);
							
							while(ChangeNameNum == 0) {
								
								if(QuitGameNum == 1) {
									QuitGameNum = 0;
									Thread_ToF = false;
									System.exit(0);
									Gameframe.dispose();
									return;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							while(joinNum == 0) {
								
								if(QuitGameNum == 1) {
									QuitGameNum = 0;
									Thread_ToF = false;
									System.exit(0);
									Gameframe.dispose();
									return;
								}
								
								if(ChangeNameNum == 2) {
									ChangeNameNum = 0;
									
									if(ChangeNamefield.getText().length() != 0) {
										
										String newName = ChangeNamefield.getText();
										
										GUD.updateName(newName, InformationId);
										
										ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
										
										for(GameUser gu : GUList ) {
											InformationId = gu.getUserid();
											InformationPw = gu.getUserpw();
											InformationName = gu.getUsername();
											InformationLevel = gu.getUserlevel();
											InformationAlias = gu.getUseralias();
											InformationStage = gu.getUserStage();
											InformationCoin = gu.getUsercoin();
											InformationAvatar = gu.getUseravatar();
										}
										
										joinNum = 3;
										
									}else {
										System.out.println("문자를 입력하지 않음");
									}
									
								}else if(ChangeNameNum == 1) {
									ChangeNameNum = 0;
									joinNum = 3;
								}
								
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
							}
														
							continue;
							
						}else if(joinNum == 7) {
							joinNum = 0;
							
							closePane();
							ChangePwPanel();
							MyPageButton.setForeground(Color.RED);
							
							while(ChangePwNum == 0) {
								
								if(QuitGameNum == 1) {
									QuitGameNum = 0;
									Thread_ToF = false;
									System.exit(0);
									Gameframe.dispose();
									return;
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
							while(joinNum == 0) {
								
								if(QuitGameNum == 1) {
									QuitGameNum = 0;
									Thread_ToF = false;
									System.exit(0);
									Gameframe.dispose();
									return;
								}
								
								if(ChangePwNum == 2) {
									ChangePwNum = 0;
									
									char[] getcheckChangePw = ChangeCurrentPwfield.getPassword();
									String checkChangePw = new String(getcheckChangePw);
									
									boolean checkChangeThisPw = GUD.LoginUser(InformationId, checkChangePw);
									
									if(checkChangeThisPw == true) {
										
										char[] getChangeNewPw = ChangePwfield.getPassword();
										String ChangeNewPw = new String(getChangeNewPw);
										
										GUD.updatePw(ChangeNewPw, InformationId);
										
										ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
										
										for(GameUser gu : GUList ) {
											InformationId = gu.getUserid();
											InformationPw = gu.getUserpw();
											InformationName = gu.getUsername();
											InformationLevel = gu.getUserlevel();
											InformationAlias = gu.getUseralias();
											InformationStage = gu.getUserStage();
											InformationCoin = gu.getUsercoin();
											InformationAvatar = gu.getUseravatar();
										}
										
										joinNum = 3;
										
									}else {
										System.out.println("현재 비밀번호가 맞지 않습니다.");
									}
									
								}else if(ChangePwNum == 1) {
									ChangePwNum = 0;
									joinNum = 3;
									
								}
								
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
							}
														
							continue;
							
						}
						
						continue;
						
					}
					else if(joinNum == 4) {
						joinNum = 0;
						
						closePane();
						ShopPanel();
						ShopButton.setForeground(Color.RED);
						
						while(joinNum == 0) {
							
							if(QuitGameNum == 1) {
								QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								Gameframe.dispose();
								return;
							}
							
							if(BuyAvatarNum != 0) {
								if(BuyAvatarNum == 1) {
									if(InformationCoin >= 1000) {
										BuyAvatarNum = 0;
										GUD.updateAvatar(2, InformationCoin, 1000, InformationId);
										System.out.println("구매성공");
									}else {
										System.out.println("코인부족");
									}
								}else if(BuyAvatarNum == 2) {
									if(InformationCoin >= 2000) {
										BuyAvatarNum = 0;
										GUD.updateAvatar(3, InformationCoin, 2000, InformationId);
										System.out.println("구매성공");
									}else {
										System.out.println("코인부족");
									}
								}else if(BuyAvatarNum == 3) {
									if(InformationCoin >= 3000) {
										BuyAvatarNum = 0;
										GUD.updateAvatar(4, InformationCoin, 3000, InformationId);
										System.out.println("구매성공");
									}else {
										System.out.println("코인부족");
									}
								}else if(BuyAvatarNum == 4) {
									if(InformationCoin >= 4000) {
										BuyAvatarNum = 0;
										GUD.updateAvatar(5, InformationCoin, 4000, InformationId);
										System.out.println("구매성공");
									}else {
										System.out.println("코인부족");
									}
								}
								
								if(BuyAvatarNum == 0) {
									ArrayList<GameUser> GUList = GUD.InputUser(InformationId);
									for(GameUser gu : GUList ) {
										InformationId = gu.getUserid();
										InformationPw = gu.getUserpw();
										InformationName = gu.getUsername();
										InformationLevel = gu.getUserlevel();
										InformationAlias = gu.getUseralias();
										InformationStage = gu.getUserStage();
										InformationCoin = gu.getUsercoin();
										InformationAvatar = gu.getUseravatar();
									}
									System.out.println("구매 성공");
								}else {
									BuyAvatarNum = 0;
									System.out.println("구매실패");
								}
							}
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						ShopButton.setForeground(Color.DARK_GRAY);
						
						continue;
						
					}else if(joinNum == 5) {
						joinNum = 0;
						
						closePane();
						MessengerPanel();
						MessengerButton.setForeground(Color.RED);
						
						String message = "join/c;"+"[ Level : "+InformationLevel+" ] "+InformationName;
						writer.println(message);
						
						while(joinNum == 0) {
							
							if(QuitGameNum == 1) {
								QuitGameNum = 0;
								Thread_ToF = false;
								System.exit(0);
								Gameframe.dispose();
								return;
							}
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						String message2 = "left/c;"+"[ Level : "+InformationLevel+" ] "+InformationName;
						writer.println(message2);
						
						MessengerButton.setForeground(Color.DARK_GRAY);
						continue;
						
					}
					
				}
				
			} // 전체 반복 구간
			
		}
		
	}
	
	public static void main(String[] args) {
		new InGame();
	}
}
