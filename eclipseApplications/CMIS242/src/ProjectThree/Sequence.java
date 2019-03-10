package ProjectThree;


/**
 * 
 * 
 * File Name : Sequence.java
 * Author : Sean Hamilton
 * Date: 02/19/2019
 * Purpose of program: Project 3 CMIS 242 UMUC. This is the Sequence utility class used to perform the projects calculations.
 * 
 * 
 *
 */

public final class Sequence {
	
	//Counters to keep track of iterations, recursion calls. 
	public static int iterativeCounter = 0;
	public static int recursiveCounter = 0;
	
	
	
	
	
	//Getters and Setters for counters.
	public static int getIterativeCounter() {
		return iterativeCounter;
	}






	public static void setIterativeCounter(int iterativeCounter) {
		Sequence.iterativeCounter = iterativeCounter;
	}






	public static int getRecursiveCounter() {
		return recursiveCounter;
	}






	public static void setRecursiveCounter(int recursiveCounter) {
		Sequence.recursiveCounter = recursiveCounter;
	}





	//Method to compute the sequence iteratively. 
	public static int computeIterative(int n) {
		int x = 0;
		int y = 1;
		int z = 2;
		for(int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = (y*2)+x;
			Sequence.setIterativeCounter(Sequence.getIterativeCounter()+1);
		}
		return x;
	}
	//Method to compute the sequence recursively. 
	public static int computeRecursive(int n) {
		
		Sequence.setRecursiveCounter(Sequence.getRecursiveCounter()+1);
		if(n==0 || n==1) {
			return n;
		}
		return (computeRecursive(n-1)*2)+computeRecursive(n-2);
	}
	
	//Method to return efficiency. 
	public static int getEfficiency(String counterType) {
		if(counterType.equals("iterative")) {
			return Sequence.getIterativeCounter();
		}else {
			return Sequence.getRecursiveCounter();
		}
		
		
		
	}
	

}
