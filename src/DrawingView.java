import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class DrawingView extends JPanel implements View {
	private DrawingModel model;

	public DrawingView() {
		setBackground(Color.WHITE);
	}

	@Override
	public void update(DrawingModel model) {
		this.model = model;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (model != null) {
			List<Shape> shapes = model.getShapes();
			for (Shape sh : shapes) {
				sh.draw(g);
			}
		}
	}

}
