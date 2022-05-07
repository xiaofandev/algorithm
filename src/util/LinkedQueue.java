package util;

public class LinkedQueue {

	private LinkedList<String> list = new LinkedList<>();
	
	public void enqueue(String e) {
		list.addLast(e);
	}
	
	public String dequeue() {
		return list.removeFirst();
	}
	
}
