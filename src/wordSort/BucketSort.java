package wordSort;

import java.util.*;

public class BucketSort {
	
    public static void sort (ArrayList<String> arrayList) {
        ArrayList<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>(26);
        
        for(int i = 0; i < 26; i++) {
            ArrayList<String> empty = new ArrayList<String>();
            buckets.add(empty);
        }

        for(int i = 0; i < arrayList.size(); i++) {
            String word = arrayList.get(i);
            buckets.get(word.charAt(0) - 'a').add(arrayList.get(i));
        }
        
        for(int i = 0; i < 26; i++) {
            BubbleSort.sort(buckets.get(i));
        }

        arrayList.clear();
        for(int i = 0; i < 26; i++) {
        	arrayList.addAll(buckets.get(i));
        }

    }
}
