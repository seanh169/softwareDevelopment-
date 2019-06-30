package practice;

import java.util.Stack;

public class PostfixToInfix {
	static boolean isOperand(char x) 
	{ 
		if(x == '+' || x == '-' || x == '/' || x == '*'){
			return false;
			
		}	
		String y  = Character.toString(x);
		Integer z = Integer.parseInt(y);
	    return (z >= 0 && z <= 9);
	} 
	  
	// Get Infix for a given postfix 
	// expression 
	static Node getInfix(String exp) 
	{ 
	    Stack<Node> s = new Stack<Node>(); 
	  
	    for (int i = 0; i < exp.length(); i++) 
	    { 
	        // Push operands 
	    	String t = Character.toString(exp.charAt(i));
	        if (isOperand(exp.charAt(i))) 
	        { 
//	        s.push(exp.charAt(i) + ""); 
	        	s.add(new OperandNode(t));
	        } 
	  
	        // We assume that input is 
	        // a valid postfix and expect 
	        // an operator. 
	        else
	        { 
	            Node op1 = s.peek(); 
	            s.pop(); 
	            Node op2 = s.peek(); 
	            s.pop(); 
//	            s.push("(" + op2 + exp.charAt(i) + 
//	                    op1 + ")"); 
	            s.add(new OperatorNode(t, op1, op2));
	        } 
	    } 
	  
	    // There must be a single element 
	    // in stack now which is the required 
	    // infix. 
	    return s.peek(); 
	} 
	  
	// Driver code 
	public static void main(String args[]) 
	{ 
	    String exp = "359+-23*/"; 
	    System.out.println( getInfix(exp).getData()); 
	} 
}
