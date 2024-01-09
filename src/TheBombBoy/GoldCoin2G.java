package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class GoldCoin2G {
	
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