package chapseven;

import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 5/10/17.
 */
public class SheepManager {
    private int sheepCount =0;
    private void incrementAndReport(){
        out.println((++sheepCount) + " ");
    }

    public static void main(String... args){
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        }finally {
            if(service != null)
                service.shutdown();
        }

    }


}
