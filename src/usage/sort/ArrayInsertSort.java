package usage.sort;

public class ArrayInsertSort {

	public static Integer[] sort(Integer[] items) {
		for(int i=1; i<items.length; i++) {
			for(int j=0; j<i; j++) {
				// 比较
				if(items[i] < items[j]) {
					int temp = items[i];
					// 下标丛j到i-1的元素往后移动1位
					for(int k=i; k>j; k--) {
						items[k] = items[k-1];
					}
					items[j] = temp;
				}
			}
		}
		return items;
	}
}
