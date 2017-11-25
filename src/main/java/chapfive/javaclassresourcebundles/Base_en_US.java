package chapfive.javaclassresourcebundles;

import static java.lang.System.out;

import java.util.ListResourceBundle;
/**
 * Created by SushmithaShamanth on 5/1/17.
 */
public class Base_en_US extends ListResourceBundle{

    @Override
    protected Object[][] getContents(){
        return new Object[][]{
                {"hello", "namaskara"},
                {"tommorrow", "naale"},
                {"holiday", "raja"}};
        }
    }

