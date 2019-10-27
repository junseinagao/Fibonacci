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
		Shape s = new FibonacciSquare(500,300,Color.BLUE,3,10);
		model.addShape(s);
		model.addView(panel);
	}
	
	
	
	
}
