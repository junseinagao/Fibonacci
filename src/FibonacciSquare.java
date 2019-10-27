import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {
	private int x;
	private int y;
	private Color c;
	private  int quadrant;
	private int n;
	
	
	private int limit;
	private int fN;

	private int arcX;
	private int arcY;
	
	private int rectWide;
	private int rectHight;
	private int arcWide;
	private int arcHight;
	
	private int angle;
	private int arcAngle =90;
	
	public FibonacciSquare(int x, int y, Color c, int quadrant,int limit) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.quadrant = quadrant;
		this.n = 1;
		this.limit = limit;
		this.fN = FibonacciSequence(n);
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
	 * @param int n
	 * @return fibonacci number
	 */
	
	public int FibonacciSequence(int n) {
			if (n < 0) {
				return -1;
			}
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}
			return FibonacciSequence(n - 1) + FibonacciSequence(n - 2);
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
	
	public FibonacciSquare fibonacciTiles(int quadrant,int n) {
		int nextX;
		int nextY;
		
		// (1) privious left upper == last right upper
		// (2) privious left lower == last left upper
			// x  == x
			// y = 
		// (3) privious right lower == last left lower
		// (4) privious right upper == last right lower
		
		switch (quadrant) {
		case 1:
			nextX = x - (2 * 10 * FibonacciSequence(n+1));
			nextY = y;
			return new FibonacciSquare(nextX,nextY,Color.BLUE,2, limit);
		case 2:
			nextX = x;
			nextY = y + rectHight;
			return new FibonacciSquare(nextX,nextY,Color.BLUE,3, limit);
		case 3:
			if(n == 1) {
				nextX = x + rectWide;
				nextY = y;
			} else {
				nextX = x + rectWide ;
				nextY = y - (2 * 10 * FibonacciSequence(n+1)) + rectWide;
			}
			return new FibonacciSquare(nextX,nextY,Color.BLUE,4, limit);
		case 4:
			nextX = x - (2 * 10 * FibonacciSequence(n+1)) + rectWide; // x = n.x + n.w - w
			nextY = y - (2 * 10 * FibonacciSequence(n+1)); // y =
			return new FibonacciSquare(nextX,nextY,Color.BLUE,1, limit);
			}
		return null;
		
	}

	public void recursiveTiles(int n,Graphics g,int limit) {
		if (n < limit) {
			// recursiveTiles(n-1,g,limit);
			FibonacciSquare s = fibonacciTiles(quadrant,n);
			s.n = n + 1;
			s.fN = FibonacciSequence(s.n);
			System.out.println(s.fN);
			s.updateDrawingParameter();
			s.updateArc();
			s.draw(g);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		recursiveTiles(n,g,limit);
		g.setColor(c);
		g.drawRect(x, y, rectWide, rectHight);
		g.drawArc(arcX, arcY, arcWide, arcHight, angle, arcAngle);
		
		
	}
	
}
