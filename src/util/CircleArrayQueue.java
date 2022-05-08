package util;

/**
 * 
 * Note:Considering to distinguish the condition of the queue is empty and full, 
 * The actual capacity of the queue is capacity-1.In other words,there are 1 space
 * has to be wasted.
 * 
 */
public class CircleArrayQueue<E> {

	private final Object[] items;
	private int capacity;
	private int size;
	private int head;
	private int tail;
	
	public CircleArrayQueue(int capacity) {
		if(capacity <2) {
			throw new CapacityNotEnoughException("Capacity has to be greater than or equal to 2");
		}
		this.capacity = capacity;
		items = new Object[capacity];
	}
	
	public void push(E e) {
		// check full
		boolean isFull = false;
		if(tail == capacity-1) {
			if(head == 0) {
				isFull = true;
			}
		} else {
			if(head == tail+1) {
				isFull = true;
			}
		}
		
		if(isFull) {
			throw new QueueIsFullException();
		} else {
			items[tail] = e;
			if(tail == capacity-1) {
				tail = 0;
			} else {
				tail++;
			}
			size++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		E element = null;
		// check empty
		if(head == tail) {
			throw new QueueIsEmptyException();
		} else {
			element = (E) items[head];
			if(head == capacity-1) {
				head = 0;
			} else {
				head++;
			}
			size--;
		}
		return element;
	}
	
	public int getSize() {
		return size;
	}
	
}
