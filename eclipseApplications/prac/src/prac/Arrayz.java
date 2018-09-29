package prac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arrayz {
	String b = new String();
	String c = new String();
//	Stack stack = new Stack();
//	Queue<Character> queue = new LinkedList();
	
	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int[] arr = new int[n];
//		int last = arr.length-1;
//		
//		for(int i = last; i >= 0 ; i--) {
//			arr[i] = in.nextInt();
//			
////			System.out.print(arr[i] + " ");
//			
//			
//		}
//		String s = Arrays.toString(arr).replaceAll("\\[|\\]|\\,", "");
//		System.out.println(s);
//		in.close();
//		
//	}
	
	void isPalindrome(String a) {
		for(int i = 0; i<a.length(); i++) {
			b = b + a.charAt(i);
		}
		for(int i = a.length()-1; i >=0; i--) {
			c = c + a.charAt(i);
		}
		System.out.println(b.equals(c));
		
	}
	public static void main(String[] args) {
//		String z = new String("Hello");
		Arrayz x = new Arrayz();
		x.isPalindrome("sean");
		
		
	}
}