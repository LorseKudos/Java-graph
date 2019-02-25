package wordSort;

import java.util.*;

public class BubbleSort {
	
	public static void sort(ArrayList<String> arrayList) {
		
		String element;
		
		for (int i = arrayList.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(arrayList.get(j).compareTo(arrayList.get(j+1)) > 0) {
					element = arrayList.get(j);
					arrayList.set(j, arrayList.get(j+1));
					arrayList.set(j+1, element);
				}
			}
		}
	}
}
