package test.usage.cache;

import test.Assert;
import usage.cache.LinkedLRUCache;
import usage.model.User;

public class LinkedLRUCacheTest {
	
	public static void main(String[] args) throws Exception {
		testGetByUserId1();
		testGetByUserId2();
		testGetByUserId3();
		testGetByUserId4();
		testGetByUserId5();
	}
	
	/**
     * description: not hitted, cache is full
     * init status: capacity=3, link = User(0, "0") -> User(1, "1") -> User(2, "2")
     * input: index=3
     * output: User(3, "3")
     */
	public static void testGetByUserId1() throws Exception {
		System.out.println("test method [getByUserId] #1");
		LinkedLRUCache instance = new LinkedLRUCache(3);
		instance.getByUserId(2);
		instance.getByUserId(1);
		instance.getByUserId(0);
		
		User source = instance.getByUserId(3);
		User expect = new User(3, "3");
		Assert.equal(source, expect);
	}
	
	/**
     * description: not hitted, cache is not full
     * init status: capacity=3, length=2, link = User(0, "0") -> User(1, "1")
     * input: index=2
     * output: User(2, 2"),[capacity=3, length=3, link = User(2, "2") -> User(0, "0") -> User(1, "1")]
     */
	public static void testGetByUserId2() throws Exception {
		System.out.println("test method [getByUserId] #2");
		
		LinkedLRUCache instance = new LinkedLRUCache(3);
		instance.getByUserId(1);
		instance.getByUserId(0);
		
		User source = instance.getByUserId(2);
		User expect = new User(2, "2");
		Assert.equal(source, expect);
	}
	
	/**
     * description: hitted, cache contains only 1 data
     * init status: capacity=3, length=1, link = User(0, "0")
     * input: index=0
     * output: User(0, 0"),[capacity=3, length=1, link = User(0, "0")]
     */
	public static void testGetByUserId3() throws Exception {
		System.out.println("test method [getByUserId] #3");
		
		LinkedLRUCache instance = new LinkedLRUCache(3);
		instance.getByUserId(0);
		
		User source = instance.getByUserId(0);
		User expect = new User(0, "0");
		Assert.equal(source, expect);
	}
	
	/**
     * description: hitted, cache is not full
     * init status: capacity=3, length=2, link = User(0, "0") -> User(1, "1")
     * input: index=1
     * output: User(1, 1"),[capacity=3, length=2, link = User(1, "1") -> User(0, "0")]
     */
	public static void testGetByUserId4() throws Exception {
		System.out.println("test method [getByUserId] #3");
		
		LinkedLRUCache instance = new LinkedLRUCache(3);
		instance.getByUserId(1);
		instance.getByUserId(0);
		
		User source = instance.getByUserId(1);
		User expect = new User(1, "1");
		Assert.equal(source, expect);
	}
	
	/**
     * description: hitted, cache is full
     * init status: capacity=3, length=2, link = User(0, "0") -> User(1, "1") -> User(2, "2")
     * input: index=1
     * output: User(1, 1"),[capacity=3, length=3, link = User(1, "1") -> User(0, "0") -> User(2, "2")]
     */
	public static void testGetByUserId5() throws Exception {
		System.out.println("test method [getByUserId] #3");
		
		LinkedLRUCache instance = new LinkedLRUCache(3);
		instance.getByUserId(2);
		instance.getByUserId(1);
		instance.getByUserId(0);
		
		User source = instance.getByUserId(1);
		User expect = new User(1, "1");
		Assert.equal(source, expect);
	}

}
