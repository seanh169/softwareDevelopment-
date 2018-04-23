package ScopeDay13;

public class ScopePractice {
//	int[] z = new int[5];
	
	
	
	
	public static void main(String[] args) {
		int[] z = {1, 2 , 3, 4 ,5 };
		
		for(int i = 0 ; i < z.length-1; i++) {
			for(int j = i + 1; j < z.length; j++) {
				System.out.println(z[i]);
//				System.out.println();
//				System.out.println(z[j]);
			}
			
		}
	}
}
