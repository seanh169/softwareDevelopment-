import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalProjectOne {
	
	

	
	
	public static void main(String[] args) {
		BufferedReader inputStream = null;
		List<List<String>> lines = new ArrayList<>();
		
		ArrayList<USCrimeClassOne> crimeObjects = new ArrayList<USCrimeClassOne>();

        String fileLine;
        try {
            inputStream = new BufferedReader(new FileReader("/Users/SeanH/Downloads/Crime.csv"));

            
            
            while ((fileLine = inputStream.readLine()) != null) {
            	int iteration = 0;
//            	USCrimeClass z = new USCrimeClass();
//            		z.setYear(fileLine.);
//                if(iteration == 0) {
//                	 iteration++;
//                	 continue;
//                }
            		
            		String[] values = fileLine.split(",");
            		lines.add(Arrays.asList(values));
//            		z.year = Short.parseShort(values[0]);	
            		
//            		crimeObjects.add(z);
//            		USCrimeClass z = new USCrimeClass(Short.parseShort(values[0]), Long.parseLong(values[1]), Integer.parseInt(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), Double.parseDouble(values[5]), Integer.parseInt(values[6]), Double.parseDouble(values[7]), Integer.parseInt(values[8]), Double.parseDouble(values[9]), Long.parseLong(values[10]), Double.parseDouble(values[11]), Long.parseLong(values[12]), Double.parseDouble(values[13]), Long.parseLong(values[14]), Double.parseDouble(values[15]), Long.parseLong(values[16]), Double.parseDouble(values[17]), Long.parseLong(values[18]), Double.parseDouble(values[19]));
//            		System.out.println(z);
//            		crimeObjects.add(z);
//            		crimeObjects.add(new USCrimeClass(Short.parseShort(values[0]), Long.parseLong(values[1]), Integer.parseInt(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), Double.parseDouble(values[5]), Integer.parseInt(values[6]), Double.parseDouble(values[7]), Integer.parseInt(values[8]), Double.parseDouble(values[9]), Long.parseLong(values[10]), Double.parseDouble(values[11]), Long.parseLong(values[12]), Double.parseDouble(values[13]), Long.parseLong(values[14]), Double.parseDouble(values[15]), Long.parseLong(values[16]), Double.parseDouble(values[17]), Long.parseLong(values[18]), Double.parseDouble(values[19])));
            		
            		
            }
            USCrimeClassOne z = new USCrimeClassOne();
            
//            System.out.println(crimeObjects);
//            System.out.println(lines);
            for(int i = 1; i < lines.size(); i++) {
//            		z.year = Short.parseShort(lines.get(i).get(0));
   
            		System.out.println(lines.get(i).get(0));
//            	crimeObjects.add(new USCrimeClass(Short.parseShort(lines.get(i).get(0)), Long.parseLong(lines.get(i).get(1)), Integer.parseInt(lines.get(i).get(2)), Double.parseDouble(lines.get(i).get(3)), Integer.parseInt(lines.get(i).get(4)), Double.parseDouble(lines.get(i).get(5)), Integer.parseInt(lines.get(i).get(6)), Double.parseDouble(lines.get(i).get(7)), Integer.parseInt(lines.get(i).get(8)), Double.parseDouble(lines.get(i).get(9)), Long.parseLong(lines.get(i).get(10)), Double.parseDouble(lines.get(i).get(11)), Long.parseLong(lines.get(i).get(12)), Double.parseDouble(lines.get(i).get(13)), Long.parseLong(lines.get(i).get(14)), Double.parseDouble(lines.get(i).get(15)), Long.parseLong(lines.get(i).get(16)), Double.parseDouble(lines.get(i).get(16)), Long.parseLong(lines.get(i).get(18)), Double.parseDouble(lines.get(i).get(19))));
            }
//           System.out.println(crimeObjects.get(0).getYear());
        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        }finally {
            // Need another catch for closing 
            // the streams          
            try {               
                if (inputStream != null) {
                inputStream.close();
            }                
            } catch (IOException io) {
                System.out.println("Issue closing the Files" + io.getMessage());
            }
        
        }
//     
        for(int i = 0 ; i < crimeObjects.size(); i++) {
//        		System.out.println(crimeObjects.get(i));
        }
			
			

	}
	
	public FinalProjectOne() {}

}
