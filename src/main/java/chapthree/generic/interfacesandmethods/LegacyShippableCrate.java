package chapthree.generic.interfacesandmethods;

import chapthree.generic.Robot;

/**
 * Created by SushmithaShamanth on 3/16/17.
 */
public class LegacyShippableCrate implements Shippable {
    public void ship(Object t){
        //this will throw class cast exception but does not get detected at compile time
        Robot r = (Robot)t;
        System.out.println("this is the legacy way of using generaic interface where the type of the interace is not specified " + r.getName() );
        //This way of doing makes the code prone to run time classCast exception as not all types are correctly usable as object.
    }

    public static void main(String... args){
        LegacyShippableCrate lc = new LegacyShippableCrate();
        String s = "Hello";
        lc.ship(s);

    }
}
