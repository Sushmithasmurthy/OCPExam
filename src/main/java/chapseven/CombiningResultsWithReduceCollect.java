package chapseven;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;
import java.util.List;

/**
 * Created by SushmithaShamanth on 9/16/17.
 */
public class CombiningResultsWithReduceCollect {
    public static void main(String... args){

        System.out.println("Using Reduce");
        System.out.println(Arrays.asList('w','o','l','f')
                .stream()
                .reduce(
                        "",
                        (c,s1)->c+s1,
                        (s2,s3)->s2+s3)
        );

        System.out.println("Combining results with Collect");
        Stream<String> parallelStream = Stream.of("w","o","l","f").parallel();

        SortedSet<String> sortedSet = parallelStream.collect(
                ConcurrentSkipListSet::new, //elements are sorted according to their natural ordering
                Set::add,
                Set::addAll
        );

      System.out.println(sortedSet);

        System.out.println("Using a one argument collect");

        Set<String> set = Stream.of("w","o","l","f")
                .parallel()
                .collect(Collectors.toSet());
        System.out.println(set);

        System.out.println("Use parallel stream and parrallel reduction");
        ConcurrentMap<Integer,String> map = Stream.of("lions","tigers","bears")
                .parallel()
                .collect(Collectors.toConcurrentMap(
                        String::length,
                        Function.identity(),
                        (s1,s2)->s1+","+s2
                ));
        System.out.println(map);
        System.out.println(map.getClass());//We get ConcurrentHAshmap ,
        // but this is not guaranteed- it can be any class that implements ConcurrentMAp


        ConcurrentMap<Integer,List<String>> groupingMap = Stream.of("lions","tigers","bears","leaopards")
                .parallel()
                .collect(
                        Collectors.groupingByConcurrent(String::length) //group by length
                );
        System.out.println(groupingMap);
    }

}
