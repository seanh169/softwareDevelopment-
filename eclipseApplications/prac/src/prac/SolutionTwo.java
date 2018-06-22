package prac;
import java.io.*;
import java.util.*;

public class SolutionTwo {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        Integer returnDateDay = in.nextInt();
        Integer returnDateMonth = in.nextInt();
        Integer returnDateYear = in.nextInt();
        Integer expectedDateDay = in.nextInt();
        Integer expectedDateMonth = in.nextInt();
        Integer expectedDateYear = in.nextInt();
        in.close();
        // Integer fine = 0;
        
       if(returnDateDay.intValue() == expectedDateDay.intValue() && returnDateMonth.intValue() == expectedDateMonth.intValue() && returnDateYear.intValue() == expectedDateYear.intValue()) {
    	   System.out.println(0);
       }else if (returnDateDay.intValue() != expectedDateDay.intValue() && returnDateMonth.intValue() == expectedDateMonth.intValue() && returnDateYear.intValue() == expectedDateYear.intValue()) {
    	   System.out.println(15 * (returnDateDay.intValue()-expectedDateDay.intValue()));
       }else if (returnDateMonth.intValue() > expectedDateMonth.intValue() && returnDateYear.intValue() == expectedDateYear.intValue()) {
    	   System.out.println(500 * (returnDateMonth.intValue() - expectedDateMonth.intValue()));
       }else if (returnDateYear.intValue() > expectedDateYear.intValue()) {
    	   System.out.println(10000);
       }else if (returnDateYear.intValue() < expectedDateYear.intValue() || returnDateMonth.intValue() < expectedDateMonth.intValue() || returnDateDay.intValue() < expectedDateDay.intValue()) {
    	   System.out.println(0);
       }
        
        
        
        
        
        
        
        
        
        
//        System.out.println(returnDateDay == expectedDateDay);
//       System.out.println(returnDateMonth == expectedDateMonth);
//       System.out.println(returnDateYear.intValue() == expectedDateYear.intValue());
//
////       System.out.println(expectedDateDay);
//       System.out.println(returnDateYear);
//       System.out.println(expectedDateYear);
    
    
    
    }
}
