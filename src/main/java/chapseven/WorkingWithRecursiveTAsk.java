package chapseven;

import java.util.Random;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by SushmithaShamanth on 9/17/17.
 */
public class WorkingWithRecursiveTAsk extends RecursiveTask<Double> {
    private int start;
    private int end;
    private Double[] weights;

   public WorkingWithRecursiveTAsk(Double[] weights,int start, int end){
       this.start = start;
       this.end = end;
       this.weights = weights;
   }

    protected Double compute(){
        if(end-start<=3){
            double sum = 0;
            for(int i=start;i<end;i++ ){
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal weighed: "+i);
                sum +=weights[i];
            }
            return sum;
        }else{
            int middle = start + ((end-start)/2);
            System.out.println("start: " + start + " middle: " + middle + " end: " + end);
            RecursiveTask<Double> otherTask = new WorkingWithRecursiveTAsk(weights,start,middle);
            otherTask.fork();
            return new WorkingWithRecursiveTAsk(weights,middle,end).compute() + otherTask.join();

        }
    }

    public static void main(String... args){
        Double[] weights = new Double[10];
        ForkJoinTask<Double> task = new WorkingWithRecursiveTAsk(weights,0,weights.length );
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println("Sum: "+ sum);
    }
}
