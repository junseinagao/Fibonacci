import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape{
	private int size;
	
	public HShape(int x, int y, Color c, int size) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.size = size;
	}
	
	public void draw(Graphics g){
		g.setColor(c);
		// Fills the spaces corresponding to the adequate squares
		g.fillRect(x, y, size, size);
		g.fillRect(x-size, y-size, size, size);
		g.fillRect(x-size, y, size, size);
		g.fillRect(x-size, y+size, size, size);
		g.fillRect(x+size, y-size, size, size);
		g.fillRect(x+size, y, size, size);
		g.fillRect(x+size, y+size, size, size);
	}
	
}
