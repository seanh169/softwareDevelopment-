package DiscussionsWeekThree;

import java.util.Random;

/**
 * 
 * 
 * File Name : DiscussionThreeExampleOne.java
 * Author : Sean Hamilton
 * 
 * 
 * Give examples in Java to illustrate a case where declaring two local variables with the same name in same method is permitted 
 * and one where it is prohibited. 
 * 
 *
 */



public class DiscussionThreeExampleOne {
	
	static Random rand = new Random();
	
	
	//Extremely simple and easy to read example of a case where declaring two local variables with the same name can be permitted. It is important to understand
	//the reason this is permitted is because they do not overlap in scopes although they are both in the local scope of this method.
	public void duplicateNames() {
		
		
		int random  = rand.nextInt(10);
		
		if(random > 5) {  
			
			String output = "Greater Than 5";
			System.out.println("The Random Number is " + random + " Display the string: " + output);
			
		}else {
			
			int output = 7;
			System.out.println("The Random Number is : " + random + ". Display the integer: " + output);
			
		}
		
	}
	
	
	

	public static void main(String[] args) {
		
		DiscussionThreeExampleOne d3 = new DiscussionThreeExampleOne();
		for(int i = 0; i < 10; i++) {
			d3.duplicateNames();
		}
		
	
	}

}
