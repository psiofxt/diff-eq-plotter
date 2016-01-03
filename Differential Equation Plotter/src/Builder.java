import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Builder {

	private JFrame frame;
	private JPanel panel;
	private myCanvas can = new myCanvas();
	private ArrayList<Double> var = null;
	private ArrayList<Shape> theG = new ArrayList<>();;
	private int count = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Builder window = new Builder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Builder() {
		initialize();
	}

	public class myCanvas extends Canvas{
		
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			ArrayList<Color> colors = new ArrayList<>();
			colors.add(Color.red);
			colors.add(Color.blue);
			colors.add(Color.green);
			colors.add(Color.orange);
			colors.add(Color.yellow);
			colors.add(Color.magenta);
			colors.add(Color.cyan);
			colors.add(Color.pink);
			
			Random r = new Random();
			g2d.setColor(Color.white);
			Shape yAxis = new Line2D.Double(950, 1920, 950, 0);
			Shape xAxis = new Line2D.Double(0, 540, 1920, 540);
			g2d.draw(yAxis);
			g2d.draw(xAxis);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			
			if (var !=null){
				
				/*for (int s = count; s < theG.size(); s++){
					g2d.setColor(colors.get(r.nextInt(8)));
					g2d.fill(theG.get(s));
					count = count + 1;
				}*/

				for (Shape s : theG){
					g2d.setColor(colors.get(r.nextInt(8)));
					g2d.fill(s);
				}
			}
		}
	}
	
	private void initialize() {
		panel = new JPanel();
		frame = new JFrame();
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				double x = b.getX();
				double y = b.getY();
				System.out.println("Entered x: " + x);
				System.out.println("Entered y: " + y);
				
				if (x == 950){
					x = 0;
				}
				else if (x < 950) {
					x = (x / 950) - 1;
				}
				else if (x > 950) {
					x = (x / 950) - 1;
				}
				
				if (y == 563){
					y = 0;
				}
				else if (y < 563){
					y = 1 - (y / 563);
				}
				else if (y > 563){
					y = 1 - (y / 563);
				}
				
				System.out.println("NEW NEW NEW NEW x: " + x);
				System.out.println("NEW NEW NEW NEW y: " + y);
				
				double inc = -2;
				var = new ArrayList<Double>();
				for (int i = -200; i < 200; i++) {
					var.add(new Equation(x, y).setEquationReturn(inc));
					inc = inc + .01;
				}
				
				double paintInc = -2;
				for (int dx = 0; dx < 200; dx++){
					double dy = var.get(dx);
					theG.add(new Ellipse2D.Double(0 + paintInc, 540 - dy, 10, 10));
					paintInc = paintInc + 10;
				}
				
				
				/*This is to display the Y values for testing purposes
				Iterator<Double> it = var.iterator();
				while (it.hasNext()){
					System.out.println(it.next());
				}*/
				
				can.repaint();
				
			}
		});
		JLabel xL = new JLabel();
		JLabel yL = new JLabel();
		JTextArea a = new JTextArea();
		a.setLocation(540, 540);
		a.setText("FFFFFFFFFFFUCK");
		a.setBackground(Color.white);
		yL.setText("Y");
		xL.setText("X");
		yL.setLocation(930, 10);
		yL.setSize(10, 10);
		yL.setBackground(Color.black);
		xL.setLocation(1900, 550);
		xL.setSize(10, 10);
		xL.setBackground(Color.black);
		xL.setOpaque(true);
		yL.setOpaque(true);
		
		panel.setBackground(Color.darkGray);
		can.setBackground(Color.black);
		can.setForeground(Color.black);
		frame.getContentPane().add(can);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		frame.add(xL);
		frame.add(yL);
		frame.add(can);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
