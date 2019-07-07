package projectthree;



/**
 * 
 * 
 * File Name : BinarySearchTree.java
 * Author : Sean Hamilton
 * Date: 06/26/2019
 * Purpose of program: Project 3 CMSC 350 UMUC. This class defines the BST per project requirements and includes the methods to build the tree and display it in either ascending or descending order.
 * 
 * 
 *
 */

public class BinarySearchTree<T extends Comparable<T>> {
	
	//display string variable for visual representation on GUI and root variable .
	StringBuilder display = new StringBuilder();
	private Node root;
	
    

    
    //Binary Search Tree constructor that resets display string on every instantiation. 
    public BinarySearchTree() {
    	this.root=null;
    	this.display.setLength(0);
    }
    
    
    public class Node {
    	
    	//private Node variables.
    	 private T data;
         private Node prev;
         private Node next;
         
         
         //Node Constructor
         public Node(T data) {
             this.data = data;
             this.prev = null;
             this.next = null;
         }

         //methods to return prev and next nodes
         public Node getPrev() {
             return prev;
         }

         public Node getNext() {
             return next;
         }

    }
    
    
    //Adds root node if null.
    public void addNode (T data) {
    	if (root == null) {                
            root = new Node(data);      
            return;
        }else {
            addNodeRec(data, root);
        }
    	
    }
    //Recursive method of adding a node to the BST. Per project requirement. 
    public void addNodeRec(T data, Node root) {
    	 if (data.compareTo(root.data) <= 0) {        
             if (root.prev != null) {                    
            	 addNodeRec(data, root.prev);  
             } else {                                    
            	 root.prev = new Node(data);
             }
         } else if (data.compareTo(root.data) > 0) {   
             if (root.next !=null) {                   
            	 addNodeRec(data, root.next); 
             } else {                                    
            	 root.next = new Node(data);
             }
         }
    	
    }
    //method that performs tree traversal and uses string variable to store it in a viewable format. 
    public void traverseTree(Node root) {
    	if (root.data != null) {
            if (root.getPrev() != null) {
            	traverseTree(root.getPrev());   
            }
            String x = (root.data).toString();                           
            display.append(x).append(" ");
            if (root.getNext() != null) {
            	traverseTree(root.getNext()); 
            }
        }
    }
    
    //method that returns a string in ascending or descending order.
    public String displayDescOrAsc(boolean ascending) {
    	if(ascending) {
    		traverseTree(root);
        	return display.toString();
    	}else{
    		traverseTree(root);
        	String[] copyDisplayImmutable = display.toString().split(" "); 
        	display.setLength(0);
        	StringBuilder displayDesc = new StringBuilder();
             for (int i = copyDisplayImmutable.length - 1; i >= 0; i--) {
            	 displayDesc.append(copyDisplayImmutable[i]).append(" ");
             }

        	return displayDesc.toString();
    	}
    }
  
}
