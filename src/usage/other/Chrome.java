package usage.other;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 需求：
 * 1.回退，访问历史
 * 2.前进（回退后没有其他操作），可以正常访问后面访问的网页
 * 3.前进（回退后有其他操作），禁止前进
 *
 */
public class Chrome {

	private LinkedList<String> stack1 = new LinkedList<>();
	private LinkedList<String> stack2 = new LinkedList<>();
	
	public String operate(String address) {
		stack1.push(address);
		clearBackward();
		return address;
	}
	
	public String backward() {
		String address = null;
		if(stack1.iterator().hasNext()) {
			stack1.pop();
			stack2.push(address);
		}
		return address;
	}
	
	public String forward() {
		String address = null;
		if(stack2.iterator().hasNext()) {
			address = stack2.pop();
			stack1.push(address);
		}
		return address;
	}
	
	private void clearBackward() {
		Iterator<String> iter = stack2.iterator();
		while(iter.hasNext()) {
			stack2.remove(iter.next());
		}
	}
	
}
