package usage.sort;

public class BubbleSort {
	
	public static int[] sort(int [] items) {
		for(int i=0; i<items.length; i++) {
			boolean isFinish = true;
			for(int j=0; j<items.length-i-1; j++) {
				if(items[j] > items[j+1]) {// 有交换
					int temp = items[j+1];
					items[j+1] = items[j];
					items[j] = temp;
					isFinish = false;
				}
			}
			if(isFinish) {
				break;
			}
		}
		return items;
	}
	
}
