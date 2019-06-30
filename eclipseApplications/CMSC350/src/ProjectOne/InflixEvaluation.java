package ProjectOne;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class InflixEvaluation {
	
		
	  //Stacks in first sentence of requirements 
	  private Stack<String> operandStack = new Stack<>();
	  private Stack<String> operatorStack = new Stack<>();
	  
	 String evaluate(String expression) throws DivideByZero, InvalidCharacterException, EmptyStackException{
		  		
	  		List<String> split = tokenizeExpression(expression);
	  		for(String unit: split) {
	  			 Pattern operatorRegex = Pattern.compile("[*/+\\-]");
	  		      Pattern operandRegex = Pattern.compile("[\\d.?]+");
	  		 // Ensures no illegal characters are used
	  		      if (!unit.matches(String.valueOf(operandRegex))
	  		          && !unit.matches(String.valueOf(operatorRegex))
	  		          && !unit.equals("(")
	  		          && !unit.equals(")")) {
	  		        throw new InvalidCharacterException();
	  		      }
	  		      if(unit.matches(String.valueOf(operandRegex))){
	  		    	  operandStack.push(unit);
	  		      }
	  		      else if(unit.equals("(")) {
	  		    	  operatorStack.push(unit);
	  		      }
	  		      else if(unit.equals(")")) {
	  		    	  while(!operatorStack.peek().equals("(")) {
	  		    		  operandStack.push(preformArithmetic(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
	  		    	  }
	  		    	  operatorStack.pop();
	  		      }
	  		      else if (unit.matches(String.valueOf(operatorRegex))) {
	  		    	while (!operatorStack.empty() && precedenceLevel(operatorStack.peek()) >= precedenceLevel(
	  		              unit)) { 
	  		    		operandStack.push(preformArithmetic(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
	  		    	}
	  		    	operatorStack.push(unit);
	  		      }
	  		}
	  		while(!operatorStack.empty()) {
	  			operandStack.push(preformArithmetic(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
	  		}
	  		return operandStack.pop();
	  	}
	  
	  
	  
	  
	  
	  
	  //Logic to determine precedence
	  static int precedenceLevel(String op) {
		  int precedence = 0;

		    switch (op) {
		      case "+":
		      case "-":
		        precedence = 1;
		        break;
		      case "*":
		      case "/":
		        precedence = 2;
		    }

		    return precedence;
	  }
	  
	  //method to perform calculation properly with correct operand correlation
	  static String preformArithmetic(String operandOne, String operator, String operandTwo) throws DivideByZero {
		  int paramOne = Integer.parseInt(operandOne);
		  int paramTwo = Integer.parseInt(operandTwo);
		  int total = 0;
//		  if(operator.equals("+")) {
//			  total = paramOne + paramTwo;
//		  }else if(operator.equals("-")) {
//			  total = paramOne - paramTwo;
//		  }else if(operator.equals("*")) {
//			  total = paramOne * paramTwo;
//		  }else if(operator.equals("/")) {
//			  if(paramTwo == 0) {
//				  throw new DivideByZero("Cannot Divide By Zero");
//			  }else {
//				  total = paramOne / paramTwo;
//			  }
//			  
//		  }
		  switch (operator) {
	      case "+":
	    	  total = paramOne + paramTwo;
	        break;
	      case "-":
	    	  total = paramOne - paramTwo;
	        break;
	      case "*":
	    	  total = paramOne * paramTwo;
	        break;
	      case "/":
	        if (paramTwo == 0) {
	          throw new DivideByZero("Division by zero");
	        }
	        total = paramOne / paramTwo;
	        break;
	    }
		  return Integer.toString(total);
	  }
	//Method to tokenize the  expression string 
	  private static List<String> tokenizeExpression(String expression) {
		  
		  //Storage for return List of properly tokenized expression.
		  List<String> tokenizedExpression = new ArrayList<>();
		  
		  for (int i = 1; i < expression.length(); i++) {
		      // Gets current char
		      char c = expression.charAt(i);
		      char lastc = expression.charAt(i - 1);

		      // If c is a space, continues to next character
		      if (c == ' ') {
		        continue;
		      }

		      // Checks if c and lastc are digits, combines characters into single token if true
		      if (Character.isDigit(c) && Character.isDigit(lastc)) {
		        int lastIndex = (tokenizedExpression.size() - 1);
		        tokenizedExpression.set(lastIndex, tokenizedExpression.get(lastIndex) + c);
		      } else { // Adds token like normal
		    	  tokenizedExpression.add(Character.toString(c));
		      }
		    }
		  return tokenizedExpression;
		  
	  }
	  

	  public static void main(String[] args) throws EmptyStackException, DivideByZero, InvalidCharacterException {
//		System.out.println(tokenizeExpression("(2+3*5)-8/5*(5-2)"));
		InflixEvaluation t = new InflixEvaluation();
		t.evaluate("(2+3*5)-8/5*(5-2)");
//		System.out.println(evaluate("(2+3*5)-8/5*(5-2)"));
	  }

}
