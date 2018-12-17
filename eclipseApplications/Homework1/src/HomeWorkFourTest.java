import java.util.Scanner;

public class HomeWorkFourTest {
	
	
		
		
		public static void main(String[] args) {
			
			HomeWorkFour testOne = new HomeWorkFour();
			HomeWorkFour testTwo = new HomeWorkFour();
			HomeWorkFour testThree = new HomeWorkFour();
			
			// Instantiate a scanner listening to the System class in. 
			Scanner in = new Scanner(System.in);
			
			// Declare boolean breakpoint for taking user input and displaying result message.
			boolean endInputOne = true;
			boolean endInputTwo = true;
			boolean endInputThree = true;
			//Start while loop taking user input.
			System.out.println("*******TEST ONE*******");
			while(endInputOne) {
				
				
				System.out.println("Enter a State or None to exit:");
				String userState = in.nextLine().replace(" ", "").toLowerCase();
				
				//Instantiate method from HomeWorkFour class to do comparison. 
				testOne.compareToState(userState);
				
				//Logic for break point and result message.
				if(userState.equals("none")) {
					endInputOne = false;
					System.out.println("**** Thank you ****");
					System.out.println("A summary report for each State, Bird, and Flower is: ");
					System.out.println(testOne.returnStorage.toString().replace("[", "").replace("]", ""));

					System.out.println("Please visit our site again!");
					System.out.println("*******END OF TEST ONE*******"+"\n" );
					testOne.returnStorage.clear();
				}
	
				
			}
			System.out.println("*******START TEST TWO*******");
			while(endInputTwo) {
				
				
				System.out.println("Enter a State or None to exit:");
				String userState = in.nextLine().replace(" ", "").toLowerCase();
				
				//Instantiate method from HomeWorkFour class to do comparison. 
				HomeWorkFour.compareToState(userState);
				
				//Logic for break point and result message.
				if(userState.equals("none")) {
					endInputTwo = false;
					System.out.println("**** Thank you ****");
					System.out.println("A summary report for each State, Bird, and Flower is: ");
					System.out.println(testTwo.returnStorage.toString().replace("[", "").replace("]", ""));

					System.out.println("Please visit our site again!");
					System.out.println("*******END OF TEST TWO*******"+"\n");
					testTwo.returnStorage.clear();
				}
	
				
			}
			
			System.out.println("\n" + "*******START TEST THREE*******");
			while(endInputThree) {
				
				
				System.out.println("Enter a State or None to exit:");
				String userState = in.nextLine().replace(" ", "").toLowerCase();
				
				//Instantiate method from HomeWorkFour class to do comparison. 
				testThree.compareToState(userState);
				
				//Logic for break point and result message.
				if(userState.equals("none")) {
					endInputThree = false;
					System.out.println("**** Thank you ****");
					System.out.println("A summary report for each State, Bird, and Flower is: ");
					System.out.println(testThree.returnStorage.toString().replace("[", "").replace("]", ""));

					System.out.println("Please visit our site again!");
					System.out.println("\n" + "*******END OF TEST THREE*******");
					testThree.returnStorage.clear();
				}
	
				
			}
			
			
			
			
			
		}
		
	}


