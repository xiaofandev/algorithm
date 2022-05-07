package util;

/**
 * 
 * 非阻塞数组实现队列
 *
 */
public class NoneBlockingArrayQueue {

	private String[] array;
	private int capacity;
	private int head = 0;
	private int tail = 0;
	
	public NoneBlockingArrayQueue(int capacity) {
		this.capacity = capacity;
		array = new String[capacity];
	}
	
	// 入栈
	public void enqueue(String val) {
		// tail指针已到尾部
		if(tail == capacity) {
			// 队列已满
			if(head == 0) {
				throw new QueueIsFullException();
			} else {
				// 移动所有元素到数组开始位置
				for(int i=head; i<tail; i++) {
					array[i-head] = array[i];
				}
				tail -= head;
				head = 0;
			}
		} else {
			array[tail] = val;
			tail++;
		}
	}
	
	// 出栈
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
