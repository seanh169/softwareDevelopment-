package ProjectTwo;

import java.math.BigDecimal;

public class Account {
	
	private BigDecimal accountBalance;
	
	private static int withdrawCounter = 0;
	
	public Account(int i) {
		
		this.accountBalance = BigDecimal.valueOf(i);
		
	}
	
	public void withdraw(double d) {
		
		BigDecimal withdrawAmountBig = BigDecimal.valueOf(d);
		
		if(this.getWithdrawCounter() > 3) {
			this.setAccountBalance(this.getAccountBalance().subtract(withdrawAmountBig).subtract(BigDecimal.valueOf(1.50)));
			this.setWithdrawCounter(this.getWithdrawCounter()+1);
		}else {
			this.setAccountBalance(this.getAccountBalance().subtract(withdrawAmountBig));
			this.setWithdrawCounter(this.getWithdrawCounter()+1);
		}
		
		
		
		
		
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
