package TheBombBoy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class OtherGameProfileBoxG {
	InGame ingame;
	OtherGameProfileBoxG(InGame ingame){
		this.ingame = ingame;
	}
	
	public Image makeProfile() {
		Image newProfile = new BufferedImage(900, 80, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newProfile.getGraphics();
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 0, 700, 80);
		g.fillOval(0, 0, 200, 80);
		g.fillOval(700, 0, 200, 80);
		g.fillOval(0, 0, 40, 80);
		g.fillOval(860, 0, 40, 80);
		
		g.setColor(Color.RED);
		g.fillOval(10, 10, 20, 60);
		g.fillOval(870, 10, 20, 60);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(100, 10, 700, 60);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(40, 5, 100, 70);
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(40, 15, 80, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(50, 32, 30, 15);
		g.fillOval(80, 32, 30, 15);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(70, 35, 10, 10);
		g.fillOval(100, 35, 10, 10);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(70, 50, 20, 5);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(680, 5, 160, 70);
		
		g.setColor(Color.CYAN);
		g.fillOval(750, 15, 110, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(770, 20, 50, 20);
		g.fillOval(760, 40, 20, 10);
		
		Font ProfileBoxFont1 = new Font("Arial", Font.BOLD, 20);
		g.setFont(ProfileBoxFont1);
		
		g.setColor(Color.GRAY);
		g.drawString("Level", 695, 47);
		
		g.setColor(Color.BLUE);
		g.fillRect(470, 0, 200, 80);
		
		g.setColor(Color.WHITE);
		g.fillRect(475, 0, 10, 80);
		g.fillRect(490, 0, 10, 80);
		g.fillRect(655, 0, 10, 80);
		g.fillRect(640, 0, 10, 80);
		
		g.setColor(Color.WHITE);
		g.drawString("- Alias -", 535, 20);
		
		if(ingame.OtherUserId != null) {
			Font ProfileBoxFont2 = new Font("Arial", Font.BOLD, 40);
			g.setFont(ProfileBoxFont2);
			g.drawString(ingame.OtherUserAlias, 525, 60);
			g.drawString(ingame.OtherUserName, 175, 55);
			g.setFont(ProfileBoxFont2);
			g.setColor(Color.BLUE);
			g.drawString(ingame.OtherUserLevel+"", 782, 55);
		}
		
		return newProfile;
	}
}