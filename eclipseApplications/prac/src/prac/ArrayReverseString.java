package prac;

public class ArrayReverseString {
	public static void main(String[] args) {
		String s = "hello";
		int last = s.length()-1;
		StringBuilder n = new StringBuilder();
		n.append(s);
		System.out.println(n.reverse());
//		int[] arr = new int[s.length()];
//		System.out.print(last);
//		for(int i = last ; i >= 0 ; i--) {
//			System.out.print(s.charAt(i));
//			
//	}
}
}
