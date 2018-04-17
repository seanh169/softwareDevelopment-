import java.util.Scanner;

public class Operator {
		
	public static void main(String[] args) {
		Scanner inputFromUser = new Scanner(System.in);
		double mealCost = inputFromUser.nextDouble();
		Scanner inputFromPercent = new Scanner(System.in);
		int tipPercent = inputFromPercent.nextInt();
		Scanner inputFromTax = new Scanner(System.in);
		int taxPercent = inputFromTax.nextInt();
		
		
		
		double tipAmount = (mealCost * tipPercent)/100;
		double taxAmount = (mealCost * taxPercent)/100;
		double totalCost = Math.rint(mealCost + tipAmount +  taxAmount);
		
//		System.out.println("The total meal cost is " + (int) totalCost + " dollars.");
		System.out.println("The total meal cost is " + (int) totalCost + " dollars");
//		System.out.println(tipAmount);
	}

}
