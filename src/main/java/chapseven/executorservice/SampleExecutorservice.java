package chapseven.executorservice;

import chapseven.SingleThreadExecutor;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * Created by SushmithaShamanth on 9/26/17.
 */
public class SampleExecutorservice {
    public static void main(String... args){
        //SampleExecutorservice.SingleThreadMethod();
        SampleExecutorservice.FixedThreadWithFuture();

    }

    private static void SingleThreadMethod(){
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.execute(() -> System.out.println("I am Task 1"));
            service.execute(() -> System.out.println("I am Task 2"));
            service.execute(() -> {
                for(int i=0;i<10;i++){
                    System.out.println("I am a for loop - id "+ i +" inside taks 3");
                }
            });
            service.execute(() -> System.out.println("I am Task 4"));
            service.execute(() -> System.out.println("I am Task 5"));
        }finally {
            if(service != null)
                service.shutdown();
        }
    }


    private static  void FixedThreadWithFuture(){
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(3);

            Future<String> t1 = service.submit( () -> {return "i am task 1";});
            Future<String> t2 = service.submit(()-> "I am task 2");
            Future<Integer> t3 = service.submit(()-> 3);
            service.execute(() -> System.out.println("I am task 4"));

            Future<String> t5 = service.submit(()-> {
                for(int i = 0;i<10;i++){
                    System.out.println("I am task 5 " + i);
                }
                return "t5";
            });
            System.out.println(t1.get());
            System.out.println(t2.get());



            while(true) {
                if (t1.isDone() && t2.isDone() && t3.isDone() && t5.isDone()) {
                    System.out.println("All threads completed execution");
                    break;
                }
                Thread.sleep(1000);
            }
            System.out.println(t3.get());

            System.out.println(t5.get());

        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            //Check whetehr all tasks are finished using sevice.isTerminated
            if(service!=null || service.isTerminated()){
                service.shutdown();
            }
        }
    }
}
