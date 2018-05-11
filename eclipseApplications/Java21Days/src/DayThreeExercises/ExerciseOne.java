package DayThreeExercises;

import java.util.Scanner;
import java.util.StringTokenizer;

//Assignment : Create a program that turns a birthday in MM/DD/YYYY format(such as 04/29/2013) into three individual Strings.

public class ExerciseOne {
	public static void main(String[] args) {
		
		StringTokenizer n = new StringTokenizer("04/29/2013", "/");
		System.out.println("String 1: " + n.nextToken());
		System.out.println("String 2: " + n.nextToken());
		System.out.println("String 3: " + n.nextToken());
		
	}
}
