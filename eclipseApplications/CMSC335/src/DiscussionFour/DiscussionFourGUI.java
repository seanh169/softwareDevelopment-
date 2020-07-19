package DiscussionFour;

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




public class DiscussionFourGUI extends JFrame {
	
	//Height and Width of JFrame
	static final int WIDTH = 500, HEIGHT = 500;
	
	//constructor 
	public DiscussionFourGUI() {
		super("Discussion 4");
		setFrame(WIDTH, HEIGHT);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		panel.add(new JLabel("   Choose your favorite language: "));
		ButtonGroup bg = new ButtonGroup();
		JRadioButton javaButton = new JRadioButton("Java");
		JRadioButton pythonButton = new JRadioButton("Python");
		JRadioButton cButton = new JRadioButton("C/C++");
		bg.add(javaButton);
		bg.add(pythonButton);
		bg.add(cButton);
		JButton seeFact = new JButton("Click to see interesting fact");
		seeFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (javaButton.isSelected()) {
					JPanel javaOutputPanel = new JPanel();
					javaOutputPanel.add(new JLabel("The inital name of java was 'Oak'. It was changed because that name was already registered by another computer company."));
					JOptionPane.showMessageDialog(null, javaOutputPanel);
				}
				else if (pythonButton.isSelected()) {
					JPanel pythonOutputPanel = new JPanel();
					pythonOutputPanel.add(new JLabel("Python does not support pointers, only references."));
					JOptionPane.showMessageDialog(null, pythonOutputPanel);
				}
				else if (cButton.isSelected()) {
					JPanel cOutputPanel = new JPanel();
					cOutputPanel.add(new JLabel("The C language was developed at Bell Laboratories in 1972."));
					JOptionPane.showMessageDialog(null, cOutputPanel);
				}
				else {
					JOptionPane.showMessageDialog(panel, "Please select a language.","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(javaButton);
		panel.add(pythonButton);
		panel.add(cButton);
		panel.add(seeFact);
		add(panel);
	}
	
	//Display methodDis
	public void display() {
	      setVisible(true);
	}
	
	//Set Frame method
	private void setFrame(int width, int height) {
	      setSize(width, height);     
	      setLocationRelativeTo(null);  		
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	//main
	public static void main(String[] args) {
		DiscussionFourGUI d4 = new DiscussionFourGUI();
		d4.display();
	}

}
