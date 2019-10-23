import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {
	private int x;
	private int y;
	private Color c;
	private int quadrant;
	private int n;

	private int rectWide;
	private int rectHight = rectWide;
	private int arcWide;
	private int arcHight = arcWide;
	
	private int sin =1;
	private int cos =1;
	private int angle;
	private int arcAngle =90;
	
	public FibonacciSquare(int x, int y, Color c, int quadrant, int n) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.quadrant = quadrant;
		this.n = n;
	}
	
	public void updateCoordinate(int x, int y) {
		
	}

	public int updateAngle(int quadrant) {
		
		switch (quadrant) {
		
			case 1:
				sin = sin;
				cos = cos;
				angle = 0;
				break;
				
			case 2:
				sin = -1 * sin;
				cos = cos;
				angle = 90;
				break;
				
			case 3:
				sin = -1 * sin;
				cos = -1 * cos;
				angle = 90 * 2;
				break;
				
			case 4:
				sin = sin;
				cos = -1 * cos;
				angle = 90 * 3;
				break;
				
			default:
				throw new IllegalArgumentException("Quadrant takes only numbers to 4 from 1.");			
		}
		return angle;
			
	}
	
	public int updateStartAngle(int quadrant) {
		
	}
	
	@Override
	public void draw(Graphics g) {
		// draw a square
		updateAngle(quadrant);
		g.setColor(c);
		g.drawRect(x, y, rectWide, rectHight);
		g.drawArc(x * sin, y * cos, arcWide, arcHight angle, arcAngle);
		
	}
}
