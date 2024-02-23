package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class TrainingBotG {
	
	public Image makeBot() {
		
		Image newBot = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newBot.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.GRAY);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.setColor(Color.CYAN);
		g.fillOval(20, 40, 30, 20);
		g.fillOval(50, 40, 30, 20);
		
		g.setColor(Color.CYAN);
		g.fillOval(40, 70, 20, 10);
		
		g.dispose();
		
		return newBot;
	}
	
	public Image makeBot_up() {
		
		Image newBot = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newBot.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.GRAY);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.dispose();
		
		return newBot;
	}
	
	public Image makeBot_right() {
		
		Image newBot = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newBot.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.GRAY);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.setColor(Color.CYAN);
		g.fillOval(70, 40, 30, 20);
		
		g.setColor(Color.CYAN);
		g.fillOval(70, 70, 20, 10);
		
		g.dispose();
		
		return newBot;
	}
	
	public Image makeBot_left() {
		
		Image newBot = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newBot.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.GRAY);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.setColor(Color.CYAN);
		g.fillOval(0, 40, 30, 20);
		
		g.setColor(Color.CYAN);
		g.fillOval(10, 70, 20, 10);
		
		g.dispose();
		
		return newBot;
	}
	
}
