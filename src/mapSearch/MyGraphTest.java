package mapSearch;

import java.util.*;
import java.io.*;

public class MyGraphTest {
    public static void main(String args[]) throws IOException, SecurityException{
        try {  
            Scanner sc = new Scanner(System.in);
            System.out.println("graphファイル名を入力してください");
            String graphFileName = sc.next();
            System.out.println("座標ファイル名を入力してください");
            String coordinateFileName = sc.next();
            System.out.println("出発地の経度を入力してください");
            double startLo = sc.nextDouble();
            System.out.println("出発地の緯度を入力してください");
            double startLa = sc.nextDouble();
            System.out.println("目的地の経度を入力してください");
            double goalLo = sc.nextDouble();
            System.out.println("目的地の緯度を入力してください");
            double goalLa = sc.nextDouble();

            Coordinate startCo = new Coordinate((int)Math.round(startLo * 1000000), (int)Math.round(startLa * 1000000));
            Coordinate goalCo = new Coordinate((int)Math.round(goalLo * 1000000), (int)Math.round(goalLa * 1000000));

            int startId = startCo.toId(coordinateFileName);
            int goalId = goalCo.toId(coordinateFileName);

            MyGraph mygraph = new MyGraph();
            mygraph.readFromFile(graphFileName);

            // 最短経路を探索
            long startTime = 0, endTime = 0;
            Dijkstra d = new Dijkstra();
            startTime = System.nanoTime();
            d.dijkstra(mygraph.nodes, startId, goalId);
            endTime = System.nanoTime();

            System.out.println("処理時間:" + (endTime - startTime)/1.0e9 + "秒");

            LinkedList<Integer> vertecies = new LinkedList<Integer>();
            vertecies = d.getVertecies();

            // ファイルに入力
            System.out.println("結果をファイルに書き込みます。書き込みたいファイルの名前を入力してください。");
            String filename = sc.next();
            File file = new File(filename);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);

            System.out.println("ファイルに書き込んでいます。。。");
            int j = 0;
            for(int i=0;i<vertecies.size();i++) {
                if(i == (vertecies.size() / 10) * j) {
                    j++;
                    System.out.print((j-1)*10 + "%..........");
                }
                Coordinate c = new Coordinate(coordinateFileName, vertecies.get(i).intValue());
                fw.write(c.getLongtitude() + " " + c.getLatitude() + "\n");
            }
            fw.close();
            System.out.println("100%");
            System.out.println("書き込みが終了しました");

        } catch (InputMismatchException e) {
            System.out.println("Double型小数値を入力してください。");
        }
    }
}