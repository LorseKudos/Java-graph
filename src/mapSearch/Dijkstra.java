package mapSearch;

import java.util.*;

public class Dijkstra {

    private int distance = 0;
    private LinkedList<Integer> vertecies = new LinkedList<Integer>();
    
    public void dijkstra(ArrayList<LinkedList<MyEdge>> nodes, int start, int goal) {
    	try{
    		MyGraph mygraph = new MyGraph();
            mygraph.setNodes(nodes);
            int[] prev = new int[nodes.size()]; //i番目の要素はその頂点への最短経路をたどるときのひとつ前の頂点を表す
	        Arrays.fill(prev, -1);
	        boolean[] checked = new boolean[nodes.size()];
	        Arrays.fill(checked, false);
	        int[] distance = new int[nodes.size()];
	        Arrays.fill(distance, 2147483647);
	        Heap buf = new Heap();
	
	        buf.addHeap(start, 0);
	        prev[start] = -1;
	        distance[start] = 0;
        
	        int current = -1;
	        LinkedList<MyEdge> edges = new LinkedList<MyEdge>();
	        while(!buf.isEmpty()) {
	            current = buf.remove(0);
	            if(current == goal) break;
	            
	            edges = nodes.get(current); // MyEdgeのリスト
	            for(int i = 0; i < edges.size(); i++) {
	            	int id = edges.get(i).getId();
	            	int cost = edges.get(i).getCost();
	                if(!checked[id] && distance[id] == 2147483647) {
	                    distance[id] = distance[current] + cost;
	                    buf.addHeap(id, distance[id]);
	                    prev[id] = current;
	                
	                } else if(!checked[id] && distance[id] > distance[current] + cost) {
	                    distance[id] = distance[current] + cost;
	                    buf.setValue(id, distance[id]);
	                    prev[id] = current;
	                }
	            }
	            checked[current] = true;
	        }
	        if(current != goal) {
	            System.out.println("グラフがダイクストラ法に適してません");
	            System.exit(-1);
	        }
        
	        vertecies.clear();
	        vertecies.add(goal);
	        while(current != start) {
	            vertecies.add(0, prev[current]);
	            current = prev[current];
	        }
	    
	        this.distance = distance[goal];
    	} catch(ArrayIndexOutOfBoundsException e) {
	        System.out.println("入力された頂点番号がグラフに含まれていません");
	        System.exit(-1);
    	}
    }
    
    
    public int getDistance() {
        return distance;
    }

    public LinkedList<Integer> getVertecies() {
        return vertecies;
    }
}