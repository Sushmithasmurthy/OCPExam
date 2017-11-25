import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Created by SushmithaShamanth on 5/22/17.
 */
public class Utilities {

    /*
    You can call this function as shown below:
        Utilities.copyDataFromSourceFileToDestFile(
        "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/source.txt",
        "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destination.txt");
     */
    public static void copyDataFromSourceFileToDestFile(String source, String destination) throws IOException {
        Path srce = Paths.get(source);
        Path dest = Paths.get(destination);
        //Try with Resources
        try(BufferedReader in = Files.newBufferedReader(srce);
            BufferedWriter out = Files.newBufferedWriter(dest)){
            out.write(in.readLine());
            System.out.println("File contents copied successfully from:\n " + source.toString() +"\nto:\n "+dest.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
