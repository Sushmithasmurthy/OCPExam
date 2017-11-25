package chapseven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SushmithaShamanth on 8/23/17.
 */
public class ImprovingAccessWithSyncBlock {
    private int sheepCount = 0;
    private synchronized void incrementAndReport(){ //Or synchronised method
       // synchronized (this){ Synchronised block
            System.out.println((++sheepCount)+"");
       // }
    }

    public static void main(String... args){
        ExecutorService service =null;
        try{
            service = Executors.newFixedThreadPool(20);
            ImprovingAccessWithSyncBlock manager = new ImprovingAccessWithSyncBlock();
            for(int i=0;i<10;i++){
                service.submit(()->manager.incrementAndReport());
            }
        }finally {
            if(service!=null)
                service.shutdown();
        }
    }
}
