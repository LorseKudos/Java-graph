package mapSearch;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;


public class MyGraph {

    ArrayList<LinkedList<MyEdge>> nodes = new ArrayList<LinkedList<MyEdge>>();

    public void readFromFile(String fileName) {
      try{
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        int ve=sc.nextInt(), ed=sc.nextInt();//ve=頂点数 ed=枝数

        // nodesのi番目の要素が、頂点iから出るすべての枝を要素に持つリストになるようにする
        for(int i=0;i<ve;i++) {// nodesを初期化する
            LinkedList<MyEdge> myEdge = new LinkedList<MyEdge>();
            nodes.add(myEdge);
        }

        while(sc.hasNext()) { // myedgeのリストに情報を追加していく
            int id1=sc.nextInt(), id2=sc.nextInt(), cost=sc.nextInt();
            MyEdge edge1 = new MyEdge(id1, cost);
            MyEdge edge2 = new MyEdge(id2, cost);

            nodes.get(id1).add(edge2);
            nodes.get(id2).add(edge1);
        }

      } catch (FileNotFoundException e) {
            System.out.println("指定されたファイルは見つかりませんでした。プログラムを終了します。");
            System.exit(-1);
      } catch (InputMismatchException e) {
            System.out.println("テキストにはint型整数値を入力してください。");
            System.exit(-1);
      }

    }

    public ArrayList<LinkedList<MyEdge>> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<LinkedList<MyEdge>> nodes) {
        this.nodes = nodes;
    }
    public LinkedList<MyEdge> getEdges(int id) {
        return nodes.get(id);
    }

}