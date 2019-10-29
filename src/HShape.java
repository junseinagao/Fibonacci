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
	
  /*
  * I tested the code by adding a few HShapes to the model in the MainClass
  *   Shape h1 = new HShape(85, 100, Color.GREEN, 60);
  *   Shape h2 = new HShape(750, 30, Color.GREEN, 10);
  *   Shape h3 = new HShape(525, 140, Color.GREEN, 15);
  *   Shape h4 = new HShape(310, 260, Color.GREEN, 40);
  *   model.addShape(h1);
  *   model.addShapw(h2);
  *   model.addShape(h3);
  *   model.addShape(h4);
  *
  */
	
}
