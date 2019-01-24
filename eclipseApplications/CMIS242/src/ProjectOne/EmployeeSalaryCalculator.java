package ProjectOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * File Name : EmployeeSalaryCalculator.java
 * Author : Sean Hamilton
 * Date: 01/22/2019
 * Purpose of program: Project 1 CMIS 242 UMUC. Class that contains main method for project 1 and reads employee information from a text file and displays a report in console.
 * 
 * 
 *
 */



public class EmployeeSalaryCalculator {
	
	//Main method.
	
	public static void main(String[] args) throws FileNotFoundException {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		//Scanner to read text file.
		Scanner in = new Scanner(new File("/Users/SeanH/Downloads/EmployeeTestThree.txt"));
		
		//ArrayLists that hold Employee objects. 2014 and 2015.
		ArrayList<Employee> fourteen = new ArrayList<>();
		ArrayList<Employee> fifteen = new ArrayList<>();
		
		//iterate over every line in the text file
		while(in.hasNextLine()) {
			
			//Regular expression used as delimiter for values array. 
			String regExp = "[,\\s]+";
			
			//Store each line in the text file in a variable.
			String line = in.nextLine();
			
			//Split each set of characters into different indexes of an array.
			String[] values = line.split(regExp);
		
			
			//logic for adding new instances of the appropriate object to the appropriate ArrayList. 
			if(line.contains("2014")) {
				if(line.contains("Employee")) {
					fourteen.add(new Employee(values[3] + " " + values[2], Double.parseDouble(values[4])));
				}
				else if(line.contains("Salesman")) {
					fourteen.add(new Salesman(values[3] + " " + values[2], Double.parseDouble(values[4]), Double.parseDouble(values[5])));
				}
				else if(line.contains("Executive")) {
					fourteen.add(new Executive(values[3] + " " + values[2], Double.parseDouble(values[4]), Double.parseDouble(values[5])));
				}
			}else {
				if(line.contains("Employee")) {
					fifteen.add(new Employee(values[3] + " " + values[2], Double.parseDouble(values[4])));
				}
				else if(line.contains("Salesman")) {
					fifteen.add(new Salesman(values[3] + " " + values[2], Double.parseDouble(values[4]), Double.parseDouble(values[5])));
				}
				else if(line.contains("Executive")) {
					fifteen.add(new Executive(values[3] + " " + values[2], Double.parseDouble(values[4]), Double.parseDouble(values[5])));
				}
			}
			

		}
		
		//turn off scanner from reading input.
		in.close();
		
		//Report displayed in console for each of the two years. 
		System.out.println("\n" + "***2014 Employee Report***" + "\n");
		BigDecimal fourteenSum = BigDecimal.valueOf(0);
		BigDecimal fifteenSum = BigDecimal.valueOf(0);
		for(Employee x : fourteen) {
			fourteenSum = fourteenSum.add(x.annualSalary());
			
			System.out.println(x.employeeToString());
			System.out.println("Employee Classification: " + x.getClass().getSimpleName());
			System.out.println(x.getName() + " Annual Salary " + formatter.format(x.annualSalary()));
			System.out.println("------");
			
		}
		System.out.println("Average of all 2014 Annual Salaries: " + formatter.format(fourteenSum.doubleValue()/fourteen.size()));
		
		
		System.out.println( "\n" + "***2015 Employee Report***"  + "\n");
		for(Employee x : fifteen) {
			fifteenSum = fifteenSum.add(x.annualSalary());
			System.out.println(x.employeeToString());
			System.out.println("Employee Classification: " + x.getClass().getSimpleName());
			System.out.println(x.getName() + " Annual Salary " + formatter.format(x.annualSalary()));
			System.out.println("------");
		}
//		System.out.println(fifteenSum.doubleValue());133000/3 = 44333.33
		System.out.println("Average of all 2015 Annual Salaries: " + formatter.format(fifteenSum.doubleValue()/fifteen.size()));
		
	}
	

}
