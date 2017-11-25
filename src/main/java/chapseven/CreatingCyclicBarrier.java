package chapseven;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SushmithaShamanth on 9/17/17.
 */
public class CreatingCyclicBarrier {
    private void removeAnimals(){
        System.out.println("Removing animals");
    }

    private void cleanPen(){
        System.out.println("Cleaningpens");
    }

    private void addanimals(){
        System.out.println("Adding animals");
    }

    public void performTAsk(CyclicBarrier c1, CyclicBarrier c2){
        try{
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addanimals();
        }catch (InterruptedException|BrokenBarrierException e){
            //Handle checked exceptions here
        }
    }

    public static void main(String... args){
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(4);
            CreatingCyclicBarrier manager = new CreatingCyclicBarrier();
            //this number 4 should always match the number of threads in the pool
            //If not cyclic barrier will wait for 4 threads indefinitely
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("**** Pen Cleaned ****")
                    );
            for(int i=0;i<4;i++){
                service.submit(
                        () -> manager.performTAsk(c1,c2)
                );
            }
        }finally {
            if(service!=null)
                service.shutdown();
        }
    }
}
