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
	
	private void incrementSize() {
		size++;
	}
	
	private void decrementSize() {
		size--;
	}
	
	private int getLastIndex() {
		return size-1;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getLast() {
		return array[getLastIndex()];
	}
	
	public boolean push(String item) {
		if(getSize() == capacity) {
			return false;
		}
		int lastIndex = getLastIndex();
		array[lastIndex+1] = item;
		incrementSize();
		return true;
	}
	
	public String pop() {
		final String item;
		if(getSize() == 0) {
			item = null;
		} else {
			int lastIndex = getLastIndex();
			item = array[lastIndex]; 
			array[lastIndex] = null; // help gc
			decrementSize();
		}
		return item;
	}

}
