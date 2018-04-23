package prac;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoDArray {
	
	//given a 2 d Array = print the sum of the max HOUR GLASS
	//EXPLANATION = 1 1 1 0 0 0
//					0 1 0 0 0 0
//					1 1 1 0 0 0
//					0 0 2 4 4 0
//					0 0 0 2 0 0
//					0 0 1 2 4 0
	//hourGlass = 1 1 1
	//				1
	//			  1 1 1 
	
	
	
	public static void main(String[] args) {
		int[][] TwoDArray = new int[6][6];
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		for(int i=0; i < 6; i++) {
			for(int j=0; j < 6; j++) {
				TwoDArray[i][j] = r.nextInt(10) + 1;
			}
		}
		int newSum = 0;
		int max = 0;
		for(int j =0 ; j < TwoDArray.length-2; j++) {
			for(int z = 0; z < TwoDArray[0].length-2; z++) {
				newSum = TwoDArray[j][z] + TwoDArray[j][z+1] + TwoDArray[j][z+2]+ 
						TwoDArray[j+1][z+1] +
						TwoDArray[j+2][z] + TwoDArray[j+2][z+1] + TwoDArray[j+2][z+2];
			if(newSum > max) {
				max = newSum;
			}		
			}
			System.out.print(Arrays.deepToString(TwoDArray));
			System.out.println();
//			System.out.println(newSum);
			System.out.println(max);
		}
//		System.out.print(Arrays.deepToString(TwoDArray));
//		System.out.println();
//		System.out.println(TwoDArray[1][5]);
//		System.out.println(TwoDArray.length);
//		System.out.println(max);
		
	}
}
