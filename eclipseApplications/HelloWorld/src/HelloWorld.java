import java.util.Scanner;

public class HelloWorld {
	static String a = new String("Hello");
	public static void main(String[] args) {
//		Scanner in = new Scanner(in);
		
		System.out.println(a.hashCode());
		String b = new String("Hello");
		System.out.println(b.hashCode());
		
		System.out.println(a.equals(b));
		System.out.println(a);
	}
}
