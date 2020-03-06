package ProjectTwo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;


/**
 * Filename:    ProjectTwo.Java
 * Author:      Sean Hamilton
 * Date:        01/24/2020
 * Purpose of program: This class holds the GUI Constructor, methods to draw each of the six shapes and all required transformation methods. This project uses an external 
 * JOGL library and implements the GLEventListener interface. 
 * 
 */


@SuppressWarnings("serial")
public class ProjectTwo extends JPanel implements GLEventListener {
	
	//private iterator and timer variables.
	private Timer frameTimer;
	private int frameIterator; 
	
	
	//constructor
	public ProjectTwo() {
		
	GLCapabilities capabilities = new GLCapabilities(null);
	 
	//Meets requirement of 640 x 480 size.
	GLJPanel display = new GLJPanel(capabilities);
	display.setPreferredSize( new Dimension(640,480) );
	display.addGLEventListener(this);
	setLayout(new BorderLayout());
	add(display, BorderLayout.CENTER);
	  
	//Animation begins
	frameTimer = new Timer(20, new ActionListener() {
		
		public void actionPerformed(ActionEvent evt) {
		frameIterator++;
		display.repaint();
		}
	});
	frameTimer.start();
	
	}
	
	
	public void init(GLAutoDrawable drawable) {
	// called when the panel is created
	GL2 gl2 = drawable.getGL().getGL2();
	  
	gl2.glEnable(GL2.GL_DEPTH_TEST); 
	gl2.glLineWidth(2);
	gl2.glShadeModel(GL2.GL_SMOOTH);
	gl2.glEnable(GL2.GL_COLOR_MATERIAL);
	gl2.glClearColor(0.5f,0.5f,0.5f,1); 
	  
	// The next three lines set up the coordinates system.

	gl2.glMatrixMode(GL2.GL_PROJECTION);
	gl2.glLoadIdentity();
	gl2.glOrtho(-10, 10, -10, 10, -5, 5); 
	gl2.glMatrixMode(GL2.GL_MODELVIEW);
	  
	  
	gl2.glClearDepth(1.0f);
	gl2.glDepthFunc(GL2.GL_LEQUAL);
	gl2.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
	  
	//turn transparency on
	gl2.glEnable(GL2.GL_BLEND);
	gl2.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	  
	}
	
	@SuppressWarnings("static-access")
	public void display(GLAutoDrawable drawable) {
	GL2 gl2 = drawable.getGL().getGL2();
	 //buffer for 3D.
	gl2.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );
	  
	gl2.glLoadIdentity();
	  
	  
	  
	// Draw the 3D Triangle.
	gl2.glPushMatrix();
	gl2.glLineWidth(1);
	gl2.glTranslated(0,5.0,0);
	gl2.glRotated(60,1.0,-3,1);
	gl2.glScaled(3,3,3);
	gl2.glRotated(-frameIterator*0.9,1.2,0,0);
	draw3DTriangle(gl2);
	gl2.glPopMatrix();		
	
	//Draw the 3D Cube.
	
	  
	gl2.glPushMatrix();
	gl2.glLineWidth(2);
	gl2.glTranslated(-8.0,7.0,0);
	gl2.glRotated(60,1.9,2.5,-3.5);
	gl2.glScaled(2.5,2.5,2.5);
	gl2.glRotated(frameIterator*0.9,0,1,1);
	draw3DCube(gl2);
	gl2.glPopMatrix();
	  
	
	// Draw the 3D Cylinder.
	gl2.glPushMatrix();
	gl2.glTranslated(2*Math.cos(.015*frameIterator) + 0, 2*Math.sin(.015*frameIterator) + 0, 0.0);
	gl2.glTranslated(5.0,3.0,0);
	gl2.glRotated(90,2.0,-2.5,3.5);
	gl2.glScaled(2.0,2.0,2.0);
	gl2.glRotated(-frameIterator*0.0,0,1,1);
	draw3DCylinder(gl2,0.5,1,32,10,5);
	gl2.glPopMatrix();
	 
	  
	// Draw the 3D Icosahedron.
	gl2.glPushMatrix();
	gl2.glLineWidth(1);
	gl2.glTranslated(-5.0,-3.0,0);
	gl2.glRotated(20,2.0,-2.5,3.5);
	gl2.glScaled(.99*(frameIterator % 250) /250,.99*(frameIterator % 250) / 250,.99*(frameIterator % 250) / 250);
	gl2.glRotated(-frameIterator*0.9,1,1,0);
	draw3DIcosah(gl2);
	gl2.glPopMatrix();
	  
	  
	// Draw the 3D tetrahedron.
	gl2.glPushMatrix();
	gl2.glLineWidth(2);
	gl2.glTranslated(0.0,-5.0,0);
	gl2.glRotated(30,1.5,-2,3);
	gl2.glScaled(1.1,1.1,1.1);
	gl2.glRotated(-frameIterator*0.9,1,0,0);
	
