import java.io.FileInputStream;
import java.io.IOException;

public class WeekThreeDisc {
	
	
	
	
	public void readFile() {
		try {
			FileInputStream fis = null;
		    fis = new FileInputStream("B:/myfile.txt"); 
		}catch(IOException e) {
			System.out.print("Error: " + e.getMessage());
			
		}
		
	}
	
	
	//public default contructor. 
	public WeekThreeDisc() {}
	
	

}
