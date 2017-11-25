package chapthree.generic.interfacesandmethods;

import chapthree.generic.Robot;
import chapthree.generic.RobotInterface;
import chapthree.generic.SemiAutomaticRobot;

/**
 * Created by SushmithaShamanth on 3/16/17.
 */
public class ShippableRobotCrate implements Shippable<Robot> {
    @Override
    public void ship(Robot robot){
        System.out.println("this implements shippable robot");
    }

    public static void main(String... args){
        ShippableRobotCrate lc = new ShippableRobotCrate();
        String s = "Hello";
        //lc.ship(s); // This gives a compiler error only robots or subclass of robot can be passed to ship method
        // -- this saves us from getting a runtime exception
        SemiAutomaticRobot sm = new SemiAutomaticRobot();
        lc.ship(sm);

        RobotInterface raOne = new SemiAutomaticRobot();
        //lc.ship(raOne); //This cannot be done as Shippable is of type Robot not RobotInterface
    }


}
