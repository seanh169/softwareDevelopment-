package Recursion;

//Triangular.java
import java.util.*;
class Triangular {
 public static int recursiveTriangular(int n) {
    if (n == 1)
	 return 1;  
    return recursiveTriangular(n-1) + n; 
 }

 public static void main(String args[]) {
    Scanner stdin = new Scanner(System.in);
    System.out.print("Please enter a number: ");
    int n = stdin.nextInt();
    System.out.println("The " + n + "-th triangular number is: " + 
                           recursiveTriangular(n)); 
 }
}
