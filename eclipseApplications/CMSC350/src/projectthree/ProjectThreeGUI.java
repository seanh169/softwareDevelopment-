package projectthree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;



/**
 * 
 * 
 * File Name : ProjectThreeGUI.java
 * Author : Sean Hamilton
 * Date: 06/26/2019
 * Purpose of program: Project 3 CMSC 350 UMUC. This class holds the GUI constructor, event handlers, and main method for Project Three. 
 * 
 * 
 *
 */

public class ProjectThreeGUI extends JFrame {
	
	//Set default size for GUI window.
	static final int WIDTH = 300, HEIGHT = 300;
	
	
	
	//GUI Constructor with all necessary labels,buttons, and event handlers to satisfy project requirements. 
	public ProjectThreeGUI() {
		super("Binary Search Tree Sort");
		setFrame(WIDTH, HEIGHT);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		
		//labels, buttons, and text-fields per requirements.
		JLabel originalList = new JLabel("Original List",  SwingConstants.CENTER);
		JTextField originalListTextField = new JTextField();
		JLabel sortedList = new JLabel("Sorted List",  SwingConstants.CENTER);
		JTextField sortedListTextField = new JTextField();
		sortedListTextField.setBackground(Color.LIGHT_GRAY);
		sortedListTextField.setEditable(false);
		JButton preformSort = new JButton("Preform Sort");
		JLabel sortOrder = new JLabel("Sort Order",  SwingConstants.CENTER);
		Font newLabelFont=new Font(sortOrder.getFont().getName(),Font.BOLD,sortOrder.getFont().getSize());
		sortOrder.setFont(newLabelFont);
		JLabel numericType = new JLabel("Numeric Type",  SwingConstants.CENTER);
		Font numericLabelFont=new Font(numericType.getFont().getName(),Font.BOLD,numericType.getFont().getSize());
		numericType.setFont(numericLabelFont);
		JRadioButton ascending = new JRadioButton("Ascending");
		ascending.setHorizontalAlignment(SwingConstants.CENTER);
		JRadioButton decsending = new JRadioButton("Descending");
		decsending.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonGroup bg = new ButtonGroup();
		bg.add(ascending);
		bg.add(decsending);
		JRadioButton integer = new JRadioButton("Integer");
		integer.setHorizontalAlignment(SwingConstants.CENTER);
		JRadioButton fraction = new JRadioButton("Fraction");
		fraction.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonGroup bgTwo = new ButtonGroup();
		bgTwo.add(integer);
		bgTwo.add(fraction);
		
		//Adding declared buttons, fields, and labels to the JPanel.
		panel.add(originalList);
		panel.add(originalListTextField);
		panel.add(sortedList);
		panel.add(sortedListTextField);
		panel.add(preformSort, BorderLayout.CENTER);
		panel.add(sortOrder);
		panel.add(ascending);
		panel.add(decsending);
		panel.add(numericType);
		panel.add(integer);
		panel.add(fraction);
		
		//Setting default values, when opening application, on radio buttons
		ascending.setSelected(true);
		integer.setSelected(true);
		
		//event listener for Perform Sort Button.
		preformSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String originalListInput = originalListTextField.getText();
					if(originalListInput.length() < 1) {
						throw new blankTextField();
					}
					//clear Sorted List Text Field
					sortedListTextField.setText("");
					//Split up input using space as delimiter into String array and instantiate the two BST's. 
					String[] splitUpInput = originalListInput.split(" ");
					BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
					BinarySearchTree<Fraction> fracTree = new BinarySearchTree<>();
					//Event Logic - to build BST , traverse and output per project requirements.
					if(fraction.isSelected()) {
						for(int i = 0; i< splitUpInput.length; i++) {
							if(splitUpInput[i].split("/").length < 2 || splitUpInput[i].split("/").length > 2){
								throw new ImproperFractionException(splitUpInput[i]);
							}
							fracTree.addNode(new Fraction(splitUpInput[i]));
						}
						if(decsending.isSelected()) {

							sortedListTextField.setText(fracTree.displayDescOrAsc(false));
						}else {

							sortedListTextField.setText(fracTree.displayDescOrAsc(true));
						}
							
					}
					if(integer.isSelected()) {
						for(int i = 0; i< splitUpInput.length; i++) {
							intTree.addNode(Integer.parseInt(splitUpInput[i]));
						}
						if(decsending.isSelected()) {

							sortedListTextField.setText(intTree.displayDescOrAsc(false));
						}else {

							sortedListTextField.setText(intTree.displayDescOrAsc(true));
						}
					}

					
				}
				//Exceptions
				catch(ImproperFractionException d) {
					JOptionPane.showMessageDialog(panel, "This is not a valid fraction: " + d.getLocalizedMessage(),"Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
				catch(blankTextField d) {
					JOptionPane.showMessageDialog(panel, "Original List text area cannot be blank!","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
				 catch (NumberFormatException d) {
		           JOptionPane.showMessageDialog(panel, "Non numeric Input.","Inane Warning",JOptionPane.WARNING_MESSAGE);
		        }
				
			}
		});
		add(panel);
		
	}
	
	
	
	
	
	//Display method.
	public void display() {
		setVisible(true);
	}
	
	//Set Frame method
	private void setFrame(int width, int height) {
		setSize(width, height);     
		setLocationRelativeTo(null);  		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
	}
	
	
	//NumberFormatException thrown for invalid fractions. 
	@SuppressWarnings("serial")
	class ImproperFractionException extends NumberFormatException{
		ImproperFractionException(String data) {
	        super(data);
	    }
	}
	@SuppressWarnings("serial")
	public class blankTextField extends Exception {
			
	}
	
	//main method
	public static void main(String[] args) {
		ProjectThreeGUI pthree = new ProjectThreeGUI();
		pthree.display();
	}

}
