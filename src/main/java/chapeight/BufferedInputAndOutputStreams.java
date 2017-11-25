package chapeight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by SushmithaShamanth on 10/17/17.
 */
public class BufferedInputAndOutputStreams {
    private static final String sourcefile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/source.txt";
    private static final String destFile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destBufferedIOStream"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MMM_YYYY_HH_mm_ss"))+ ".txt";

    public static void main(String... args){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(sourcefile)
        )){
            try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream(destFile)
            )){
                byte[] buffer = new byte[1024];
                int lengthRead;
                while((lengthRead = bufferedInputStream.read(buffer))>0){
                    bufferedOutputStream.write(buffer,0,lengthRead);
                    bufferedOutputStream.flush();
                }

            }catch(IOException ex){
                ex.printStackTrace();
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
