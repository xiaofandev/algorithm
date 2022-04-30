package test.functionality;

import other.PalindromeChecker;
import test.Assert;

public class PalindromeCheckerTest {

	/**
     * description: not palindrome, the count of char is odd
     * init status: 'a' -> 'b' -> 'c'
     * input: null
     * output: false
     */
	public static void testCheck1() {
		PalindromeChecker checker = new PalindromeChecker("abc");
		boolean source = checker.check();
		Assert.equal(source, false);
	}
	
	/**
     * description: not palindrome, the count of char is even
     * init status: 'a' -> 'b' -> 'c' -> 'd'
     * input: null
     * output: false
     */
	public static void testCheck2() {
		PalindromeChecker checker = new PalindromeChecker("abcd");
		boolean source = checker.check();
		Assert.equal(source, false);
	}
	
	/**
     * description: palindrome, the count of char is odd
     * init status: 'a' -> 'b' -> 'c' -> 'b' -> 'a'
     * input: null
     * output: false
     */
	public static void testCheck3() {
		PalindromeChecker checker = new PalindromeChecker("abcba");
		boolean source = checker.check();
		Assert.equal(source, true);
	}
	
	/**
     * description: palindrome, the count of char is even
     * init status: 'a' -> 'b' -> 'b' -> 'a'
     * input: null
     * output: false
     */
	public static void testCheck4() {
		PalindromeChecker checker = new PalindromeChecker("abba");
		boolean source = checker.check();
		Assert.equal(source, true);
	}
	
	public static void main(String[] args) {
		testCheck1();
		testCheck2();
		testCheck3();
		testCheck4();
	}
	
}
