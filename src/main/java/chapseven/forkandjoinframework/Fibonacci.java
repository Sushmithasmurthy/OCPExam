package chapseven.forkandjoinframework;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;
import java.util.concurrent.RecursiveTask;

/**
 * Created by SushmithaShamanth on 9/20/17.
 */
public class Fibonacci {
List<Integer> fibNs ;



    public static void main(String... args) throws InterruptedException {
        Fibonacci fibObj = new Fibonacci();

        int n = 200;
        System.out.println("Print first " + n + " fibonacci numbers using for loop");
        Long beforeExecFibLoop = System.currentTimeMillis();
        Integer[] fibs = fibObj.fibUsingLoop(n);
        Thread.sleep(1000);
        Long afterExecFibLoop = System.currentTimeMillis();
        System.out.println("Time taken for Loop:"
                + (beforeExecFibLoop - afterExecFibLoop));
       /* for(Integer i : fibs) {
            System.out.print(i + " ");
        }*/


        System.out.println("\nPrint first "+n+" fibonacci numbers using for Recursion");
        fibObj.fibNs = new ArrayList<>();
        Long beforeRecFuncExec = System.currentTimeMillis();
        fibObj.fibNs.add(0);
        fibObj.fibUsingRecursion(0, 1, n);
        Thread.sleep(1000);
        Long afterRecFuncExec = System.currentTimeMillis();

        System.out.println("Time taken using Recursion:" + (beforeRecFuncExec - afterRecFuncExec));
       // fibObj.fibNs.forEach(x->System.out.print(x+ " "));


    }

    private Integer[] fibUsingLoop(int n){
        int prev = 0;
        int current = 1;
        int i = 2;
        Integer[] fibs = new Integer[n];
        fibs[0] = prev;
        fibs[1] = current;
        if(n==2)
            return fibs;
        else{
            while(i<n){

                int temp = current;
                current = current + prev;
                prev = temp;
                fibs[i] = current;
                i++;
            }
            return fibs;
        }


    }

    private int fibUsingRecursion(int prev, int current, int n){
        if(n == 1){
            return -1;
        }
        else{
            this.fibNs.add(current);
            return fibUsingRecursion(current, current+prev, n-1);
        }

    }


}
