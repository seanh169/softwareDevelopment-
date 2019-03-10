import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WeekSevenDiscussion {
	
	//Give an example of a program that uses the nongeneric version of a class from the STL and the equivalent program that uses the generic version. How do the two implementations differ? Why is having the syntax of generics better?
	
	//NameStore Generic
	
	 HashMap nameAgeLibrary = new HashMap(); 
	 
	 
	 
	 public static void main(String[] args) throws IOException {
			
			Integer userAge = null;
			WeekSevenDiscussion test = new WeekSevenDiscussion();
			Scanner in = new Scanner(System.in);
		
			System.out.println("NAME AGE LIBRARY");
			System.out.println("Continue?[Y/N(or any character other than y)]");
			while(in.hasNext() && (in.nextLine().equalsIgnoreCase("y"))) {
				
				System.out.println("Please enter your name. (q to Quit):" );
				String userName = in.nextLine();
				System.out.println("Please enter your age: " );
				try {
					 userAge = Integer.parseInt(in.nextLine());
			    } catch (IllegalArgumentException e) {
			        e.printStackTrace();
			    }
				test.nameAgeLibrary.put(userName, userAge);
				System.out.println("Summary of Entries: ");
				System.out.println(test.nameAgeLibrary);
				System.out.println("Continue?[Y/N(or any character other than y)]");
			
			}
			
			System.out.println("Exiting..");
			System.exit(1);
			in.close();
	}
	
}

