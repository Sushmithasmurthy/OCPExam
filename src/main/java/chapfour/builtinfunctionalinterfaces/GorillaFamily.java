package chapfour.builtinfunctionalinterfaces;

import java.time.*;
import java.util.function.*;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/1/17.
 */
public class GorillaFamily {
    String walk = "walk";

    void everyonePlay(boolean baby){
        String approach = "amble";
        //approach = "run";
        //baby = false;
        this.walk = "blue";
        play(() -> walk);
        play(() -> approach);//local Variable used in lambda should be effectively final
        play(() -> baby?"hitch a ride": "run");

    }
    void play(Gorilla g){
        System.out.println(g.move());
    }

    public static void main(String... args){
        GorillaFamily gf = new GorillaFamily();
        gf.everyonePlay(true);



    }
}
