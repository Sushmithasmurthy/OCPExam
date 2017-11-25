package chapseven.excercise;

import java.util.concurrent.*;
import java.util.stream.*;

/**
 * Created by SushmithaShamanth on 9/30/17.
 */
public class StockRoomTracker {
    public static void await(CyclicBarrier cb){ //j1
        try{
            cb.await();
        }catch(InterruptedException|BrokenBarrierException e){
            e.printStackTrace();
        }
    }

    public static void main(String... args){
        CyclicBarrier cb = new CyclicBarrier(2,
                ()->System.out.println("Stock room full!") ); //j2
        IntStream.iterate(1,i->1).limit(5)
                .parallel().forEach(i->await(cb)); //j3
    }
}
