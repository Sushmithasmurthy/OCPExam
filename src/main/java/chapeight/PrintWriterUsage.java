package chapeight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SushmithaShamanth on 10/18/17.
 */
public class PrintWriterUsage {
    private static final String fileName = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/printWriterFile.txt";
    public static void main(String... args){
        try(PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileName)
                )
        )){
            printWriter.println("hello - I am print writer and i can write characters");
            printWriter.format("i can also format %s and print", "data");
            printWriter.println();
            printWriter.println("Although i dont add new line if use onl print or format so i use println");

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
