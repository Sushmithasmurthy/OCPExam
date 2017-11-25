package chapseven.excercise;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by SushmithaShamanth on 9/19/17.
 */
public class MainProgram extends MyTask {
    private Integer[] elements;
    private int a;
    private int b;
    public MainProgram(Integer[] elements, int a, int b){
        this.elements = elements;
        this.a = a;
        this.b = b;
    }

    public Integer compute(){
        if((b-a) <2)
            return Math.min(elements[a],elements[b]);
        else{
            int m = a + ((b-a)/2);
            System.out.println(a + "," + m + "," +b);
            MyTask t1 = new MainProgram(elements,a,m);
            Object result = t1.fork().join();
            return Math.min(new MainProgram(elements ,m, b).compute(), Integer.parseInt(result.toString()));
        }
    }


    public static void main(String... args) throws InterruptedException, ExecutionException{
        /* Integer[] elements = new Integer[]{8,-3,2,-54};
        MyTask task = new MainProgram(elements,0, elements.length-1);
        ForkJoinPool pool = new ForkJoinPool(1);
        Object sum = pool.invoke(task);
        System.out.println("Min: "+ sum);
        Stream<String> s = Stream.of("s", "b", "w", "r");
        List<String> c = new ArrayList<>();
        ExecutorService service = Executors.newSingleThreadScheduledExecutor();

        service.submit(
                () -> {
                    System.out.println("Open Zoo");
                    return null;
                });
        Future<?> result = service.submit(
                ()-> System.out.println("Wake Staff"));
        try{
            System.out.println(result.get());
        }catch(InterruptedException|ExecutionException e){
            e.printStackTrace();
        }

        System.out.println("Question4");
        AtomicLong value1 = new AtomicLong(0);
        final long[] value2 = {0};

        IntStream.iterate( 1, i ->1).limit(100).parallel()
                .forEach(i-> value1.incrementAndGet());
        IntStream.iterate(1,i->1).limit(100).parallel()
                .forEach(i -> ++value2[0]);

        System.out.println(value1 + " " + value2);

        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
        Set<Integer> s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);

        for(Integer item:l2)  l2.add(4); //x1
        for(Integer item:s3) s3.add(5);//x2

        System.out.println(l1.size() + " "+l2.size() + " "+ s3.size());

        Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();
        synchronized (i1){ //y1
            Integer i2 = Arrays.asList(6, 7, 8, 9, 10)
                    .parallelStream()
                    .sorted() //y2
                    .findAny().get(); //y3 //6
            System.out.println(i1+ " " + i2); //1 6
        }


        System.out.println(Arrays.asList("duck","chicken", "flmingo","pelican")
               .parallelStream().parallel()
                .reduce(0,
                        (c1,c2)-> c1.length() + c2.length(),
                                    (s1,s2)-> s1+s2
                        )



        );

        Object o1= new Object();
        Object o2 = new Object();

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<?> f1 = service.submit(
                () -> {
                    synchronized (o1) {
                        synchronized (o2) {
                            System.out.println("Tortoise");
                        }
                    }
                }
        );

        Future<?> f2 = service.submit(
                () -> {
                    synchronized (o2){
                        synchronized (o1){
                            System.out.println("hare");
                        }
                    }
                }
        );

        System.out.println("Do you think this is a deadlock or a live lock");
        f1.get();
        f2.get();


        Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
        Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();

        ConcurrentMap<Boolean,List<String>> data = Stream.of(cats,bears)
                .flatMap( s->s)
                .collect(Collectors.groupingByConcurrent( s-> !s.startsWith("p")));

        System.out.println(data.get(false).size() + " " + data.get(true).size());*/

        MainProgram.addAndPrintItems(new LinkedBlockingDeque<>());


    }

    public static void addAndPrintItems(BlockingDeque<Integer> deque) throws InterruptedException{
        deque.offer(103); //103
        deque.offerFirst(20, 1, TimeUnit.SECONDS); // 20, 103
        deque.offerLast(85, 2, TimeUnit.MINUTES); //20, 103,85
        System.out.println(deque.pollFirst(200, TimeUnit.NANOSECONDS)); //20 leaving 103
        System.out.println(" " + deque.pollLast(25,TimeUnit.SECONDS));

    }
}

/*Answers
1. D,F
2. C, D,F
3. B,C,E
4. F
5. D
6. B
7. G
8. G
9. D,E,F
10.C
11.A, F,G
12.E
13.A,G
14. A
15. C,E,G/
16. H --> Requires further reeading
17. C
18. F
19. A,F
20. A,D
21. A,C
22. F
*/