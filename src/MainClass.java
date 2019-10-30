import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			buildGUI();
		});
	}

	private static void buildGUI() {
		JFrame frame = new JFrame();
		frame.setSize(1024, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingView panel = new DrawingView();
		frame.add(panel);

		frame.setVisible(true);

		DrawingModel model = new DrawingModel();
		
		// draw Fibonacci Squares.
		Shape f1 = new FibonacciSquare(10,50,Color.BLUE,1,1);
		Shape f2 = new FibonacciSquare(10,100,Color.GREEN,2,1);
		Shape f3 = new FibonacciSquare(10,150,Color.RED,3,1);
		Shape f4 = new FibonacciSquare(10,200,Color.BLACK,4,1);
		model.addShape(f1);
		model.addShape(f2);
		model.addShape(f3);
		model.addShape(f4);
		
		// draw HShapes
		Shape h1 = new HShape(100,500,Color.DARK_GRAY,10);
		Shape h2 = new HShape(175,500,Color.LIGHT_GRAY,20);
		Shape h3 = new HShape(300,500,Color.PINK,30);
		Shape h4 = new HShape(450,500,Color.YELLOW,40);
		model.addShape(h1);
		model.addShape(h2);
		model.addShape(h3);
		model.addShape(h4);
		
		model.addView(panel);
	}
}
