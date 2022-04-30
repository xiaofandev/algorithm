package other;

/**
 * 
 * 使用单链表存储字符串
 * 算法：使用两个指针，用于定位中间节点，一个快慢针每次前进1，一个快指针每次前进2，慢指针前进的同时改变指向为前一个节点
 *
 */
public class PalindromeChecker {

	private Node head;
	
	public PalindromeChecker(String str) {
		if(str == null || str.equals("")) {
			throw new RuntimeException("str parameter can not be null");
		}
		
		Node node = new Node(str.charAt(0));
		this.head = node;
		
		for(int i=1; i<str.length(); i++) {
			node.next = new Node(str.charAt(i));
			node = node.next;
		}
		
	}
	
	public boolean check() {
		Node slow = this.head;
		Node fast = this.head;
		Node pre = null;
		Node next = null;
		
		while(fast.next != null && fast.next.next != null) {// 偶
			// 需求：slow节点的next指向前一个节点，slow指针改变为下一个节点
			fast = fast.next.next;
			
			next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
			
		}
		// 奇
		if(fast.next == null) {
			slow = slow.next;
		} else {
			next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
		}
		while(slow != null) {
			if(slow.ch != pre.ch) {
				return false;
			}
			slow = slow.next;
			pre = pre.next;
		}
		return true;
	}
	
	private class Node {
		char ch;
		Node next;
		private Node(char ch) {
			this.ch = ch;
		}
	}
	
}
