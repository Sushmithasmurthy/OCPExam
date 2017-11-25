package chapfour.builtinfunctionalinterfaces;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/5/17.
 */
public class StreamUsage {
    public static void main(String... args){
        Stream<String> empty = Stream.empty();
        Optional<?> minEmpty = empty.min((s, t) -> 1);//Since stream is empty the comparator is never called.
        out.println(minEmpty.isPresent()); //since stream is empty and the comparator was never called - ispresent is false

        Stream<Integer> singleElement = Stream.of(1);
        Stream<String> singlestringStream = Stream.of(":)");
        Stream<String> arrayStream = Stream.of("smile", "frown", "laugh");
        out.println(arrayStream.count());

        List<String> list = Arrays.asList("stimpsd","so","shapa","phsu");
        Stream<String> fromList = list.stream();

        out.println(fromList.min((x,y)-> x.length() - y.length()));//this closes the stream so in next line if u want to use it again u have to recreate the stream.
        out.println(list.stream().max((x, y) -> x.length() - y.length())); //so use directly from list
        list.stream().findAny().ifPresent(out::println);
        list.stream().findFirst().ifPresent(out::println);

        Stream<String> fromParallelList = list.parallelStream();
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers =Stream.iterate(1, n -> n + 2);
        Stream<String> strStream = Stream.generate(String::new);


        List<String> list1 =Arrays.asList("monkey", "2", "chimp");
        Stream<String> infiniteStrm = Stream.generate(() -> "chimp");
        Predicate<String> pred = x-> Character.isLetter(x.charAt(0));
        out.println(list.stream().anyMatch(pred));
        out.println(list.stream().allMatch(pred));
        out.println(list.stream().noneMatch(pred));
        out.println(infiniteStrm.anyMatch(pred));


        list1.stream().forEach((x)-> System.out.println(x + ",") );//System.out.println(x)

        Stream<Integer> s1 =Stream.of(1);
        //for(Integer i: s1){} // foreach is not applicable for a stream in this way as foreach is a loop here, foreach is applicable to stream only as a terminal operation

        Map<String, String> empDepMap = new HashMap<>();
        empDepMap.put("murtsu","T496");
        empDepMap.put("tharmt","T496");
        empDepMap.put("cramas","T495");
        empDepMap.put("patelsc","T646");
        empDepMap.put("xisher", "T495");

        String[] array = new String[]{"w","o","l","f"};
        String result = "";
        for(String s:array)
            result = result +s;
        out.println("Stream usage");
        Stream<String> st = Stream.of("w", "o", "l", "f");
        out.println(st.reduce("", (s, c) -> s + c));

        Stream<String> st2 = Stream.of("w", "o", "l", "f");
        st2.reduce("",String::concat);
        BinaryOperator<Integer> op = (a,b) ->a*b;
        Stream<Integer> emptyInt =Stream.empty();
        Stream<Integer> oneElement =Stream.of(3);
        Stream<Integer> threeElements =Stream.of(1,2,3);

        emptyInt.reduce(op).ifPresent(out::println);
        oneElement.reduce(op).ifPresent(out::println);
        threeElements.reduce(op).ifPresent(out::println);

        StringBuilder word =   Stream.of("w", "o", "l", "f").collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
        out.println("Collect usage");

        out.println(word);
        out.println("Collect usage on tree");
        TreeSet<String> set = Stream.of("w","o","l","f").collect(TreeSet::new, TreeSet::add,TreeSet::addAll);
        out.println(set);
       // TreeSet<String> set2 = Stream.of("w","o","l","f").collect(TreeSet::new, TreeSet::add,TreeSet::add);// this does not work
        out.println("Collect usage using Collectors approach");
        TreeSet<String> set3 =Stream.of("w","o","l","f").collect(Collectors.toCollection(TreeSet::new));
        out.println(set3);

        Set<String> set4 =Stream.of("w","o","l","f").collect(Collectors.toSet());
        out.println(set4);

        out.println("Integer stream - limit an dskip usage");
        Stream<Integer> intStrm = Stream.iterate(1, n -> n + 1);
        intStrm.skip(2).limit(2).forEach(out::println);

        out.println("map usage");
        Stream<String> s = Stream.of("monkey",  "gorilla", "bonobo");
        s.peek(x -> {
          //  x = x + ","; // bad peek - peek should not try to modify elements.
            out.print(x);
        })
                .map(String::length)
                .forEach(out::println);

        out.println("flatmap usage");
        Stream.of(Arrays.asList(), Arrays.asList("Bonobo"),Arrays.asList("sefr","sdsds","dsdsds","qwqe"))
                .flatMap( l->l.stream())
                .forEach(out::println);

        out.println("sorted usage");
        Stream.of(Arrays.asList(), Arrays.asList("Bonobo"),Arrays.asList("sefr","sdsds","dsdsds","qwqe"))
                .peek(x -> out.println(x + ","))
                .flatMap(l -> l.stream())
                .sorted()
                .forEach(out::println);
        out.println("sortwith comparator");
        Comparator<String> cmp = (x,y)-> x.length() -y.length();
        Stream<String> stringStream = Stream.of("sefr", "sdsds", "dsdsds", "qw");
        stringStream .sorted(cmp)
                .forEach(out::println);

        out.println("sortwith comparator reverse");
        Stream<String> stringStream1 = Stream.of("sefr", "sdsds", "dsdsds", "qw");
        stringStream1.sorted(Comparator.reverseOrder())
                .forEach(out::println);
    }

}
