package util;

public class LinkedList<T> {

	private Node head;
	private int length = 0;
	private int capacity = 0;
	
	public LinkedList(int capacity) {
		this.capacity = capacity;
	}
	
	public LinkedList<T> addToHead(T data) {
		if(data == null) {
			throw new RuntimeException("patameter data cannot be null");
		}
		if(this.capacity == this.length) {
			throw new RuntimeException("capacity is not enough");
		}
		
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
		
		this.length++;
		return this;
	}
	
	private class Node {
		private T data;
		private Node next;
		public Node(T data) {
			this.data = data;
		}
	}

	// only for unit test
	public void print() {
		Node node = this.head;
		while(node != null) {
			System.out.print(node.data);
			node = node.next;
		}
		System.out.println();
	}
}
