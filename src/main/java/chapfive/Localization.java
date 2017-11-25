package chapfive;

import java.util.Locale;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 5/1/17.
 */
public class Localization{
    public static void main(String... args){
        out.println("Print default Locale: format<language_Country> : " + Locale.getDefault());
        out.println("Rules:" +
                "1. Language is mandatory- you can have a language without a country but not reverse"
        );
        out.println("2. If language and country are present they need to be seperated by _ underscore" );
        out.println("3. Country an dlanguage cannot be reveresed" );
        out.println("4. Language must be lowercase");

        out.println(Locale.GERMAN);
        out.println(Locale.GERMANY);
        out.println(new Locale("fr"));
        out.println(new Locale("kn", "IN"));

        out.println("Create locale using builder pattern");
        out.println(new Locale.Builder().setLanguage("kn").setRegion("IN").build());
        out.println(new Locale.Builder().setRegion("IN").setLanguage("kn").build());
        out.println(new Locale.Builder().setLanguage("kn").build());
        out.println(new Locale.Builder().setRegion("IN").build());

        out.println("Change default locale");
        out.println("Current default: " +Locale.getDefault());
        Locale locale = new Locale("fr"); //Create new locale
        Locale.setDefault(locale); //Set default
        out.println("Changed default: " +Locale.getDefault());



    }

}
