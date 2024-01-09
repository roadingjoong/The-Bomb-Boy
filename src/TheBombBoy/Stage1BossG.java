package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Stage1BossG {
	
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