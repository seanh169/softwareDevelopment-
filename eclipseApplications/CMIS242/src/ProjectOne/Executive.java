package ProjectOne;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 
 * 
 * File Name : Executive.java
 * Author : Sean Hamilton
 * Date: 01/22/2019
 * Purpose of program: Executive subclass Project 1 CMIS 242 UMUC. Executive subclass of Employee class. Used for collection of executive employees for a salaries computational program. 
 * 
 * 
 *
 */

public class Executive extends Employee {
	
	//Additional instance variable that reflects current stock price. Per requirement 3. 
	private double currentStockPrice;
	
	
	
	public Executive() {}
	
	
	//constructor that allows name, monthly salary, and current stock price initialization. Per requirement 3a. 
	public Executive(String name, double monthlySalary, double currentStockPrice) {
		
		super(name, monthlySalary);
		this.currentStockPrice = currentStockPrice;
		
	}
	
	
	//Overridden method that returns the salary for a whole year. Per requirement 3b.
	@Override 
	public BigDecimal annualSalary() {
		
		BigDecimal bonus;
		if(this.getCurrentStockPrice() > 50) {
			bonus = BigDecimal.valueOf(30000);
		}else {
			bonus = BigDecimal.valueOf(0);
		}
		
		return (this.getMonthlySalary().multiply(BigDecimal.valueOf(12)).add(bonus)); 
	}
	
	//Overridden toString method. Per requirement 3c. 
	@Override
	public String employeeToString() {
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return "Employee Name: " + this.getName() + ", Employee Monthly Salary: " + formatter.format(this.getMonthlySalary()) + ", Employee Stock Price: " + formatter.format(this.getCurrentStockPrice());
	}
	
	
	//getter and setter for additional instance variable. 
	public double getCurrentStockPrice() {
		return currentStockPrice;
	}

	public void setCurrentStockPrice(double currentStockPrice) {
		this.currentStockPrice = currentStockPrice;
	}
	
	
}
