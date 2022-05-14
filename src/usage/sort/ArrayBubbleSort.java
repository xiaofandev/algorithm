package usage.sort;

public class ArrayBubbleSort {
	
	public static Integer[] sort(Integer[] items) {
		//int bubbleCount = 0;
		for(int i=0; i<items.length; i++) {
			boolean isFinish = true;
			for(int j=0; j<items.length-i-1; j++) {
				if(items[j] > items[j+1]) {// 有交换
					Integer temp = items[j+1];
					items[j+1] = items[j];
					items[j] = temp;
					isFinish = false;
				}
			}
			//bubbleCount++;
			if(isFinish) {
				//System.out.println("冒泡次数" + bubbleCount);
				break;
			}
		}
		return items;
	}
	
}
