package chapseven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SushmithaShamanth on 9/17/17.
 */
public class WithoutCyclicBarrier {
    private void removeAnimals(){
        System.out.println("Removing animals");
    }

    private void cleanPen(){
        System.out.println("Cleaning pen");
    }

    private void addAnimals(){
        System.out.println("Adding Animals");
    }

    public void performTask(){
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    public static void main(String... args){
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(4);
            WithoutCyclicBarrier manager = new WithoutCyclicBarrier();
            for(int i=0;i<4;i++){
                service.submit(()->manager.performTask());
            }
        }finally {

            if(service!=null)
                service.shutdown();
        }
    }
}
