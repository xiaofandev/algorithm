package test.usage.other;

import usage.other.Chrome;

public class ChromeTest {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 测试需求1.回退，访问历史
	 */
	public static void test1() {
		Chrome chrome = new Chrome();
		chrome.operate("aa");
		chrome.operate("bb");
		
	}
	
	/**
	 * 测试需求2.前进（回退后没有其他操作），可以正常访问后面访问的网页
	 */
	public static void test2() {
		
		
	}
	
	/**
	 * 3.前进（回退后有其他操作），禁止前进
	 */
	public static void test3() {
		
		
	}
}
