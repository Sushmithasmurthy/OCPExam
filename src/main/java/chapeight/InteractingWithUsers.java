package chapeight;

import chapseven.SynchronizingDataAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Console;

/**
 * Created by SushmithaShamanth on 10/18/17.
 */
public class InteractingWithUsers {
    public static void main(String... args){
        System.out.println("Read Data OldWay by using system.in wrapped inside a Stream reader that reads a stream and builds a reader object out of it.");
        readDataOldWay();
        System.out.println("Read Data Using Console Class");
        readDataUsingConsoleClass();
        System.out.println("Program completed successfully!!");
    }

    private static void readDataOldWay()  {
        try{
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )
            );
            String userInput = bufferedReader.readLine();
            System.out.println("User Input: " + userInput);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static void readDataUsingConsoleClass(){
        Console console = System.console();
        if(console != null) {
            String userInput = console.readLine();
            System.out.println("User Input using console class: " + userInput);
        }else{
            System.out.println("System.console is null as this is running in an environmnet where text interaction is not supported!");
        }
    }
}
