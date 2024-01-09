package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Villain1G {
	
	public Image makeVillain1() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.BLACK);
		g.fillRect(5, 5, 90, 50);
		
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.setColor(Color.RED);
		g.fillOval(20, 40, 30, 20);
		g.fillOval(50, 40, 30, 20);
		
		g.setColor(Color.RED);
		g.fillOval(40, 70, 20, 10);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain1_up() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.BLACK);
		g.fillRect(5, 5, 90, 50);
		
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain1_right() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.setColor(Color.RED);
		g.fillOval(70, 40, 30, 20);
		
		g.setColor(Color.RED);
		g.fillOval(70, 70, 20, 10);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain1_left() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, 100, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(20, 9, 25, 20);
		g.fillOval(10, 25, 10, 10);
		
		g.setColor(Color.RED);
		g.fillOval(0, 40, 30, 20);
		
		g.setColor(Color.RED);
		g.fillOval(10, 70, 20, 10);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain1_die() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.RED);
		g.fillRect(5, 5, 90, 50);
		
		g.setColor(Color.RED);
		g.fillOval(0, 0, 100, 100);
		
		g.dispose();
		
		return newVillain;
	}
	
}