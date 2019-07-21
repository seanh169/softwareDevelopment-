package ProjectFour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 
 * 
 * File Name : DirectedGraph.java
 * Author : Sean Hamilton
 * Date: 07/09/2019
 * Purpose of program: Project 4 CMSC 350 UMUC. This class builds the required Directed Graph, and outputs the correlating topological order of the graph.
 * 
 * 
 *
 */


public class DirectedGraph<T> {
	
	
	//Private variables - includes storage strcutres and counters.
	private ArrayList<LinkedList<Integer>> edgeList; 
	private Map<T, Integer> classNames; 
	private int countVertices = 0;  
	private StringBuilder results;
	private List<Integer> listNeighbors; 
	
	
	//default constructor
	public DirectedGraph() {
		this.classNames = new HashMap<>();
		this.edgeList = new ArrayList<>();      
		
	}
	
	//method that splits up the text in a file into tokens. Requires sibling folder to this project named "textfiles". 
	ArrayList<String[]> splitUpFile(String fileInput) throws IOException {
	   String fileLocation = new File("textfiles/" + fileInput).getAbsolutePath();    
	   @SuppressWarnings("resource")
	   BufferedReader b = new BufferedReader(new FileReader(fileLocation));   
	   ArrayList<String[]> fileStorage = new ArrayList<>();  
	   String nextToken;
	   int i = 0;
	     while ((nextToken = b.readLine()) != null) {            
	        String[] splitUpTokens = nextToken.split("\\s"); 
	        fileStorage.add(i,splitUpTokens);                 
	        i++;                                        
	     }

	  return fileStorage;
	}
	//method that builds graph , stores either vertex or edge.
	public void buildDirectedGraph(ArrayList<T[]> inputAraray) {
		 for (T[] iterator : inputAraray) {                
	            for (int i = 0; i < iterator.length; i++) {   
	            	storeVertex(iterator[i]);                   
	                if (i != 0) {                               
	                	storeEdge(iterator[0], iterator[i]);  
	                }
	            }
	        }
	}
	//helper methods to store vertex or edge
	 public void storeVertex(T className) {
	        if (!classNames.containsKey(className)) {         
	        	classNames.put(className, countVertices);                 
	            LinkedList<Integer> adj = new LinkedList<>();   
	            edgeList.add(countVertices, adj);                          
	            countVertices++;                                            
	        }
	  }
	 
	  public void storeEdge(T startVertex, T endVertex) {
	        edgeList.get(classNames.get(startVertex)).add(classNames.get(endVertex));               
	  }
	  //method that displays out the topological order of the graph.
	  public String topologicalOrder(T startVertex) throws InvalidClassName, CycleOccuredException {
	        if (classNames.get(startVertex) == null) {    
	            throw new InvalidClassName();      
	        }
	        results = new StringBuilder();           
	        listNeighbors = new ArrayList<>();          
	        searchAndAppend(classNames.get(startVertex));     

	        return results.toString();
	  }
	  
	  //helper method for searchAndAppend
	  public String returnNameString(int inputVertex) {
	        for (T i : classNames.keySet()) {             
	            if (classNames.get(i).equals(inputVertex)) {   
	                return i.toString();                    
	            }
	        }
	        return "";
	    }

	  public void searchAndAppend(int y) throws CycleOccuredException {
		  results.append(returnNameString(y)).append(" ");     
	        for (Integer x : edgeList.get(y)) {                 
	            if (listNeighbors.contains(x)) {                  
	                throw new CycleOccuredException();         
	            }
	            listNeighbors.add(x);                               
	            searchAndAppend(x);                                         
	        }
	    }
	  

	 
}
