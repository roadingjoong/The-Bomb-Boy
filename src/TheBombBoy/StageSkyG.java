package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class StageSkyG {
	
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