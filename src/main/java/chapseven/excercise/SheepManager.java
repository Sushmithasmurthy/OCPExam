package chapseven.excercise;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SushmithaShamanth on 9/30/17.
 */
public class SheepManager {
    public static AtomicInteger sheepCount1 = new AtomicInteger(0);//W1
    public static int sheepCount2 =0;

    public static void main(String... args) throws InterruptedException{
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor(); //W2
            for(int i=0;i<100;i++)
                service.execute(() ->
                        {   sheepCount1.getAndIncrement();sheepCount2++;}); //W3
            Thread.sleep(100);
            System.out.println(sheepCount1 + " "+ sheepCount2);
        }finally {
            if(service!=null) service.shutdown();
        }
    }
}
