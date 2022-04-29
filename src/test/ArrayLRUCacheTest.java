package test;

import cache.ArrayLRUCache;

public class ArrayLRUCacheTest {

	public static void main(String[] args) throws Exception {
		ArrayLRUCache.testMove();
		ArrayLRUCache.testGetOffsetByUserId();
		ArrayLRUCache.testGetByUserId();
	}
}
