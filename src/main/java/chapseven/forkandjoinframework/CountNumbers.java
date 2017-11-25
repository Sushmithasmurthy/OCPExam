package chapseven.forkandjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by SushmithaShamanth on 9/25/17.
 */
public class CountNumbers extends RecursiveAction {
    protected void compute(){
        if(start<0) return;
        else {
            int middle = start + ((end-start)/2);
            invokeAll(new CountNumbers(start, middle), new CountNumbers(middle, end));
        }

    }

    int start;
    int end;
    public CountNumbers(int start, int end){
        this.start = start;
        this.end = end;
    }

    public static void main(String... args){
        ForkJoinTask<?> task = new CountNumbers(0,4);
        ForkJoinPool pool = new ForkJoinPool();
        Object result = pool.invoke(task);
    }


}
