import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * File Name : HomeWorkOne.java
 * Author: Sean Hamilton
 * Date: 11/1/2018
 * Purpose of program: Obtain student EMPLID,3 quiz scores,age, and current temperature to
 * display transformed results. 
 * 
 * 
 * 
 */



public class HomeWorkOne {
			
	
	public static void main(String[] args) throws IOException {
		
		//Creating instance of Scanner taking input
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your Student EMPLID (0-999999): ");
		//Create variables to take in all user inputs
		int studentEMPLID = in.nextInt();
		
		System.out.println("Enter your quiz1 percentage score(0.0 - 100.0); ");
		
		double quizOneScore = in.nextDouble();
		
		System.out.println("Enter your quiz2 percentage score(0.0 - 100.0); ");
		
		double quizTwoScore = in.nextDouble();
		
		System.out.println("Enter your quiz3 percentage score(0.0 - 100.0); ");
		
		double quizThreeScore = in.nextDouble();
		
		System.out.println("Enter your age in months(0-144): ");
		
		int age = in.nextInt();
		
		System.out.println("Enter the current Temperature in degrees Celsius: ");
		
		double temperature = in.nextDouble();
		DecimalFormat df = new DecimalFormat("#.0");
		//Display transformed information using to output
		System.out.println("***Thank you***");
		System.out.println("Student EMPLID: " + studentEMPLID);
		System.out.println("Quiz 1 Score: " + quizOneScore);
		System.out.println("Quiz 2 Score: " + quizTwoScore);
		System.out.println("Quiz 3 Score: " + quizThreeScore);
		System.out.println("Average quiz score: " + df.format(((quizOneScore + quizTwoScore + quizThreeScore)/3)));
		System.out.println("Age in months: " + age);
		System.out.println("Age in years: "+ (age/12));
		System.out.println("Temperature in Celsius: " + temperature + "\u00b0");
		System.out.println("Temperature in Fahrenheit: " + ((temperature * 9.0/5.0) +32)  + "\u00b0");
		
				
		
		
	}
	
	
	
	
	
	
	
	
	
}
