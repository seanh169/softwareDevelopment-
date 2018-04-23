package DayTwoExercises;

public class Exercises {
	public void findVals(double n, double m) {
		System.out.println(n/m);
		System.out.println(n%m);
	}
	public void findValue(double investment) {
		
		double firstYear = investment * 1.4;
		double secondYear = firstYear - 1500;
		double thirdYear = secondYear * 1.12;
//		thirdYear = investment;
		System.out.println((float) thirdYear);
	}
	public static void main(String[] args) {
		
	
	
//	int n = 3;
//	int m = 4;
	
		
	Exercises x = new Exercises();
//	x.findVals(10, 2);
	x.findValue(14000);
//	System.out.println();
	
	
//	System.out.println( (float) thirdYear);
	}
}
