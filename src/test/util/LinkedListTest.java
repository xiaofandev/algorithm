package test.util;

import test.Assert;
import util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		testAddFirst();
	}
	
	public static void testAddFirst() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(1);
		Assert.equal(list.get(0), 1);
		list.addLast(2);
		Assert.equal(list.get(1), 2);
		list.addLast(3);
		Assert.equal(list.get(2), 3);
	}
	
}
