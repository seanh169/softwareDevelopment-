package DayThreeExercises;

import java.awt.Point;

public class RefTester {
	public static void main(String[] arguments) {
	Point pt1, pt2;
	pt1 = new Point();
	pt2 = pt1;
	pt1.x =  200;
	pt1.y = 200;
	System.out.println("Point1: " + pt1.x + ", " + pt1.y);
	pt1.setLocation(200, 300);
	System.out.println(pt1.x + " " + pt1.y);
		
		
		
	}
	
	
	

}
