import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readFileWO {
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		File file = new File("/Users/SeanH/Downloads/discussion.dat");
		
		Scanner x = new Scanner(file);
		
		int counter = 0;  
		
		while(x.hasNextLine()) {
			
			int line = x.nextInt();
			
			System.out.println("File Contents: " + line);
			
			counter++;
			
		}
		
		System.out.println("There are  " + counter + " entries of data.");
		
	}

}
