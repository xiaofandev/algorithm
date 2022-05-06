package usage.other;

import util.ArrayStack;

public class Calculator {

	private ArrayStack variableStack = new ArrayStack(20);
	private ArrayStack operatorStack = new ArrayStack(20);
	
	/**
	 * 判断操作符优先级
	 * @param operator
	 * @return 如果operator的优先级小于等于操作符栈顶元素优先级，返回true，否则返回false
	 */
	private boolean compare(String operator) {
		boolean result = false;
		String lastOperator = operatorStack.getLast();
		if("+".equals(operator) || "-".equals(operator)) {
			return true;
		}
		
		if("*".equals(operator) || "/".equals(operator)) {
			if("*".equals(lastOperator) || "/".equals(lastOperator)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * 取两个栈顶变量和一个栈顶操作符进行运算，最后把结果放入变量栈栈顶
	 */
	private void calculate() {
		String operatedNum = variableStack.pop();
		String operateNum = variableStack.pop();
		String operator = operatorStack.pop();
		int result = 0;
		switch(operator) {
		case "+":
			result = Integer.valueOf(operateNum) + Integer.valueOf(operatedNum);
			break;
		case "-":
			result = Integer.valueOf(operateNum) - Integer.valueOf(operatedNum);
			break;
		case "*":
			result = Integer.valueOf(operateNum) * Integer.valueOf(operatedNum);
			break;
		case "/":
			result = Integer.valueOf(operateNum) / Integer.valueOf(operatedNum);
			break;
		}
		variableStack.push(String.valueOf(result));
	}
	
	public int calculate(String expression) {
		String[] array = expression.split(" ");
		String variable;
		String operator;
		// push variables and operator
		for(int i=0; i<array.length; i++) {
			if((i+1)%2 == 1) {
				variable = array[i];
				variableStack.push(variable);
			} else {
				operator = array[i];
				// pre calculate
				while(operatorStack.getSize()>0 && compare(operator)) {
					calculate();
				}
				operatorStack.push(operator);
			}
		}
		
		// last calculate
		while(operatorStack.getSize()>0) {
			calculate();
		}
		return Integer.valueOf(variableStack.pop());
	}
	
}
