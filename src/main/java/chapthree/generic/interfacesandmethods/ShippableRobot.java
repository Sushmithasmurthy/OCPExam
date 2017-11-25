package chapthree.generic.interfacesandmethods;

import chapthree.generic.*;

/**
 * Created by SushmithaShamanth on 3/16/17.
 */
public class ShippableRobot implements Shippable<RobotInterface> {

        public void ship(RobotInterface raOne){
        System.out.println("This is ra one interface" + raOne.getClass().getCanonicalName());
    }

    public static void main(String... args){
        ShippableRobot lc = new ShippableRobot();
        String s = "Hello";
        //lc.ship(s); // This gives a compiler error only sub interfacesandmethods or classes that implement Robot interface can be passed to ship method
        // -- this saves us from getting a runtime exception
        Robot robo = new Robot("I am Rajni robo");
        lc.ship(robo);

        SemiAutomaticRobot sm = new SemiAutomaticRobot();
        lc.ship(sm);

        RobotInterface raOne = new SemiAutomaticRobot();
        lc.ship(raOne); //This can be done as Shippable is of type Robot not RobotInterface
    }
}
