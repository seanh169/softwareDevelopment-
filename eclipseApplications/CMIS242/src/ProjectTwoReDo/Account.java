package ProjectTwoReDo;

import java.math.BigDecimal;


/**
 * 
 * 
 * File Name : Account.java
 * Author : Sean Hamilton
 * Date: 02/11/2019
 * Purpose of program: Project 2 CMIS 242 UMUC. ATM Machine program. This is the account class that defines Account functionality and fields.  
 * 
 * 
 *
 */


public class Account {
	
	//private member field holds the account balance. Per requirement 2. 
	private BigDecimal accountBalance;
	
	//private static variable to hold the amount of withdraws processed. Per requirement 2.
	private static int withdrawCounter = 0;
	
	//Constructor per requirement 2.
	public Account(int i) {
		
		this.accountBalance = BigDecimal.valueOf(i);
		
	}
	
	//Methods below that correspond to each of the four buttons in the GUI. Per requirement 2. 
	public void withdraw(double d) {
		
		BigDecimal withdrawAmountBig = BigDecimal.valueOf(d);
		
		this.setAccountBalance(this.getAccountBalance().subtract(withdrawAmountBig));
		
		
	}
	
	public void deposit(double d) {
		
		BigDecimal depositAmount = BigDecimal.valueOf(d);
		
		this.setAccountBalance(this.getAccountBalance().add(depositAmount));
	}
	
	public void transfer(double d, Account reciever) {
		
		BigDecimal transferAmount = BigDecimal.valueOf(d);
		reciever.setAccountBalance(reciever.getAccountBalance().add(transferAmount));
		this.setAccountBalance(this.getAccountBalance().subtract(transferAmount));
		
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public static int getWithdrawCounter() {
		return withdrawCounter;
	}

	public static void setWithdrawCounter(int withdrawCounter) {
		Account.withdrawCounter = withdrawCounter;
	}
	

}
