package ProjectOne;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ProjectOne.DivideByZero;
import ProjectOne.InfixEvaluationProjectOne;

/**
 * 
 * 
 * File Name : ProjectOneGUI.java
 * Author : Sean Hamilton
 * Date: 05/29/2019
 * Purpose of program: Project 1 CMSC 350 UMUC. This class holds the GUI constructor, event handlers, and main method for Project One. 
 * 
 * 
 *
 */

public class ProjectOneGUI extends JFrame {
	
	
	
	
	//Set default size for GUI window.
	static final int WIDTH = 300, HEIGHT = 300;
	
	//Constructor that builds GUI with all necessary labels, buttons, and fields.
	public ProjectOneGUI() {
		//Builds the GUI - all necessary buttons, labels, and fields according to the requirements. 
		super("Project One");
		setFrame(WIDTH, HEIGHT);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		JLabel inflixExpressionLabel = new JLabel("Enter Inflix Expression", SwingConstants.CENTER);
		JTextField inflixExpressionTextField = new JTextField();
		JButton evaluate = new JButton("Evaluate");
		JLabel resultLabel = new JLabel("Result", SwingConstants.CENTER);
		JTextField resultTextField = new JTextField();
		resultTextField.setEditable(false);
		
		panel.add(inflixExpressionLabel);
		panel.add(inflixExpressionTextField);
		panel.add(evaluate);
		InfixEvaluationProjectOne processor = new InfixEvaluationProjectOne();
		//Event Handler for Construct Tree Button
		evaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					String expressionInput = inflixExpressionTextField.getText();
					resultTextField.setText("");
					if(expressionInput.length() < 1) {
						throw new blankTextField();
					}else {
						resultTextField.setText(processor.evaluateExpression(expressionInput));
					}
				}catch(blankTextField d) {
					JOptionPane.showMessageDialog(panel, "Inflix Expression text area cannot be blank!","Inane Warning", JOptionPane.WARNING_MESSAGE);
				} catch (EmptyStackException e1) {
					
					e1.printStackTrace();
				} catch (DivideByZero e1) {
					
					JOptionPane.showMessageDialog(panel, new DivideByZero("Cannot divide by 0"),"Inane Warning", JOptionPane.WARNING_MESSAGE);
				} 
			}		
		});
		panel.add(resultLabel);
		panel.add(resultTextField);
		
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
	//Exception used a blank input field
	public class blankTextField extends Exception {
		
	}
	
	
	//main method
	public static void main(String[] args) {
		
		
		ProjectOneGUI pone = new ProjectOneGUI();
		pone.display();
	}
	
	
	

}
