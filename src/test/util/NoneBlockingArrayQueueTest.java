package test.util;

import test.Assert;
import util.NoneBlockingArrayQueue;
import util.QueueIsEmptyException;
import util.QueueIsFullException;

public class NoneBlockingArrayQueueTest {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	
	/**
	 * 队列已满，入队操作
	 */
	public static void test1() {
		NoneBlockingArrayQueue queue = new NoneBlockingArrayQueue(2);
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
	 * 队列为空，出队操作
	 */
	public static void test2() {
		NoneBlockingArrayQueue queue = new NoneBlockingArrayQueue(2);
		try {
			queue.dequeue();
			Assert.failure();
		} catch (QueueIsEmptyException e) {
			Assert.success();
		}
	}
	
	public static void test3() {
		NoneBlockingArrayQueue queue = new NoneBlockingArrayQueue(2);
		queue.enqueue("aa");
		queue.enqueue("bb");
		String source = queue.dequeue();
		Assert.equal(source, "aa");
	}
	
}
