package chapeight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by SushmithaShamanth on 10/17/17.
 */
public class BufferedReaderAndWriter {
    private static final String sourcefile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/source.txt";
    private static final String destFile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destBufferedReaderWriter"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MMM_YYYY_HH_mm_ss"))+ ".txt";

    public static void main(String... args){
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader(sourcefile)
        )){
            try(BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(destFile)
            )) {
                String s;
                while((s = bufferedReader.readLine())!= null) {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
