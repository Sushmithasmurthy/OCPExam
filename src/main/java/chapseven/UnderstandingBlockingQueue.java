package chapseven;

import java.util.concurrent.*;

/**
 * Created by SushmithaShamanth on 8/23/17.
 */
public class UnderstandingBlockingQueue {
    public static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
    public static ExecutorService service = null;
    public static final BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(2);//Look even though you have declared this as final you are able to add elements

    public static void main(String... args){

            Thread t1 = new Thread( () -> {
                try {

                    blockingQueue.offer(1, 60, TimeUnit.SECONDS);
                    blockingQueue.offer(2);
                    blockingQueue.offer(3);
                    blockingQueue.offer(4);
                    blockingQueue.offer(5);
                    System.out.println("T1-blockingQueue : " + blockingQueue.poll());
                    System.out.println("T1-blockingQueue: size: " + blockingQueue.size());

                    System.out.println("T1: "+blockingQueue.poll(10, TimeUnit.SECONDS));
                } catch (InterruptedException ex) {
                    //Handle Interruption
                }
            }
            );

            Thread t2 = new Thread( () ->{
                try {
                    System.out.println("T2-blockingQueue: " + blockingQueue.poll());
                    System.out.println("T2-blockingQueue: size: " + blockingQueue.size());
                    blockingQueue.offer(6);
                    blockingQueue.offer(7);
                    blockingQueue.offer(8);
                    blockingQueue.offer(9, 60, TimeUnit.SECONDS);
                }catch (InterruptedException ex) {
                    //Handle Interruption
                }
            });

        t1.start();
        t2.start();

    try {
        service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
                    try {
                        blockingDeque.offer(1);
                        blockingDeque.offer(2); //1,2
                        System.out.println("Executors1-Blocking Deque: " + blockingDeque.peek());
                        System.out.println("Executors1-Blocking Deque: " + blockingDeque.peekFirst());
                        System.out.println("Executors1-Blocking Deque: " + blockingDeque.peekLast());
                        blockingDeque.offerFirst(3); //1,2 it wont be able to add as the size is limited
                        System.out.println("Executors1-Blocking Deque: size: " + blockingDeque.size());
                        blockingDeque.offerLast(4, 10, TimeUnit.SECONDS); //it ll wait for 60 seconds and then try but if single thread then it ll still not be able to add

                        System.out.println("Executors1-Blocking Deque: " + blockingDeque.poll());
                        System.out.println("Executors1-Blocking Deque: " + blockingDeque.poll());
                        System.out.println("Executors1-Blocking Deque: size: " + blockingDeque.size());
                        blockingDeque.offer(5);
                    } catch (InterruptedException ex) {
                        //Handle Interruption
                    }
                }
        );

        service.execute(() -> {
                    try {
                        System.out.println("Executors2:Blocking Deque: " + blockingDeque.poll());
                        System.out.println("Executors2:Blocking Deque: size: " + blockingDeque.size());
                        blockingDeque.offer(6);
                        blockingDeque.offer(7);
                        blockingDeque.offer(8);
                        System.out.println("Executors2:Blocking Deque: " + blockingDeque.peek());
                        blockingDeque.offer(9, 60, TimeUnit.SECONDS);
                        System.out.println("Executors2:Blocking Deque: " + blockingDeque.peekLast());
                    } catch (InterruptedException x) {

                    }
                }
        );

    }
    finally {
        if (service != null) {
            service.shutdown();
        }
    }

    }
}
