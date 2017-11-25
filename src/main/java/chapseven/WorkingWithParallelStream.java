package chapseven;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.Stream;
import java.util.List;

/**
 * Created by SushmithaShamanth on 9/10/17.
 */
public class WorkingWithParallelStream {

    public int processRecord(int input){
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            //Handle interrupted exception
        }
        return input+1;
    }

    public void processAllData(List<Integer> data){
      /* System.out.println(data.stream().map(
                a-> processRecord(a))
                .count());*/

        System.out.println(data.parallelStream().map(
                a -> processRecord(a))
                .count());
    }

    public static void main(String... args){
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        Stream<Integer> parallelStream = Arrays.asList(1,2,3,4,5).parallelStream();

        System.out.println("Using sequential stream");
        stream.forEach(System.out::println);

        System.out.println("Using parrallel streams");
        parallelStream.forEach(System.out::println);

        WorkingWithParallelStream seqStream = new WorkingWithParallelStream();

        //Define Data
        List<Integer> data = new ArrayList<>();
        for(int i=0;i<4000;i++)
            data.add(i);

        //Process the data
        long start = System.currentTimeMillis();
        seqStream.processAllData(data);
        double time = (System.currentTimeMillis()-start)/1000.0;

        //Report results
        System.out.println("\n Tasks completed in : " + time + " seconds");

    }

}
