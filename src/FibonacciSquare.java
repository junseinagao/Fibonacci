import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {

	@Override
	public void draw(Graphics g) {
		// draw a square
		g.setColor(Color.RED);
		g.drawRect(50, 50, 100, 100);
		g.drawArc(50, -50, 200, 200, 180, 90);
		
	}
}
