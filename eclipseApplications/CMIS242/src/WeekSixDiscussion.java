
public class WeekSixDiscussion {
	
	
//	The sequence I provided is that the first number of the sequence is always 0, the second number is always 1, and the third number is always 3. Every number after that is the result of multiplying the previous number by 3 and adding the second previous number. Example sequence :
//
//		1 2 7 23 76 251
	
	
	//Counters to keep track of iterations, recursion calls. 
	private int iterativeCounter = 0;
	private int recursiveCounter = 0;
	
	
	
	
	//Getters and setters for efficiency counters.
	public int getIterativeCounter() {
		return iterativeCounter;
	}




	public void setIterativeCounter(int iterativeCounter) {
		this.iterativeCounter = iterativeCounter;
	}




	public int getRecursiveCounter() {
		return recursiveCounter;
	}




	public void setRecursiveCounter(int recursiveCounter) {
		this.recursiveCounter = recursiveCounter;
	}



	//Iterative Method
	public int computerIterative(int sequenceNumber) {
		
		int zero = 0;
		int first = 1;
		int second = 2;
		for(int i = 2; i < sequenceNumber; i++) {
			zero = first;
			first = second;
			second = (first * 3) + zero;
	this.setIterativeCounter(this.getIterativeCounter()+1);
		}
		return second;
	}
	
	//Recursive Methods.
	public int computeRecursive(int sequenceNumber) {
		
		this.setRecursiveCounter(this.getRecursiveCounter()+1);
		if(sequenceNumber == 1 || sequenceNumber == 2) {
			return sequenceNumber;
		}
		return (computeRecursive(sequenceNumber-1)*3)+computeRecursive(sequenceNumber-2);
		
	}
	
	
	public static void main(String[] args) {
		WeekSixDiscussion testOne = new WeekSixDiscussion();
		WeekSixDiscussion testTwo = new WeekSixDiscussion();
//		System.out.println(testOne.computerIterative(5));
//		System.out.println(testOne.computeRecursive(5));
//		System.out.println(testOne.computerIterative(7));
//		System.out.println(testOne.computeRecursive(7));
		testOne.computerIterative(5);
		System.out.println("The Number at the 5th sequence is " + testOne.computeRecursive(5)+" , the efficiency using recursion is: " +  testOne.getRecursiveCounter()+" , and the efficiency using iteration is: " + testOne.getIterativeCounter());
		testTwo.computerIterative(10);
		System.out.println("The Number at the 10th sequence is " + testTwo.computeRecursive(10)+" , the efficiency using recursion is: " +  testTwo.getRecursiveCounter()+" , and the efficiency using iteration is: " + testTwo.getIterativeCounter());
	}

}
