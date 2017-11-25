package chapseven;

import java.util.concurrent.*;
/**
 * Created by SushmithaShamanth on 8/20/17.
 */
public class AddData {
    public static void main(String... args) throws InterruptedException, ExecutionException{

        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 30+11);
            System.out.println(result.get());
        }finally {
            if(service !=null)
                service.shutdown();
        }

    }

}
