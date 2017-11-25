package chapseven;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Created by SushmithaShamanth on 8/20/17.
 */
public class CallableVsSupplier {
    public static void useCallable(Callable<Integer> expression){

    }

    public static void useSupplier(Supplier<Integer> expression){

    }

    public static void use(Supplier<Integer> expression){

    }

    public static void use(Callable<Integer> expression){

    }

    public static void main(String... args){
        useCallable(() -> {
            throw new IOException(); //Callable is permitted to throw checked exception
        });

       // useSupplier(() ->{   throw new IOException();   }); //Supplier is not permitted to throw checked exception
       // use( () -> { throw new IOException();   }); //Ambiguous lambda expression

    }
}
