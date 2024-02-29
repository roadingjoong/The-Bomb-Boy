package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Villain4G {
	
	public Image makeVillain4() {
		BufferedImage newVillain = new BufferedImage(100,110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(0, 95, 100, 15);
		
		g.setColor(Color.CYAN);
		g.fillOval(35, 0, 30, 100);
		g.fillOval(0, 35, 100, 30);
		
		g.setColor(Color.WHITE);
		g.fillOval(38, 10, 15, 38);
		g.fillOval(40, 5, 15, 38);
		g.fillOval(45, 0, 10, 20);
		g.fillOval(5, 40, 35, 15);
		g.fillOval(10, 37, 35, 15);
		g.fillOval(15, 36, 35, 15);
		g.fillOval(50, 50, 15, 15);
		g.fillOval(40, 65, 10, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(15, 40, 20, 20);
		g.fillOval(65, 40, 20 ,20);
		
		g.setColor(Color.RED);
		g.fillOval(20, 45, 10, 10);
		g.fillOval(70, 45, 10, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(40, 50, 20, 10);
		
		return newVillain;
	}
	
	public Image makeVillain4_up() {
		BufferedImage newVillain = new BufferedImage(100,110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(0, 95, 100, 15);
		
		g.setColor(Color.CYAN);
		g.fillOval(35, 0, 30, 100);
		g.fillOval(0, 35, 100, 30);
		
		g.setColor(Color.WHITE);
		g.fillOval(38, 10, 15, 38);
		g.fillOval(40, 5, 15, 38);
		g.fillOval(45, 0, 10, 20);
		g.fillOval(5, 40, 35, 15);
		g.fillOval(10, 37, 35, 15);
		g.fillOval(15, 36, 35, 15);
		g.fillOval(40, 50, 15, 15);
		g.fillOval(50, 65, 10, 10);
		
		return newVillain;
	}
	
	public Image makeVillain4_left() {
		BufferedImage newVillain = new BufferedImage(100,110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(35, 95, 30, 15);
		
		g.setColor(Color.CYAN);
		g.fillOval(35, 0, 30, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(38, 10, 15, 38);
		g.fillOval(40, 5, 15, 38);
		g.fillOval(45, 0, 10, 20);
		g.fillOval(50, 65, 15, 15);
		g.fillOval(40, 60, 10, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(35, 40, 10, 20);
		
		g.setColor(Color.RED);
		g.fillOval(35, 45, 5, 10);
		
		return newVillain;
	}
	
	public Image makeVillain4_right() {
		BufferedImage newVillain = new BufferedImage(100,110, BufferedImage.TYPE_INT_ARGB);
		Graphics g = newVillain.getGraphics();
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(35, 95, 30, 15);
		
		g.setColor(Color.CYAN);
		g.fillOval(35, 0, 30, 100);
		
		g.setColor(Color.WHITE);
		g.fillOval(38, 10, 15, 38);
		g.fillOval(40, 5, 15, 38);
		g.fillOval(45, 0, 10, 20);
		g.fillOval(40, 70, 15, 15);
		g.fillOval(50, 60, 10, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(55, 40, 10, 20);
		
		g.setColor(Color.RED);
		g.fillOval(60, 45, 5, 10);
		
		return newVillain;
	}
}
