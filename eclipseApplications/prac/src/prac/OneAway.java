package prac;
//Cracking the code interview pg 201
//One Away - There are three types of edits that can be preformed on strings: insert a character, remove a character,or replace a character.
//Given two strings, write a function to check if they are one edit(or zero edits) away.
//examples:
//pale, ple ---> true
//pales, pale ---->true
//pale, bale ----> true
//pale, bake ----> false
public class OneAway {
	public boolean oneEditAway(String s, String t) {
		//check lengths to see if the difference is either -1(one removal), 1(one addition), or 0(zero inserts or removes)
		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		//Setting two pointers(variables) to hold the shortest and longest length. Need to know which input parameter String is longer.
		String s1 = s.length() < t.length() ? s:t;
		String s2 = s.length() < t.length() ? t:s;
		//Setting two iterators(break cases) for our while loop 
		int idx1 = 0;
		int idx2 = 0;
		//Setting a boolean that will change to true if the chars are not equal twice
		boolean foundDifference = false;
		//Loop through each String, only incrementing the long String if there is a difference.
		//if the difference in the two different Strings happens twice it breaks and we know its not true;
		while(idx2 < s.length() && idx1 < t.length()) {
			if(s1.charAt(idx1) != s2.charAt(idx2)) {
				if(foundDifference) return false;
				foundDifference = true;
				if (s1.length() == s2.length()) {
					idx1++;
				}
			}else {
				idx1++;
			}
			idx2++;
		}
		return true;
	}
	public static void main(String[] args) {
		OneAway n = new OneAway();
		System.out.println(n.oneEditAway("hey", "he"));
	}
	
}
