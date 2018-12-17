import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandom {
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int inputArgumentX =  Integer.parseInt(args[0]);
		int inputArgumentY =  Integer.parseInt(args[1]);
		
		int[] generateRandomIntegers = new int[inputArgumentX];
		
		for(int i = 0; i < generateRandomIntegers.length; i++) {
			generateRandomIntegers[i] = ThreadLocalRandom.current().nextInt(0, inputArgumentY+1);
		}
		
		
		System.out.println(Arrays.toString(generateRandomIntegers));
		
		
		

	}
}
