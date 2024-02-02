package TheBombBoy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BPGameStartButtonG {
	
	public Image MakeStartButton1() {
		
		Image newStartButton = new BufferedImage(200, 80, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newStartButton.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 200, 80);
		
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 180, 60);
		
		Font buttonFont = new Font("Alial", Font.BOLD, 40);
		g.setColor(Color.RED);
		g.setFont(buttonFont);
		g.drawString("Start", 50, 55);
		
		return newStartButton;
	}
	
	public Image MakeStartButton2() {
		
		Image newStartButton = new BufferedImage(200, 80, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newStartButton.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 200, 80);
		
		g.setColor(Color.WHITE);
		g.fillOval(10, 10, 180, 60);
		
		Font buttonFont = new Font("Alial", Font.BOLD, 40);
		g.setColor(Color.RED);
		g.setFont(buttonFont);
		g.drawString("Start", 50, 55);
		
		return newStartButton;
	}

}
