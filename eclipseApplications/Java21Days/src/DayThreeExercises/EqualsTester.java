package DayThreeExercises;

public class EqualsTester {
	public static void main(String[] args) {
		String st1, st2;
		st1 = "Free the bound periodicals";
		st2 = st1;
		
		System.out.println("String 1: " + st1);
		System.out.println("String 2: " + st2);
		System.out.println("Same Object? " + (st1==st2));
		st2 = new String(st1);
		
		System.out.println("String 1: " + st1);
		System.out.println("String 2: " + st2);
		System.out.println("Same Object? " + (st1==st2));
		System.out.println("Same Value? " + (st1.equals(st2)));
//		System.out.println(new EqualsTester().getClass().hashCode());
	}
}
