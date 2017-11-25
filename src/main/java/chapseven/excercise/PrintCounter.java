package chapseven.excercise;

import java.util.concurrent.*;
import java.util.*;
import java.util.stream.*;
/**
 * Created by SushmithaShamanth on 9/30/17.
 */
public class PrintCounter {
    static int counter = 0;
    public static void main(String... args)throws InterruptedException,ExecutionException{
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<?>> results = new ArrayList<>();
        IntStream.iterate(0,i -> i+1).limit(5).forEach(
                i-> results.add(service.submit(() -> counter++))) ; //n1
                //See this execute always takes a runnable, but if you had used submit that may have worked
        //BEcause subit takes runnable as well as callable
        for(Future<?> result: results){
            System.out.println(result.get()+ " "); //n2
        }

        service.shutdown();
    }

}
