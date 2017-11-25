package chapseven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;
import java.util.Arrays;


/**
 * Created by SushmithaShamanth on 8/31/17.
 */
public class ConcurrentCollecVsSynchronisedCollec {
    public static final List<Integer> copyOnWriteArrayList= new CopyOnWriteArrayList<>(Arrays.asList(4,3,5));
    public static final List<Integer> arrayList= new ArrayList<>(Arrays.asList(4,3,5));

    public static final List<Integer> synchronisedArrayList = Collections.synchronizedList(
            new ArrayList<Integer>(Arrays.asList(4,3,5))
    );


    public static void main(String... args){

        Thread t1 = new Thread(
            () -> {
                for (Integer item : copyOnWriteArrayList) {
                    System.out.println("copyOnWriteArrayList : "+item + " ");
                    copyOnWriteArrayList.add(9);
                }

                System.out.println("copyOnWriteArrayList contents : " + copyOnWriteArrayList.toString());
            }
        );

        Thread t2 = new Thread(
                () -> {
                    for (Integer item : arrayList) {
                        System.out.println("arrayList: " + item + " ");
                        //arrayList.add(9); //Gives Concurrent modification exception
                    }
                }
        );

        Thread t3 = new Thread(
                () -> {
                    try {
                        Thread.sleep(4000);
                    synchronized (synchronisedArrayList) {

                        for (Integer item : synchronisedArrayList) {
                            System.out.println("synchronisedArrayList: " + item + " ");
                            //  synchronisedArrayList.add(9); //Gives Concurrent modification exception even for synchronisedArrayList
                        }
                    }

                    } catch (InterruptedException ex) {
                        //Handle Interruption
                    }

                }
        );

        Thread t4 = new Thread(
                () -> {
                    synchronized (synchronisedArrayList)
                    {
                        synchronisedArrayList.add(9); //Works fine

                    }
                }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}
