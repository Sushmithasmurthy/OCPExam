package chapsix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by SushmithaShamanth on 5/22/17.
 */
public class TryWithResources {

    public static void main(String... args) throws IOException{
        Path source = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/source.txt");
        Path destination = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destination.txt");
        copyDataFromSourceFileToDestFile(source, destination);

    }
    private static void copyDataFromSourceFileToDestFile(Path source, Path dest) throws IOException{
        try(BufferedReader in = Files.newBufferedReader(source);
            BufferedWriter out = Files.newBufferedWriter(dest)){
            out.write(in.readLine()); //the scope of out is limited to this try block and cannot be used in catch block
            System.out.println("File contents copied successfully from:\n " + source.toString() +"\nto:\n "+dest.toString());
        } //0 catch and 0 finally block is allowed only for try with resources.
    }

    private static void readData(){
        try(Scanner s = new Scanner(System.in)){
            s.nextLine();
        }catch(Exception e){
            //s is not accessible from here- the scope of s is limited to try block.
            //s.nextLine();
        }finally{
            //s is not accessible from here- the scope of s is limited to try block.
            //s.nextLine();
        }
    }
}
