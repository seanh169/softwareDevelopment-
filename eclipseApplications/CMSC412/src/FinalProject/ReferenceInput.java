package FinalProject;

import java.util.ArrayList;

/**
 * 
 * 
 * File Name : ReferenceInput.java
 * Author : Sean Hamilton
 * Date: 12/12/2019
 * Purpose of program: CMSC 412 UMUC Final Project. Helper class to properly parse the reference string.
 * 
 * 
 * 
 * 
 *
 */

class ReferenceInput {
	ArrayList<Integer> givenReferenceString; 

	ReferenceInput() {
		givenReferenceString = new ArrayList<Integer>();
	}

	ReferenceInput(ArrayList<Integer> referenceInput) {
		givenReferenceString = referenceInput;
	}

	public int getLength() {
		return givenReferenceString.size();
	}
	public int getAtIndex(int i) {
		return givenReferenceString.get(i);
	}
	public void print() {
		int i;
		for (i = 0; i < givenReferenceString.size() - 1; i++) {
			System.out.print(givenReferenceString.get(i) + " ");
		}
		System.out.print(givenReferenceString.get(i));
	}
}

