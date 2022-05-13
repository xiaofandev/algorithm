package test.usage.sort;

import test.Assert;
import usage.sort.InsertSort;

public class InsertSortTest {

	public static void main(String[] args) {
		testSort();
	}
	
	public static void testSort() {
		Integer[] items2 = new Integer[] {1, 2, 4, 6, 3};
		Assert.equal(InsertSort.sort(items2), new Integer[] {1, 2, 3, 4, 6});
		
		Integer[] items = new Integer[] {3, 2, 6, 2, 7, 1};
		Assert.equal(InsertSort.sort(items), new Integer[] {1, 2, 2, 3, 6, 7});
		
	}

}
