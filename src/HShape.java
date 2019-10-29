import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape{
	
	private int x;
	private int y;
	private Color c;
	private int size;
	
	private int limit = size / 3;
	/**
	 * @param x
	 * @param y
	 * @param c
	 * @param size
	 */
	public HShape(int x, int y, Color c, int size) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.size = size;
	}
	
	public void fractcalPattern(Graphics g,int limit) {
		if (size > limit) {
			for (int i = 0;i < 3;i++) {
				HShape sl = new HShape(this.x,this.y + i*(this.size/3),c,size/3);
				HShape sr = new HShape(this.x + 2*(this.size/3),this.y + i*(this.size/3),c,size/3);
				sl.draw(g);
				sr.draw(g);
			}
			HShape sm = new HShape(this.x + (this.size/3),this.y + (this.size/3),c,size/3);
			sm.draw(g);
		}
	}

	public int getSize() {
		return size;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Color c) {
		this.c = c;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public HShape deepCopy() {
		Color copyColor = new Color(0);
		copyColor = c;
		return new HShape(x,y,copyColor,size);
	}
	
	public void drawH(Graphics g) {
		int blockSize = size / 3; // size of block of H
		
		// draw squares of left line
		for (int i = 0;i < 3;i++) {
			g.drawRect(x,y + (i * blockSize),blockSize,blockSize);
		}
		
		// draw squares of center line
		g.drawRect(x + blockSize,y+blockSize,blockSize,blockSize);
		
		
		// draw squares of right line
		for (int i = 0;i < 3;i++) {
			g.drawRect(x + 2 * blockSize,y + (i * blockSize),blockSize,blockSize);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		drawH(g);
		fractcalPattern(g,limit);
	}
	


}
