package graphSearch;

import java.util.*;
import java.io.*;

public class MyGraph {
    
    ArrayList<LinkedList<MyEdge>> nodes = new ArrayList<LinkedList<MyEdge>>();
    private String name;
    private int ve,ed; //ve=頂点数 ed=枝数
    
    public void readFromFile(String fileName) {
      try{
    	  name = fileName;
    	  File file = new File(fileName);
    	  Scanner sc = new Scanner(file);	
        
    	  ve = sc.nextInt();		
    	  ed = sc.nextInt();	

    	  for(int i = 0; i < ve; i++) {
    		  LinkedList<MyEdge> myEdge = new LinkedList<MyEdge>();
    		  nodes.add(myEdge);
    	  }
        
    	  while(sc.hasNext()) {
    		  int id1=sc.nextInt(), id2=sc.nextInt(), cost=sc.nextInt();
    		  if(cost < 1) {
    			  System.out.println("正のコストをもつグラフのみ対応しています。プログラムを終了します");
    			  System.exit(-1);
    		  }
    		  MyEdge edge1 = new MyEdge(id1, cost);	
    		  MyEdge edge2 = new MyEdge(id2, cost);
            
    		  nodes.get(id1).add(edge2);
    		  nodes.get(id2).add(edge1);
    	  }
      	} catch (FileNotFoundException e) {
      		System.out.println("指定されたファイルは見つかりませんでした。プログラムを終了します");
			System.exit(-1);
      	} catch (InputMismatchException e) {
            System.out.println("指定されたファイル内の要素がint型ではありませんでした");
            System.exit(-1);
      	} 
    }
    
    public void bfs(int id) {
    	try {
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        boolean[] set = new boolean[nodes.size()];
	        Arrays.fill(set,false);
	        
	        list.add(id);
	        System.out.println(id);
	
	        int ve = 0;
	        int buf = 0;
	        LinkedList<MyEdge> myedge = new LinkedList<MyEdge>();
	        while(!list.isEmpty()) {
	            ve = list.remove();
	            set[ve] = true;
	            myedge = nodes.get(ve);
	            for(int i = 0; i < myedge.size(); i++) {
	                buf = myedge.get(i).getId();
	                if(!set[buf] && !list.contains(buf)){
	                    list.add(buf);
	                    System.out.println(buf);
	                }
	            }
	        }
    	} catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("頂点番号は0〜" + (this.ve - 1) + "を入力してください");
            System.exit(-1);
        }
    }
    
    public void dfs(int id) {
    	try {
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        boolean[] set = new boolean[nodes.size()];
	        Arrays.fill(set, false);
	        
	        list.add(id);
	        System.out.println(id);
	
	        int ve = 0;
	        int buf = 0;
	        LinkedList<MyEdge> myedge = new LinkedList<MyEdge>();
	        while(!list.isEmpty()) {
	            ve = list.remove(list.size() - 1);
	            set[ve] = true;
	            myedge = nodes.get(ve);
	            for(int i = 0; i < myedge.size(); i++) {
	                buf = myedge.get(i).getId();
	                if(!set[buf] && !list.contains(buf)){
	                    list.add(buf);
	                    System.out.println(buf);
	                }
	            }
	        }
    	} catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("頂点番号は0〜" + (this.ve - 1) + "を入力してください");
            System.exit(-1);
        }
    }
    
    public LinkedList<MyEdge> getEdges(int id) {
        return nodes.get(id);
    }
    
    public String getFileName() {
        return this.name;
    }
}