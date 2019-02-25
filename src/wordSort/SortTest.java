package wordSort;

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
        ArrayList<String> arrayList = new ArrayList<String>();
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
        BucketSort.sort(arrayList);
		  // 結果を出力
		outputArrayListToConsole(arrayList);
	}
	
	private static void inputArrayListFromFile(String filename, ArrayList<String> arrayList) throws FileNotFoundException {     
	       try{
	           File inputFile = new File(filename);
	           Scanner sc = new Scanner(inputFile);
	           sc.useDelimiter("[,.]+\\s?|\\s+"); 
	           String word;
        	   while(sc.hasNext()){
        		   word = sc.next();
                   char c;
                   boolean isWord = true;
                   
                   for(int i = 0; i < word.length(); i++) {
                       c = word.charAt(i);
                       if(!('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z')) isWord = false;
                   }
                   if(isWord) {
                       word = word.toLowerCase();
                       arrayList.add(word);
                   }
        	   }
	       } catch(FileNotFoundException ex){ 
	    	   System.out.println("指定された名前のファイルが存在しません");
	           System.out.println("もう一度ファイル名を入力してください");
	           System.out.println("プログラムを終了するには\"-q\"と入力してください");
	           fileNotExist = true;
	       }
	}
	
	private static void outputArrayListToConsole(ArrayList<String> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
	}

}
