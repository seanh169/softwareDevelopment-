import java.util.ArrayList;
import java.util.Arrays;

//CHAPTER ONE PRACTICE CRACKING THE CODING INTERVIEW
//1.1 pg. 90 - NEED TO ASK IF IT IS ASCI2 OR UNICODE
public class isUnique {
	String s = "";
	public isUnique(String s) {
		this.s = s;
	}
	
	
	public boolean isUnqiez(String s) {
		if(s.length() > 128) {return false;}
		boolean [] char_set = new boolean[128];
		for(int i = 0; i < s.length(); i++) {
			int val = (int) s.charAt(i);
			if(char_set[val] == true) {
				return false;
			}
			else {
				char_set[val] = true;
			}
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
//		boolean[] arr = new boolean[3];
		String d = "HELLO";
		isUnique n = new isUnique(d);
		System.out.println(n.isUnqiez(d));
	}
	
	
	
	}
	
	
	






