import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Finalz {
	
	public static void main(String[] args) throws FileNotFoundException {
		List<List<String>> lines = new ArrayList<>();
		List<USCrimeClassOne> crimeObjects = new ArrayList<USCrimeClassOne>();
		Scanner scanner = new Scanner(new File("/Users/SeanH/Downloads/Crime.csv"));
		scanner.useDelimiter(",");
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] lineArray = line.split(",");
			lines.add(Arrays.asList(lineArray));
		}
//		System.out.println(lines);
		for(int i = 1; i< lines.size(); i++) {
			crimeObjects.add(new USCrimeClassOne(Short.parseShort(lines.get(i).get(0)), Long.parseLong(lines.get(i).get(1)), Integer.parseInt(lines.get(i).get(2)), Double.parseDouble(lines.get(i).get(3)), Integer.parseInt(lines.get(i).get(4)), Double.parseDouble(lines.get(i).get(5)), Integer.parseInt(lines.get(i).get(6)), Double.parseDouble(lines.get(i).get(7)), Integer.parseInt(lines.get(i).get(8)), Double.parseDouble(lines.get(i).get(9)), Long.parseLong(lines.get(i).get(10)), Double.parseDouble(lines.get(i).get(11)), Long.parseLong(lines.get(i).get(12)), Double.parseDouble(lines.get(i).get(13)), Long.parseLong(lines.get(i).get(14)), Double.parseDouble(lines.get(i).get(15)), Long.parseLong(lines.get(i).get(16)), Double.parseDouble(lines.get(i).get(16)), Long.parseLong(lines.get(i).get(18)), Double.parseDouble(lines.get(i).get(19))));
//			System.out.println(lines.get(i));
		}
		for(int i = 0 ; i < crimeObjects.size(); i++) {
			
		}
	}

}
