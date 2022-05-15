package test.usage.sort;

import test.Assert;
import usage.sort.ArrayBubbleSort;

public class BubbleSortTest {

	public static void main(String[] args) {
		testSort();
	}
	
	public static void testSort() {
		Integer[] data1 = new Integer[] {3, 1, 5, 4, 2};
		Assert.equal(ArrayBubbleSort.sort(data1), new Integer[] {1,2,3,4,5});
		
		Integer[] data2 = new Integer[] {23, 15, 2, 7, 21};
		Assert.equal(ArrayBubbleSort.sort(data2), new Integer[] {2,7,15,21,23});
	}

}
