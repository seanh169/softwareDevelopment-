
public class Calculator implements CalculatorInterface {
	
	private int operOne;
	private int operTwo;
	private int total;
	private String operaator;
	public Calculator() {}
	public void preformOperation() {
		if (operaator == "+") {
			total = operOne + operTwo;
		}
		else if (operaator == "-") {
			total = operOne - operTwo;
		}
	}
	public void getResults() {
		System.out.println(total);
	}
	public void setOperandOne(int number) {
		operOne = number;
	}
	public void setOperandTwo(int numberz) {
		operTwo = numberz;
	}
	public void setOperation(String operator) {
		operaator = operator;
	}
	public static void main(String[] args) {
		Calculator newcalc = new Calculator();
		newcalc.setOperandOne(10);
		newcalc.setOperation("-");
		newcalc.setOperandTwo(5);
		newcalc.preformOperation();
		newcalc.getResults();
		
	}
}