import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Sean Hamilton
 * @date 12/11/2018
 * @purpose Program that reads a csv file, parses the data into USCrimeObjects and then parses the Objects to find relative information.
 *
 */

public class FileReader {
	
	//ArrayList Which holds USCrimeClass Objects
	 static ArrayList<USCrimeClass> z = new ArrayList<>();
	 
	 
		
	 
	 
	public static void main(String[] args) throws FileNotFoundException {
		
		//Format population growth % output
		DecimalFormat df = new DecimalFormat("0.0000");
		//Command line argument taking name of File.
		String fileName = args[0];
		//Root directory for finding file
		String  currentDirectory = new String("./");
		//Scanner to Read File contents.
		Scanner in = new Scanner(new File(currentDirectory + fileName));
		//Setting delimiter
		in.useDelimiter(",");
		//Skipping first line of titles
		in.nextLine();
		//Loop through entire document and create new CrimeClass object with values in each entry.
		while(in.hasNextLine()) {
			
			String line = in.nextLine();
			String[] values = line.split(",");
			z.add(new USCrimeClass(Short.parseShort(values[0]), Long.parseLong(values[1]), Integer.parseInt(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]), Double.parseDouble(values[5]), Integer.parseInt(values[6]), Double.parseDouble(values[7]), Integer.parseInt(values[8]), Double.parseDouble(values[9]), Long.parseLong(values[10]), Double.parseDouble(values[11]), Long.parseLong(values[12]), Double.parseDouble(values[13]), Long.parseLong(values[14]), Double.parseDouble(values[15]), Long.parseLong(values[16]), Double.parseDouble(values[17]), Long.parseLong(values[18]), Double.parseDouble(values[19])));
		}
		
