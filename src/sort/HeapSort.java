package sort;

import java.util.*;

public class HeapSort {
	
    public static void sort(ArrayList<Integer> arrayList) {

        ArrayList<Integer> sortedArrayList = new ArrayList<Integer>();
        
        int size = arrayList.size();
        for(int i = 0; i < size; i++) {
			NonRecursiveHeap.heap(arrayList);
        	
            sortedArrayList.add(arrayList.remove(0));
        }
        
        arrayList.clear();
        arrayList.addAll(sortedArrayList);
    }
}
