package chapten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SushmithaShamanth on 11/15/17.
 */
public class CheckIfSQLExceptionISChecked {



    public static void main(String... args){
        try {
            Connection conn = DriverManager.getConnection("");
        }catch (SQLException yesCheckedExceptio){

        }
    }

}
