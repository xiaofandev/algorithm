package test.util;

import test.Assert;
import util.ArrayStack;

public class ArrayStackTest {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		ArrayStack stack = new ArrayStack(1);
		Assert.equal(stack.push("aa"), true);
		Assert.equal(stack.push("bb"), false);
		Assert.equal(stack.pop(), "aa");
		Assert.equal(stack.pop(), null);
		Assert.equal(stack.getSize(), 0);
	}
	
}
