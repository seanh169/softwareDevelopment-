package DiscussionsWeekThree;



/**
 * 
 * 
 * File Name : DiscussionThreeExampleFour.java
 * Author : Sean Hamilton
 * 
 * 
 * Are such forward references always prohibited within a single Java class? Are forward references of local 
 * names always prohibited within a single method? If not, provide an example that demonstrates your claim.
 * 
 *
 */

public class DiscussionThreeExampleFour {

	
	
	public void illegalForwardReference() {
		
		int medium = highest;
		int highest = 5;
		System.out.println(highest);
	}
	
	public static void main(String[] args) {
		
		
		DiscussionThreeExampleFour d4 = new DiscussionThreeExampleFour();
		d4.illegalForwardReference();
	}

}
