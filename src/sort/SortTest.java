package sort;

import java.io.*;
import java.util.*;

public class SortTest {
	
	private static boolean fileNotExist = false;
	
	public static void main(String[] args) throws IOException {
        String fileName = "";
        if(args.length == 0) {
            System.out.println("ファイル名を入力してください");
            Scanner sc = new Scanner(System.in);
            fileName = sc.next();
            if(fileName.equals("-q")) {
                System.out.println("プログラムを終了します");
                System.exit(-1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(args.length == 0) inputArrayListFromFile(fileName, arrayList);
        else inputArrayListFromFile(args[0], arrayList);
        while(fileNotExist) {
            Scanner sc = new Scanner(System.in);
            fileName = sc.next();
            if(fileName.equals("-q")) {
                System.out.println("プログラムを終了します");
                System.exit(-1);
            }
            inputArrayListFromFile(fileName, arrayList);
        }
		  // ソートを実行.
//		  BubbleSort.sort(arrayList);
//		  InsertionSort.sort(arrayList);
//        HeapSort.sort(arrayList);
//        MergeSort.sort(arrayList);
        QuickSort.sort(arrayList);
		  // 結果を出力
		  outputArrayListToConsole(arrayList);
	}
	
	private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) throws FileNotFoundException {     
	       try{
	           File inputFile = new File(filename);
	           Scanner sc = new Scanner(inputFile);
        	   while(sc.hasNext()){
        		   arrayList.add(sc.nextInt());
        	   }
	       } catch(FileNotFoundException ex){ 
	    	   System.out.println("指定された名前のファイルが存在しません");
	           System.out.println("もう一度ファイル名を入力してください");
	           System.out.println("プログラムを終了するには\"-q\"と入力してください");
	           fileNotExist = true;
	       } catch (InputMismatchException e) {
	            System.out.println("指定されたファイル内の要素がint型ではありませんでした");
	            System.exit(-1);
	       }
	}
	
	private static void outputArrayListToConsole(ArrayList<Integer> arrayList) {
		
		for(int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%10d",arrayList.get(i));
            if ((i+1) % 10 == 0) {
            	System.out.println();
            }else {
            	System.out.print("\t");
            }
        }
	}

}
