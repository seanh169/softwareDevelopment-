package ProjectTwo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;




/**
 * 
 * 
 * File Name : ProjectTwoGUI.java
 * Author : Sean Hamilton
 * Date: 06/13/2019
 * Purpose of program: Project 2 CMSC 350 UMUC. This class holds the GUI constructor, Expression Tree Data structure, Conversion method, InvalidToken Exception, event handlers, and main method for Project Two. 
 * 
 * 
 *
 */

public class ProjectTwoGUI extends JFrame {
	
	//Set default size for GUI window.
	static final int WIDTH = 300, HEIGHT = 300;
	
	// Data structure used to represent expression Tree
	private Stack<Node> infixTree = new Stack<>();
	//Initialize variable currentData for later operator instantiation.
    private Node currentData;
	
	//GUI constructor
	public ProjectTwoGUI() {
		super("Three Address Generator");
		setFrame(WIDTH, HEIGHT);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		JLabel postfixExpression = new JLabel("Enter Inflix Expression", SwingConstants.CENTER);
		JTextField postfixExpressionTextField = new JTextField();
		JButton constructTree = new JButton("Construct Tree");
		JLabel infixExpression = new JLabel("Infix Expression", SwingConstants.CENTER);
		JTextField infixExpressionTextField = new JTextField();
		infixExpressionTextField.setEditable(false);
		panel.add(postfixExpression);
		panel.add(postfixExpressionTextField);
		panel.add(constructTree);
		panel.add(infixExpression);
		panel.add(infixExpressionTextField);
		//Event handler for construct tree button.
		constructTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					String postfixInput = postfixExpressionTextField.getText();
					infixExpressionTextField.setText("");
					if(postfixInput.length() < 1) {
						throw new blankTextField();
					}else {
						infixExpressionTextField.setText(preformExpressionTree(postfixInput));
					}
				}
				catch(blankTextField d) {
					JOptionPane.showMessageDialog(panel, "Postfix Expression text area cannot be blank!","Inane Warning", JOptionPane.WARNING_MESSAGE);
				} catch (EmptyStackException e1) {
					JOptionPane.showMessageDialog(panel, "Postfix must be a valid postfix expression!","Inane Warning", JOptionPane.WARNING_MESSAGE);
				} catch (TokenException e1) {
					JOptionPane.showMessageDialog(panel, "Invalid Token!: " + e1.getLocalizedMessage(),"Inane Warning", JOptionPane.WARNING_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(panel, "File could not read/write!","Inane Warning", JOptionPane.WARNING_MESSAGE);
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
	
	
	//Exception used a blank input field
	@SuppressWarnings("serial")
	public class blankTextField extends Exception {
			
	}

	//Method used to construct tree depending on which operand or operator on the current iteration. Then uses algorithm logic to display final Infix expression.
	String preformExpressionTree(String data) throws TokenException, EmptyStackException, IOException {
		
		//replaceAll method used for requirement that accounts for whitespace.
    	String st = data.replaceAll("\\s+", "");
    	//split method to split up expression into String array.
        String[] splitUpChars = st.split("");
      

   	 	
   	 	
   	 	
   	 	
   	 	//below is logic for expression tree construction.
        for(int i = 0 ; i < splitUpChars.length; i++) {
        	
        	//if current iteration does not match any operator symbols for this project or operand regex which is digits 0-9 then it is an invalid character.
        	 if (!splitUpChars[i].matches("[0-9.?]+") && !(splitUpChars[i].equals("-") || splitUpChars[i].equals("+") || splitUpChars[i].equals("*") || splitUpChars[i].equals("/") )) {
               throw new TokenException(splitUpChars[i]);
           }
           if (splitUpChars[i].matches("[0-9.?]+")) {
        	   infixTree.push(new Operand(splitUpChars[i]));
           }else if(splitUpChars[i].equals("-") || splitUpChars[i].equals("+") || splitUpChars[i].equals("*") || splitUpChars[i].equals("/") ) {
        		   currentData = new Operator(splitUpChars[i], infixTree.pop(), infixTree.pop());
        		   infixTree.push(currentData);
           }
        }
        currentData.writeToFile();

        return infixTree.pop().nodeData();
    }
	
	//InvalidToken RuntimException class per project requirements. 
	@SuppressWarnings("serial")
	public class TokenException extends RuntimeException {
	    public TokenException(String data) {
	        super(data);
	    }
	}
	
	//main method
	public static void main(String[] args) {
		
		ProjectTwoGUI ptwo = new ProjectTwoGUI();
		ptwo.display();
				
	}
		
}
