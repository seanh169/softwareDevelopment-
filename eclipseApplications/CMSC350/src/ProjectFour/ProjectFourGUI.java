package ProjectFour;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 
 * 
 * File Name : ProjectFourGUI.java
 * Author : Sean Hamilton
 * Date: 07/09/2019
 * Purpose of program: Project 4 CMSC 350 UMUC. This class holds the GUI constructor, event handlers, and main method for Project Four. 
 * 
 * 
 *
 */

@SuppressWarnings("serial")
public class ProjectFourGUI extends JFrame {

	//Set default size for GUI window.
	static final int WIDTH = 1200, HEIGHT = 400;

	private DirectedGraph<String> directedGraph;
	
	public ProjectFourGUI() {
		super("Class Dependency Graph");
		setFrame(WIDTH, HEIGHT);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,3));
		JLabel inputFileName = new JLabel("Input File Name: ");
		JTextField inputFileTextField = new JTextField();
		JButton buildGraph = new JButton("Build Directed Graph");
		JLabel compileClass = new JLabel("Class to recompile:");
		JTextField compileClassTextField = new JTextField();
		JButton topologicalOrder = new JButton("Topoligcal Order"); 
		JLabel recompOrderLabel = new JLabel("Recompilation Order: ");
		JTextArea recompOrder = new JTextArea();
		recompOrder.setSize(new Dimension(200,200));
		panel.add(inputFileName);
		panel.add(inputFileTextField);
		panel.add(buildGraph);
		panel.add(compileClass);
		panel.add(compileClassTextField);
		panel.add(topologicalOrder);
		panel.add(recompOrderLabel);
		panel.add(recompOrder);
		recompOrder.setEditable(false);
		add(panel);
		buildGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            directedGraph = new DirectedGraph<>();
	            try {
	            	String inputFileName = inputFileTextField.getText();
	            	if(inputFileName.length() < 1) {
						throw new blankTextField();
					}
	            	directedGraph.buildDirectedGraph(directedGraph.splitUpFile(inputFileName));
	            	
	            	JOptionPane.showMessageDialog(panel, "Graph Built Sucessfully","Inane Warning", JOptionPane.WARNING_MESSAGE);
	            	
	            }
	            catch(blankTextField d) {
					JOptionPane.showMessageDialog(panel, "Input File Text Area cannot be blank!","Inane Warning", JOptionPane.WARNING_MESSAGE);
				} catch (IOException e1) {	
					JOptionPane.showMessageDialog(panel, "File did not open","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
	            
			}
		});
	topologicalOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				recompOrder.setText("");
				String inputClassText = compileClassTextField.getText();
				if(inputClassText.length() < 1) {
					throw new blankTextField();
				}
				recompOrder.setText(directedGraph.topologicalOrder(inputClassText));
			}
			catch(blankTextField d) {
				JOptionPane.showMessageDialog(panel, "Class Name Text Area cannot be blank!","Inane Warning", JOptionPane.WARNING_MESSAGE);
			} catch (InvalidClassName e1) {
				JOptionPane.showMessageDialog(panel, "Invalid Class Name","Inane Warning", JOptionPane.WARNING_MESSAGE);
			} catch (CycleOccuredException e1) {
				JOptionPane.showMessageDialog(panel, "Cycle Occured!","Inane Warning", JOptionPane.WARNING_MESSAGE);
			}
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
	}
	public class blankTextField extends Exception {
			
	}
	//main method
	public static void main(String[] args) {
		ProjectFourGUI pfour = new ProjectFourGUI();
		pfour.display();
	}
}
