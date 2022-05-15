package test.usage.sort.performance;

import java.util.Random;

import usage.sort.ArrayBubbleSort;
import usage.sort.ArrayInsertSort;
import usage.sort.ArraySelectionSort;

/**
 * 
 * Test performance of each type of sort
 *
 */
public class PerformanceTest {

	public static void main(String[] args) {
		Integer[] data = mockData();
		testBubbleSort(data);
		testInsertSort(data);
		testSelectionSort(data);
		
		Integer[][] data2 = mockData2();
		testBubbleSort2(data2);
		testInsertSort2(data2);
		testSelectionSort2(data2);
	}
	
	public static void testBubbleSort(Integer[] data) {
		System.out.print("testBubbleSort:");
		long start = System.currentTimeMillis();
		ArrayBubbleSort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testBubbleSort2(Integer[][] data) {
		System.out.print("testBubbleSort2:");
		long start = System.currentTimeMillis();
		for(int i=0; i<data.length; i++) {
			ArrayBubbleSort.sort(data[i]);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testInsertSort(Integer[] data ) {
		System.out.print("testInsertSort");
		long start = System.currentTimeMillis();
		ArrayInsertSort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testInsertSort2(Integer[][] data) {
		System.out.print("testInsertSort2:");
		long start = System.currentTimeMillis();
		for(int i=0; i<data.length; i++) {
			ArrayInsertSort.sort(data[i]);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testSelectionSort(Integer[] data) {
		System.out.print("testSelectionSort:");
		long start = System.currentTimeMillis();
		ArraySelectionSort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testSelectionSort2(Integer[][] data) {
		System.out.print("testSelectionSort2:");
		long start = System.currentTimeMillis();
		for(int i=0; i<data.length; i++) {
			ArraySelectionSort.sort(data[i]);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	/**
	 * Create 1 array which contains 2000000 elements
	 * @see: {@link #mockData2()}
	 * @Deprecated: Since eache type of sort which time cost will be O(n²), 
	 * so the data scale need to be small, one large data task distributed 
	 * to more small data task will be a better choice.
	 */
	@Deprecated
	private static Integer[] mockData() {
		Integer[] a = new Integer[100000];
		for(int i=0; i< a.length; i++) {
			a[i] = new Random().nextInt(10);
		}
		return a;
	}
	
	/**
	 * create 10000 arrays which each contains 200 elements
	 */
	private static Integer[][] mockData2() {
		Integer[][] a = new Integer[10000][200];
		for(int i=0; i< a.length; i++) {
			for(int j=0; j< a[i].length; j++) {
				a[i][j] = new Random().nextInt(10);
			}
		}
		return a;
	}
	
}
