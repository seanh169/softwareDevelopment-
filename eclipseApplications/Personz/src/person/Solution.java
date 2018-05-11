package person;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int numSwaps = 0;
        for(int i = 0; i < a.length; i++){
//        	int numSwaps = 0;
            for(int j = 0; j < a.length-1; j++) {
            	if(a[j] > a[j + 1]) {
            		int tmp = a[j];
            		a[j] = a[j+1];
            		a[j+1] = tmp;
            		numSwaps++;
            	}
            }
            if(numSwaps == 0) {
            	break;
            }
        
        }
//        System.out.println(a[]);
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + a[0] );
        System.out.println("Last Element: " + a[a.length-1]);
    }

//	private static void swap(int i, int j) {
//		// TODO Auto-generated method stub
//		int tmp;
//		tmp = i;
//		i = j;
//		j = tmp;
//		
//	}
}
