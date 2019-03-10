package ProjectThree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Calculation {
	int counterRecursive = 0;
	// 0 1 2 5 12 29 70
	
	public String calculateIterative(int n) {
		
		int x = 0;
		int y = 1;
		int z = 2;
		int counter = 0;
		
		for(int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = (y*2)+x;
			counter++;
			
		}
		return "Sequence Value: " + x + "\n Amount of iterations: " + counter;

	}
	
	public int calculateRecursive(int n) {
		counterRecursive++;
		if(n==0 || n==1) {
			return n;
		}
		return (calculateRecursive(n-1)*2)+calculateRecursive(n-2);
		
		

	}
	
		
		
		
		
		

	
	
	
	public static void main(String[] args) {
		Calculation x = new Calculation();
		System.out.println(x.calculateIterative(5));
		System.out.println(x.calculateRecursive(5));
		System.out.println(x.counterRecursive);
	}

}
