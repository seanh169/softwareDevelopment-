package ProjectTwo;

import java.math.BigDecimal;

public class AccountWRONG {

	private BigDecimal checkingsBalance;
	private BigDecimal savingsBalance;
	private int withdrawCounter = 0;
	
	
	
	
	public AccountWRONG(BigDecimal checkingsBalance, BigDecimal savingsBalance) {
		this.checkingsBalance = checkingsBalance;
		this.savingsBalance = savingsBalance;
	}
	
	
	public void withdraw(Integer withdrawAmount, boolean isChecking) {
		BigDecimal withdrawAmountBig = BigDecimal.valueOf(withdrawAmount);
		if(this.getWithdrawCounter() > 3) {
			if(isChecking == true) {
			  this.setCheckingsBalance(this.getCheckingsBalance().subtract(withdrawAmountBig).subtract(BigDecimal.valueOf(1.50)));
				this.setWithdrawCounter(this.getWithdrawCounter()+1);
			}else {
				this.setSavingsBalance(this.getSavingsBalance().subtract(withdrawAmountBig).subtract(BigDecimal.valueOf(1.50)));
				this.setWithdrawCounter(this.getWithdrawCounter()+1);
			}
		}else {
			if(isChecking == true) {
				this.setCheckingsBalance(this.getCheckingsBalance().subtract(withdrawAmountBig));
				this.setWithdrawCounter(this.getWithdrawCounter()+1);
			}else {
				this.setSavingsBalance(this.getSavingsBalance().subtract(withdrawAmountBig));
				this.setWithdrawCounter(this.getWithdrawCounter()+1);
				
			}
		}
		
		
			
	}
	
	public void deposit(Integer depositAmount, boolean isChecking) {
		BigDecimal depositAmountBig = BigDecimal.valueOf(depositAmount);
		if(isChecking == true) {
			this.setCheckingsBalance(this.getCheckingsBalance().add(depositAmountBig));
		}else {
			this.setSavingsBalance(this.getSavingsBalance().add(depositAmountBig));
		}
	}
	//default Java constructor
	public AccountWRONG() {
		
	}
	
	
	
	public BigDecimal getCheckingsBalance() {
		return checkingsBalance;
	}


	public void setCheckingsBalance(BigDecimal checkingsBalance) {
		this.checkingsBalance = checkingsBalance;
	}


	public BigDecimal getSavingsBalance() {
		return savingsBalance;
	}


	public void setSavingsBalance(BigDecimal savingsBalance) {
		this.savingsBalance = savingsBalance;
	}


	public int getWithdrawCounter() {
		return withdrawCounter;
	}


	public void setWithdrawCounter(int withdrawCounter) {
		this.withdrawCounter = withdrawCounter;
	}


	
}
