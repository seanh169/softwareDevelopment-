package ProjectOne;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 
 * 
 * File Name : Salesman.java
 * Author : Sean Hamilton
 * Date: 01/22/2019
 * Purpose of program: Salesman subclass Project 1 CMIS 242 UMUC. Salesman subclass of Employee class. Used for collection of salesman employees for a salaries computational program. 
 * 
 * 
 *
 */

public class Salesman extends Employee {
	
	
	//Additional instance variable that contains the annual sales in whole dollars. Per requirement 2. 
	private BigDecimal annualSales;
	
	//empty default constructor
	public Salesman() {}
	
	//constructor that allows name, monthly salary, and annual sales initialization. Per requirement 2a. 
	public Salesman(String name, double monthlySalary, double annualSales) {
		
		super(name, monthlySalary);
		this.annualSales = BigDecimal.valueOf(annualSales);
	}
	
	//Overridden method that returns the salary for a whole year. Per requirement 2b.
	@Override
	public BigDecimal annualSalary() {
		
		BigDecimal commission = this.annualSales.multiply(BigDecimal.valueOf(0.02));
		if(commission.intValue() > 20000) {
			commission = BigDecimal.valueOf(20000);
		}
		
		return (this.getMonthlySalary().multiply(BigDecimal.valueOf(12)).add(commission));
		
	}
	
	//Overridden toString method. Per requirement 2c. 
	@Override
	public String employeeToString() {
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return "Employee Name: " + this.getName() + ", Employee Monthly Salary: " + formatter.format(this.getMonthlySalary()) + ", Employee Annual Sales: " + formatter.format(this.getAnnualSales());
		
	}
	
	//getter and setter for additional instance variable.
	public BigDecimal getAnnualSales() {
		return annualSales;
	}

	public void setAnnualSales(BigDecimal annualSales) {
		this.annualSales = annualSales;
	}


}
