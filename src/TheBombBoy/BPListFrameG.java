package TheBombBoy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BPListFrameG {
	
	public Image newFrame1() {
		
		BufferedImage newFrame = new BufferedImage(50, 300, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = newFrame.getGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(20, 0, 30, 300);
		g.fillOval(0, 0, 50, 300);
		
		return newFrame;
	}
	
	public Image newFrame2() {
		
		BufferedImage newFrame = new BufferedImage(50, 300, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = newFrame.getGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 30, 300);
		g.fillOval(0, 0, 50, 300);
		
		return newFrame;
		
	}
	
	public Image newFrame3() {
		
		BufferedImage newFrame = new BufferedImage(600, 50, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = newFrame.getGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(20, 20, 560, 30);
		g.fillOval(15, 0, 570, 50);
		
		return newFrame;
		
	}
	
	public Image newFrame4() {
		
		BufferedImage newFrame = new BufferedImage(600, 50, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = newFrame.getGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(20, 0, 560, 30);
		g.fillOval(15, 0, 570, 50);
		
		return newFrame;
		
	}
	
	public Image newSearchIcon() {
		
		BufferedImage SearchIcon = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = SearchIcon.getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 50, 50);
		
		g.setColor(Color.CYAN);
		g.drawString("Search", 5, 30);
		
		return SearchIcon;
	}

}
