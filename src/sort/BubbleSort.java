package sort;

import java.util.*;

public class BubbleSort {
	
	public static void sort(ArrayList<Integer> arrayList) {
		
		int element;
		
		for (int i = arrayList.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(arrayList.get(j) > arrayList.get(j+1)) {
					element = arrayList.get(j);
					arrayList.set(j, arrayList.get(j+1));
					arrayList.set(j+1, element);
				}
			}
		}
	}
}
