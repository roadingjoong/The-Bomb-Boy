package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Villain2G {
	
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