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
	
	private void linkBefore(E e, Node<E> source) {
		// assert source is not null
		Node<E> prev = source.prev;
		final Node<E> newNode = new Node<>(source.prev, e, source.next);
		source.prev = newNode;
		if (prev == null) {
			first = newNode;
		} else {
			prev.next = newNode;
		}
		size++;
	}
	
	private E unlinkFirst() {
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
	
	private void unlink(Node<E> node) {
		final Node<E> prev = node.prev;
		final Node<E> next = node.next;
		
		node.element = null;
		
		if(prev == null) {
			first = next;
		} else {
			prev.next = next;
			node.prev = null;
		}
		
		if(next == null) {
			last = prev;
		} else {
			next.prev = prev;
			node.next = null;
		}
		size--;
	}
	
	private E getFirst() {
		final Node<E> f = first;
		if(f == null) {
			throw new NoSuchElementException();
		}
		return f.element;
	}
	
	private E getLast() {
		final Node<E> l = last;
		if(l == null) {
			throw new NoSuchElementException();
		}
		return l.element;
	}
	
	public void addFirst(E e) {
		linkFirst(e);
	}
	
	public void addLast(E e) {
		linkLast(e);
	}
	
	public E removeFirst() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return unlinkFirst();
	}
	
	public E removeLast() {
		if(last == null) {
			throw new NoSuchElementException();
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
