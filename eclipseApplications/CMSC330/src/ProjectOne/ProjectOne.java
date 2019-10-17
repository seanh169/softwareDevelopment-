package ProjectOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;



/**
 * 
 * 
 * File Name : ProjectOne.java
 * Author : Sean Hamilton
 * Date: 09/09/2019
 * Purpose of program: Project 1 CMSC 330 UMUC. This class holds the FileChooser method to obtain the input filer from the user. This class also includes the main method. 
 * 
 * 
 *
 */

public class ProjectOne extends JFrame {
	
	//Default height and width for window if no file is selected.
	static final int WIDTH = 500, HEIGHT = 500;
	
	
	
	public ProjectOne() throws IOException, InvalidInputException {	
		this.fileChooser();
	}
	
	
	//FileChooser Method. Called in ProjectOne constructor. 
	public void fileChooser() throws IOException, InvalidInputException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    String selectedFilePath = selectedFile.getAbsolutePath();
	        FiParser parser = new FiParser(selectedFilePath);	
		}else {
			setFrame(WIDTH, HEIGHT);
			JOptionPane.showMessageDialog(this, "No File chosen!","Inane Warning", JOptionPane.WARNING_MESSAGE);
			setVisible(false);
			System.exit(1);
		}
	}
	
	//Display method.
	public void display() {
		setVisible(true);
	}
			
	//Set Frame method.
	private void setFrame(int width, int height) {
		setSize(width, height);     
		setLocationRelativeTo(null);  		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
	}
	
	//Main method.
	public static void main(String[] args) throws IOException, InvalidInputException {
		
		ProjectOne pOne = new ProjectOne();

	}
}
