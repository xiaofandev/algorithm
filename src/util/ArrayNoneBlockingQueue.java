package util;

public class ArrayNoneBlockingQueue {

	private String[] array;
	private int capacity;
	private int head = 0;
	private int tail = 0;
	
	public ArrayNoneBlockingQueue(int capacity) {
		this.capacity = capacity;
		array = new String[capacity];
	}
	
	/**
	 * Insert element to the end of the queue
	 * @param e The inserted element
	 */
	public void enqueue(String e) {
		// tail pointer has moved to the boundary of the queue
		if(tail == capacity) {
			// queue is full
			if(head == 0) {
				throw new QueueIsFullException();
			} else {
				// move all elements to the start position
				for(int i=head; i<tail; i++) {
					array[i-head] = array[i];
				}
				tail -= head;
				head = 0;
			}
		} else {
			array[tail] = e;
			tail++;
		}
	}
	
	/**
	 * Remove the element which at start position of the queue
	 * @return The removed element
	 */
	public String dequeue() {
		String result;
		if(head == tail) {
			throw new QueueIsEmptyException();
		} else {
			result = array[head];
			head++;
			return result;
		}
	}
}
