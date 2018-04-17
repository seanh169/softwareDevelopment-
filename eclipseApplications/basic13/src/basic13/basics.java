package basic13;

import java.util.ArrayList;

//BASIC 13 ALGOS IN JAVA
//1. - Write a method that prints all the numbers from 1 to 255.
public class basics {
	
	private int[] arr;
	public basics(int[] arr) {
		this.arr = arr;
	}
	
	
	public void printOneToTwoFiftyFive() {
		for(int i = 1; i < 256; i++) {
			System.out.println(i);
		}
	}
//2 - Write a method that prints all the odd numbers from 1 to 255.
	public void printOddTo255() {
		for(int i = 1; i < 256; i++) {
			if(i%2 == 1) {
				System.out.println(i);
			}
		}
	}
//3 - Write a method that prints the numbers from 0 to 255, but this time print the 
//sum of the numbers that have been printed so far. For example, your output should 
// be something like this:
	public void printSum() {
		int sum = 0;
		for(int i = 0; i < 256; i++) {
			sum = sum + i;
			System.out.println("New Number: " + i + " Sum: " + sum);
		}
	}
//4 - Given an array X, say [1,3,5,7,9,13], write a method that would iterate through 
// each member of the array and print each value on the screen. Being able to loop 
// through each member of the array is extremely important.
	public void iteration() {
		int[] newArr = {1,3,5,7,9,13};
		for(int i = 0 ; i < newArr.length; i++) {
			
			System.out.println(newArr[i]);
		}
	}
	public void findMax(int[] arr) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	public void getAverage(int[] arr) {
		
		int sum = 0;
		for(int i = 0 ;i < arr.length; i++) {
			sum = sum + arr[i];
			
		}
//		System.out.println(sum);
		float average = sum/arr.length;
		System.out.println(average);
	}
	public void arrayWithOddNumbers() {
		ArrayList newArr = new ArrayList();
		for(int i = 0; i < 256; i++) {
			if(i%2 == 1) {
			newArr.add(i);
			}
		}
		System.out.println(newArr);
	}
	public void greaterThanY(int[] arr, int y) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > y ) {
				count = count + 1;
			}
		}
		System.out.println(count);
	}
	public void squareTheValues(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
			System.out.print(arr[i] + " , ");
		}
		
	}
	@Override
	public String toString() {
		String str = new String();
		for (int idx = 0; idx < this.arr.length; idx++) {
			str += this.arr[idx] + " , ";
		}
		str = str.substring(0, str.length() - 3);
		return str;
	}
	public void elimNegatives(int[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i]< 0) {
				arr[i] = 0;
			}
			System.out.print( arr[i] + " " );
		}
		
	}
	public void maxMinAverage(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		int average = 0;
		int sum = 0;
		for(int i = 0;i < arr.length; i ++) {
			sum = sum + i;
			if(arr[i] < min) {
				min = arr[i];
			}
			else if(arr[i] > max) {
				max = arr[i];
			}
		}
		average = sum/arr.length;
		System.out.print(max + " ");
		System.out.print(min + " ");
		System.out.print(average);
	}
	
	
	
	public static void main(String[] args) {
		int[] y = {5,10,-15,20,30};
		basics n = new basics(y);
//		n.printOneToTwoFiftyFive();
//		n.printOddTo255();
//		n.printSum();
	
//		n.findMax(arr);	
//		n.getAverage(arr);
//		n.arrayWithOddNumbers();
//		n.greaterThanY(y, 9);
//		n.squareTheValues(y);
//		n.printValues(y);
//		System.out.print("\n");
//		System.out.println(n);
//		n.elimNegatives(y);
		n.maxMinAverage(y);
		
	}
	

}
