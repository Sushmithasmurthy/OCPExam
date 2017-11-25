package chapseven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by SushmithaShamanth on 9/16/17.
 */
public class AvoidingStateFullOps {

    public static void main(String... args){
        List<Integer> data = Collections.synchronizedList(new ArrayList<Integer>());//Collections.synchronizedList(
        Arrays.asList(1,2,3,4,5,6).parallelStream()
                .map( i-> {
                    data.add(i);
                    return i;
                })
                .forEachOrdered(i -> System.out.print(i + " "));

        System.out.println();

        for(Integer e:data){
            System.out.print(e + " ");
        }



    }
}
