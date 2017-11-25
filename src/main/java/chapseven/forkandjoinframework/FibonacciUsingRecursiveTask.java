package chapseven.forkandjoinframework;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.*;

/**
 * Created by SushmithaShamanth on 9/21/17.
 */
public class FibonacciUsingRecursiveTask extends RecursiveTask {
    private final int number;

    public FibonacciUsingRecursiveTask(int number){
        this.number = number;
    }

    @Override
    public Integer compute(){
        if(number<=1)
            return number;
        FibonacciUsingRecursiveTask f1 = new FibonacciUsingRecursiveTask(number-1);
        f1.fork();
        FibonacciUsingRecursiveTask f2 = new FibonacciUsingRecursiveTask(number-2);
        return f2.compute() + (Integer)f1.join();
    }

    public static void main(String... args){
        //to calculate 20th element of Fibonacci-Series
        int number = 10;
        int poolSize = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(poolSize);

        Integer result = (Integer) pool.invoke(new FibonacciUsingRecursiveTask(number));
        System.out.println(number +"the element of Fibonacci Number = "+result);
    }
}
