package ScopeDay13;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Difference {
	private int[] elements;
  	public int maximumDifference;
  	public Difference(int[] elements){
        this.elements = elements;
    }

    public void computeDifference(){
    	int sum = 0;
    	
    	for(int i = 0; i < elements.length-1; i++) {
    		for(int z = i+1; z < elements.length; z++) {
    			int difference = Math.abs(elements[i] - elements[z]);
    			if(difference > sum) {
        			sum = difference;
        		}
    		}
    	maximumDifference = sum;	
    	}
        System.out.println(elements.length);
        System.out.println(maximumDifference);
    }
}
