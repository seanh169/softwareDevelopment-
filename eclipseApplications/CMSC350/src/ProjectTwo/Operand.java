package ProjectTwo;

import java.io.IOException;

/**
 * 
 * 
 * File Name : Operand.java
 * Author : Sean Hamilton
 * Date: 06/13/2019
 * Purpose of program: Project 2 CMSC 350 UMUC. This is the class that represents an Operand for the expression tree. Implements Node interface
 * for inheritance. 
 * 
 * 
 * 
 *
 */

public class Operand implements Node {
	
	private String data;
	
	public Operand(String data) {
		this.data = data;
	}


	public String nodeData() {

		return data;
	}


	public String traversalBac() throws IOException {

		return data;
	}

	@Override
	public void writeToFile() throws IOException {
		
	}

    //Below are getters and setters for private variables. Project did not state in requirements whether or not these classes are meant to be Immutable. 
    //If they are , these getters and setters are to be deleted. 
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
}
