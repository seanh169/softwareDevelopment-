package prac;

import java.util.Arrays;

public class morePrac {
	
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for(int i = 0; i < array.length; i ++ ) {
			int item = array[i];
			System.out.print(item);
			if (i < array.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	
	public static void main(String[] args) {
		int[] intArray1; 
		
		int[] intArray2 = new int[4];
		printArray(intArray2);
		int[] intArray3 = {5, 2, 9, 1, 3};
		
		String[] shoppingList = {"bananas", "apples", "pairs"};
		
		intArray2[0] = 10;
		intArray2[1] = 8;
		intArray2[2] = 5;
		intArray2[3] = 10;
		
		
		
		//print out arrays
		System.out.println(Arrays.toString(intArray2));
		System.out.println(Arrays.toString(intArray3));
		System.out.println();
		
		//customer print out arrays
		printArray(intArray2);
		printArray(intArray3);
		
		//Retrieve objects
		System.out.println(intArray2[3]);
		 
		//Given function
		Arrays.sort(intArray3);
		printArray(intArray3);
	}
}



























