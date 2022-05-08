package test.util;

import test.Assert;
import util.CircleArrayQueue;
import util.QueueIsEmptyException;
import util.QueueIsFullException;

public class CircleArrayQueueTest {

	public static void main(String[] args) {
		testPush();
		testPop();
		testCirclePushAndPop();
	}
	
	/**
	 * description: queue is full
	 * init param: capacity = 3
	 * input: "aa", "bb", "cc", "dd"
	 * output: throw QueueIsFullException
	 */
	public static void testPush() {
		CircleArrayQueue<String> queue = new CircleArrayQueue<>(3);
		queue.push("aa");
		queue.push("bb");
		try {
			queue.push("cc");
		} catch (QueueIsFullException e) {
			Assert.success();
		}
	}
	
	/**
	 * description: queue is empty
	 * init param: capacity = 3
	 * input: "aa", "bb", "cc", "dd"
	 * output: throw QueueIsFullException
	 */
	public static void testPop() {
		CircleArrayQueue<String> queue = new CircleArrayQueue<>(3);
		queue.push("aa");
		queue.push("bb");
		Assert.equal(queue.pop(), "aa");
		Assert.equal(queue.pop(), "bb");
		try {
			queue.pop();
			Assert.failure();
		} catch (QueueIsEmptyException e) {
			Assert.success();
		}
	}
	
	/**
	 * description: circle push and pop
	 * init param: capacity = 3
	 * input: 
	 * output: 
	 */
	public static void testCirclePushAndPop() {
		CircleArrayQueue<String> queue = new CircleArrayQueue<>(3);
		queue.push("aa");
		queue.push("bb");
		Assert.equal(queue.getSize(), 2);
		queue.pop();
		Assert.equal(queue.getSize(), 1);
		queue.pop();
		Assert.equal(queue.getSize(), 0);
		queue.push("aa");
		queue.push("bb");
		queue.pop();
		queue.pop();
		queue.push("aa");
		queue.push("bb");
		Assert.equal(queue.pop(), "aa");
		Assert.equal(queue.pop(), "bb");
		Assert.success();
	}
	
	
	
}
