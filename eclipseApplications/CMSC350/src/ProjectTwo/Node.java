package ProjectTwo;

import java.io.IOException;

/**
 * 
 * 
 * File Name : Node.java
 * Author : Sean Hamilton
 * Date: 06/13/2019
 * Purpose of program: Project 2 CMSC 350 UMUC. This interface holds attributes for creating the operands and operators nodes. Fulfilling project 
 * requirements and demonstrating the inheritance advantages of interfaces. 
 * 
 * 
 *
 */

public interface Node {
	
	//public and abstract
	void writeToFile() throws IOException;
	String traversalBac() throws IOException;
	String nodeData();
	

}
