package test.util;

import test.Assert;
import util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		testAddToHead1();
		testAddToHead2();
		testAddToHead3();
	}
	
	/**
     * description: parameter is null
     * init status: capacity=2, null
     * input: null
     * output: throw a runtime exception
     */
	public static void testAddToHead1() {
		LinkedList<String> linkedList = new LinkedList<>(2);
		try {
			linkedList.addToHead(null);
			Assert.failure();
		} catch (Exception e) {
			Assert.success();
		}
	}
	
	/**
     * description: list is full
     * init status: capacity=2, length=2, "aa" -> "bb"
     * input: cc
     * output: throw a runtime exception
     */
	public static void testAddToHead2() {
		LinkedList<String> linkedList = new LinkedList<>(2);
		linkedList.addToHead("bb");
		linkedList.addToHead("aa");
		try {
			linkedList.addToHead("cc");
			Assert.failure();
		} catch (Exception e) {
			Assert.success();
		}
	}
	
	/**
     * description: normal
     * init status: capacity=3, length=0
     * input: "cc","bb","aa"
     * output: null,["aa" -> "bb" -> "cc"]
     */
	public static void testAddToHead3() {
		LinkedList<String> linkedList = new LinkedList<>(3);
		linkedList.addToHead("cc");
		linkedList.addToHead("bb");
		linkedList.addToHead("aa");
		linkedList.print();
	}
	
	
}