		//New scanner brought in to take userInput.
		Scanner userInput = new Scanner(System.in);
		//Shutoff boolean for entering Q
		boolean endInput = true;
		//Starting timer on elapsed time.
		long start = System.currentTimeMillis()/1000;
		System.out.println("********** Welcome to the US Crime Statistical Application **************************");
		while(endInput) {

			System.out.println("Enter the number of the question you want answered. Enter ‘Q’ to quit the program :");
			System.out.println("1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
			System.out.println("2. What year was the Murder rate the highest?");
			System.out.println("3. What year was the Murder rate the lowest?");
			System.out.println("4. What year was the Robbery rate the highest?");
			System.out.println("5. What year was the Robbery rate the lowest?");
			System.out.println("6. What year was the Burglary rate rate the highest?");
			System.out.println("7. What year was the Burglary rate rate the lowest?");
			System.out.println("Q. Quit the program");
			String userAnswer = userInput.nextLine().toLowerCase();
			if(userAnswer.equals("1")) {
				System.out.println("Population Growth for 1994-1995: " + df.format(getPopulationGrowth().get(0)) + "%");
				System.out.println("Population Growth for 1995-1996: " + df.format(getPopulationGrowth().get(1)) + "%");
				System.out.println("Population Growth for 1996-1997: " + df.format(getPopulationGrowth().get(2)) + "%");
				System.out.println("Population Growth for 1997-1998: " + df.format(getPopulationGrowth().get(3)) + "%");
				System.out.println("Population Growth for 1998-1999: " + df.format(getPopulationGrowth().get(4)) + "%");
				System.out.println("Population Growth for 1999-2000: " + df.format(getPopulationGrowth().get(5)) + "%");
				System.out.println("Population Growth for 2000-2001: " + df.format(getPopulationGrowth().get(6)) + "%");
				System.out.println("Population Growth for 2001-2002: " + df.format(getPopulationGrowth().get(7)) + "%");
				System.out.println("Population Growth for 2002-2003: " + df.format(getPopulationGrowth().get(8)) + "%");
				System.out.println("Population Growth for 2003-2004: " + df.format(getPopulationGrowth().get(9)) + "%");
				System.out.println("Population Growth for 2004-2005: " + df.format(getPopulationGrowth().get(10)) + "%");
				System.out.println("Population Growth for 2005-2006: " + df.format(getPopulationGrowth().get(11)) + "%");
				System.out.println("Population Growth for 2006-2007: " + df.format(getPopulationGrowth().get(12)) + "%");
				System.out.println("Population Growth for 2007-2008: " + df.format(getPopulationGrowth().get(13)) + "%");
				System.out.println("Population Growth for 2008-2009: " + df.format(getPopulationGrowth().get(14)) + "%");
				System.out.println("Population Growth for 2009-2010: " + df.format(getPopulationGrowth().get(15)) + "%");
				System.out.println("Population Growth for 2010-2011: " + df.format(getPopulationGrowth().get(16)) + "%");
				System.out.println("Population Growth for 2011-2012: " + df.format(getPopulationGrowth().get(17)) + "%");
				System.out.println("Population Growth for 2012-2013: " + df.format(getPopulationGrowth().get(18)) + "%");
				
			}
			//Logic for user entries
			if(userAnswer.equals("2")) {
				System.out.println("The year with the highest Murder Rate: " + getMaxMurderRate());
			}
			if(userAnswer.equals("3")) {
				System.out.println("The year with the lowest Murder Rate: " + getMinMurderRate());
				
			}
			if(userAnswer.equals("4")) {
				System.out.println("The Year with the highest Robbery Rate: " + getMaxRobberyRate());
			}
			if(userAnswer.equals("5")) {
				System.out.println("The year with the lowest Robbery Rate: " + getMinRobberyRate());
			}
			if(userAnswer.equals("6")) {
				System.out.println("The Year with the highest Burglary Rate: " + getMaxBurglaryRate());
			}
			if(userAnswer.equals("7")) {
				System.out.println("The Year with the lowest Burglary Rate: " + getMinBurglaryRate());
			}
			if(userAnswer.equals("Q")|| userAnswer.equals("q")) {
				long finish = System.currentTimeMillis()/1000;
				endInput = false;
				userInput.close();
				System.out.println("Thank you for trying the US Crimes Statistics Program");
				System.out.println("Elapsed Time in Seconds Was: " + (finish-start));
			}
			
		}
	}
	//Methods for logic on what to do with user entries.
	static public ArrayList<Double> getPopulationGrowth() {
		 
		 ArrayList<Double> returnNumbers = new ArrayList<>();
		 for(int i = 0 ; i < z.size()-1; i++) {
			 double x = ((z.get(i+1).population-z.get(i).population));
				double y = z.get(i).population;
				double result = (x/y)*100;
				returnNumbers.add(result);
		 }
		 return returnNumbers;
		 
	 }
	static public short getMaxMurderRate() {
		double max = 0;
		short returnYear = 0;
		for(int i = 0; i < z.size(); i++) {
			if(z.get(i).murderNNMSrate > max) {
				max = z.get(i).murderNNMSrate;
				returnYear = z.get(i).year;
			}
		}
		return returnYear;
	}
	static public short getMinMurderRate() {
		double min = z.get(0).murderNNMSrate;
		short returnYear=0;
		for(int i = 0 ; i< z.size(); i++) {
			if(z.get(i).murderNNMSrate < min) {
				min = z.get(i).murderNNMSrate;
				returnYear = z.get(i).year;
			}
		}
		return returnYear;
	}
	static public short getMaxRobberyRate() {
		double max = 0;
		short returnYear = 0;
		for(int i=0; i < z.size(); i++) {
			if(z.get(i).robberyRate > max) {
				max = z.get(i).robberyRate;
				returnYear = z.get(i).year;
			}
		}
		return returnYear;
	}
	static public short getMinRobberyRate() {
		short returnYear = 0;
		double min = z.get(0).robberyRate;
		for(int i = 0 ; i < z.size(); i++) {
			if(z.get(i).robberyRate < min) {
				min = z.get(i).robberyRate;
				returnYear = z.get(i).year;
			}
		}
		return returnYear;
	}
	static public short getMaxBurglaryRate() {
		short returnYear = z.get(0).year;
		double max = z.get(0).burglaryRate;
		for(int i = 0; i < z.size(); i++) {
			if(z.get(i).burglaryRate > max) {
				max = z.get(i).burglaryRate;
				returnYear = z.get(i).year;
			}
		}
		return returnYear;
	}
	static public short getMinBurglaryRate() {
		short returnYear = z.get(0).year;
		double max = z.get(0).burglaryRate;
		for(int i = 0; i < z.size(); i++) {
			if(z.get(i).burglaryRate < max) {
				max = z.get(i).burglaryRate;
				returnYear = z.get(i).year;
			}
		}
		return returnYear;
	}
	
	
	
}
