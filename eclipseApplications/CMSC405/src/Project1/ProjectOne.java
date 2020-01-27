package Project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Filename:    ProjectOne.Java
 * Author:      Sean Hamilton
 * Date:        01/24/2020
 * Purpose of program: This class holds all the logic for translating, rotating, scaling images, and displaying the transformations in sequence. Hold the constructor that creates JFrame to display the animations and 
 * holds the main method. Satisfies all requirements per project document. 
 * 
 */

public class ProjectOne extends JPanel {
	// A counter that increases by one in each frame.
    private int frameNumber;
    // The time, in milliseconds, since the animation started.
    private long elapsedTimeMillis;
    // This is the measure of a pixel in the coordinate system
    // set up by calling the applyLimits method.  It can be used
    // for setting line widths, for example.
    private float pixelSize;

    static int translateX = 0;
    static int translateY = 0;
    static double rotation = 0.0;
    static double scaleX = 1.0;
    static double scaleY = 1.0;
    private ImageTemplate images = new ImageTemplate();
    private BufferedImage greenX = images.getImage(ImageTemplate.greenX);
    private BufferedImage letterI = images.getImage(ImageTemplate.letterI);
    private BufferedImage blueRectangle = images.getImage(ImageTemplate.blueRectangle);
    
    
    public static void main(String[] args) {
    	// TODO code application logic here
        JFrame window;
        window = new JFrame("Project 1 - Java 2D Graphics");  // The parameter shows in the window title bar.
        final ProjectOne panel = new ProjectOne(); // The drawing area.
        window.setContentPane(panel); // Show the panel in the window.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End program when window closes.
        window.pack();  // Set window size based on the preferred sizes of its contents.
        window.setResizable(false); // Don't let user resize window.
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( // Center window on screen.
                (screen.width - window.getWidth()) / 2,
                (screen.height - window.getHeight()) / 2);
        Timer animationTimer;  // A Timer that will emit events to drive the animation.
        final long startTime = System.currentTimeMillis();
        animationTimer = new Timer(1600, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (panel.frameNumber > 6) {
                    panel.frameNumber = 0;
                } else {
                    panel.frameNumber++;
                }
                panel.elapsedTimeMillis = System.currentTimeMillis() - startTime;
                panel.repaint();
            }
        });
        window.setVisible(true); // Open the window, making it visible on the screen.
        animationTimer.start();  // Start the animation running.
	}
    public ProjectOne() {
        // Size of Frame
        setPreferredSize(new Dimension(800, 600));
    }
    
    public void paintComponent(Graphics g) {
    	
    	/* First, create a Graphics2D drawing context for drawing on the panel.
         * (g.create() makes a copy of g, which will draw to the same place as g,
         * but changes to the returned copy will not affect the original.)
         */

        Graphics2D g2 = (Graphics2D) g.create(); // Creates Graphics2D object

        /* Turn on antialiasing in this graphics context, for better drawing.
         */
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* Fill in the entire drawing area with white.
         */
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // View
        applyWindowToViewportTransformation(g2, -75, 75, -75, 75, true);
        AffineTransform savedTransform = g2.getTransform();

        // transformations switch 
        switch (frameNumber) {
          case 0: // Resets all transformations
            translateX = 0;
            translateY = 0;
            scaleX = 1.0;
            scaleY = 1.0;
            rotation = 0;
            break;
          case 1: // Translates -5 in X 
            translateX += -5;
            break;
          case 2: // Translates +7 in Y 
            translateY += 7;
            break;
          case 3: // Rotates 45 degrees counter-clockwise
            rotation += 45 * Math.PI / 180.0;
            break;
          case 4: // Rotates 90 degrees clockwise
            rotation += -90 * Math.PI / 180.0;
            break;
          case 5: // Scale 2 times for X 
            scaleX = 2.0;
            break;
          case 6: // Scales 0.5 times for Y 
            scaleY = 0.5;
            break;
        }

        // greenX Image
        g2.translate(translateX, translateY); // Moves image
        g2.rotate(rotation); // Rotates image
        g2.scale(scaleX, scaleY); // Scales image
        g2.drawImage(greenX, 0, 0, this); // Draw image
        g2.setTransform(savedTransform);

        // letterI Image
        g2.translate(translateX, translateY); // Moves image
        g2.translate(-50, -25); // to offset image
        g2.rotate(rotation); // Rotates image
        g2.scale(scaleX, scaleY); // Scales image
        g2.drawImage(letterI, 0, 0, this); // Draw image
        g2.setTransform(savedTransform);

        // blueRectangle Image
        g2.translate(translateX, translateY); // Moves image
        g2.translate(50, 25); // to offset image
        g2.rotate(rotation); // Rotates image
        g2.scale(scaleX, scaleY); // Scales image
        g2.drawImage(blueRectangle, 0, 0, this); // Draw image
        g2.setTransform(savedTransform);
      }
    // Method taken directly from AnimationStarter.java Code
    private void applyWindowToViewportTransformation(
    	      Graphics2D g2, double left, double right, double bottom, double top, boolean preserveAspect) {

    	    int width = getWidth(); // The width of this drawing area, in pixels
    	    int height = getHeight(); // The height of this drawing area, in pixels

    	    if (preserveAspect) {

    	      // Adjust the limits to match the aspect ratio of the drawing area
    	      double displayAspect = Math.abs((double) height / width);
    	      double requestedAspect = Math.abs((bottom - top) / (right - left));
    	      if (displayAspect > requestedAspect) {
    	        // Expand the viewport vertically
    	        double excess = (bottom - top) * (displayAspect / requestedAspect - 1);
    	        bottom += excess / 2;
    	        top -= excess / 2;
    	      } else if (displayAspect < requestedAspect) {
    	        // Expand the viewport horizontally
    	        double excess = (right - left) * (requestedAspect / displayAspect - 1);
    	        right += excess / 2;
    	        left -= excess / 2;
    	      }
    	    }

    	    g2.scale(width / (right - left), height / (bottom - top));
    	    g2.translate(-left, -top);
    	  }
    
}
