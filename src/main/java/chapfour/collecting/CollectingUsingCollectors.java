package chapfour.collecting;

import apple.laf.JRSUIUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;

import static java.lang.System.out;
import static java.util.stream.Collector.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by SushmithaShamanth on 4/13/17.
 */
public class CollectingUsingCollectors {
    public static void main(String... args){

        out.println("Collecting into treeset");

        List<String> abc = Arrays.asList("s", "sd", "dog");
        List<String> anythingStartingWithD = abc.stream()
                .filter( x -> x.startsWith("d"))
                .map(x-> x + "dssd")
                .collect( Collectors.toList());



        Stream<String> s = Stream.of("simp","asa2","dfdg3","asasa4");
        TreeSet<String> tset = s
                .filter(x -> x.startsWith("a"))
                .collect(Collectors.toCollection(TreeSet::new));

        out.println("Collecting using joining");
        Stream<String> strm2 = Stream.of("occealaris clown","guppy","gobi","starfish","molly","goldfish");
        String result2 = strm2.collect(Collectors.joining(","));
        out.println(result2);

        out.println("Finding average between 3 animal names");
        Stream<String> strm3 = Stream.of("occealaris clown","guppy","gobi","starfish","molly","goldfish");
        Double result3 = strm3.collect(Collectors.averagingInt(String::length));
        out.println(result3);

        out.println("Collecting into maps");
        Stream<String> strm4 = Stream.of("occealaris clown","guppy","gobi","starfish","molly","goldfish");
        Map<String, Integer> mapresult = strm4.collect(Collectors.toMap(x -> x, String::length));
        out.println(mapresult);

       out.println("Collecting into maps using to map with Merge");
        Stream<String> strm5 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map<Integer, String> mp = strm5
                .collect(Collectors
                        .toMap(String::length, v -> v, (s1, s2) -> s1 + "," + s2));

        mp.forEach((x, y) -> out.println(x + "->" + y));

        out.println("Collecting into treemap maps using merge and supplier ");
        Stream<String> strm6 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map<Integer, String> treemap = strm6
                .collect(Collectors
                                .toMap(String::length, v -> v, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        treemap.forEach((x, y) -> out.println(x + "->" + y));

        out.println("Collecting into map using groupby");
        Stream<String> strm7 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map<Integer, List<String>> mapRes = strm7
                .collect(Collectors.groupingBy(String::length));
        mapRes.forEach((x,y) -> {
            out.println(x + "->");
            y.forEach(p -> out.println(p));
        });
        out.println("Collecting into Set using groupby");
        Stream<String> strm8 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");

        Map<Integer, Set<String>> setRes = strm8
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));


        setRes.forEach((x,y) -> {
            out.println(x + "->");
            y.forEach(p -> out.println(p));
        });
        out.println("Collecting into treemap and then Set using groupby");
        Stream<String> strm9 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        TreeMap<Integer, Set<String>> treeMapToResSet = strm9
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        treeMapToResSet.forEach((x, y) -> {
                            out.println(x + "->");
                            y.forEach(p -> out.println(p));
                        });

        out.println("Use of paritioning");
        Stream<String> strm10 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map<Boolean, List<String>> partResult = strm10.collect(Collectors.partitioningBy(x -> x.startsWith("g")));
        partResult.forEach( (x,y)-> {
            out.println(x + "->");
            y.forEach(out::println);
        });

        out.println("Use of paritioning");
        Stream<String> strm11 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map<Boolean, Set<String>> partSetResult = strm11.collect(Collectors.partitioningBy( x-> x.startsWith("g"),Collectors.toSet()) );
        partSetResult.forEach( (x,y)-> {
            out.println(x + "->");
            y.forEach(out::println);
        });

        out.println("group by String legth an dcount number of such animals");
        Stream<String> strm12 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map<Integer, Long> groupByRes = strm12.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        groupByRes.forEach((x, y) ->  out.println( x + "->"+y) );


        /*out.println("get the first letter of the first animal of each legth");
        Stream<String> strm13 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map< Integer, Optional<Character> > result = strm13.collect(
               Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(ch -> ch.charAt(0),
                                Collectors.minBy(Comparator.naturalOrder()))));
         out.println(lengthOfFirstLetterOfFirstAnimal);

        out.println("get the first letter of the first animal of each legth using static import");
        Stream<String> strm14 = Stream.of("occealaris clown", "guppy", "gobi", "starfish", "molly", "goldfish");
        Map< Integer, Optional<Character> > result14 = strm14.collect(
               .groupingBy(
                String::length,
                mapping(ch -> ch.charAt(0),
                        Collectors.minBy(Comparator.naturalOrder()))));
         out.println(result14);*/


    }
}
