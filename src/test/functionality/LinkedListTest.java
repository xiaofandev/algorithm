package test.functionality;

import other.LinkedList;

public class LinkedListTest {

	/**
     * description: 
     * init status: length=2, "a" -> "b"
     * input: null
     * output: "b" -> "a"
     */
	public static void testReverse() {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("b").add("a");
		linkedList.print();
		linkedList.reverse();
		linkedList.print();
		
		// TODO automation has to be done, i have not yet configuring out how to equal linked list
	}
	
	/**
     * description: 
     * init status: length=2, "a" -> "b" -> "c" -> "d" -> "e"
     * input: null
     * output: "e" -> "d" -> "c" -> "b" -> "a"
     */
	public static void testReverse2() {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("e").add("d").add("c").add("b").add("a");
		linkedList.print();
		linkedList.reverse();
		linkedList.print();
		
		// TODO automation has to be done, i have not yet configuring out how to equal linked list
	}
	
	public static void main(String[] args) {
		testReverse();
		testReverse2();
	}
	
}
