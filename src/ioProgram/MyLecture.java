package ioProgram;

import java.util.*;
import java.io.*; 

public class MyLecture {
   
   //指定したファイルを一行づつ読み込み
   //Stringの配列として返すメソッド
   public String[] readFile(String intputFileName){
       
       //読み込んだテキストを格納する変数
       ArrayList<String> lines = new ArrayList<>();
       
       try{
           //ファイルを読み込むためのscannerオブジェクトを用意する
           File inputFile = new File(intputFileName);
           Scanner sc = new Scanner(inputFile);     
           //読み込める行がなくなるまで、以下を繰り返す
           while(sc.hasNext()){
               //一行読み込んで変数lineに内容を格納する
               String line = sc.next();
               //linesにlineを追加する
               lines.add(line);
           }  
       } catch(FileNotFoundException ex){ 
           //inputFileNameが存在しない場合には、FileNotFoundExceptionが発生し、ここに飛ぶ
           System.out.println("ファイル" + intputFileName + "は見つかりませんでした");
           return null;
       }
       
       return lines.toArray(new String[0]); //ArrayList<String>型をString[]型に変換
   }
   
   //与えられた文字列の配列を、行番号付きでファイルに出力するメソッド
   public void outputFile(String outputFileName, String[] lines){
       try{
           //出力ファイルに文字列を書き込むためのwriterオブジェクトを用意する
           File outputFile = new File(outputFileName);
           FileWriter writer = new FileWriter(outputFile);
           //与えられた文字列の行数分、以下を繰り返す
           for(int i = 0; i < lines.length; i++){
               String line = lines[i]; //i番目の内容
               int lineNum = i + 1; //行番号
               writer.write(lineNum + "\t" + line + "\n");
           }
           //出力ファイルを閉じる
           writer.close();
       } catch (IOException ex) {
           //なんらかの理由で、出力ファイルにアクセスできない場合、ここに飛ぶ
           System.out.println("ファイルの書き込みに失敗しました");
       }
   }
   
}