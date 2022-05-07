package test.util;

import test.Assert;
import util.LinkedQueue;

public class LinkedQueueTest {

	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		LinkedQueue queue = new LinkedQueue();
		queue.enqueue("aa");
		Assert.equal(queue.dequeue(), "aa");
	}
	
}
