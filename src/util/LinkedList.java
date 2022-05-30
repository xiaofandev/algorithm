package util;

public class LinkedList<E> implements Iterable<E> {

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
	
	private void linkAfter(Node<E> node, E e) {
		final Node<E> nextNode = node.next;
		final Node<E> newNode = new Node<E>(node, e, null);
		newNode.next = nextNode;
		if(nextNode == null) {
			last = newNode;
		} else {
			nextNode.prev = newNode;
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
	
	private E unlink(Node<E> node) {
		// assert node != null
		final E element = node.element;
		final Node<E> prev = node.prev;
		final Node<E> next = node.next;
		
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
		node.element = null;
		size--;
		return element;
	}
	
	public void addFirst(E e) {
		linkFirst(e);
	}
	
	public void addLast(E e) {
		linkLast(e);
	}
	
	public void addAfter(int index, E e) {
		checkPositonIndex(index);

		linkAfter(node(index), e);
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
	
	public E remove(int index) {
		Node<E> node = node(index);
		return unlink(node);
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
	
	private String outOfBoundMsg(int index) {
		return "Index:"+index+",Size:"+size;
	}
	
	private void checkPositonIndex(int index) {
		if(!(index >= 0 && index < size)) {
			throw new IndexOutOfBoundsException(outOfBoundMsg(index));
		}
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

	@Override
	public Iterator<E> iterate() {
		return new LinkedItr();
	}
	
	private class LinkedItr implements Iterator<E> {

		int cursor = 0;
		
		@Override
		public E next() {
			E el = get(cursor);
			cursor += 1;
			return el;
		}

		@Override
		public boolean hasNext() {
			if (cursor == getSize()-1) {
				return false;
			} else {
				return true;
			}
		}
		
	}
	
}
