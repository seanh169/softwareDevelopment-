
// 1.2 pg 90 cracking the coding interview
//Check Permuation - Given Two Strings, write a method to decide if one is a permuation of the other.
//Two Questions to ASk - IS IT CASE SENSITIVE? DOES WHITESPACE MATTER?
public class checkPermuation {
	String t = "";
	String s = "";
	public checkPermuation(String s , String t) {
		this.s = s;
		this.t= t;
	}
	public checkPermuation() {
		// TODO Auto-generated constructor stub
	}
	public boolean Permutation(String t, String s) {
		if(t.length() != s.length()) {
			return false;
		}
		//Below Code is for ASCII REGULAR
		int[] newArr = new int[128];
		for(int i = 0; i < s.length(); i ++) {
			newArr[s.charAt(i)]++;
		}
		for(int i = 0; i < t.length(); i++) {
			newArr[t.charAt(i)]--;
			if(newArr[t.charAt(i)] < 0) {
				return false;
			}
		
		}
	
	return true;
}
		public static void main(String[] args) {
			checkPermuation n = new checkPermuation();
			System.out.println(n.Permutation("hello", "llexh"));
			System.out.println(n.Permutation("DAD", "ADD"));
		}
}