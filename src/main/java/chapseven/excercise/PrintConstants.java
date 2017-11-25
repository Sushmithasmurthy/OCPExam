package chapseven.excercise;

import java.util.concurrent.*;
import java.util.stream.*;

/**
 * Created by SushmithaShamanth on 9/30/17.
 */
public class PrintConstants {

    public static  void main(String... args){
        ExecutorService service = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159,2.71828)
                .forEach(
                        c->service.submit(
                                ()->System.out.println(10*c)));

        service.execute(()->System.out.println("Printed"));
    }

}
