package chapeight;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by SushmithaShamanth on 10/17/17.
 */
public class FileInputAndOutputStream {
    private static final String sourcefile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/source.txt";
    private static final String destFile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destFileIOStream"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MMM_YYYY_HH_mm_ss"))+ ".txt";

    public static void main(String... args){
        try( FileInputStream fileInputStream = new FileInputStream(sourcefile)){
            try(FileOutputStream fileOutputStream = new FileOutputStream(destFile)){
                //The problem with the below tehnique is that it only returns the number of bytes available for reading ]
                // If the bytes are blocked by a differnet caller this returns 0, even though its unread by the stream resulting in data not being read
                //so do not use the available method-- if you are trying to use it in the context of getting end of file/Stream.
                //while(fileInputStream.available() >0)
                int data;
                while((data = fileInputStream.read())!= -1 )
                fileOutputStream.write(data);
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
