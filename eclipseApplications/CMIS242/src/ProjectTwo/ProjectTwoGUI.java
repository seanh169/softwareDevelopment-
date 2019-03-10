package ProjectTwo;

import javax.swing.JFrame;

public class ProjectTwoGUI extends JFrame {
	
	
	static final int WIDTH = 300, HEIGHT = 300;
	
	public ProjectTwoGUI() {
		super("ATM Machine");
		setFrame(WIDTH, HEIGHT);
	}
	
	public ProjectTwoGUI(String title) {
		super(title);
		setFrame(WIDTH, HEIGHT);
	}
	
	public ProjectTwoGUI(String title, int width, int height) {
		super(title);        				
	    setFrame(width, height);
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
		
		ProjectTwoGUI testApp = new ProjectTwoGUI("ATM Machine");
		testApp.add(new ProjectTwoPanel());
		testApp.display();
	}
}
