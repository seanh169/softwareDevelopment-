package DayFourExercises;

public class Solution {
	public static void main(String[] args) {
		float x = 10;
		float y = 5;
		int z = (int)(x/y);
		switch(z){
			case 2:
				x = x + 2;
			case 1:
				x = x + 3;
			case 3:
				x = x + 3;
			default: 
				x = x + 1;
		}
		System.out.println(x);
		
	}
}
