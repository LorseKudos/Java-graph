package sort;

import java.util.*;

public class NonRecursiveHeap {
	
    public static void heap(ArrayList<Integer> arrayList) {
        ArrayList<Integer> heap = new ArrayList<Integer>();
        
        for(int i = 0; i < arrayList.size(); i++) {
            heap.add(arrayList.get(i));
            int position = heap.size();
            while(position != 1) {
                if(heap.get(position - 1) > heap.get(position/2 - 1)) break;
                else {
                    int element = heap.get(position - 1);
                    heap.set(position - 1,heap.get(position/2 - 1));
                    heap.set(position/2 - 1,element);
                    position = position/2;
                }
            }
        }
        
        arrayList.clear();
        arrayList.addAll(heap);
    }
}
