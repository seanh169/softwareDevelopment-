import java.io.IOException;

public class ExceptionsPractice {
	
	
	public static void main(String[] args) {
		try {
			int[] c = new int[5];
			c[2] = (Integer) 3;
			System.out.println("Element 6 at index 5 = " + c[11]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown " + e);
			
		}
		finally {
		System.out.println("Finally clause");
	}
}
}
