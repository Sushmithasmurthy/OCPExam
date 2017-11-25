package chapeight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by SushmithaShamanth on 9/30/17.
 */
public class FileOperations {

    private static final String pathOfFile = new String("/Users/SushmithaShamanth/IdeaProjects/OCPExam");

    public static void main(String... args) {
        echo("Reader and writer are used for inputting only character and string data");
        try(
                BufferedReader bufferedReader = new BufferedReader(

                        new FileReader("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destination.txt"))
                ) {
                    echo(bufferedReader.readLine());
                }catch(IOException e){
            e.printStackTrace();

        }

      /*  echo("Stream classes are used for inputting an outputting all types of binary or byte data");
        try(ObjectInputStream objectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/sample.txt"))
                )){
            //echo(objectStream.readObject());
        }catch(IOException e){
            e.printStackTrace();
        }*/



        echo("How can u get File path sepeartor");

        echo("System.getProperty(\"file.separator\") = " + System.getProperty("file.separator"));

        echo("File.separator = " + File.separator);

        echo("File.pathSeparator = " + File.pathSeparator);

        echo("");

        File f = new File(pathOfFile);
        echo("List details of all Files under" + f.getAbsolutePath());
        for(File file : f.listFiles()) {
            echo("FileName= " + file.getName()
                            + "\nFile Size= " + file.length()
                            + "\nIs File? = " + file.isFile()
                            + "\nIs Directory? = " + file.isDirectory()
                            + "\nLast Modified= " + LocalDateTime.ofEpochSecond(file.lastModified(), 0, ZoneOffset.UTC)
                            + "\ngetParent= " + file.getParent()
                            + "\ngetPath= " + file.getPath()
            );
            echo("\n******\n");
        }






    }

    private static void echo(Object message){
        if(message instanceof String)
        System.out.println(message);
    }

}
