import java.util.Arrays;
import java.util.Random;

public class TwoDArray {
	
	int[][] randNums;
	
	public TwoDArray() {
		
		Random rand = new Random(10);
		randNums = new int[5][10];
		
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 10; j++) {
				randNums[i][j] = rand.nextInt(10);
			}
		}

		System.out.println(Arrays.deepToString(randNums));
	}
	
	public void printTwoDArray() {
		
		for(int i = 0;i<5;i++) {
			for(int j=0; j< 10; j++) {
				System.out.print(randNums[i][j]+" ");
			}
			
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args) {
		TwoDArray z = new TwoDArray();
		z.printTwoDArray();
		
	}
	
	
}
