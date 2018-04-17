package fibonacci;

import java.util.Scanner;

public class factorial {
	//program that takes in an integer value and them returns the factorial of that value
	
	
	public int factorial (int n) {
		if(n == 1) {
			return n;
		}
		else {
			return n*factorial(n-1);
		}
	}
	public int m1(int n) {
		//Base CASE : WE ARE AT THE END
		if(n==1) {
			return 25;
		}
		//Recursive Case: KEEP GOING
		else {
			System.out.println(n);
			//6 + m1(5)
			//6 + 5 + m1(4)
			//6 + 5 + 4 + m1(3)
			//6 + 5 + 4 + 3 + m1(2)
			//6 + 5 + 4 + 3 + 2 + 25
			return n + m1(n-1);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int j =in.nextInt();
		factorial z = new factorial();
//		System.out.println(z.factorial(j));
		System.out.println(z.m1(j));
		
	}
	
}
