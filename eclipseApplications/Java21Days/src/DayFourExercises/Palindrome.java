package DayFourExercises;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		Queue<Character> z = new LinkedList();
		Stack<Character> x = new Stack();
		
		for(int i = 0; i < n.length(); i++) {
			z.add(n.charAt(i));
		}
		for(int j = n.length()-1; j>=0 ; j--) {
			x.push(n.charAt(j));
		}
		String newString = z.toString().toLowerCase();
		String newStringz = x.toString().toLowerCase();
		if(newString.equals(newStringz)) {
			System.out.println("This is a palindrome");

		}else {
			System.out.println("This is not a palindrome");
		}
		
		
		
	}
	
	

}
