import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class Grapher extends JFrame {
	public JPanel panel1 = new JPanel();
	ArrayList<Double> v1, v2;

	public Grapher(ArrayList v1, ArrayList v2) {
		this.v1 = v1;
		this.v2 = v2;
		panel1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				int x = (int) b.getX();
				int y = (int) b.getY();

				System.out.println("Entered x: " + x);
				System.out.println("Entered y: " + y);
			
				/*
				 * ToDO: Gather the x and y coordinates and create a new
				 * equation with x and y. Solve for the constant and somehow
				 * repaint.
				 */

			}
		});
	}

	public class paintage extends JPanel {

		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			ArrayList<Color> colors = new ArrayList<>();
			colors.add(Color.red);
			colors.add(Color.blue);
			colors.add(Color.green);
			colors.add(Color.orange);
			colors.add(Color.yellow);
			colors.add(Color.magenta);
			Random r = new Random();
			g2d.setColor(Color.white);
			Shape yAxis = new Line2D.Double(950, 1920, 950, 0);
			Shape xAxis = new Line2D.Double(0, 540, 1920, 540);
			g2d.draw(yAxis);
			g2d.draw(xAxis);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			double inc = -2;
			for (int x = 0; x < 200; x++) {
				g2d.setColor(colors.get(r.nextInt(6)));
				double y = v1.get(x);
				Shape l = new Ellipse2D.Double(0 + inc, 540 - y, 10, 10);
				g2d.fill(l);
				inc = inc + 5;
			}
			/*
			 * For the second test equation Plot it
			 */
			inc = -2;
			for (int x = 0; x < 200; x++) {
				g2d.setColor(colors.get(r.nextInt(6)));
				double y = v2.get(x);
				System.out.println(y);
				Shape l = new Ellipse2D.Double(0 + inc, 540 - Math.abs(y), 10,
						10);
				g2d.fill(l);
				inc = inc + 5;
			}
		}
	}

	public void init() {

		paintage p = new paintage();
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Grapher");

		// Labels x and y axis
		JLabel xL = new JLabel();
		JLabel yL = new JLabel();
		yL.setText("Y");
		xL.setText("X");
		// panel.add(xL);
		// panel.add(yL);
		yL.setLocation(930, 0);
		yL.setSize(50, 50);
		yL.setForeground(Color.white);
		yL.setBackground(Color.black);
		xL.setLocation(1900, 540);
		xL.setSize(50, 50);
		xL.setForeground(Color.white);
		xL.setBackground(Color.black);

		JScrollPane pane = new JScrollPane(panel1);

		// frame.setContentPane(pane);

		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1920, 1080);
		panel1.setSize(1900, 1000);
		panel1.setOpaque(false);
		panel1.setBackground(Color.black);
		panel1.setForeground(Color.black);
		frame.add(panel1);
		frame.add(panel);
		frame.add(xL);
		frame.add(yL);
		frame.add(p);
		// frame.add(pane);
		// pane.setOpaque(true);

	}
}
