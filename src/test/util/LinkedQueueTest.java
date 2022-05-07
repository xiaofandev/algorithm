package test.util;

import test.Assert;
import util.LinkedQueue;

public class LinkedQueueTest {

	public static void main(String[] args) {
		testEnqueue();
		testDequeue();
	}
	
	public static void testEnqueue() {
		LinkedQueue<String> queue = new LinkedQueue<>();
		queue.enqueue("aa");
		queue.enqueue("bb");
		Assert.success();
	}
	
	/**
	 * description: on condition of queue is not empty and queue is empty
	 * 
	 */
	public static void testDequeue() {
		LinkedQueue<String> queue = new LinkedQueue<>();
		queue.enqueue("aa");
		queue.enqueue("bb");
		// not empty
		Assert.equal(queue.dequeue(), "aa");
		Assert.equal(queue.dequeue(), "bb");
		// empty
		Assert.equal(queue.dequeue(), null);
		
	}
	
}
