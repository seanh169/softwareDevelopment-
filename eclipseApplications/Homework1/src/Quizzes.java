import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

//Write a method that computes the average of the values in an array of doubles.
//
//The header of the method is as follows:
//
//public static double average(double[] x)

public class Quizzes {
	
	double average;
//	public static double sum;
	
	public static double average(double[] x) {
		
		double sum = 0;
		
		for(int i = 0; i < x.length; i++) {
			sum += x[i]; 
		}
		return sum/x.length;
	}
	
	 public static void main(String args[]){  
		   
		 int[] x = {1, 2, 3};
//		 Quizzes z = new Quizzes();
//		 double[] x = {6.00, 5.00, 7.00};
//		 double[] z = {5.00, 6.00, 7.00};
//		 System.out.println(z.average(x));
//		 System.out.println(x.equals(5.00));
//		 DoubleStream.of(x).allMatch("5.00, 6.00, 7.00"::equals);
//		 Arrays.sort(x);
//		 System.out.println(Arrays.asList(x).contains());
		 
	 }
}