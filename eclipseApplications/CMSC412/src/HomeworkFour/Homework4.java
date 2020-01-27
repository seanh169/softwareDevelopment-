package HomeworkFour;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * 
 * File Name : Homework4.java
 * Author : Sean Hamilton
 * Date: 11/15/2019
 * Purpose of program: Homework 4 CMSC 412 UMUC. Solution. 
 * 
 * Requirements: 
 * 
 * Implement the Banker's algorithm for deadlock avoidance, that works on a given set of N processes and
 * M resource types (N<10,M<10). Use C/C++/C# or Java for the implementation, with a simple text
 * interface, where the user enters only the name of the input file (text only). The program reads all the
 * necessary input data from that file.
 * The input data and result is then displayed on the screen.
 * You may use your program to validate the example you gave in the Week 4 discussion.
 * 
 *
 */

public class Homework4 {
	
	
	
	//Main method
	public static void main(String[]args)throws IOException,FileNotFoundException{
		
        // variables
		int [] totalVectorResources;
	    int [] availableVector;
	    int [] orderProcesses;
        int [] columsAdded;
        int [] rowsAdded;
        int [] currAvailIteration;
        int numberOfProcesses = 0;
        int numberOfResources = 0;
        int curLine = 0;  
        int idxIteration = 0;
        boolean complBoolArr[];
        int [][] maxResourceClaim;
        int [][] allocationInput;
        int [][] remainingNeed;
        boolean isSequenceSafe = false;
        String line;
        String inputFileName;
        StringTokenizer lines;
        
        //Start reading text file
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.print("File Name(Must be on Desktop) : ");
        inputFileName = input.nextLine();
        FileReader fileReader = new FileReader("/Users/SeanH/Desktop/" + inputFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();
        numberOfProcesses = Integer.parseInt(line);
        line = bufferedReader.readLine();
        numberOfResources = Integer.parseInt(line);

       

        //Storage for processes and resources. Algorithm and 2d matrix idea from G4G. 

        maxResourceClaim = new int[numberOfProcesses][numberOfResources];

        allocationInput = new int[numberOfProcesses][numberOfResources];

        remainingNeed = new int [numberOfProcesses][numberOfResources];

        totalVectorResources = new int[numberOfResources];

       

 

        availableVector = new int[numberOfResources];

       

        currAvailIteration = new int[numberOfResources];

        complBoolArr = new boolean[numberOfProcesses];

       

        orderProcesses = new int[numberOfProcesses];

        columsAdded = new int[numberOfResources];

        rowsAdded = new int[numberOfProcesses];

        line = bufferedReader.readLine();


        while(line != null && curLine < numberOfProcesses){

             lines = new StringTokenizer(line);
             if(lines.hasMoreTokens()){
                  for(int j = 0; j < numberOfResources; j++){
                  maxResourceClaim[curLine][j]=Integer.parseInt(lines.nextToken());  
                  }  
             }  
             line = bufferedReader.readLine();
             curLine = curLine + 1;
        }
        curLine = 0;       

        while(line != null && curLine < numberOfProcesses){
             lines = new StringTokenizer(line);
             if(lines.hasMoreTokens()){
                  for(int j = 0; j < numberOfResources; j++){
                       allocationInput[curLine][j] = Integer.parseInt(lines.nextToken());
                  }
             }
             line = bufferedReader.readLine();
             curLine = curLine + 1;
        }  

        lines = new StringTokenizer(line);
        while(lines.hasMoreTokens()){
             for(int i = 0; i < numberOfResources; i++){
                  totalVectorResources[i] = Integer.parseInt(lines.nextToken());
             }
        }  
        bufferedReader.close();
        fileReader.close();

        for(int i = 0; i < numberOfProcesses; i++){
             for(int j = 0; j < numberOfResources; j++){
                  remainingNeed[i][j] = maxResourceClaim[i][j]-allocationInput[i][j];
             }
        }  

        // Calculate available 

        for(int i = 0; i < numberOfProcesses; i++){
             for(int j = 0; j < numberOfResources; j++){
                  columsAdded[j] += allocationInput[i][j];
                  rowsAdded[i] += remainingNeed[i][j];
             }
        }

        for(int j = 0; j < numberOfResources; j++){
             availableVector[j] = totalVectorResources[j] - columsAdded[j];
        }
        
        for(int j = 0; j < numberOfResources; j++){
             currAvailIteration[j]=availableVector[j];
        }

        for(int i = 0; i < numberOfProcesses; i++){
             complBoolArr[i] = false;
        }

        // Determine if system is safe

        boolean systemNotSafe = false;

        do {

             systemNotSafe = false;
             int i = 0;
             for(; i < numberOfProcesses; i++){
                  if ((!complBoolArr[i])){
                       boolean safe = true;  
                       for (int j = 0; j < numberOfResources; j++){  
                    	   // not safe condition
                            if(remainingNeed[i][j] > currAvailIteration[j]){
                                 safe = false;
                                 break;
                            }
                       }
                       if (!safe) {
                            continue;
                       }
                       systemNotSafe = true;
                       break;  
                  }
             }

             if(systemNotSafe){
                  complBoolArr[i] = true;
                  for (int j = 0; j < numberOfResources; j++){  
                       currAvailIteration[j] += allocationInput[i][j];
                  }
                  orderProcesses[idxIteration++] = i;
             }
        }while (systemNotSafe);

        for(int i = 0; i < numberOfProcesses; i++){
             if(!complBoolArr[i]){
                  isSequenceSafe = false;
             }
             else{
                  isSequenceSafe = true;
             }
        }

        //OUTPUT per homework requirements
        System.out.println("Processes from input file: " + numberOfProcesses);
        System.out.println("Resources from input file: " + numberOfResources);
        System.out.println("Max Claim : ");
        for(int i = 0; i < numberOfProcesses; i++){
             for(int j = 0; j < numberOfResources; j++){
                  System.out.print(maxResourceClaim[i][j] + " ");
             }
             System.out.println();
        }
        System.out.println("Allocation: ");
        for(int i = 0; i < numberOfProcesses; i++){
             for(int j = 0; j < numberOfResources; j++){
                  System.out.print(allocationInput[i][j] + " ");
             }
             System.out.println();
        }

        //Total Resources
        System.out.println("Total Resources: ");
        for(int i = 0; i < numberOfResources; i++){
             System.out.print(totalVectorResources[i] + " ");
        }
        System.out.println();
        //Remaining need
        System.out.println("Remaining need : ");
        for(int i = 0; i < numberOfProcesses; i++){
             for(int j = 0; j < numberOfResources; j++){
                  System.out.print(remainingNeed[i][j] + " ");
             }
             System.out.println();
        }
        //Display the Available Vector
        System.out.println();
        System.out.println("Resources available: ");
        for(int j = 0; j < numberOfResources; j++){
             System.out.print(availableVector[j] +" ");
        }
        //Print the output
        if(isSequenceSafe){
             System.out.print("Safe sequence : ");
             for(int i = 0; i < orderProcesses.length; i++){
                  System.out.print((orderProcesses[i]+1) + " ");
             }
             System.out.println();
             System.out.println("\n"+"This system is in a safe state.");
        }
        else{
             System.out.println("\n"+"This system is not in a safe state.!");
        }	
	}

}
