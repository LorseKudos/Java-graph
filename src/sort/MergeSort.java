package sort;

import java.util.*;

public class MergeSort {
	
	public static void sort(ArrayList<Integer> arrayList){
		
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        
        for(int i = 0; i < arrayList.size(); i++) {
            if(i < arrayList.size() / 2) arrayList1.add(arrayList.get(i));
            else arrayList2.add(arrayList.get(i));
        }
        
        if(arrayList1.size() > 1) {
            sort(arrayList1);
        }
        if(arrayList2.size() > 1) {
            sort(arrayList2);
        }
        
        merge(arrayList1, arrayList2, arrayList);
    }
	
    public static void merge(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2, ArrayList<Integer> mergedArrayList){
    	
    	int size = mergedArrayList.size();
    	
    	mergedArrayList.clear();
    	
        int left = 0, right = 0;
        
        for(int i = 0; i < size; i++) {
            if(right == arrayList2.size() || left != arrayList1.size() && arrayList1.get(left) < arrayList2.get(right)) {
                mergedArrayList.add(arrayList1.get(left));
                left++;
            } else {
                mergedArrayList.add(arrayList2.get(right));
                right++;
            }
        }
    }
}