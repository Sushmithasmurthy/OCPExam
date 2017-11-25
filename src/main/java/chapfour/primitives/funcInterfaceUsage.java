package chapfour.primitives;

import java.util.function.BooleanSupplier;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/13/17.
 */
public class funcInterfaceUsage {

    public static void main(String... args){
        BooleanSupplier b1 = ()->true;
        BooleanSupplier b2 = () -> Math.random() >0.5;
        out.println("functional interface for boolean");
        out.println(b1.getAsBoolean());
        out.println(b2.getAsBoolean());

    }
}
