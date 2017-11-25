package chapsix;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * Created by SushmithaShamanth on 5/22/17.
 */
public class RethrowingExceptions {
    public void multicatch() throws SQLException,DateTimeParseException,IOException{
        try{
            parseData();
        }catch(DateTimeParseException|IOException e){
            System.err.println(e);
            throw e;
        }

    }

    /*This apprach is better than the multicatch method
      as this method requires less changes when we need to add new/ remove existing exceptions
      To the parse data method.
    */
    public void rethrowing() throws SQLException,DateTimeParseException,IOException{
        try{
            parseData();
            //Having it as just exception avoids duplication as long as its declared in the method as it thorws the checked execptuions
        }catch(Exception e){
            System.err.println(e);
            throw e;
        }

    }

    public static void parseData() throws IOException{

    }
}
