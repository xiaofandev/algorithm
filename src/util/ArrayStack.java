package util;

public class ArrayStack implements Stack<String> {

	private String[] array;
	private int capacity;
	private int size;
	
	public ArrayStack(int capacity) {
		array = new String[capacity];
		this.capacity = capacity;
		size = 0;
	}
	
	public boolean push(String item) {
		if(size == capacity) {
			return false;
		}
		array[size] = item;
		size++;
		return true;
	}
	
	public String pop() {
		final String item;
		if(size == 0) {
			item = null;
		} else {
			item = array[size-1]; 
			array[size-1] = null; // help gc
			size--;
		}
		return item;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getLast() {
		if(size == 0) {
			return null;
		} else {
			return array[size-1];
		}
	}

}
