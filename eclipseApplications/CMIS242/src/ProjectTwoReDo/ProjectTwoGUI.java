package ProjectTwoReDo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * 
 * File Name : ProjectTwoGUI.java
 * Author : Sean Hamilton
 * Date: 02/11/2019
 * Purpose of program: Project 2 CMIS 242 UMUC. ATM Machine program. This class holds the GUI, Panel, and main method. 
 * 
 * 
 *
 */


public class ProjectTwoGUI extends JFrame {
	

	
//Set defaul size for GUI window.
static final int WIDTH = 300, HEIGHT = 300;
	
	//No Parameter Constructor.Sets title and size of GUI.
	public ProjectTwoGUI() {
		super("ATM Machine");
		setFrame(WIDTH, HEIGHT);
	}
	
	//Constructor to accept title of GUI if ATM Machine name is not sufficient. 
	public ProjectTwoGUI(String title) {
		super(title);
		setFrame(WIDTH, HEIGHT);
	}
	
	//Constructor to set title and size of GUI if necessary. 
	public ProjectTwoGUI(String title, int width, int height) {
		super(title);        				
	    setFrame(width, height);
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
	
	//Main method that builds the GUI and add layout panel.
	public static void main(String[] args) {
		
		ProjectTwoGUI testApp = new ProjectTwoGUI("ATM Machine");
		testApp.add(new ProjectTwoPanel());
		testApp.display();
	}
	
}

//Class that defined the panel, GUI Layout, and event handlers. 
class ProjectTwoPanel extends JPanel {
	
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	//All necessary buttons and different account definitions per requirement 1. 
	private JButton withdraw = new JButton("Withdraw");
	private JButton deposit = new JButton("Deposit");
	private JButton transferTo = new JButton("Transfer to");
	private JButton balance = new JButton("Balance");
	private JRadioButton checkings = new JRadioButton("Checking");
	private JRadioButton savings = new JRadioButton("Savings");
	ButtonGroup group = new ButtonGroup();

	Account checkingAccount = new Account(1000);
	Account savingsAccount = new Account(800);
	
	private JTextField mainTextField = new JTextField();
	
	
	//Constructor that builds our panel. 
	public ProjectTwoPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.gray);
		
