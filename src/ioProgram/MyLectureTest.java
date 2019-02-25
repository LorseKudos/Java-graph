package ioProgram;

public class MyLectureTest {
	   public static void main(String[] args){
	       MyLecture lecture = new MyLecture();
	       String[] lines = lecture.readFile("mylecture.txt");      
	       if(lines != null){ //ファイルが読み込めたら
	           lecture.outputFile("mylecture2.txt", lines);
	       }
	   }
	}