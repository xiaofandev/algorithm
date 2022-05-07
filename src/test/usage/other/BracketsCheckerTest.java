package test.usage.other;

import test.Assert;
import usage.other.BracketsChecker;

public class BracketsCheckerTest {

	public static void main(String[] args) {
		testCheck();
	}
	
	public static void testCheck() {
		BracketsChecker checker = new BracketsChecker();
		boolean source1 = checker.check("{ [ ( ) ] }");
		Assert.equal(source1, true);
		boolean source2 = checker.check("{ ( } )");
		Assert.equal(source2, false);
		
	}
	
}
