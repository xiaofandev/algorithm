package test.usage.other;

import test.Assert;
import usage.other.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		testCalculate1();
		testCalculate2();
		testCalculate3();
	}
	
	public static void testCalculate1() {
		Calculator calculator = new Calculator();
		int source = calculator.calculate("1 + 2 * 3 - 4");
		Assert.equal(source, 3);
	}
	
	public static void testCalculate2() {
		Calculator calculator = new Calculator();
		int source = calculator.calculate("1 + 2 * 3");
		Assert.equal(source, 7);
	}
	
	public static void testCalculate3() {
		Calculator calculator = new Calculator();
		int source = calculator.calculate("1 + 4 * 3 - 1 + 16 / 4");
		Assert.equal(source, 16);
	}
}
