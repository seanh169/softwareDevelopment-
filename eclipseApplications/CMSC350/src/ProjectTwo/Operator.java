package ProjectTwo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * 
 * File Name : Operator.java
 * Author : Sean Hamilton
 * Date: 06/13/2019
 * Purpose of program: Project 2 CMSC 350 UMUC. This is the class that represents an Operator for the expression tree. Implements Node interface
 * for inheritance and also processes each line for the output text file. I thought it would be best to put a lot of that logic here due to
 * how the algorithm works. 
 * 
 * 
 *
 */


public class Operator implements Node {
	
	//private variables declared per project requirements. 
	private String data;
    private Node next;
    private Node prev;
    private static int registerCounter;
    
    //Defining desktop location using System super class.
    String desktop = System.getProperty("user.home") + "/Desktop/";
    //Writes necessary file to desktop.
    private File file = new File(desktop + "ProjectTwo.txt"); // creates 3-Address text file on users Desktop

    // main constructor used for creating an Operator. Holds the data for the current operator as well as the previos and next nodes.
    Operator(String data, Node right, Node left) {
    	convertToOperatorString(data);
        this.data = data;
        this.next = right;
        this.prev = left;
        
    }

    //method captures current Infix expression in the proper format.
    public String nodeData() {
//        return "(" + prev.traversalFor() + " " + data + " " + next.traversalFor() + ")";
    	 return "(" + prev.nodeData() + " " + data + " " + next.nodeData() + ")";
    }

   //method that starts tree traversal
    public void writeToFile() throws IOException {
    	registerCounter = 0;       
        traversalBac();  
    }

    // Traverse data structure in Post order. Capture each line of output file and write to file.
    public String traversalBac() throws IOException {
        String prevValue = prev.traversalBac();
        String nextValue = next.traversalBac();
        String currentOperatorPhrase = convertToOperatorString(this.data);

        //Generate line needed for file.
        String lineInFile = currentOperatorPhrase + " " + "R" + registerCounter++ + " " + prevValue + " " + nextValue;
        //Write to file, then create new line, and close.
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(lineInFile);
        writer.newLine();
        writer.close();

        return "R" + registerCounter++;
    }
    
    //helper method that takes the current operator and returns a string used in the output text file.
    private String convertToOperatorString(String data) {
        String currentOperator = "";
        if(data.equals("+")) {
        	currentOperator = "Add";
        }else if(data.equals("-")) {
        	currentOperator = "Sub";
        }else if(data.equals("*")) {
        	currentOperator = "Mul";
        }else {
        	currentOperator = "Div";
        }
        return currentOperator;
    }

    
    //Below are getters and setters for private variables. Project did not state in requirements whether or not these classes are meant to be Immutable. 
    //If they are , these getters and setters are to be deleted. 
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public static int getRegisterCounter() {
		return registerCounter;
	}

	public static void setRegisterCounter(int registerCounter) {
		Operator.registerCounter = registerCounter;
	}
    
    

	

}
