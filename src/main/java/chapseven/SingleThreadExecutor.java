package chapseven;

import java.util.concurrent.*;
/**
 * Created by SushmithaShamanth on 6/11/17.
 */
public class SingleThreadExecutor {

    public static void main(String... args){
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Printing record " + i);
                }
            });

            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        }finally {
            if(service!=null)
                service.shutdown();
        }

    }
}
