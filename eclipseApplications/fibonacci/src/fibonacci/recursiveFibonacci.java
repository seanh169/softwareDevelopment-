package fibonacci;

import java.util.Scanner;

public class recursiveFibonacci {
	//FIBONACCI SEQUENCE
	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ........
	
	public int fib(int n) {
		if(n<2) {
			return n;
		}
		else {
//			System.out.println(fib(n-1) + fib(n-2));
			return (fib(n-1) + fib(n-2));
			
			
		}
	}
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int j = z.nextInt();
		z.close();
		recursiveFibonacci x = new recursiveFibonacci();
		System.out.println(x.fib(j));
		
		
	}
}
