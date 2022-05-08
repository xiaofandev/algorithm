package util;

public class ArrayStack<E> implements Stack<E> {

	private Object[] array;
	private int capacity;
	private int size;
	
	public ArrayStack(int capacity) {
		array = new Object[capacity];
		this.capacity = capacity;
		size = 0;
	}
	
	public boolean push(E item) {
		if(size == capacity) {
			return false;
		}
		array[size] = item;
		size++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		final E item;
		if(size == 0) {
			item = null;
		} else {
			item = (E) array[size-1]; 
			array[size-1] = null; // help gc
			size--;
		}
		return item;
	}
	
	public int getSize() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public E getLast() {
		if(size == 0) {
			return null;
		} else {
			return (E) array[size-1];
		}
	}

}
