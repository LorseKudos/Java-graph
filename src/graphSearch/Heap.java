package graphSearch;

import java.util.*;

public class Heap extends ArrayList<Integer> {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public void heapify(int n) {
        replace(n);
        if(2*(n+1)-1 <= this.size()-1)heapify(2*(n+1)-1);
        if(2*(n+1) <= this.size()-1)heapify(2*(n+1));
        replace(n);        
    }

    public void replace(int n) {
    	int parentKey = this.get(n);
        int parentVal = map.get(this.get(n));
        int child1Key = 0;
        int child1Val = 0;
        int child2Key = 0;
        int child2Val = 0;
        
        if(2*(n+1)-1 <= this.size()-1) {
            child1Key = this.get(2*(n+1)-1);
            child1Val = map.get(this.get(2*(n+1)-1));
        }
        else child1Val = 2147483647; // int型整数の最大値　次の操作でchild1を無視してよいことを示す。
        
        if(2*(n+1) <= this.size()-1) {
        	child2Key = this.get(2*(n+1));
            child2Val = map.get(this.get(2*(n+1)));
        }
        else child2Val = 2147483647; // int型整数の最大値　次の操作でchild2を無視してよいことを示す。
        
        if(child1Val <= child2Val && parentVal > child1Val) {
            this.set(n, child1Key);
            this.set(2*(n+1)-1, parentKey);
        } else if(child1Val >= child2Val && parentVal > child2Val) {
            this.set(n, child2Key);
            this.set(2*(n+1), parentKey);
        }
    }

    public void addHeap(int key, int val) {
        this.add(key);
        map.put(key, val);
        heapify(0);
    }

    public void setValue(int key, int val) {
        map.put(key, val);
        heapify(0);
    }
}