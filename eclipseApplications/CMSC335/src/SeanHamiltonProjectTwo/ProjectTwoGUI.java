package SeanHamiltonProjectTwo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProjectTwoGUI extends JFrame {
	
	
	//Height and Width of JFrame
	static final int WIDTH = 600, HEIGHT = 600;
	
	//Buttons and labels per requirements
	JLabel selectShape = new JLabel("Select Shape: ");
	JRadioButton circleButton = new JRadioButton("Circle");
	JRadioButton squareButton = new JRadioButton("Square");
	JRadioButton triangleButton = new JRadioButton("Triangle");
	JRadioButton rectangleButton = new JRadioButton("Rectangle");
	JRadioButton sphereButton = new JRadioButton("Sphere");
	JRadioButton cubeButton = new JRadioButton("Cube");
	JRadioButton coneButton = new JRadioButton("Cone");
	JRadioButton cylinderButton = new JRadioButton("Cylinder");
	JRadioButton torusButton = new JRadioButton("Torus");
	JButton calculateAreaVol = new JButton("Calculate Area/Vol");
	JButton exitProgram = new JButton("Exit");
	ButtonGroup bg = new ButtonGroup();
	
	
	public ProjectTwoGUI() {
		super("Project 2");
		setFrame(WIDTH, HEIGHT);
		bg.add(circleButton);
		bg.add(squareButton);
		bg.add(triangleButton);
		bg.add(rectangleButton);
		bg.add(sphereButton);
		bg.add(cubeButton);
		bg.add(coneButton);
		bg.add(cylinderButton);
		bg.add(torusButton);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,1));
		panel.add(selectShape);
		panel.add(circleButton);
		panel.add(squareButton);
		panel.add(triangleButton);
		panel.add(rectangleButton);
		panel.add(sphereButton);
		panel.add(cubeButton);
		panel.add(coneButton);
		panel.add(cylinderButton);
		panel.add(torusButton);
		panel.add(calculateAreaVol);
		calculateAreaVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				//Rectangle logic and drawing
				if(rectangleButton.isSelected()) {
					
					JPanel rectPanel = new JPanel();
					JTextField widthField = new JTextField(5);
					JTextField lengthField = new JTextField(5);
					rectPanel.add(new JLabel("width: "));
					rectPanel.add(widthField);
					rectPanel.add(new JLabel("length: "));
					rectPanel.add(lengthField);
					double getRectDimen = JOptionPane.showConfirmDialog(null, rectPanel, "Please Enter the width and height", JOptionPane.OK_CANCEL_OPTION);
					if (getRectDimen == JOptionPane.OK_OPTION) {
						try {
							Double.parseDouble(lengthField.getText());
							Double.parseDouble(widthField.getText());
							JPanel rectResultPanel = new JPanel();
							Rectangle outputRect = new Rectangle(Double.parseDouble(lengthField.getText()), Double.parseDouble(widthField.getText()));
							JLabel rectAreaOutput = new JLabel("Area of Rectangle: " + outputRect.area);
							rectResultPanel.add(rectAreaOutput);
							RectDraw newDraw = new RectDraw(Double.parseDouble(lengthField.getText()), Double.parseDouble(widthField.getText()));
							rectResultPanel.add(newDraw);
							JOptionPane.showConfirmDialog(null, rectResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(rectPanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
				      }
					
					}
				if(circleButton.isSelected()) {
					JPanel circlePanel = new JPanel();
					JTextField circleRadius = new JTextField(5);
					circlePanel.add(new JLabel("radius: "));
					circlePanel.add(circleRadius);
					double getCircleDimen = JOptionPane.showConfirmDialog(null, circlePanel, "Please Enter the radius", JOptionPane.OK_CANCEL_OPTION);
					if (getCircleDimen == JOptionPane.OK_OPTION) {
						try {
							Double.parseDouble(circleRadius.getText());
							JPanel circleResultPanel = new JPanel();
							Circle outputCircle = new Circle(Double.parseDouble(circleRadius.getText()));
							JLabel circleAreaOutput = new JLabel("Area of Circle: " + outputCircle.area);
							circleResultPanel.add(circleAreaOutput);
							CircleDraw newCir = new CircleDraw(Double.parseDouble(circleRadius.getText()));
							circleResultPanel.add(newCir);
							JOptionPane.showConfirmDialog(null, circleResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(circlePanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					}
				}
			}
		});
		panel.add(exitProgram);
		exitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);
			}
		});
		add(panel);
		
	}
	
	public void display() {
	      setVisible(true);
	}
	
	private void setFrame(int width, int height) {
	      setSize(width, height);     
	      setLocationRelativeTo(null);  		
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args) {
		ProjectTwoGUI p2 = new ProjectTwoGUI();
		p2.display();
	}
	
	//private class for rectangle drawing.
	private static class RectDraw extends JPanel {
		 private int RECT_WIDTH = 100;
		 private int RECT_HEIGHT = RECT_WIDTH;
		 private int RECT_X = 10;
		 private int RECT_Y = RECT_X;
			public RectDraw(double length, double height) {
				this.RECT_WIDTH = (int) length;
				this.RECT_HEIGHT = (int) height;
				
			}
		   protected void paintComponent(Graphics g) {
		     super.paintComponent(g);  
		     g.drawRect(RECT_X,RECT_Y,RECT_HEIGHT,RECT_WIDTH);  
		     g.setColor(Color.RED);  
		     g.fillRect(RECT_X,RECT_Y,RECT_HEIGHT,RECT_WIDTH);  
		   }

		   public Dimension getPreferredSize() {
			   return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y); // appropriate constants
		   }
	}
	
	//private class for circle draw.
	private static class CircleDraw extends JPanel{
		
		private int radi = 0;
		
		public CircleDraw(double radius) {
			setPreferredSize( new Dimension(400, 400) );
			this.radi = (int) radius * 2;
		}
		public void paintComponent(Graphics g) {
//	        super.
			super.paintComponent(g);
//			setSize(500, 500);
//	        g.drawOval(0, 0, radi, radi);
			g.drawOval(100, 100, radi, radi);
	        g.setColor(Color.GREEN);
	        g.fillOval(100, 100, radi, radi);
	        
//	        g.fillOval(10, 10, radi, radi);
//			g.set
			
	    }
		
	}
	

}
