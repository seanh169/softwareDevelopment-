package ProjectThree;

import java.awt.Color;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * 
 * 
 * File Name : ProjectThree.java
 * Author : Sean Hamilton
 * Date: 02/19/2019
 * Purpose of program: Project 3 CMIS 242 UMUC. This class holds the GUI constructor, event handlers,  and main method. 
 * 
 * 
 *
 */

public class ProjectThree extends JFrame {
	
	
	//Set default size for GUI window.
	static final int WIDTH = 300, HEIGHT = 300;
	
	
	//Buttons, labels, and text fields per requirements
	JRadioButton iterative = new JRadioButton("Iterative");
	JRadioButton recursive = new JRadioButton("Recursive");
	JTextField userInput = new JTextField(2);
	JLabel userInputLabel = new JLabel("Enter n: ");
	JLabel resultLabel = new JLabel("Result: ");
	JLabel efficiencyLabel = new JLabel("Efficiency: ");
	JButton compute = new JButton("COMPUTE");
	JTextField result = new JTextField();
	JTextField efficiency = new JTextField();
	ButtonGroup bg = new ButtonGroup();
	
	//constructor that builds the GUI, and adds event handlers.
	public ProjectThree() {
		super("Project Three");
		setFrame(WIDTH, HEIGHT);
		iterative.setAlignmentX(Component.CENTER_ALIGNMENT);
		bg.add(iterative);
		bg.add(recursive);
		this.compute.setBackground(Color.GRAY);
		this.iterative.setSelected(true);
		this.result.setEditable(false);
		this.efficiency.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,1));
		panel.add(iterative);
		panel.add(recursive);
		panel.add(userInputLabel);
		panel.add(userInput);
		panel.add(compute);
		compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(iterative.isSelected()) {
					try {
						
						Integer inputSequence = Integer.parseInt(userInput.getText());
						if(inputSequence < 0) {
							throw new NumberFormatException();
						}
//						int inputInt = (int)inputSequence;
						result.setText(String.valueOf(Sequence.computeIterative(inputSequence)));
						efficiency.setText(String.valueOf(Sequence.getEfficiency("iterative")));
						Sequence.setIterativeCounter(0);
					}
					catch(NumberFormatException r) {
						JOptionPane.showMessageDialog(panel, "Must be an Integer that is 0 or greater.","Inane Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
				if(recursive.isSelected()) {
					try {
						
						Integer inputSequence = Integer.parseInt(userInput.getText());
						if(inputSequence < 0) {
							throw new NumberFormatException();
						}
						result.setText(String.valueOf(Sequence.computeRecursive(inputSequence)));
						efficiency.setText(String.valueOf(Sequence.getEfficiency("recursive")));
						Sequence.setRecursiveCounter(0);
					}
					catch(NumberFormatException r) {
						JOptionPane.showMessageDialog(panel, "Must be an Integer.","Inane Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			
		});
		panel.add(resultLabel);
		panel.add(result);
		panel.add(efficiencyLabel);
		panel.add(efficiency);
		add(panel);
		//Adds event to write text file of running program with 0-10 as inputs for n. Per project requirement. 
		this.addWindowListener(new WindowAdapter() {
			 @Override
		        public void windowClosing(WindowEvent arg0) {
//				 ArrayList<Integer> resultsHolder = new ArrayList<>();
//				 for(int i =1; i<11;i++) {
//					 resultsHolder.add(Sequence.computeIterative(i));
//				 }

				 
				 try(FileWriter fw = new FileWriter("/Users/SeanH/Downloads/myfile.txt", true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
					 
					 	for(int i=0;i<11;i++) {
					 		Sequence.computeRecursive(i);
					 		Sequence.computeIterative(i);
					 		out.println(i+","+Sequence.getEfficiency("iterative")+","+Sequence.getEfficiency("recursive"));
					 		Sequence.setIterativeCounter(0);
					 		Sequence.setRecursiveCounter(0);
					 	}
//						  
						} catch (IOException e) {
						    //exception handling left as an exercise for the reader
						}
				 System.exit(0);
		        }
			
		});
		
	}
	
	//Display method.
	public void display() {
		setVisible(true);
	}
	
	//Set Frame method
	private void setFrame(int width, int height) {
	    setSize(width, height);     
	    setLocationRelativeTo(null);  		
	    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
	}
	
	//main method. 
	public static void main(String[] args) {
		
		
		ProjectThree test = new ProjectThree();
		test.display();
	}
}
