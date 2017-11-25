package chapfour.excercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.List;
import java.util.Set;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/19/17.
 */
public class Mainprogram {
    public static void main(String... args){

        String c = "Q20";
        switch(c) {
            case "Q1":
                out.println("Q1");
                Stream<String> stream = Stream.iterate("", (s) -> s + "1");
                out.print(stream.limit(2).map(x -> x + "2"));
                break;
            case "Q2":
                out.println("Q2");
                Predicate<? super String> predicate = s -> s.startsWith("g");
                Stream<String> stream1 = Stream.generate(() -> "growl! ");
                Stream<String> stream2 = Stream.generate(() -> "growl! ");
                boolean b1 = stream1.anyMatch(predicate); //any match should return a value as soon as it sees a match
                boolean b2 = stream2.allMatch(predicate); //waits for all the elements hence can run infintely
                out.println(b1 + " " + b2);
                break;
            case "Q3":
                out.println("Q3");
                Predicate<? super String> predicate1 = s->s.length() >3;
                Stream<String> stream3 = Stream.iterate("-", (s)-> s+s);
                boolean b3 = stream3.noneMatch(predicate1);
                boolean b4 = stream3.anyMatch(predicate1);
                out.println(b3+ " " + b4);
                break;
            case "Q10":
                out.println("Q11");
                 out.println(Stream.iterate(1,x->++x)
                         .limit(5)
                        .map(x -> ""+x)
                        .collect(Collectors.joining()));
                break;

            case "Q13":
                out.println("Q13");
                List<Integer> l1 = Arrays.asList(1,2,3);
                List<Integer> l2 = Arrays.asList(4,5,6);
                List<Integer> l3 = Arrays.asList();

                Stream.of(l1,l2,l3).peek(out::println).forEach(x-> out.println(x.toString()));
                      //  .map( x-> x + 1) // this does not work as x is [1,2,3] and 1 is intefer
                break;
            case "Q14":
                out.println("Q14");

                Stream<Integer> s = Stream.of(1);
                IntStream is = s.mapToInt(x -> x);
                DoubleStream ds = s.mapToDouble(x -> x); //Also you cannot use s here it gives runtime exception because stream s is already closed.
                //Stream<Integer> s2 = ds.mapToInt(x-> x); //you cannot convert double to int without explicit cast
                ds.forEach(out::println);
                break;
            case "Q15":
                out.println("QA15");
                //Let me try set on a partition
                Set<String> stringSet =  new HashSet<>();
                stringSet.add("hello");
                stringSet.add("missisispi");

                Map<Boolean, Set<String>> partResult = stringSet.stream()
                        .collect( Collectors.partitioningBy(x-> x.length()>6, Collectors.toSet()));

                partResult.forEach( (x,y)-> out.println(x  +"--> " + y));
                break;

            case "Q16":
                out.println("QA16");
                Stream<String> s1 = Stream.empty();
                Stream<String> s2 = Stream.empty();
                Map<Boolean, List<String>> p = s1.collect(Collectors.partitioningBy(b -> b.startsWith("c")));
                Map<Boolean, List<String>> g = s2.collect(Collectors.groupingBy( b->b.startsWith("c")));
                out.println(p + " " + g);
                break;
            case "Q20":
                List<Integer> l = IntStream.range(1, 6)
                        .mapToObj(i->i)
                        .collect(Collectors.toList());
                l.forEach(out::println);
                IntStream.range(1,6).forEach(out::println);


                break;




        }
    }

}


/*
Solution
13: F
14: D
15: D,E
16: C
17: D---- thsi should be E
18: D
19: A, C,E
20: B


 */