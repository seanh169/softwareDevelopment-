package ProjectOne;

import java.util.Stack;

public class InflixExpressionEvaluation {
	
	
	public static Stack operandStack = new Stack();
	public static Stack operatorStack = new Stack();
	
	static int precedenceLevel(char op) {
	    switch (op) {
	        case '+':
	        case '-':
	            return 0;
	        case '*':
	        case '/':
	            return 1;
	        default:
	            throw new IllegalArgumentException("Operator unknown: " + op);
	    }
	}
	
	public static void evalute(String expression) {
		
		String st = expression.replaceAll("\\s+","");
//		System.out.println(st);
//		char[] charArray = st.toCharArray();
		for(int i = 0; i < st.length(); i++) {
			Character x = st.charAt(i);
			if(Character.isDigit(x)) {
				operandStack.push(x);
			}
			else if(x == '(') {
				operatorStack.push(x);
			}
			else if(x == ')') {
				Character top = (char) operatorStack.peek();
				while(top != '(') {
					int first = (Integer) operatorStack.pop();
					String op = (String) operandStack.pop();
					int second = (Integer) operatorStack.pop();
					operandStack.push((Integer) first+op+second);
				}
				
//				char top = (char) operatorStack.peek();
//				while(top != '(') {
////					System.out.println(Character.getNumericValue(operandStack.pop())+ operatorStack.pop() + operandStack.pop());
////					System.out.println((Integer) operandStack.pop() + operatorStack.pop() + );
//					int first = (Integer) operatorStack.pop();
//					String op = (String) operandStack.pop();
//					int second = (Integer) operatorStack.pop();
//					
//					System.out.println((Integer) first+op+second);
//					operandStack.push((Integer) first+op+second);
////					System.out.println(1);
//				}		
			}
			else if(x.equals('+') || x.equals('-') || x.equals('*') || x.equals('/')) {
				char y = (char) operatorStack.peek();
				while(!operatorStack.isEmpty() && precedenceLevel(y) >= precedenceLevel(x) && operandStack.size() > 1) {
//////				System.out.println(1);
				Integer operandOne = (Integer) operandStack.pop();
				Integer operandTwo = (Integer) operandStack.pop();
				operandStack.push(operandOne+x+operandTwo);
				}
				operatorStack.push(x);
			}
//			else if(Character.toString(x ).equals(Character.toString('+')) ) {
//				operatorStack.push(x); 
////				System.out.println(1);
////				char y = (char) operatorStack.peek();
////				while(!operatorStack.isEmpty() && precedenceLevel(y) >= precedenceLevel(x)) {
//////					System.out.println(1);
//////					Integer operandOne = (Integer) operandStack.pop();
//////					Integer operandTwo = (Integer) operandStack.pop();
//////					operandStack.push(operandOne+x+operandTwo);
////				}
//			}
			else {
				System.out.println("nothing matched");
			}
		
		}
		while(!operatorStack.isEmpty()) {
			Integer operandOneX = (Integer) operandStack.pop();
			Integer operandTwoeX = (Integer) operandStack.pop();
			String operatorOnex = (String) operatorStack.pop();
			operandStack.push((Integer) operandOneX+operatorOnex+operandTwoeX);
//			Integer result = (Integer) operandOneX+operatorOnex+operandTwoeX;
		}
//		if(charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '/' || charArray[i] == '*') {
//		operandStack.push(charArray[i]);
//	}
		
//		System.out.println(charArray);
		
	}
	
	public static void main(String[] args) {
		
		
		InflixExpressionEvaluation z = new InflixExpressionEvaluation();
		z.evalute("(2+3*5)-8/5*(5-2)");
		System.out.println(operandStack);
		System.out.println(operatorStack);
//		System.out.println(typeOf());
//		System.out.println(precedenceLevel('+'));
		
		
	}

}
