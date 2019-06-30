package ProjectOne;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 * 
 * File Name : InfixEvaluationProjectOne.java
 * Author : Sean Hamilton
 * Date: 05/29/2019
 * Purpose of program: This class contains the methods that evaluate the expression according to the provided pseudocode. evaluateExpression is the primary method being called from this class.
 * 
 * 
 *
 */

public class InfixEvaluationProjectOne {
	
	
	//Stacks in first sentence of requirements 
	  private Stack<String> operandStack = new Stack<>();
	  private Stack<String> operatorStack = new Stack<>();

	  //Main method to evaluate the expression
	  String evaluateExpression(String expression)
	      throws DivideByZero, EmptyStackException {
	    
	    List<String> units = splitUpExpression(expression);

	    // Evaluates tokens
	    for (String unit : units) {
	      // Regex expressions for matching
	      Pattern operatorRegex = Pattern.compile("[*/+\\-]");
	      Pattern operandRegex = Pattern.compile("[\\d.?]+");
	      
	      //start of matching logic
	      if (unit.matches(String.valueOf(operandRegex))) {
	    	  operandStack.push(unit);
	      }else if (unit.equals("(")) {
	    	  operatorStack.push(unit);
	      }else if (unit.equals(")")) {
	        while (!operatorStack.peek().equals("(")) {
	        	operandStack.push(preformArithmetic(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
	        }
	        operatorStack.pop();
	      }else if (unit.matches(String.valueOf(operatorRegex))) {
	        
	        while (!operatorStack.empty() && precedenceLevel(operatorStack.peek()) >= precedenceLevel(
	        		unit)) { 
	        	operandStack.push(preformArithmetic(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
	        }
	        operatorStack.push(unit);
	      }
	    }

	    // Ends matching logic and performs stack pops and calculations
	    while (!operatorStack.empty()) {
	    	operandStack.push(preformArithmetic(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
	    }
	    return operandStack.pop();
	  }

	  //helper method that returns a list of strings that will tokenize and given input.  Accounts for spaces and integers that are tied together. Also skips over spaces.
	  public List<String> splitUpExpression(String expression) {
	    List<String> brokenUpTokens = new ArrayList<>();

	    brokenUpTokens.add(Character.toString(expression.charAt(0)));

	    for (int i = 1; i < expression.length(); i++) {
	    	
	      char current = expression.charAt(i);
	      char previous = expression.charAt(i - 1);

	
	      if (current == ' ') {
	        continue;
	      }

	      if (Character.isDigit(current) && Character.isDigit(previous)) {
	        int lastIndexofTokens = (brokenUpTokens.size() - 1);
	        brokenUpTokens.set(lastIndexofTokens, brokenUpTokens.get(lastIndexofTokens) + current);
	      } else {
	    	  brokenUpTokens.add(Character.toString(current));
	      }
	    }

	    return brokenUpTokens;
	  }

	  //helper method to determine order operation precedence according to this application.
	  public int precedenceLevel(String operator) {
	    int precedenceRating = 0;
	    switch (operator) {
	      case "+":
	      case "-":
	    	  precedenceRating = 1;
	        break;
	      case "*":
	      case "/":
	    	  precedenceRating = 2;
	    }

	    return precedenceRating;
	  }

	 // helper method to perform calculation when necessary according to requirements.
	  public String preformArithmetic(String num2, String operator, String num1) throws DivideByZero {
	    int paramOne = Integer.parseInt(num1);
	    int paramTwo = Integer.parseInt(num2);
	    int total = 0;

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
	          throw new DivideByZero("Cannot Divide By 0");
	        }
	        total = paramOne / paramTwo;
	        break;
	    }
	    return Integer.toString(total);
	  }
	  
	  

	  
}
