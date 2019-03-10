package ProjectOne;

import java.math.BigDecimal;
import java.text.NumberFormat;


/**
 * 
 * 
 * File Name : Employee.java
 * Author : Sean Hamilton
 * Date: 01/22/2019
 * Purpose of program: Employee class Project 1 CMIS 242 UMUC. Employee class used for collection of employees for a salaries computational program. 
 * 
 * 
 *
 */


//First Class - Employee Class. 
public class Employee {
	
	//private instance variables. Employee's name and monthly salary per requirement 1.
	private String name; 
	private BigDecimal monthlySalary; 
	
	//default empty constructor
	public Employee() {}
	
	//constructor that allows the name and monthly salary to be initialized. Per requirement 1a. 
	public Employee(String name, double monthlySalary) {
		this.name = name;
		this.monthlySalary = BigDecimal.valueOf(monthlySalary);
		
	}
	
	//Method that returns salary for a whole year. Per requirement 1b. 
	public BigDecimal annualSalary() {
		
		
		return this.monthlySalary.multiply(BigDecimal.valueOf(12));
		
	}
	
	//toString method that returns a string containing labeled name and monthly salary. Per requirement 1c.
	public String employeeToString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return "Employee Name: " + this.name + ", Employee Monthly Salary: " + formatter.format(this.monthlySalary);
	}
	
	//Getters and Setters for private instance variables. 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
	}


}
