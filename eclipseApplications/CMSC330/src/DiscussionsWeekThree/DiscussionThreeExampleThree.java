package DiscussionsWeekThree;

/**
 * 
 * 
 * File Name : DiscussionThreeExampleThree.java
 * Author : Sean Hamilton
 * 
 * 
 * Are such forward references always prohibited within a single Java class? Are forward references of local 
 * names always prohibited within a single method? If not, provide an example that demonstrates your claim.
 * 
 *
 */

public class DiscussionThreeExampleThree {
	
	
	

	public void forwardReference() {
		int total = 10 + daily;
		System.out.println(total);
	}
	
	
	static int daily = 7;
		

	public static void main(String[] args) {
		
		DiscussionThreeExampleThree d3 = new DiscussionThreeExampleThree();
		d3.forwardReference();
		
	}

}
