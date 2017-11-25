package chapeight;

import java.io.*;

/**
 * Created by SushmithaShamanth on 10/17/17.
 */
public class MarkingTheStream {
    private static String fileName = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/sample.txt";
    public static void main(String... args){
        try( BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName)
        )){
            if(bufferedReader.markSupported()){
                System.out.println("Yay!! mark is supported");
                bufferedReader.mark(10);
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
                bufferedReader.skip(1);
                System.out.println((char) bufferedReader.read());
                bufferedReader.reset();
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
                System.out.println((char) bufferedReader.read());
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