	draw3DTetrah(gl2);
	gl2.glPopMatrix();
	  
	// Draw the 3D Deformed Diamond.
	gl2.glPushMatrix();
	gl2.glLineWidth(2);
	gl2.glTranslated(6.0,-5.0,0);
	gl2.glRotated(35,1.5,-2,3);
	gl2.glScaled(.35,.35,.35);
	gl2.glRotated(-frameIterator*0.9,0,1,0);
	draw3DDiamond(gl2);
	gl2.glPopMatrix();
	}
	  
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height){}
	  
	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
	  
	public void dispose(GLAutoDrawable arg0) {}
	
	//Creates a 3D Triangle.
	public static void draw3DTriangle(GL2 gl2) {

	gl2.glBegin(GL2.GL_LINE_LOOP);

	//Front side
	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( 0f, 1.5f, 0.0f ); 

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( -.5f, -.5f, .5f ); 

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( .5f, -.5f, .5f ); 

	//Right side
	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( 0f, 1.5f, 0.0f ); 

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( .5f, -.5f, .5f ); 

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( .5f, -.5f, -.5f ); 

	//Back side
	gl2.glColor3f( 1.0f, 0.0f, 0.0f );
	gl2.glVertex3f( 0f, 1.5f, 0.0f ); 

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( .5f, -.5f, -.5f );

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( -.5f, -.5f, -.5f ); 

	//Left side
	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( 0f, 1.5f, 0.0f ); 

	gl2.glColor3f( 1.0f, 0.0f, 0.0f); 
	gl2.glVertex3f( -.5f, -.5f, -.5f );

	gl2.glColor3f( 1.0f, 0.0f, 0.0f ); 
	gl2.glVertex3f( -.5f, -.5f, .5f ); 

	gl2.glEnd(); 
	gl2.glFlush();
	}
	
	//Creates a drwSquare.

	public static void drwSquare(GL2 gl2) {
	gl2.glBegin(GL2.GL_TRIANGLE_FAN);
	gl2.glColor3f(0.0f, 0.0f, 1.0f ); // Blue
	gl2.glVertex3d(-0.5, -0.5, 0.5); // Bottom left corner

	gl2.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	gl2.glVertex3d(0.5, -0.5, 0.5); // Bottom right corner

	gl2.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	gl2.glVertex3d(0.5, 0.5, 0.5); //Top right corner

	gl2.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	gl2.glVertex3d(-0.5, 0.5, 0.5); //Top left corner
	gl2.glEnd();


	gl2.glColor3d(0,0,0); //black
	gl2.glBegin(GL2.GL_LINE_LOOP);
	gl2.glVertex3d(-0.5, -0.5, 0.5);
	gl2.glVertex3d(0.5, -0.5, 0.5);
	gl2.glVertex3d(0.5, 0.5, 0.5);
	gl2.glVertex3d(-0.5, 0.5, 0.5);
	gl2.glEnd();
	}
	
	//Creates a 3D cube.

	public static void draw3DCube(GL2 gl2) {
	gl2.glPushMatrix();
	drwSquare(gl2); //Front face
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(90, 0, 1, 0);
	drwSquare(gl2);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(-90, 1, 0, 0); 
	drwSquare(gl2);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(180, 0, 1, 0); 
	drwSquare(gl2);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(-90, 0, 1, 0); 
	drwSquare(gl2);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(90, 1, 0, 0); 
	drwSquare(gl2);
	gl2.glPopMatrix();
	gl2.glFlush();
	}
	
	//Creates a transparent 3D cylinder.
	public static void draw3DCylinder(GL2 gl2, double radius, double height, int slices, int stacks, int rings) {
	for (int j = 0; j < stacks; j++) {
	double z1 = (height/stacks) * j;
	double z2 = (height/stacks) * (j+1);
	gl2.glBegin(GL2.GL_QUAD_STRIP);
	for (int i = 0; i <= slices; i++) {
	double longitude = (2*Math.PI/slices) * i;
	double sinLong = Math.sin(longitude);
	double cosLong = Math.cos(longitude);
	double x = cosLong;
	double y = sinLong;
	gl2.glNormal3d(x,y,0);

	gl2.glColor4f( 0.0f, 1.0f, 0.0f, 0.5f ); 
	gl2.glVertex3d(radius*x,radius*y,z2);
	gl2.glVertex3d(radius*x,radius*y,z1);
	}
	gl2.glEnd();
	}
	if (rings > 0){ 
	gl2.glNormal3d(0,0,1);
	for (int j = 0; j < rings; j++) {
	double d1 = (1.0/rings) * j;
	double d2 = (1.0/rings) * (j+1);
	gl2.glBegin(GL2.GL_QUAD_STRIP);
	for (int i = 0; i <= slices; i++) {
	double angle = (2*Math.PI/slices) * i;
	double sin = Math.sin(angle);
	double cos = Math.cos(angle);
	gl2.glColor3f( 0.0f, 1.0f, 0.0f ); // Blue
	gl2.glVertex3d(radius*cos*d1,radius*sin*d1,height);
	gl2.glColor3f( 0.0f, 1.0f, 0.0f ); // Blue
	gl2.glVertex3d(radius*cos*d2,radius*sin*d2,height);
	}
	gl2.glEnd();
	}

	gl2.glNormal3d(0,0,-1);
	for (int j = 0; j < rings; j++) {
	double d1 = (1.0/rings) * j;
	double d2 = (1.0/rings) * (j+1);
	gl2.glBegin(GL2.GL_QUAD_STRIP);
	for (int i = 0; i <= slices; i++) {
	double angle = (2*Math.PI/slices) * i;
	double sin = Math.sin(angle);
	double cos = Math.cos(angle);

	gl2.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	gl2.glVertex3d(radius*cos*d2,radius*sin*d2,0);

	gl2.glColor3f( 0.0f, 1.0f, 0.0f ); // Green

	gl2.glVertex3d(radius*cos*d1,radius*sin*d1,0);
	}
	gl2.glEnd();
	}
	}

	gl2.glFlush();
	}
	
	//Creates 3D Tetrahedron.
	public static void draw3DTetrah(GL2 gl2) {
		
	double[][] vertices = new double[][] {
	{1, -1, -1},
	{-1, -1, 1},
	{-1, 1, -1},
	{1, 1, 1}
	};

	int[][] faces = new int[][] {
	{0, 3, 2},
	{3, 0, 1},
	{0, 2, 1},
	{2, 3, 1}
	};

	double[][] faceColors = new double[][] {
		
	//All Yellow
	{1, 1, 0}, 
	{1, 1, 0}, 
	{1, 1, 0}, 
	{1, 1, 0} 
	};

	gl2.glPushMatrix();


	for (int i = 0; i < faces.length; i++) {
	gl2.glColor3dv(faceColors[i], 0 );

	gl2.glBegin(GL2.GL_TRIANGLE_FAN);
	for (int j = 0; j < faces[i].length; j++) {
	int vertexNum = faces[i][j];
	gl2.glVertex3dv( vertices[vertexNum], 0 );
	}
	gl2.glEnd();
	}

	gl2.glColor3f(0,0,0);
	for (int i = 0; i < faces.length; i++) {
	gl2.glBegin(GL2.GL_LINE_LOOP);
	for (int j = 0; j < faces[i].length; j++) {
	int vertexNum = faces[i][j];
	gl2.glVertex3dv( vertices[vertexNum], 0 );
	}
	gl2.glEnd();
	}
	gl2.glPopMatrix();
	gl2.glFlush();
	}
	
	//Creates a transparent 3D Icosahedron.
	public static void draw3DIcosah(GL2 gl2) {
	double[][] vertices = new double[][]{


	{-1, -0.918034, 0},
	{0, 1, 0.918034},
	{0, 1, -0.918034},
	{1, 0.918034, 0},
	{1, -0.918034, 0},
	{0, -1, -0.918034},
	{0, -1, 0.918034},
	{0.918034, 0, 1},
	{-0.918034, 0, 1},
	{0.918034, 0, -1},
	{-0.918034, 0, -1},
	{-1, 0.918034, 0}
	};

	int[][] faces = new int[][] {
	{3, 7, 1},
	{4, 7, 3},
	{6, 7, 4},
	{8, 7, 6},
	{7, 8, 1},
	{9, 4, 3},
	{2, 9, 3},
	{2, 3, 1},
	{11, 2, 1},
	{10, 2, 11},
	{10, 9, 2},
	{9, 5, 4},
	{6, 4, 5},
	{0, 6, 5},
	{0, 11, 8},
	{11, 1, 8},
	{10, 0, 5},
	{10, 5, 9},
	{0, 8, 6},
	{0, 10, 11}
	};

	//all white
	double[][] faceColors = new double[][] {
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	{1, 1, 1, 1},
	};

	gl2.glPushMatrix();

	for (int i = 0; i < faces.length; i++) {
	gl2.glColor4dv(faceColors[i], 0 );

	gl2.glBegin(GL2.GL_TRIANGLE_FAN);
	for (int j = 0; j < faces[i].length; j++) {
	int vertexNum = faces[i][j];
	gl2.glVertex3dv( vertices[vertexNum], 0 );
	}
	gl2.glEnd();
	}


	gl2.glColor3f(0,0,0);
	for (int i = 0; i < faces.length; i++) {
	gl2.glBegin(GL2.GL_LINE_LOOP);
	for (int j = 0; j < faces[i].length; j++) {
	int vertexNum = faces[i][j];
	gl2.glVertex3dv( vertices[vertexNum], 0 );
	}
	gl2.glEnd();
	}

	gl2.glPopMatrix();
	gl2.glFlush();
	}
	
	//Creates a 3D diamond.
	public static void draw3DDiamond(GL2 gl2) {
	double[][] vertices = new double[][]{
	{ 3, -3, 3 },
	{ 1, -1, -1 },
	{ 2, 1, -3 },
	{ 3, 2, 3 },
	{ 1.5, 5.0, 0 },
	{ -2, 6.0, 0 },
	{ -3, -3, 3 },
	{ -2, 1, 2 },
	{ -2, 1, -2 },
	{ -2, -2, -2 },
	{ 1.5, -5.0, 0 },
	{ -1.5, -5.0, 0 },
	};

	int[][] faces = new int[][] {
	{ 1, 1, 1, 1 }, 
	{ 1, 1, 1 }, 
	{ 7, 3, 4, 5 }, 
	{ 2, 8, 5, 4 }, 
	{ 5, 8, 7 }, 
	{ 0, 3, 7, 6 }, 
	{ 2, 1, 9, 8 }, 
	{ 6, 7, 8, 9 }, 
	{ 0, 1, 10 }, 
	{ 6, 9, 11 }, 
	{ 6, 0, 10, 11 },
	{ 9, 1, 10, 11 }, 
	};

	double[][] faceColors = new double[][] {
		//All black
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0}, 
	{0,0,0},

	};

	gl2.glPushMatrix();

	for (int i = 0; i < faces.length; i++) {
	gl2.glColor3dv(faceColors[i], 0 );

	gl2.glBegin(GL2.GL_TRIANGLE_FAN);
	for (int j = 0; j < faces[i].length; j++) {
	int vertexNum = faces[i][j];
	gl2.glVertex3dv( vertices[vertexNum], 0 );
	}
	gl2.glEnd();
	}

	gl2.glColor3f(0,0,0);
	for (int i = 0; i < faces.length; i++) {
	gl2.glBegin(GL2.GL_LINE_LOOP);
	for (int j = 0; j < faces[i].length; j++) {
	int vertexNum = faces[i][j];
	gl2.glVertex3dv( vertices[vertexNum], 0 );
	}
	gl2.glEnd();
	}

	gl2.glPopMatrix();
	gl2.glFlush();
	}
	
	
	//main method
	public static void main(String[] args) {
		JFrame p2 = new JFrame("Project 2");
		ProjectTwo panel = new ProjectTwo();
		p2.setContentPane(panel);
		p2.pack(); 
		p2.setResizable(false);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		p2.setLocation( 
		(screen.width - p2.getWidth())/2,
		(screen.height - p2.getHeight())/2 );
		p2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p2.setVisible(true);
	}
}
