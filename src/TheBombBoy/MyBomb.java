package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class MyBomb {
	
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