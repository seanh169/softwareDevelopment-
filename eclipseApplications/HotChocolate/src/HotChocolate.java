import java.util.Random;

public class HotChocolate {
	public static final double tooHot = 185;
	public static final double tooCold = 160;
	
	public static void drinkHotChocolate(double cocoaTemp) throws TooHotException, TooColdException {
		if(cocoaTemp >= tooHot) {
			throw new TooHotException();
		}else if (cocoaTemp <= tooCold) {
			throw new TooColdException();
		}
		
	}
	public static void main(String[] args) {
		Random r = new Random();
		double currentCocoaTemp = (double) r.nextInt(250-1) +1;
		System.out.println(currentCocoaTemp);
		try {
			drinkHotChocolate(currentCocoaTemp);
			System.out.println("That cocoa was good!");
		}catch (TooHotException e1) {
			System.out.println("That cocoa was too Hot!");
		}catch (TooColdException e2) {
			System.out.println("That cocoa was too Cold!");
		}
		
		System.out.println("And its gone.");
		
	}

}
