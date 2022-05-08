package test.util;

import test.Assert;
import util.ArrayStack;

public class ArrayStackTest {

	public static void main(String[] args) {
		testPush();
		testPop();
		testGetSize();
		testGetLast();
	}
	
	/**
	 * description: stack is full
	 * init param: capacity = 1
	 * input: "aa", "bb"
	 * output: false
	 */
	public static void testPush() {
		ArrayStack<String> stack = new ArrayStack<>(1);
		stack.push("aa");
		Assert.equal(stack.push("bb"), false);
	}
	
	/**
	 * description: stack is not empty, stack is empty
	 * init param: capacity = 1
	 * input: "aa"
	 * output: "aa", null
	 */
	public static void testPop() {
		ArrayStack<String> stack = new ArrayStack<>(1);
		stack.push("aa");
		Assert.equal(stack.pop(), "aa");
		Assert.equal(stack.pop(), null);
	}
	
	/**
	 * description: test getSize after push and pop
	 * init param: capacity = 2
	 * input: 
	 * output: 
	 */
	public static void testGetSize() {
		ArrayStack<String> stack = new ArrayStack<>(2);
		stack.push("aa");
		stack.push("bb");
		Assert.equal(stack.getSize(), 2);
		stack.pop();
		Assert.equal(stack.getSize(), 1);
	}
	
	/**
	 * description: stack is empty, stack is not emty
	 * init param: capacity = 0
	 * input: 
	 * output: 
	 */
	public static void testGetLast() {
		ArrayStack<String> stack = new ArrayStack<>(2);
		Assert.equal(stack.getLast(), null);
		stack.push("aa");
		stack.push("bb");
		Assert.equal(stack.getLast(), "bb");
		stack.pop();
		Assert.equal(stack.getLast(), "aa");
	}
	
}
