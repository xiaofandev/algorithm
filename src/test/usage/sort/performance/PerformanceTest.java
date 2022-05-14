package test.usage.sort.performance;

import java.util.Random;

import usage.sort.BubbleSort;
import usage.sort.InsertSort;
import usage.sort.SelectionSort;

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
	}
	
	public static void testBubbleSort(Integer[] data) {
		System.out.print("BubbleSort:");
		long start = System.currentTimeMillis();
		BubbleSort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testInsertSort(Integer[] data ) {
		System.out.print("InsertSort");
		long start = System.currentTimeMillis();
		InsertSort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	public static void testSelectionSort(Integer[] data) {
		System.out.print("SelectionSort:");
		long start = System.currentTimeMillis();
		SelectionSort.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Time used:" + (end-start)+"ms");
	}
	
	private static Integer[] mockData() {
		Integer[] a = new Integer[100000];
		for(int i=0; i< a.length; i++) {
			a[i] = new Random().nextInt(10);
		}
		return a;
	}
	
}
