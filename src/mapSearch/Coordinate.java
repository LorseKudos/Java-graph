package mapSearch;

import java.util.*;
import java.io.*;

public class Coordinate {
    
    private int longtitude, latitude;
    
    public Coordinate(int longtitude, int latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public Coordinate(String filename, int id) { // id番号に対応する経度と緯度を探して座標を初期化
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            int num = sc.nextInt();

            int id2 = 0, lo = 0, la = 0;
            while(sc.hasNext()) {
                id2 = sc.nextInt();
                lo = sc.nextInt();
                la = sc.nextInt();
                
                if(id2 == id) {
                    longtitude = lo;
                    latitude = la;
                    break;
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("指定されたファイルが見つかりませんでした。");
            System.exit(-1); 
        } catch(InputMismatchException e) {
            System.out.println("指定されたファイルが見つかりませんでした。");
            System.exit(-1); 
        }
    }

    public int getLongtitude() { 
        return longtitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLongtitude(int lo) {
        longtitude = lo;
    }

    public void setLatitude(int la) {
        latitude = la;
    }

    public int toId(String filename) { // 経度と緯度の組を頂点番号に変換する
        try {
            
            Coordinate c = new Coordinate(0, 0);
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            int num = sc.nextInt(); // 頂点数
            
            int id = 0, cur = 0, lo = 0, la = 0;
            long powDis = 0, min = 2147483647, dlo = 0, dla = 0;
            while(sc.hasNext()) { // 眺めてみたけどソートされてるわけでもなさそうなので普通に線形で探索
                id = sc.nextInt();
                lo = sc.nextInt();
                la = sc.nextInt();
                
                dlo = longtitude - lo;
                dla = latitude - la;
                powDis = dlo * dlo + dla * dla;
                if(powDis < min) {
                    min = powDis;
                    cur = id;
                }
            }

            return cur;

        } catch (FileNotFoundException e) {
            System.out.println("指定されたファイルが見つかりませんでした。もういちどファイル名を入力してください");
            Scanner sc = new Scanner(System.in);
            String filename2 = sc.next();
            int id = toId(filename2);
            return id;
        } catch (InputMismatchException e) {
            System.out.println("ファイルにはint型整数値のみを入れてください。");
            System.exit(-1);
            return 0;
        }
    }
}