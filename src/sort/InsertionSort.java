package sort;

import java.util.*;

public class InsertionSort {
	
    public static void sort(ArrayList<Integer> arrayList) {
    	
        int element;
        
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = 0; j <= i; j++) {
            	element = arrayList.get(i+1);	
                if(element <= arrayList.get(j)) {
                    arrayList.set(i+1, arrayList.get(j));
                    arrayList.set(j, element);
                }
            }
        }        
    }
}
