package usage.cache;

import usage.model.User;

public class LinkedLRUCache {

	private int capacity;
	private int length = 0;
	private Node head;
	private Node tail;
	
	public LinkedLRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * add a new node to head
	 * 
	 */
	private void addToHead(Node node) {
		if(node == null) {
			throw new RuntimeException("parameter node cannot be null");
		}
		
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.pre = null;
			node.next = this.head;
			this.head.pre = node;
			this.head = node;
		}
	}
	
	/**
	 * move an exist node to head
	 * 
	 */
	private void moveToHead(Node node) {
		if(node == null) {
			throw new RuntimeException("parameter node can not be null");
		}
		if(node == this.head) {
			return;
		}
		if(node == this.tail) {
			node.pre.next = null;
			this.tail = node.pre;
			addToHead(node);
		} else {
			node.pre.next = node.next;
			node.next.pre = node.pre;
			addToHead(node);
		}
	}
	
	private void removeTail() {
		if(this.tail == null) {
			return;
		}
		if(this.tail == this.head) {
			this.tail = null;
			this.head = null;
		} else {
			this.tail.pre.next = null;
			this.tail = this.tail.pre;
		}
	}
	
	public User getByUserId(int userId) {
		User user = null;
		Node hittedNode = null;
		
		Node tempNode = this.head;
		while(tempNode != null) {
			if(((User)tempNode.data).getId() == userId) {
				hittedNode = tempNode;
				break;
			}
			tempNode = tempNode.next;
		}
		
		if(hittedNode == null) {
			user = new User(userId, userId+"");
			Node newNode = new Node(user);
			addToHead(newNode);
			if(length == capacity) {
				removeTail();
			} else {
				length++;
			}
		} else {
			moveToHead(hittedNode);
			user = (User) hittedNode.data;
		}
		return user;
	}
	
	private class Node {
		private Node pre;
		private Object data;
		private Node next;
		public Node(Object data) {
			this.data = data;
		}
		
	}

/*
 * 
 * Considering automation of test is not availible due to internal class, so method below is supplied for unit test
 * 
 */
//	private void pintStatus() {
//		System.out.print("capacity="+capacity+",");
//		System.out.print("length="+length+",");
//		Node node = head;
//		while(node != null) {
//			if(node.data != null) {
//				System.out.print(node.data.toString()+",");
//			} else {
//				System.out.print("data is null");
//			}
//			node = node.next;
//		}
//		System.out.println();
//	}
	
}
