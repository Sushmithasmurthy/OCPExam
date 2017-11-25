package chapseven;

import java.util.*;
import java.util.concurrent.*;


/**
 * Created by SushmithaShamanth on 9/17/17.
 */
public class ForkJoinFramework extends RecursiveAction{
    private int start;
    private int end;
    private Double[] weights;
    public ForkJoinFramework(Double[] weights,int start,int end){
        this.start = start;
        this.end = end;
        this.weights = weights;
    }


    protected void compute(){
        if(end-start <=3) {
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);//takes upper bound as the parameter
                System.out.println("Animal weighted: " + i);
            }
        }else{
            int middle = start+((end-start)/2);
            System.out.println("start= "+start+ " middle= " + middle + " end= " +end);
            invokeAll(
                    new ForkJoinFramework(weights,start,middle),
                    new ForkJoinFramework(weights,middle,end)
            );
        }


    }

    public static void main(String... args){
        System.out.println("No of processors: " + Runtime.getRuntime().availableProcessors());
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new ForkJoinFramework(weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        //Print results
        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights)
                .stream()
                .forEach(
                        d-> System.out.print(d.intValue() + " ")
                );

    }



}
