package chapfive.javaclassresourcebundles;

import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 5/1/17.
 */
public class ResourceBundling {
    public static void main(String... args){
        Locale us = new Locale("en", "US");
        Locale kannada_Kar = new Locale("kn", "IN");
        ResourceBundling resourceBundling = new ResourceBundling();
        out.println("resource bundling for kannada");
        resourceBundling.printProperties("lang", kannada_Kar);
        out.println("resource bundling for english");
        resourceBundling.printProperties("lang", us);

        out.println("resource bundling for Kannada from RB class");
       ResourceBundle rb = ResourceBundle.getBundle("chapfive.javaclassresourcebundles.Base"
              );//by default uses default locale which is  , Locale.US
        out.println(rb.getObject("hello"));

        out.println("resource bundle another Java Class");
        Locale nm_IN = new Locale("nm","IN");

        out.println(nm_IN);
        rb = ResourceBundle.getBundle("chapfive.javaclassresourcebundles.Base", nm_IN);

        out.println(rb.getObject("hello"));
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle rb2 = ResourceBundle.getBundle("chapfive.javaclassresourcebundles.Base");

    }

    private void printProperties(String baseClass,Locale l){
        ResourceBundle rb = ResourceBundle.getBundle(baseClass, l);
        rb.keySet()
                .stream()
                .forEach(k -> out.println(k + " : " +rb.getString(k)));
    }
}
