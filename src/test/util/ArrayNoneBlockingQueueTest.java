package test.util;

import test.Assert;
import util.ArrayNoneBlockingQueue;
import util.QueueIsEmptyException;
import util.QueueIsFullException;

public class ArrayNoneBlockingQueueTest {

	public static void main(String[] args) {
		testEnqueue();
		testDequeue();
		testDequeue2();
	}
	
	/**
	 * description: test enqueue operation in normal and in condition of the queue is full
	 * input: "aa", "bb", "cc"
	 * output: throw QueueIsFullException runtime exception
	 */
	public static void testEnqueue() {
		ArrayNoneBlockingQueue queue = new ArrayNoneBlockingQueue(2);
		queue.enqueue("aa");
		queue.enqueue("bb");
		try {
			queue.enqueue("cc");
			Assert.failure();
		} catch (QueueIsFullException e) {
			Assert.success();
		}
	}
	
	/**
	 * description: test dequeue operation in condition of the queue is empty
	 * input: null
	 * output: throw QueueIsEmptyException runtime exception
	 */
	public static void testDequeue() {
		ArrayNoneBlockingQueue queue = new ArrayNoneBlockingQueue(2);
		try {
			queue.dequeue();
			Assert.failure();
		} catch (QueueIsEmptyException e) {
			Assert.success();
		}
	}
	
	/**
	 * description: test enqueue and dequeue operation in normal
	 * input: "aa", "bb"
	 * output: "aa"
	 */
	public static void testDequeue2() {
		ArrayNoneBlockingQueue queue = new ArrayNoneBlockingQueue(2);
		queue.enqueue("aa");
		queue.enqueue("bb");
		String source = queue.dequeue();
		Assert.equal(source, "aa");
	}
	
}
