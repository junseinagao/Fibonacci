import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			buildFibonacciGUI();
			buildHShapeGUI();
		});
	}

	private static void buildFibonacciGUI() {
		JFrame frame = new JFrame();
		frame.setSize(1024, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingView panel = new DrawingView();
		frame.add(panel);

		frame.setVisible(true);

		DrawingModel model = new DrawingModel();
		Shape s = new FibonacciSquare(500,300,Color.BLUE,3,10);
		model.addShape(s);
		model.addView(panel);
	}
	
	private static void buildHShapeGUI() {
		JFrame frame = new JFrame();
		frame.setSize(1024, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingView panel = new DrawingView();
		frame.add(panel);

		frame.setVisible(true);

		DrawingModel model = new DrawingModel();
		Shape s = new HShape(0,0,Color.GREEN,500);
		model.addShape(s);
		model.addView(panel);
	}
}
