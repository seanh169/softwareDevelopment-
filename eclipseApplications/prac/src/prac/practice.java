package prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice {
	public static void main(String[] args) {
		 	  //Hackerrank day 3 conditionals
		      Scanner scan = new Scanner(System.in);
		      int n = scan.nextInt(); 
		      scan.close();
		      String ans="";
		          
		      // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
		      if(n%2==1){
		         ans = "Weird";
		      }
		      else if(n%2 == 0 && n>=2 && n <= 5){
		          ans = "Not Weird";
		      }
		      else if(n%2 == 0 && n >= 6 && n <= 20) {
		    	  ans = "Weird";
		      }
		      else if(n%2 == 0 && n > 20) {
		    	  ans = "Not Weird";
		      }
		      System.out.println(ans);
		      Queue<Character> charQue = new LinkedList<Character>();
		      charQue.remove();
	}
	public practice() {};
}
