import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeekFourDiscussion extends JFrame {
	
	//Set defaul size for GUI window.
	static final int WIDTH = 200, HEIGHT = 150;
	
	
	JTextField addTextField = new JTextField(5);
	JLabel addLabel = new JLabel("ADD AMOUNT");
	JTextField addTwoTextField = new JTextField(5);
	JLabel addLabelTwo = new JLabel("ADD AMOUNT");
	JLabel resultLabel = new JLabel("RESULT AMOUNT");
	JTextField resultTextField = new JTextField(5);
	JButton calculator = new JButton("Calculate!");
	
	
	
	public WeekFourDiscussion() {
		super("Addition Only Calculator");
		setFrame(WIDTH, HEIGHT);
		this.resultTextField.setEditable(false);
		
		JPanel panel = new JPanel();
//		mainTextField.setSize(200, 200);
		panel.add(addLabel);
		panel.add(addTextField);
		panel.add(addLabelTwo);
		panel.add(addTwoTextField);
		panel.add(resultLabel);
		panel.add(resultTextField);
		panel.add(calculator);
		calculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double inputAdd = Double.parseDouble(addTextField.getText());
					Double inputAddTwo = Double.parseDouble(addTwoTextField.getText());
					
					Double inputResult = inputAdd + inputAddTwo;
					resultTextField.setText(inputResult.toString());
				}
				catch(NumberFormatException r) {
					JOptionPane.showMessageDialog(panel, "Must be a number.","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		this.getContentPane().add(panel);
		
		
	}
	

	
	//Display method.
		public void display() {
		      setVisible(true);
	}
		
		//SetFrame method. Sets default close operation. 
	private void setFrame(int width, int height) {
		setSize(width, height);     
		setLocationRelativeTo(null);  		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}	
		
	public static void main(String[] args) {
		
		
		WeekFourDiscussion testApp = new WeekFourDiscussion();
		testApp.display();
				
				
	}
	
	
	
}
