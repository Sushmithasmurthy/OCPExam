package chapfive.javaclassresourcebundles;

import java.util.ListResourceBundle;

/**
 * Created by SushmithaShamanth on 5/2/17.
 */
public class Base_nm_IN extends ListResourceBundle {
    @Override
    public Object[][] getContents(){
        return new Object[][]{
                {"hello","ello"},
                {"tired","chillmaadi"},
        };
    }
}
