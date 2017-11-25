package chapeight;

import java.io.*;

/**
 * Created by SushmithaShamanth on 10/17/17.
 * This is completely different from the streams API introduced in Chap 4.
 */
public class IntroducingStreamOperations {

    private static final String textFile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/sample.txt";
    private static final String imgFile = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/IMG_0567.jpg";

    public static void main(String... args) {
        System.out.println("lowLevelStreamsWrapedInHighLevelStream");
        IntroducingStreamOperations.lowLevelStreamsWrapedInHighLevelStream();
        System.out.println("highLevelStreamsWrapedInHighLevelStream");
        IntroducingStreamOperations.highLevelStreamsWrapedInHighLevelStream();
    }
    /*
    Readers and writers - allow reading/writing only charatercs and strings
     */
    private static void lowLevelStreamsWrapedInHighLevelStream() {
        try (BufferedReader bufferedReader = new BufferedReader( //Buffered reader is a high level stream and it access data in chunks, also as it is a reader it can read only characters and strings
                //File reader is a low level stream and it connects directly with the source of the data such as file, array or string
                //Lowlevel streams such as filereader directly access raw data or the resource in unfiltered manner.
                new FileReader(textFile)
        )) {
            //System.out.println(bufferedReader.readLine());//The above wrote only the first line so if i want to type the contents of the entire file, u need to prßint it line by line

            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Stream classes allow reading/writing of binary or byte data.
     */
    private static void highLevelStreamsWrapedInHighLevelStream(){
        //Stream classes can input or output all types of binary or byete data
        try(ObjectInputStream objectInputStream = new ObjectInputStream( //Object input stream is another high level stream
                new BufferedInputStream( //Buffered input stream is a high level stream
                        new FileInputStream(imgFile) //File input stream is a low level stream --Also i am not able able to read both text file and mg file
                )
        )){
            System.out.println(objectInputStream.readObject());
        }catch(ClassNotFoundException|IOException ex){
            ex.printStackTrace();
        }
    }
}