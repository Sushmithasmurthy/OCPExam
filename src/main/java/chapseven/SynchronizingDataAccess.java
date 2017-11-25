package chapseven;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SushmithaShamanth on 8/23/17.
 */
public class SynchronizingDataAccess {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport(){
        System.out.println((sheepCount.incrementAndGet())+ "");
    }

    public static void main(String... args){
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(55);
            SynchronizingDataAccess manager = new SynchronizingDataAccess();
            for(int i=0;i<10;i++){
                service.submit(()->manager.incrementAndReport());
            }
        }
        finally {
            if(service!=null){
                service.shutdown();
            }
        }
    }
}
