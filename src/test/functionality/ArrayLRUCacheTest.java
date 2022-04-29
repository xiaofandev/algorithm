package test.functionality;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cache.ArrayLRUCache;
import data.model.User;
import test.Assert;

public class ArrayLRUCacheTest {
	
	/**
     * description: test exception
     * init status: capacity=3, cache = [null, null,null]
     * input: index=3
     * output: null,[ throw runtime exception ]
     */
    private static void testMove1() throws Exception{
    	ArrayLRUCache instance1 = new ArrayLRUCache(3);
    	try {
    		Method move = ArrayLRUCache.class.getDeclaredMethod("move", int.class);
    		move.invoke(instance1, 3);
    		Assert.failure();
    	} catch (Exception e) {
			Assert.success();
		}
    }
    
    /**
     * description: cache not full
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"),null]
     * input: index=1
     * output: null,[capacity=3, cache = [User(0, "0"), User(0, "0"), null] 
     */
    private static void testMove2() throws Exception{
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), null});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("move", int.class);
    	method.setAccessible(true);
    	method.invoke(instance, 1);
    	
    	User[] source = (User[]) field.get(instance);
    	User[] expect = new User[] {new User(0, "0"), new User(0, "0"), null};
    	Assert.equal(source, expect);
    }
    
    /**
     * description: cache is full
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"),User(2, "2")]
     * input: index=1
     * output: null,[capacity=3, cache = [User(0, "0"), User(0, "0"), User(1, "1")] 
     */
    private static void testMove3() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), new User(2, "2")});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("move", int.class);
    	method.setAccessible(true);
    	method.invoke(instance, 1);
    	
    	User[] source3 = (User[]) field.get(instance);
    	User[] expect3 = new User[] {new User(0, "0"), new User(0, "0"), new User(1, "1")};
    	Assert.equal(source3, expect3);
    }
    
    /**
     * description: cache empty
     * init status: capacity=3, cache = [null, null, null]
     * input: 1
     * output: throw a runtime exception
     */
    private static void testGetOffsetByUserId1() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getOffsetByUserId", int.class);
    	method.setAccessible(true);
    	try {
    		method.invoke(instance, 1);
    	} catch (Exception e) {
			Assert.success();
		}
    	
    }
    
    /**
     * description: cache not empty,user exist
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"), null]
     * input: 1
     * output: 1
     */
    private static void testGetOffsetByUserId2() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), null});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getOffsetByUserId", int.class);
    	method.setAccessible(true);
    	int source = (int) method.invoke(instance, 1);
    	Assert.equal(source, 1);
    	
    }
    
    /**
     * description: cache not empty,user not exist
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"), null]
     * input: 2
     * output: throw a runtime exception
     */
    private static void testGetOffsetByUserId3() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), null});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getOffsetByUserId", int.class);
    	method.setAccessible(true);
    	try {
    		method.invoke(instance, 2);
    	} catch (Exception e) {
			Assert.success();
		}
    }
    
    /**
     * description: cache data empty
     * init status: capacity=3, cache = [null, null, null]
     * input: 1
     * output: User(1, "1"),[status: capacity=3, cache = [User(1, "1"), null, null]]
     */
    private static void testGetByUserId1() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getByUserId", int.class);
    	method.setAccessible(true);
    	User source = (User) method.invoke(instance, 1);
    	User expect = new User(1, "1");
    	Assert.equal(source, expect);
    	
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	User[] source_status = (User[]) field.get(instance);
    	User[] expect1_status = new User[]{new User(1, "1"), null, null};
    	Assert.equal(source_status, expect1_status);
    	
    }
    
    /**
     * description: data not found, cache is not full
     * init status: capacity=3, cache = [User(0, "0"), null, null]
     * input: 1
     * output: User(1, "1"),[status: capacity=3, cache = [User(1, "1"), User(0, "0"), null]]
     */
    private static void testGetByUserId2() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), null, null});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getByUserId", int.class);
    	method.setAccessible(true);
    	User source = (User) method.invoke(instance, 1);
    	User expect = new User(1, "1");
    	Assert.equal(source, expect);
    
    	User[] source_status = (User[]) field.get(instance);
    	User[] expect1_status = new User[]{new User(1, "1"), new User(0, "0"), null};
    	Assert.equal(source_status, expect1_status);
    }
    
    /**
     * description: data not found, cache is full
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"), User(2, "2")]
     * input: 3
     * output: User(3, "3"),[status: capacity=3, cache = [User(3, "3"), User(0, "0"), User(1, "1")]]
     */
    private static void testGetByUserId3() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), new User(2, "2")});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getByUserId", int.class);
    	method.setAccessible(true);
    	User source = (User) method.invoke(instance, 3);
    	User expect = new User(3, "3");
    	Assert.equal(source, expect);
    
    	User[] source_status = (User[]) field.get(instance);
    	User[] expect1_status = new User[]{new User(3, "3"), new User(0, "0"), new User(1, "1")};
    	Assert.equal(source_status, expect1_status);
    	
    }
    
    /**
     * description: data found, cache is not full
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"), null]
     * input: 1
     * output: User(1, "1"),[status: capacity=3, cache = [User(1, "1"), User(0, "0"), null]]
     */
    private static void testGetByUserId4() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), null});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getByUserId", int.class);
    	method.setAccessible(true);
    	User source = (User) method.invoke(instance, 1);
    	User expect = new User(1, "1");
    	Assert.equal(source, expect);
    
    	User[] source_status = (User[]) field.get(instance);
    	User[] expect1_status = new User[]{new User(1, "1"), new User(0, "0"), null};
    	Assert.equal(source_status, expect1_status);
    	
    }
    
    /**
     * description: data found, cache is full
     * init status: capacity=3, cache = [User(0, "0"), User(1, "1"), User(2, "2")]
     * input: 1
     * output: User(1, "1"),[status: capacity=3, cache = [User(1, "1"), User(0, "0"), User(2, "2")]]
     */
    private static void testGetByUserId5() throws Exception {
    	ArrayLRUCache instance = new ArrayLRUCache(3);
    	Field field = ArrayLRUCache.class.getDeclaredField("cache");
    	field.setAccessible(true);
    	field.set(instance, new User[]{new User(0, "0"), new User(1, "1"), new User(1, "1")});
    	
    	Method method = ArrayLRUCache.class.getDeclaredMethod("getByUserId", int.class);
    	method.setAccessible(true);
    	User source = (User) method.invoke(instance, 1);
    	User expect = new User(1, "1");
    	Assert.equal(source, expect);
    
    	User[] source_status = (User[]) field.get(instance);
    	User[] expect1_status = new User[]{new User(1, "1"), new User(0, "0"), new User(2, "2")};
    	Assert.equal(source_status, expect1_status);
    	
    }
    
    public static void testMove() throws Exception {
    	System.out.println("test method [move]");
		testMove1();
		testMove2();
		testMove3();
		System.out.println();
    }
    
    public static void testGetOffsetByUserId() throws Exception {
    	System.out.println("test method [getOffsetByUserId]");
    	testGetOffsetByUserId1();
    	testGetOffsetByUserId2();
    	testGetOffsetByUserId3();
    	System.out.println();
    }
    
    public static void testGetByUserId() throws Exception {
    	System.out.println("test method [getByUserId]");
    	testGetByUserId1();
    	testGetByUserId2();
    	testGetByUserId3();
    	testGetByUserId4();
    	testGetByUserId5();
    	System.out.println();
    }

	public static void main(String[] args) throws Exception {
		testMove();
		testGetOffsetByUserId();
		testGetByUserId();
	}
}
