package test.util;

import test.Assert;
import util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		testAddLast();
		testAddFirst();
		testAddAfter();
		testRemoveFirst();
		testRemoveLast();
		testGetSize();
		testPush();
		testPop();
	}
	
	public static void testAddFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(1);
		Assert.equal(list.get(0), 1);
		list.addFirst(2);
		Assert.equal(list.get(0), 2);
		list.addFirst(3);
		Assert.equal(list.get(0), 3);
	}
	
	public static void testAddLast() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		Assert.equal(list.get(0), 1);
		list.addLast(2);
		Assert.equal(list.get(1), 2);
		list.addLast(3);
		Assert.equal(list.get(2), 3);
	}
	
	public static void testAddAfter() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		// add after first
		list.addAfter(0, 4);
		Assert.equal(list.get(0), 1);
		// add after last
		list.addAfter(3, 5);
		Assert.equal(list.get(4), 5);
		// add after element which index >0 and <size
		list.addAfter(2, 6);
		Assert.equal(list.get(3), 6);
		Assert.equal(list.getSize(), 6);
	}
	
	public static void testRemoveFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		Assert.equal(list.removeFirst(), 1);
		Assert.equal(list.removeFirst(), 2);
		Assert.equal(list.removeFirst(), 3);
	}
	
	public static void testRemoveLast() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		Assert.equal(list.removeLast(), 3);
		Assert.equal(list.removeLast(), 2);
		Assert.equal(list.removeLast(), 1);
	}
	
	public static void testGetSize() {
		LinkedList<Integer> list = new LinkedList<>();
		Assert.equal(0, list.getSize());
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		Assert.equal(3, list.getSize());
	}
	
	public static void testPush() {
		LinkedList<Integer> list = new LinkedList<>();
		list.push(1);
		Assert.equal(list.get(0), 1);
		list.push(2);
		Assert.equal(list.get(1), 2);
	}
	
	private static void testPop() {
		LinkedList<Integer> list = new LinkedList<>();
		list.push(1);
		list.push(2);
		Assert.equal(list.pop(), 2);
		Assert.equal(list.pop(), 1);
		Assert.equal(list.pop(), null);
	}
	
}
