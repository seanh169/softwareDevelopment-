package SeanHamiltonProjectTwo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
				//Circle logic and drawing
				else if(circleButton.isSelected()) {
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
				//Square logic and drawing
				else if(squareButton.isSelected()) {
					JPanel squarePanel = new JPanel();
					JTextField squareSideLength = new JTextField(5);
					squarePanel.add(new JLabel("Length of side: "));
					squarePanel.add(squareSideLength);
					double getSquareDimen = JOptionPane.showConfirmDialog(null, squarePanel, "Please Enter the radius", JOptionPane.OK_CANCEL_OPTION);
					if (getSquareDimen == JOptionPane.OK_OPTION) {
						try {
							Double.parseDouble(squareSideLength.getText());
							JPanel squareResultPanel = new JPanel();
							Square squareAreaOutput = new Square(Double.parseDouble(squareSideLength.getText()));
							JLabel squareAreaOutputText = new JLabel("Area of Square: " + squareAreaOutput.area);
							RectDraw newDrawSqaure = new RectDraw(Double.parseDouble(squareSideLength.getText()), Double.parseDouble(squareSideLength.getText()));
							squareResultPanel.add(newDrawSqaure);
							JOptionPane.showConfirmDialog(null, squareResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(squarePanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				//Triangle logic and drawing
				else if(triangleButton.isSelected()) {
					JPanel trianglePanel = new JPanel();
					JTextField triangleBase = new JTextField(5);
					JTextField triangleHeight = new JTextField(5);
					trianglePanel.add(new JLabel("Base: "));
					trianglePanel.add(triangleBase);
					trianglePanel.add(new JLabel("Height: "));
					trianglePanel.add(triangleHeight);
					double getTriangleDim = JOptionPane.showConfirmDialog(null, trianglePanel, "Please Enter the base and height", JOptionPane.OK_CANCEL_OPTION);
					if (getTriangleDim == JOptionPane.OK_OPTION) {
						try {
							double triangleInputBase = Double.parseDouble(triangleBase.getText());
							double triangleInputHeight = Double.parseDouble(triangleHeight.getText());
							JPanel triangleResultPanel = new JPanel();
							Triangle outputTriangle = new Triangle(triangleInputBase, triangleInputHeight);
							JLabel triangleOutputArea = new JLabel("Area of Triangle: " + outputTriangle.area);
							triangleResultPanel.add(triangleOutputArea);
							TriangleDraw newTriangle = new TriangleDraw(triangleInputBase, triangleInputHeight);
							triangleResultPanel.add(newTriangle);
							JOptionPane.showConfirmDialog(null, triangleResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
							
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(trianglePanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
				//Sphere logic and drawing
				else if(sphereButton.isSelected()) {
					JPanel spherePanel = new JPanel();
					JTextField sphereRadius = new JTextField(5);
					spherePanel.add(new JLabel("radius: "));
					spherePanel.add(sphereRadius);
					double getSphereDimen = JOptionPane.showConfirmDialog(null, spherePanel, "Please Enter the radius", JOptionPane.OK_CANCEL_OPTION);
					if (getSphereDimen == JOptionPane.OK_OPTION) {
						try {
							double sphereRadiusInput = Double.parseDouble(sphereRadius.getText());
							JPanel sphereResultPanel = new JPanel();
							Sphere outputSphere = new Sphere(sphereRadiusInput);
							JLabel sphereOutputVolume = new JLabel("Volume of Sphere: " + outputSphere.volume);
							sphereResultPanel.add(sphereOutputVolume);
							SphereDraw newSphere = new SphereDraw();
							sphereResultPanel.add(newSphere);
							JOptionPane.showConfirmDialog(null, sphereResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
							
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(spherePanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
				//Cube logic and drawing
				else if(cubeButton.isSelected()) {
					JPanel cubePanel = new JPanel();
					JTextField cubeEdge = new JTextField(5);
					cubePanel.add(new JLabel("Edge: "));
					cubePanel.add(cubeEdge);
					double getCubeDimen = JOptionPane.showConfirmDialog(null, cubePanel, "Please Enter the edge", JOptionPane.OK_CANCEL_OPTION);
					if (getCubeDimen == JOptionPane.OK_OPTION) {
						try {
							double cubeEdgeInput = Double.parseDouble(cubeEdge.getText());
							JPanel cubeResultPanel = new JPanel();
							Cube outputCube = new Cube(cubeEdgeInput);
							JLabel cubeOutputVolume = new JLabel("Volume of Cube: " + outputCube.volume);
							cubeResultPanel.add(cubeOutputVolume);
							CubeDraw newCube = new CubeDraw();
							cubeResultPanel.add(newCube);
							JOptionPane.showConfirmDialog(null, cubeResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(cubePanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				//Cone logic and drawing
				else if (coneButton.isSelected()) {
					JPanel conePanel = new JPanel();
					JTextField coneRadius = new JTextField(5);
					JTextField coneHeight = new JTextField(5);
					conePanel.add(new JLabel("Radius: "));
					conePanel.add(coneRadius);
					conePanel.add(new JLabel("Height: "));
					conePanel.add(coneHeight);
					double getConeDimen = JOptionPane.showConfirmDialog(null, conePanel, "Please Enter the Radius and Height", JOptionPane.OK_CANCEL_OPTION);
					if(getConeDimen == JOptionPane.OK_OPTION) {
						try {
							double coneInputRadius = Double.parseDouble(coneRadius.getText());
							double coneInputHeight = Double.parseDouble(coneHeight.getText());
							JPanel coneResultPanel = new JPanel();
							Cone newCone = new Cone(coneInputRadius, coneInputHeight);
							JLabel coneOutputVolume = new JLabel("Volume of Cone: " + newCone.volume);
							coneResultPanel.add(coneOutputVolume);
							ConeDraw newConeDraw = new ConeDraw();
							coneResultPanel.add(newConeDraw);
							JOptionPane.showConfirmDialog(null, coneResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(conePanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				//cylinder logic and drawing
				else if (cylinderButton.isSelected()) {
					JPanel cylinderPanel = new JPanel();
					JTextField cylinderRadius = new JTextField(5);
					JTextField cylinderHeight = new JTextField(5);
					cylinderPanel.add(new JLabel("Radius: "));
					cylinderPanel.add(cylinderRadius);
					cylinderPanel.add(new JLabel("Height: "));
					cylinderPanel.add(cylinderHeight);
					double getCylinderDimen = JOptionPane.showConfirmDialog(null, cylinderPanel, "Please Enter the Radius and Height", JOptionPane.OK_CANCEL_OPTION);
					if(getCylinderDimen == JOptionPane.OK_OPTION) {
						try {
							double cylinderInputRadius = Double.parseDouble(cylinderRadius.getText());
							double cylinderInputHeight = Double.parseDouble(cylinderHeight.getText());
							JPanel cylinderResultPanel = new JPanel();
							Cylinder outputCylinder = new Cylinder(cylinderInputRadius, cylinderInputHeight);
							JLabel cylinderOutputVolume = new JLabel("Volume of Cylinder: " + outputCylinder.volume);
							cylinderResultPanel.add(cylinderOutputVolume);
							CylinderDraw newCyl = new CylinderDraw();
							cylinderResultPanel.add(newCyl);
							JOptionPane.showConfirmDialog(null, cylinderResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(cylinderPanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				//torus logic and drawing
				else if(torusButton.isSelected()) {
					JPanel torusPanel = new JPanel();
					JTextField majorRadius = new JTextField(5);
					JTextField minorRadius = new JTextField(5);
					torusPanel.add(new JLabel("Major Radius: "));
					torusPanel.add(majorRadius);
					torusPanel.add(new JLabel("Minor Radius: "));
					torusPanel.add(minorRadius);
					double getTorusDimen = JOptionPane.showConfirmDialog(null, torusPanel, "Please Enter the Radius and Height", JOptionPane.OK_CANCEL_OPTION);
					if(getTorusDimen == JOptionPane.OK_OPTION) {
						try {
							double torusMajorRadius = Double.parseDouble(majorRadius.getText());
							double torusMinorRadius = Double.parseDouble(minorRadius.getText());
							JPanel torusResultPanel = new JPanel();
							Torus outputTor = new Torus(torusMajorRadius, torusMinorRadius);
							JLabel torusOutputVolume = new JLabel("Volume of Torus: " + outputTor.volume);
							torusResultPanel.add(torusOutputVolume);
							TorusDraw newTor = new TorusDraw();
							torusResultPanel.add(newTor);
							JOptionPane.showConfirmDialog(null, torusResultPanel,"Result", JOptionPane.OK_CANCEL_OPTION);
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(torusPanel, "Must be an valid number/decimal.","Inane Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				//error handling if calculate button is clicked without any selection
				else {
					
						JPanel errorPanel = new JPanel();
						JOptionPane.showMessageDialog(errorPanel, "Please select a shape","Inane Warning", JOptionPane.WARNING_MESSAGE);				
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
	
	
	
	//private class for rectangle/square drawing.
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
			super.paintComponent(g);
			g.drawOval(100, 100, radi, radi);
	        g.setColor(Color.GREEN);
	        g.fillOval(100, 100, radi, radi);
	    }
		
	}
	//private class for Triangle draw.
	private static class TriangleDraw extends JPanel {
		
		private int base = 0;
		private int height = 0;
		
		public TriangleDraw(double base, double height) {
			setPreferredSize( new Dimension(400, 400) );
			this.base = (int) base * 3;
			this.height = (int) height * 3;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawPolygon(new int[] {base, base * 2, base * 3}, new int[] {height, height / 2, height}, 3);
	    }
		
	}
	//Sphere drawing
	private static class SphereDraw extends JPanel{
		private BufferedImage image;
		private Image scaledImage;
		String home = System.getProperty("user.home");
		public SphereDraw() {
			setPreferredSize( new Dimension(300, 300) );
			try {
				image = ImageIO.read(new File(home + File.separator + "Desktop" + File.separator + "sphere.gif"));
				
			}catch(IOException ex) {
				System.out.println(ex);
			}
		}
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
	    }
		
	}
	//Cube drawing
	private static class CubeDraw extends JPanel{
		private BufferedImage image;
		private Image scaledImage;
		String home = System.getProperty("user.home");
		public CubeDraw() {
			setPreferredSize( new Dimension(300, 300) );
			try {
				image = ImageIO.read(new File(home + File.separator + "Desktop" + File.separator + "cube.png"));
				
			}catch(IOException ex) {
				System.out.println(ex);
			}
		}
		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
	    }
		
	}
		//Cone drawing
		private static class ConeDraw extends JPanel{
			private BufferedImage image;
			private Image scaledImage;
			String home = System.getProperty("user.home");
			public ConeDraw() {
				setPreferredSize( new Dimension(300, 300) );
				try {
					image = ImageIO.read(new File(home + File.separator + "Desktop" + File.separator + "cone.png"));
					
				}catch(IOException ex) {
					System.out.println(ex);
				}
			}
			@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
		    }
			
		}
		//Cylinder drawing
		private static class CylinderDraw extends JPanel{
			private BufferedImage image;
			private Image scaledImage;
			String home = System.getProperty("user.home");
			public CylinderDraw() {
				setPreferredSize( new Dimension(300, 300) );
				try {
					image = ImageIO.read(new File(home + File.separator + "Desktop" + File.separator + "cylinder.png"));
					
				}catch(IOException ex) {
					System.out.println(ex);
				}
			}
			@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
		    }
			
		}
		//Torus drawing
		private static class TorusDraw extends JPanel{
			private BufferedImage image;
			private Image scaledImage;
			String home = System.getProperty("user.home");
			public TorusDraw() {
				setPreferredSize( new Dimension(300, 300) );
				try {
					image = ImageIO.read(new File(home + File.separator + "Desktop" + File.separator + "torus.png"));
					
				}catch(IOException ex) {
					System.out.println(ex);
				}
			}
			@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
		    }
			
		}
		//main
		public static void main(String[] args) {
			ProjectTwoGUI p2 = new ProjectTwoGUI();
			p2.display();
		}
}
