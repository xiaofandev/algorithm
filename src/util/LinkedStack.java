package util;

public class LinkedStack implements Stack<String> {

	private int capacity;
	private LinkedList<String> list;
	
	public LinkedStack(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean push(String e) {
		if(list.getSize() == capacity) {
			return false;
		} else {
			list.push(e);
			return true;
		}
	}

	@Override
	public String pop() {
		return list.pop();
	}
	
}
