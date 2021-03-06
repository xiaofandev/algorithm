package usage.sort;

/**
 *	Every time select a min value element from none select area, 
 *	and add the element to the end of the selected area.  
 */
public class ArraySelectionSort {

	public static Integer[] sort(Integer[] a) {
		for(int i=0; i<a.length; i++) {
			
			// select min value element
			int minOffset = i;
			for(int j=i; j<a.length; j++) {
				if(a[j] < a[minOffset]) {
					minOffset = j;
				}
			}
			
			// add to the end of the selected area
			if(minOffset != i) {
				int temp = a[minOffset];
				a[minOffset] = a[i];
				a[i] = temp;
			}
		}
		return a;
	}
	
}
