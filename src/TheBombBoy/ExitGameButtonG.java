package TheBombBoy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ExitGameButtonG {
	
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