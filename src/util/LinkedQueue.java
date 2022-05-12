package util;

public class LinkedQueue<E> {

	private Node<E> head;
	private Node<E> tail;
	
	public void enqueue(E e) {
		if(tail == null) {
			final Node<E> newNode = new Node<>(null, e, null);
			tail = newNode;
			head = newNode;
		} else {
			final Node<E> prev = tail;
			final Node<E> node = new Node<>(prev, e, null);
			prev.next = node;
			tail = node;
		}
	}
	
	public E dequeue() {
		if(head == null) {
			return null;
		} else {
			final Node<E> h = head;
			final Node<E> next = h.next;
			h.next = null;
			head = next;
			if(next == null) {
				tail = null;
			} else {
				next.prev = null;
			}
			return h.element;
		}
	}
	
	private static class Node<E> {
		@SuppressWarnings("unused")
		Node<E> prev;
		E element;
		Node<E> next;
		
		public Node(Node<E> prev, E e, Node<E> next) {
			this.prev = prev;
			this.element = e;
			this.next = next;
		}
	}
	
}
