package prac;

import java.util.Arrays;
import java.util.Scanner;

public class Arrayz {
	
//	public static void printArray(int[] array) {
//		for(int i = array.length-1; i >= 0; i--) {
//			System.out.println(array[i]);
//		}
//	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int last = arr.length-1;
		
		for(int i = last; i >= 0 ; i--) {
			arr[i] = in.nextInt();
			
//			System.out.print(arr[i] + " ");
			
			
		}
		String s = Arrays.toString(arr).replaceAll("\\[|\\]|\\,", "");
		System.out.println(s);
		in.close();
		
	}
	
}
