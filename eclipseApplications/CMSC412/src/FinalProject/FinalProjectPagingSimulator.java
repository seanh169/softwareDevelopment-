package FinalProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**
 * 
 * 
 * File Name : FinalProjectPagingSimulator.java
 * Author : Sean Hamilton
 * Date: 12/12/2019
 * Purpose of program: CMSC 412 UMUC Final Project. 
 * 
 * Requirements: Design and implement and Demag Paging virtual memory simulator. 
 * 
 * 
 *
 */

class FinalProjectPagingSimulator {
	
	//Main method. Holds all logic for user selections and orchestrates the u
	public static void main(String[] args) {
		//logic to parse command line input based upon project requirements. 
		if (args.length < 1) {
			System.out.println("Physical frames must be input as a command line argument.");
			System.exit(-1);
		}
		if (args.length > 1) {
			System.out.println("This program only accepts one command line argument.");
		}
		int n = -1;
		try {
			n = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			System.out.println("Command line argument must be an integer.");
			System.exit(-1);
		}
		if (n > 7 || n < 1) {
			System.out.println("Please enter between 1 and 7 physical frames.");
			System.exit(-1);
		}
		int inputFrameAmount = n;
		System.out.println("Page Frames obtained from comamnd inputLine arguments: " + inputFrameAmount);

		//Scanner for accepting user input
		Scanner in = new Scanner(System.in);
		//Input line from user 
		String inputLine; 
		ReferenceInput referenceInput = null;
		PagingSimulation pagingSim;


		//Main loop with all necessary options per requirements.
		while (true) {
			System.out.println("Choose one (Press 0 to exit): ");
			System.out.println("0 - Exit");
			System.out.println("1 - Read reference string");
			System.out.println("2 - Generate reference string");
			System.out.println("3 - Display current reference string");
			System.out.println("4 - Simulate FIFO");
			System.out.println("5 - Simulate OPT");
			System.out.println("6 - Simulate LRU");
			System.out.println("7 - Simulate LFU");
			System.out.println();

			
			inputLine = in.next();
			in.nextLine();
			
			// Logic using switch statement for input per project requirements.
			switch (inputLine) {
				case "0":
				System.out.println("Exiting...");
				System.exit(0);
				break;
				case "1":
				referenceInput = parseInputRefString(in);
				if (referenceInput != null) {
					System.out.print("Reference String Input Successful!");
				} else {
					System.out.println("You have entered an invalid reference string. Please enter a valid reference string.");
				}
				break;
				case "2":
				System.out.println("Reference string size?");
				int inputStringLength;
				inputStringLength = in.nextInt();
				referenceInput = parseReferenceString(inputStringLength, 10);
				if (referenceInput != null) {
					System.out.print("Valid reference string saved: ");
					referenceInput.print();
					System.out.print(".");
				} else {
					System.out.println("Invalid reference string. Please try again.");
				}
				break;
				case "3":
				if (referenceInput != null) {
					System.out.print("Displaying current reference string: ");
					referenceInput.print();
				} else {
					System.out.println("Reference string empty. Please enter a reference string.");
				}
				break;
				case "4":
				if (referenceStringSet(referenceInput)) {
					pagingSim = new PagingSimulation(referenceInput, inputFrameAmount, 10);
					pagingSim.processSimulation("FIFO");
					pagingSim.print();
				}
				break;
				case "5":
				if (referenceStringSet(referenceInput)) {
					pagingSim = new PagingSimulation(referenceInput, inputFrameAmount, 10);
					pagingSim.processSimulation("OPT");
					pagingSim.print();
				}
				break;
				case "6":
				if (referenceStringSet(referenceInput)) {
					pagingSim = new PagingSimulation(referenceInput, inputFrameAmount, 10);
					pagingSim.processSimulation("LRU");
					pagingSim.print();
				}
				break;
				case "7":
				if (referenceStringSet(referenceInput)) {
					pagingSim = new PagingSimulation(referenceInput, inputFrameAmount, 10);
					pagingSim.processSimulation("LFU");
					pagingSim.print();
				}
				break;
				default:
				break;
			} 
		} 
	} 

	public static ReferenceInput parseInputRefString(Scanner in) {
		System.out.println("Reference String: ");
		ArrayList<Integer> inputReferArr = new ArrayList<Integer>();
		ReferenceInput referenceInput = null;

		do {
			String inputLine = in.nextLine();
			Scanner inputLineScanner = new Scanner(inputLine);
			String inputIterator;
			int inputIteratorInt = -1;
			boolean isIntValid;
			while (inputLineScanner.hasNext()) {
				inputIterator = inputLineScanner.next();
				isIntValid = false;
				try {
					inputIteratorInt = Integer.parseInt(inputIterator);
					isIntValid = true;
				} catch (NumberFormatException e) {
					System.out.println("Must be an integer - \"" + inputIterator + "\" is not an integer.");
				}
				if (isIntValid && (inputIteratorInt < 0 || inputIteratorInt >= 10)) {
					System.out.println("Input must be between 0 and 9.");
				} else if (isIntValid) {
					inputReferArr.add(inputIteratorInt);
				}
			}
			if (inputReferArr.size() < 1) {
				System.out.println("Please enter a valid integer between 0 and 9.");
			}
		} while (inputReferArr.size() < 1);
		referenceInput = new ReferenceInput(inputReferArr);
		return referenceInput;
	}

	//Method that parses reference string into Array of Integers. 
	public static ReferenceInput parseReferenceString(int n, int maxInput) {
		if (n < 1) {
			System.out.println("Reference string must be of greater length than 1.");
			return null;
		}
		Random randomOutput = new Random();
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			intArray.add(randomOutput.nextInt(maxInput));
		}
		ReferenceInput referenceInput = new ReferenceInput(intArray);
		return referenceInput;
	}
	
	//Method used to avoid repeating code on validating user input reference string. 
	public static boolean referenceStringSet(ReferenceInput referenceInput) {
		if (referenceInput != null) {
			return true;
		}
		System.out.println("Reference string empty. Please enter a reference string.");
		return false;
	}
}
