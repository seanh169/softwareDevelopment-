package ProjTwoTest;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Filename:    ExpressionEval
 * Author:      William Crutchfield
 * Date:        6/16/2017
 * Description: Handles all logic and calculations related to the arithmetic expression.
 */

class ExpressionEval {

    // Variables
    private Stack<Node> expressionStack = new Stack<>();
    private Node operator;

    /**
     * Takes an expression, splits it into tokens, then pushes tokens to a stack. Used in the construction of the Expression Tree
     * @param expression String the user inputs
     * @return Infix Expression version of input
     * @throws InvalidTokenException is thrown when an incorrect character is in the expression
     * @throws EmptyStackException is thrown when there is no input
     */
    String evaluate(String expression) throws InvalidTokenException, EmptyStackException, IOException {
    	String st = expression.replaceAll("\\s+", "");
        String[] tokens = st.split("");
        String operandPat = "[\\d.?]+";
   	 	String operatorPat = "[*/+\\-]";
//        for (String token : tokens) {
//            // Determines patterns used to determine tokens
//            String operandPat = "[\\d.?]+";
//            String operatorPat = "[*/+\\-]";
//            
//
//            // Ensures no illegal characters are used
//            if (!token.matches(operandPat) && !token.matches(operatorPat)) {
//                throw new InvalidTokenException(token);
//            }
//           
//            // Pushes Operands onto Stack. Assigns children to Operators, then pushes Operators onto Stack
//            if (token.matches(operandPat)) {
//                expressionStack.push(new OperandNode(token));
//            } else if (token.matches(operatorPat)) {
//                operator = new OperatorNode(token, expressionStack.pop(), expressionStack.pop());
//                expressionStack.push(operator);
//            }
//        }
        for(int i = 0 ; i < tokens.length; i++) {
        	
        	 
        	 if (!tokens[i].matches(operandPat) && !tokens[i].matches(operatorPat)) {
//               throw new InvalidTokenException(token);
           }
//        	 Pushes Operands onto Stack. Assigns children to Operators, then pushes Operators onto Stack
           if (tokens[i].matches(operandPat)) {
               expressionStack.push(new OperandNode(tokens[i]));
           } else if (tokens[i].matches(operatorPat)) {
               operator = new OperatorNode(tokens[i], expressionStack.pop(), expressionStack.pop());
               expressionStack.push(operator);
           }
        }

        // Creates the Assembly Code written to File
        operator.post();

        return expressionStack.pop().inOrderWalk();
    }
//    public static void main(String[] args) throws EmptyStackException, InvalidTokenException, IOException {
//    	PostfixToInfix x = new PostfixToInfix();
//    	System.out.println(x.evaluate("3 5 9 +-2 3 * /"));
////    	String st = "3 5 9 + - 2 3 * /".replaceAll("\\s+", "");
////    	System.out.println(st);
//	}
}
