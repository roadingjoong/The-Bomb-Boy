package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Villain3_bulletG {
	
	public Image makeBullet() {
		
		Image newBullet = new BufferedImage(30,30, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newBullet.getGraphics();
		
		g.setColor(Color.RED);
		g.fillOval(0,0,30,30);
		
		return newBullet;
	}
	
}