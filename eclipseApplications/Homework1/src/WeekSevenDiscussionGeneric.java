import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeekSevenDiscussionGeneric {
	
	Map<String, Object> nameAgeLibrary = new HashMap<String, Object>();
	
	public static void main(String[] args) throws IOException {
		
		Integer userAge = null;
		WeekSevenDiscussionGeneric test = new WeekSevenDiscussionGeneric();
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