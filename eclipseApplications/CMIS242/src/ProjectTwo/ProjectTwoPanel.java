package ProjectTwo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProjectTwoPanel extends JPanel {
	
	private JButton withdraw = new JButton("Withdraw");
	
	private JButton deposit = new JButton("Deposit");
	private JButton transferTo = new JButton("Transfer to");
	private JButton balance = new JButton("Balance");
	private JRadioButton checkings = new JRadioButton("Checking");
	private JRadioButton savings = new JRadioButton("Savings");
	ButtonGroup group = new ButtonGroup();
//	AccountWRONG seansAccount = new AccountWRONG(BigDecimal.valueOf(5000), BigDecimal.valueOf(2000));
	Account checkingAccount = new Account(200);
	Account savingsAccount = new Account(2000);
	
	private JTextField mainTextField = new JTextField();
	
	public ProjectTwoPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.gray);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(4,2));
		buttonsPanel.add(withdraw);
//		WithdrawListener withdrawListener = new WithdrawListener();
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
//				mainTextField.setText(seansAccount.getCheckingsBalance().toString());
				try {
//					Integer.parseInt(mainTextField.getText());
//					Double.parseDouble(mainTextField.getText());
					
					Integer inputWithdraw = Integer.parseInt(mainTextField.getText());
					
					if(inputWithdraw % 20 == 1) {
						throw new ArithmeticException();
					}
					else {
						if(checkings.isSelected()) {
							if(checkingAccount.getWithdrawCounter() > 3) {
								
								if((inputWithdraw+1.50) > checkingAccount.getAccountBalance().intValue()) {
									throw new InsufficientFundsException();
								}else {
									checkingAccount.withdraw(inputWithdraw+(1.50));
									JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from checkings has succeeded.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
								}
								
							}else {
								
								if(inputWithdraw > checkingAccount.getAccountBalance().intValue() ) {
									throw new InsufficientFundsException();
								}else {
									checkingAccount.withdraw(inputWithdraw);
									JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from checkings has succeeded.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
								}
								
							}
							
							
							
							
							
							
						}
						else if(savings.isSelected()) {
							if(savingsAccount.getWithdrawCounter() > 3) {
								if(inputWithdraw > (savingsAccount.getAccountBalance().intValue()+(1.50)) ) {
									throw new InsufficientFundsException();
								}else {
									savingsAccount.withdraw(inputWithdraw+((int) 1.50));
									JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from savings has succeeded.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
								}
							}else {
								if(inputWithdraw > savingsAccount.getAccountBalance().intValue() ) {
									throw new InsufficientFundsException();
								}else {
									savingsAccount.withdraw(inputWithdraw);
									JOptionPane.showMessageDialog(buttonsPanel, "Withdraw from savings has succeeded.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
								}
							}
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
					JOptionPane.showMessageDialog(buttonsPanel, "Sorry, you do not have the necessary funds to complete that transaction.", "Insufficient funds", JOptionPane.WARNING_MESSAGE);
				}
			  }
		});
		buttonsPanel.add(deposit);
//		deposit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) { 
//				try {
//					Integer.parseInt(mainTextField.getText());
//					Integer inputDeposit = Integer.parseInt(mainTextField.getText());
//					if(checkings.isSelected()) {
//						seansAccount.deposit(inputDeposit, true);
//						JOptionPane.showMessageDialog(buttonsPanel, "Deposit to checkings has succeeded.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
//					}else {
//						seansAccount.deposit(inputDeposit, false);
//						JOptionPane.showMessageDialog(buttonsPanel, "Deposit to savings has succeeded.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
//					}
//					
//				}catch(NumberFormatException r) {
//					JOptionPane.showMessageDialog(buttonsPanel, "Must be a number.","Inane Warning", JOptionPane.WARNING_MESSAGE);
//				}
//			}
//			
//		});
		buttonsPanel.add(transferTo);
		buttonsPanel.add(balance);
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(checkings.isSelected()) {
					JOptionPane.showMessageDialog(buttonsPanel, checkingAccount.getAccountBalance(), "Checking Account Balance", JOptionPane.DEFAULT_OPTION);
				}else if(savings.isSelected()) {
					JOptionPane.showMessageDialog(buttonsPanel, savingsAccount.getAccountBalance(), "Savings Account Balance", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		group.add(checkings);
		group.add(savings);
		buttonsPanel.add(checkings);
		buttonsPanel.add(savings);
		buttonsPanel.add(mainTextField);
		
		add(buttonsPanel, BorderLayout.CENTER);
		
		
		

	}
	

}