		//All necessary button event handlers per requirement 1. 
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(4,2));
		buttonsPanel.add(withdraw);
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 

				try {

					//Forces Numberformat exception to satisfy requirement of text field being numeric. 
					Double inputWithdraw = Double.parseDouble(mainTextField.getText());
					
					//Satisfy requirement of ensuring amounts in textfield are in increments of $20. 
					if(inputWithdraw % 20 != 0) {
						throw new ArithmeticException();
					}
					//Logic below to determine if a withdraw can be made, how much to withdraw, and from which account to withdraw. Per requirement 1. 
					if(inputWithdraw % 20 == 0 && checkings.isSelected() && Account.getWithdrawCounter() >= 4) {
						Double serviceFee = 1.50;
						Double newWithdrawAmount = inputWithdraw + serviceFee;
						BigDecimal newWithdrawAmountTwo = BigDecimal.valueOf(newWithdrawAmount);
						if(checkingAccount.getAccountBalance().compareTo(newWithdrawAmountTwo) == -1) {
							throw new InsufficientFundsException("Sorry, you do not have the necessary funds to complete that transaction.");
						}else if(checkingAccount.getAccountBalance().compareTo(newWithdrawAmountTwo) != -1) {
							checkingAccount.setAccountBalance(checkingAccount.getAccountBalance().subtract(BigDecimal.valueOf(newWithdrawAmount)));
							Account.setWithdrawCounter(Account.getWithdrawCounter()+1);
							JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from checkings has succeeded. New Balance:" + formatter.format(checkingAccount.getAccountBalance()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if(inputWithdraw % 20 == 0 && checkings.isSelected() && Account.getWithdrawCounter() < 4) {
						if(checkingAccount.getAccountBalance().doubleValue() < inputWithdraw) {
							throw new InsufficientFundsException("Sorry, you do not have the necessary funds to complete that transaction.");
						}else {
							checkingAccount.setAccountBalance(checkingAccount.getAccountBalance().subtract(BigDecimal.valueOf(inputWithdraw)));
							Account.setWithdrawCounter(Account.getWithdrawCounter()+1);
							JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from checkings has succeeded. New Balance:" + formatter.format(checkingAccount.getAccountBalance()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if(inputWithdraw % 20 == 0 && savings.isSelected() && Account.getWithdrawCounter() >= 4) {
						Double serviceFee = 1.50;
						Double newWithdrawAmount = inputWithdraw + serviceFee;
						BigDecimal newWithdrawAmountTwo = BigDecimal.valueOf(newWithdrawAmount);
						if(savingsAccount.getAccountBalance().compareTo(newWithdrawAmountTwo) == -1) {
							throw new InsufficientFundsException("Sorry, you do not have the necessary funds to complete that transaction.");
						}else if(savingsAccount.getAccountBalance().compareTo(newWithdrawAmountTwo) != -1) {
							savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(BigDecimal.valueOf(newWithdrawAmount)));
							Account.setWithdrawCounter(Account.getWithdrawCounter()+1);
							JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from savings has succeeded. New Balance:" + formatter.format(savingsAccount.getAccountBalance()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					if(inputWithdraw % 20 == 0 && savings.isSelected() && Account.getWithdrawCounter() < 4) {
						if(savingsAccount.getAccountBalance().doubleValue() < inputWithdraw) {
							throw new InsufficientFundsException("Sorry, you do not have the necessary funds to complete that transaction.");
						}else {
							savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(BigDecimal.valueOf(inputWithdraw)));
							Account.setWithdrawCounter(Account.getWithdrawCounter()+1);
							JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from savings has succeeded. New Balance:" + formatter.format(savingsAccount.getAccountBalance()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}			
							
				catch(NumberFormatException r) {
					JOptionPane.showMessageDialog(buttonsPanel, "Must be a number.","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
				catch(ArithmeticException s) {
					JOptionPane.showMessageDialog(buttonsPanel, "Must be a multiple of $20.","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
				catch(InsufficientFundsException t) {
					
					JOptionPane.showMessageDialog(buttonsPanel, t.getMessage(), "Insufficient funds", JOptionPane.WARNING_MESSAGE);
				}
			  }
		});		
							
							
							

		//Deposit button action event listener. 		
		buttonsPanel.add(deposit);
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					//Logic below to check if textfield is numeric and deposit logic. 
					Double.parseDouble(mainTextField.getText());
					Double inputDeposit = Double.parseDouble(mainTextField.getText());
					if(checkings.isSelected()) {
						checkingAccount.deposit(inputDeposit);
						JOptionPane.showMessageDialog(buttonsPanel, "Deposit to checkings has succeeded. New Balance:" + formatter.format(checkingAccount.getAccountBalance()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}else if(savings.isSelected()) {
						savingsAccount.deposit(inputDeposit);
						JOptionPane.showMessageDialog(buttonsPanel, "Deposit to savings has succeeded. New Balance: " + formatter.format(savingsAccount.getAccountBalance()), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}catch(NumberFormatException r) {
					JOptionPane.showMessageDialog(buttonsPanel, "Must be a number.","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		//Transfer button action even listener logic and exceptions.
		buttonsPanel.add(transferTo);
		transferTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					Double inputDeposit = Double.parseDouble(mainTextField.getText());
					BigDecimal inputDepositBig = BigDecimal.valueOf(inputDeposit);
					if(checkings.isSelected()) {
						if(savingsAccount.getAccountBalance().compareTo(inputDepositBig) == -1) {
							throw new InsufficientFundsException("Sorry, you do not have the necessary funds to complete that transaction.");
						}else if(savingsAccount.getAccountBalance().compareTo(inputDepositBig) == 1) {
							savingsAccount.transfer(inputDeposit, checkingAccount);
						}
						
					}
					if(savings.isSelected()) {
						if(checkingAccount.getAccountBalance().compareTo(inputDepositBig) == -1) {
							throw new InsufficientFundsException("Sorry, you do not have the necessary funds to complete that transaction.");
						}else if(checkingAccount.getAccountBalance().compareTo(inputDepositBig) == 1) {
							checkingAccount.transfer(inputDeposit, savingsAccount);
						}
						
					}
					
					
				}catch(NumberFormatException r) {
					JOptionPane.showMessageDialog(buttonsPanel, "Must be a number.","Inane Warning", JOptionPane.WARNING_MESSAGE);
				}
				catch(InsufficientFundsException l) {
					JOptionPane.showMessageDialog(buttonsPanel, l.getMessage(), "Insufficient funds", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//Balance logic to show JoptionPane of balance. 
		buttonsPanel.add(balance);
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(checkings.isSelected()) {
					JOptionPane.showMessageDialog(buttonsPanel, formatter.format(checkingAccount.getAccountBalance()) , "Checking Account Balance", JOptionPane.DEFAULT_OPTION);
				}else if(savings.isSelected()) {
					JOptionPane.showMessageDialog(buttonsPanel, "Savings account Balance: " + formatter.format(savingsAccount.getAccountBalance()), "Savings Account Balance", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		
		//add radio button grouping and layout.
		group.add(checkings);
		group.add(savings);
		buttonsPanel.add(checkings);
		buttonsPanel.add(savings);
		buttonsPanel.add(mainTextField);
		
		add(buttonsPanel, BorderLayout.CENTER);
		
		
		

	}
	

}