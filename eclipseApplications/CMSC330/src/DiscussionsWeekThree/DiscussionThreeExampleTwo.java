package DiscussionsWeekThree;


/**
 * 
 * 
 * File Name : DiscussionThreeExampleTwo.java
 * Author : Sean Hamilton
 * 
 * 
 * Give examples in Java to illustrate a case where declaring two local variables with the same name in same method is permitted 
 * and one where it is prohibited. 
 * 
 *
 */


public class DiscussionThreeExampleTwo {
	
	public void duplicateNotAlowed() {
		
		String output = "Hello";
		int output = 5;
		
		System.out.println(output);
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		DiscussionThreeExampleTwo d3 = new DiscussionThreeExampleTwo();
		d3.duplicateNotAlowed();
		
	}

}
