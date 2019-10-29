import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {
	private int x;
	private int y;
	private Color c;
	private  int quadrant;
	private int n;
	
	private int count;
	private int fN;

	private int arcX;
	private int arcY;
	
	private int rectWide;
	private int rectHight;
	private int arcWide;
	private int arcHight;
	
	private int angle;
	private int arcAngle =90;
	
	public FibonacciSquare(int x, int y, Color c, int quadrant,int n) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.quadrant = quadrant;
		this.count = 1;
		this.n = n;
		this.fN = FibonacciSequence(count);
		updateDrawingParameter();
		updateArc();
	}
	
	public void updateDrawingParameter() {
		rectWide = 2 * 10 * fN;
		rectHight = rectWide;
		arcWide =2 * rectWide;
		arcHight = arcWide;
	}
	/*
	 * Calculate fibonacci number
	 * @param int count
	 * @return fibonacci number
	 */
	
	public int FibonacciSequence(int count) {
			if (count < 0) {
				return -1;
			}
			if (count == 0) {
				return 0;
			}
			if (count == 1) {
				return 1;
			}
			return FibonacciSequence(count - 1) + FibonacciSequence(count - 2);
	}

	/*
	 * update the x and y of "Arc", that location depends on x and y of "Rectangle" and quadrant.
	 * update the angle to draw Arc of the right quadrant.
	 */
	public void updateArc() {
		
		switch (quadrant) {
		
			case 1:
				arcX = x - rectWide;
				arcY = y;
				angle = 0;
				break;
				
			case 2:
				arcX = x;
				arcY = y;
				angle = 90;
				break;
				
			case 3:
				arcX = x;
				arcY = y - rectHight;
				angle = 90 * 2;
				break;
				
			case 4:
				arcX = x - rectWide;
				arcY = y - rectHight;
				angle = 90 * 3;
				break;
				
			default:
				throw new IllegalArgumentException("Quadrant takes only numbers to 4 from 1.");
		}
			
	}
	
	public FibonacciSquare fibonacciTiles(int quadrant,int count) {
		int nextX;
		int nextY;
		
		switch (quadrant) {
		case 1:
			nextX = x - (2 * 10 * FibonacciSequence(count+1));
			nextY = y;
			return new FibonacciSquare(nextX,nextY,Color.BLUE,2, n);
		case 2:
			nextX = x;
			nextY = y + rectHight;
			return new FibonacciSquare(nextX,nextY,Color.BLUE,3, n);
		case 3:
			if(count == 1) {
				nextX = x + rectWide;
				nextY = y;
			} else {
				nextX = x + rectWide ;
				nextY = y - (2 * 10 * FibonacciSequence(count+1)) + rectWide;
			}
			return new FibonacciSquare(nextX,nextY,Color.BLUE,4, n);
		case 4:
			nextX = x - (2 * 10 * FibonacciSequence(count+1)) + rectWide;
			nextY = y - (2 * 10 * FibonacciSequence(count+1));
			return new FibonacciSquare(nextX,nextY,Color.BLUE,1, n);
			}
		return null;
		
	}

	public void recursiveTiles(int count,Graphics g,int n) {
		if (count < n) {
			// recursiveTiles(count-1,g,n);
			FibonacciSquare s = fibonacciTiles(quadrant,count);
			s.count = count + 1;
			s.fN = FibonacciSequence(s.count);
			s.updateDrawingParameter();
			s.updateArc();
			s.draw(g);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		recursiveTiles(count,g,n);
		g.setColor(c);
		g.drawRect(x, y, rectWide, rectHight);
		g.drawArc(arcX, arcY, arcWide, arcHight, angle, arcAngle);
		
		
	}
	
}
