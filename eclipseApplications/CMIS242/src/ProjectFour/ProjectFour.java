package ProjectFour;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 
 * 
 * File Name : ProjectFour.java
 * Author : Sean Hamilton
 * Date: 03/04/2019
 * Purpose of program: Project 4 CMIS 242 UMUC. This class holds the GUI constructor, event handlers, data storage(HashMap) and main method. 
 * 
 * 
 *
 */

public class ProjectFour extends JFrame {
	
		//Set default size for GUI window.
		static final int WIDTH = 300, HEIGHT = 300;
		
		//HashMap student data base per requirement.
		HashMap<Integer, Student> studentDataBase = new HashMap<Integer, Student>();
		
		//All necessary text fields, labels, combo boxes and buttons.
		JLabel idLabel = new JLabel("Id:");
		JTextField idTextField = new JTextField();
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameTextField = new JTextField();
		JLabel majorLabel = new JLabel("Major:");
		JTextField majorTextField = new JTextField();
		JLabel selectionChoice = new JLabel("Choose Selection:");
		String[] selectionChoices = {"Insert", "Delete", "Find", "Update"};
		JComboBox selectionChoicesBox = new JComboBox<>(selectionChoices);
		JButton processRequests = new JButton("Process Request");
		
		//constructor including all event handlers and GUI panel set up.
		public ProjectFour() {
			super("Project Four");
			setFrame(WIDTH, HEIGHT);
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(5,2));
			
			panel.add(idLabel);
			panel.add(idTextField);
			panel.add(nameLabel);
			panel.add(nameTextField);
			panel.add(majorLabel);
			panel.add(majorTextField);
			panel.add(selectionChoice);
			panel.add(selectionChoicesBox);
			panel.add(processRequests);
			
			processRequests.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) { 
					try {
						Integer idInput = Integer.parseInt(idTextField.getText());
						if(selectionChoicesBox.getSelectedItem().equals("Insert") ) {
							if(studentDataBase.containsKey(idInput)) {
								throw new entryAlreadyExists();
							} 
							if(nameTextField.getText().isEmpty()) {
								throw new blankTextField();
							}
							if(majorTextField.getText().isEmpty()) {
								throw new blankTextField();
							}
								studentDataBase.put(idInput, new Student(nameTextField.getText(), majorTextField.getText()));
								JOptionPane.showMessageDialog(panel, "Sucessfully Added!","Inane Warning", JOptionPane.WARNING_MESSAGE);
								
							
							nameTextField.setText("");
							majorTextField.setText("");
							idTextField.setText("");

							
						}
						if(selectionChoicesBox.getSelectedItem().equals("Find")) {
							if(!studentDataBase.containsKey(idInput)) {
								throw new entryDoesntExist();
							}else {
								JOptionPane.showMessageDialog(panel,studentDataBase.get(idInput).studentToString(),"Inane Warning", JOptionPane.WARNING_MESSAGE);
							
								nameTextField.setText("");
								majorTextField.setText("");
								idTextField.setText("");
							}
						}
						if(selectionChoicesBox.getSelectedItem().equals("Delete")) {
							if(!studentDataBase.containsKey(idInput)) {
								throw new entryDoesntExist();
							}else {
								studentDataBase.remove(idInput);
								JOptionPane.showMessageDialog(panel, "Sucessfully Removed!","Inane Warning", JOptionPane.WARNING_MESSAGE);
							}
						}
						if(selectionChoicesBox.getSelectedItem().equals("Update")) {
							if(!studentDataBase.containsKey(idInput)) {
								throw new entryDoesntExist();
							}else {
								String[] choices = { "A", "B", "C", "D", "F"};
								String[] choicesCredits = { "3", "6"};
								String input = (String) JOptionPane.showInputDialog(null, "Grade: ", "Enter Course Grade", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
								String inputCredits = (String) JOptionPane.showInputDialog(null, "Grade: ", "Enter Course Credits", JOptionPane.QUESTION_MESSAGE, null, choicesCredits, choicesCredits[0]);
								studentDataBase.get(idInput).courseCompleted(input, Double.parseDouble(inputCredits));
								if(!input.isEmpty()  && !inputCredits.isEmpty()) {
									JOptionPane.showMessageDialog(panel, "Course Sucessfully Added!","Inane Warning", JOptionPane.WARNING_MESSAGE);
								}
							}
						}
					}catch(NumberFormatException r) {
						JOptionPane.showMessageDialog(panel, "Id field Must be an Integer that is 1 or greater.","Inane Warning", JOptionPane.WARNING_MESSAGE);
					}catch(entryAlreadyExists c) {
						JOptionPane.showMessageDialog(panel, "Entry Id Exists in Database!","Inane Warning", JOptionPane.WARNING_MESSAGE);
					}
					catch(entryDoesntExist d) {
						JOptionPane.showMessageDialog(panel, "Entry Id Does not Exist in Database!","Inane Warning", JOptionPane.WARNING_MESSAGE);
					}
					catch(blankTextField d) {
					JOptionPane.showMessageDialog(panel, "Name and/or Major text areas cannot be blank!","Inane Warning", JOptionPane.WARNING_MESSAGE);
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
		
		//main method. 
		public static void main(String[] args) {
			
			
			ProjectFour test = new ProjectFour();
			test.display();
		}
		
		
		//Exception classes for error handling. 
		public class entryAlreadyExists extends Exception {

			

			
		}
		public class entryDoesntExist extends Exception {

			

			
		}
		public class blankTextField extends Exception {

			

			
		}
}
