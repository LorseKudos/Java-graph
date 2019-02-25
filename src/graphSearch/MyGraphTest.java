package graphSearch;

import java.util.*;

public class MyGraphTest {
    public static void main(String args[]) {
    	try {  
	        Scanner sc = new Scanner(System.in);
	        System.out.println("ファイル名を入力してください");
	        String fileName = sc.next();
	        
	        MyGraph mygraph = new MyGraph();
	        mygraph.readFromFile(fileName);
	        
//	        search(sc, mygraph);
	        
	        dijkstra(sc, mygraph);
	        
    	} catch (InputMismatchException e) {
		    System.out.println("引数がint型ではありませんでした");
		    System.exit(-1);
    	}
    }
    
    public static void search(Scanner sc, MyGraph mygraph) {
        int id = sc.nextInt();
        System.out.println("幅優先探索:");
        mygraph.dfs(id);
        System.out.println("深さ優先探索:");
        mygraph.bfs(id);
    }
    
    public static void dijkstra(Scanner sc, MyGraph mygraph) {
    	System.out.println("始点の番号を入力してください");
        int start = sc.nextInt();
        System.out.println("終点の番号を入力してください");
        int goal = sc.nextInt();
        
        Dijkstra d = new Dijkstra();
        d.dijkstra(mygraph, start, goal);
        
        LinkedList<Integer> vertecies = new LinkedList<Integer>();
        vertecies = d.getVertecies();
        System.out.println("ファイル名:" + mygraph.getFileName());
        System.out.println("始点番号:" + start);
        System.out.println("終点番号:" + goal);
        for(int i = 0; i < vertecies.size(); i++) {
        System.out.print(vertecies.get(i));
            if(i == vertecies.size()-1) System.out.println();
            else System.out.print(" ");
        }
        System.out.println(d.getDistance());
    }
}