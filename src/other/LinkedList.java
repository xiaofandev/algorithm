package other;

/**
 * Notice: capacity is not limited
 *
 */
public class LinkedList<T> {

	private Node head;
	private Node tail;
	private int length = 0;
	
	public LinkedList<T> add(T data) {
		if(data == null) {
			throw new RuntimeException("patameter data cannot be null");
		}
		
		Node node = new Node(data);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head.pre = node;
			this.head = node;
		}
		this.length++;
		return this;
	}
	
	public LinkedList<T> remove(T data) {
		Node hittedNode = find(data);
		if(hittedNode == null) {
			throw new RuntimeException("data not exists");
		}
		
		if(hittedNode == this.head) {
			this.head = null;
			this.tail = null;
		} else if(hittedNode == this.tail){
			this.tail.pre.next = null;
			this.tail = this.tail.pre;
		} else {
			hittedNode.pre.next = hittedNode.next;
			hittedNode.next.pre = hittedNode.pre;
		}
		this.length--;
		return this;
	}
	
	public LinkedList<T> reverse() {
		Node node = this.head;
		Node pre = null;
		Node next = null;
		while(node != null) {
			next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		Node headTemp = this.head;
		this.head = this.tail;
		this.tail = headTemp;
		return this;
	}
	
	public Node find(Object data) {
		Node node = this.head;
		Node hittedNode = null;
		while(node != null) {
			if(node.data.equals(data)) {
				hittedNode = node;
				break;
			}
			node = node.next;
		}
		return hittedNode;
	}
	
	public int getLength() {
		return this.length;
	}
	
	private class Node {
		private Node pre;
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
