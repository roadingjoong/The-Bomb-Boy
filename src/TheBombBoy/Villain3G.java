package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Villain3G {
	
	public Image makeVillain3() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(10, 60, 20, 40);
		g.fillOval(70, 60, 20, 40);
		
		g.setColor(Color.WHITE);
		g.fillOval(15, 65, 5, 15);
		g.fillOval(75, 65, 5, 15);
		
		g.setColor(Color.WHITE);
		g.fillOval(17, 85, 5, 5);
		g.fillOval(77, 85, 5, 5);
		
		g.setColor(Color.BLACK);
		g.fillOval(20, 30, 60, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(25, 35, 30, 20);
		
		g.setColor(Color.WHITE);
		g.fillOval(22, 55, 5, 5);
		
		g.setColor(Color.BLACK);
		g.fillOval(30, 15, 10, 30);
		g.fillOval(60, 15, 10, 30);
		
		g.setColor(Color.RED);
		g.fillOval(25, 0, 20, 20);
		g.fillOval(55, 0, 20, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(30, 5, 10, 10);
		g.fillOval(60, 5, 10, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(30, 35, 40, 40);
		
		g.setColor(Color.RED);
		g.fillOval(35, 40, 30, 30);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain3_up() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(10, 60, 20, 40);
		g.fillOval(70, 60, 20, 40);
		
		g.setColor(Color.WHITE);
		g.fillOval(15, 65, 5, 15);
		g.fillOval(75, 65, 5, 15);
		
		g.setColor(Color.WHITE);
		g.fillOval(17, 85, 5, 5);
		g.fillOval(77, 85, 5, 5);
		
		g.setColor(Color.BLACK);
		g.fillOval(30, 15, 10, 30);
		g.fillOval(60, 15, 10, 30);
		
		g.setColor(Color.BLACK);
		g.fillOval(25, 0, 20, 20);
		g.fillOval(55, 0, 20, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(20, 30, 60, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(25, 35, 30, 20);
		
		g.setColor(Color.WHITE);
		g.fillOval(22, 55, 5, 5);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain3_left() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.RED);
		g.fillOval(0, 40, 30, 30);
		
		g.setColor(Color.BLACK);
		g.fillRect(15, 35, 30, 40);
		
		g.setColor(Color.BLACK);
		g.fillOval(25, 30, 50, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(30, 35, 30, 20);
		
		g.setColor(Color.WHITE);
		g.fillOval(27, 55, 5, 5);
		
		g.setColor(Color.BLACK);
		g.fillOval(40, 15, 10, 30);
		
		g.setColor(Color.BLACK);
		g.fillOval(35, 0, 20, 20);
		
		g.setColor(Color.RED);
		g.fillOval(35, 0, 10, 20);
		
		g.setColor(Color.BLACK);
		g.fillOval(35, 5, 5, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(30, 60, 40, 40);
		
		g.setColor(Color.WHITE);
		g.fillOval(36, 63, 10, 10);
		
		g.setColor(Color.WHITE);
		g.fillOval(34, 65, 10, 15);
		
		g.setColor(Color.WHITE);
		g.fillOval(33, 84, 5, 5);
		
		g.dispose();
		
		return newVillain;
	}
	
	public Image makeVillain3_die() {
		
		Image newVillain = new BufferedImage(100, 110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(5, 85, 90, 20);
		
		g.setColor(Color.RED);
		g.fillOval(10, 60, 20, 40);
		g.fillOval(70, 60, 20, 40);
		
		g.setColor(Color.RED);
		g.fillOval(30, 15, 10, 30);
		g.fillOval(60, 15, 10, 30);
		
		g.setColor(Color.RED);
		g.fillOval(25, 0, 20, 20);
		g.fillOval(55, 0, 20, 20);
		
		g.setColor(Color.RED);
		g.fillOval(20, 30, 60, 50);
		
		g.dispose();
		
		return newVillain;
	}
	
}