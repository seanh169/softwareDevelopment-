package ProjectOne;


/**
 * 
 * 
 * File Name : InvalidInputException.java
 * Author : Sean Hamilton
 * Date: 09/09/2019
 * Purpose of program: Project 1 CMSC 330 UMUC. Exception class for invalid tokens. 
 * 
 * 
 *
 */

public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public InvalidInputException() {
		super("Invalid Input");
    }
	public InvalidInputException(String input) {
		super(input);
    }
}
