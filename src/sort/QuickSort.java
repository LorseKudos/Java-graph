package sort;

import java.util.*;

public class QuickSort {
	
    public static void sort(ArrayList<Integer> arrayList) {
    	
    	int pivot;
    	
        if(arrayList.size() > 1) {   
	        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
	        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
	        ArrayList<Integer> pivots = new ArrayList<Integer>();

            pivot = pivot(arrayList);
            for(int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) < pivot) {
                    arrayList1.add(arrayList.get(i));
                } else if(arrayList.get(i) > pivot){
                    arrayList2.add(arrayList.get(i));
                } else {
                    pivots.add(arrayList.get(i));
                }
            }
            
            sort(arrayList1);
            sort(arrayList2);
            
            arrayList.clear();
            arrayList.addAll(arrayList1);
            arrayList.addAll(pivots);
            arrayList.addAll(arrayList2);
        }
    }

    public static int pivot(ArrayList<Integer> arrayList) {
    	
        int top, mid, end;

        top = arrayList.get(0);
        mid = arrayList.get(arrayList.size()/2);
        end = arrayList.get(arrayList.size() - 1);
        return Math.max(Math.min(top,mid),end);
    }
}
