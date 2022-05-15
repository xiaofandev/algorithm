package util;

public class LinkedList<E> {

	private Node<E> first;
	private Node<E> last;
	private int size = 0;
	
	private void linkFirst(E e) {
		final Node<E> h = first;
		final Node<E> newNode = new Node<>(null, e, h);
		first = newNode;
		if(h == null) {
			last = newNode;
		} else {
			h.prev = newNode;
		}
		size++;
	}
	
	private void linkLast(E e) {
		final Node<E> t = last;
		final Node<E> newNode = new Node<>(t, e, null);
		last = newNode;
		if (t == null) {
			first = newNode;
		} else {
			t.next = newNode;
		}
		size++;
	}
	
	private E unlinkFirst() {
		// assert first node is not null
		final Node<E> f = first;
		final E element = f.element;
		final Node<E> next = f.next;
		f.element = null;
		f.next = null;
		first = next;
		if(next == null) {
			last = null;
		} else {
			next.prev = null;
		}
		size--;
		return element;
	}
	
	private E unlinkLast() {
		// assert last node is not null
		final Node<E> l = last;
		final E element = last.element;
		final Node<E> prev = l.prev;
		l.element = null;
		l.prev = null;
		last = prev;
		if(prev == null) {
			first = null;
		} else {
			prev.next = null;
		}
		size--;
		return element;
	}
	
	public void addFirst(E e) {
		linkFirst(e);
	}
	
	public void addLast(E e) {
		linkLast(e);
	}
	
	public E removeFirst() {
		if(first == null) {
			return null;
		}
		return unlinkFirst();
	}
	
	public E removeLast() {
		if(last == null) {
			return null;
		}
		return unlinkLast();
	}
	
	public int getSize() {
		return size;
	}
	
	public void push(E e) {
		addLast(e);
	}
	
	public E pop() {
		return removeLast();
	}
	
	// below is search method
	public E get(int index) {
		return node(index).element;
	}
	
	private Node<E> node(int index) {
		if(index < (size >> 1)) {// search from head
			Node<E> node = first;
			for(int i=0; i<index; i++) {
				node = node.next;
			}
			return node;
		} else {// search from tail
			Node<E> node = last;
			for(int i=size-1; i>index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	
	private static class Node<E> {
		Node<E> prev;
		E element;
		Node<E> next;
		public Node(Node<E> prev,E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}
	
}
