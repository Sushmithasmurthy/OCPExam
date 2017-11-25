package chapfour.primitives;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.LongStream;
import java.util.OptionalDouble;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/11/17.
 */
public class PrimitiveStreamUsage {
    public enum PrimStream{
        NON_PRIMITIVE_STREAM,
        INT_STREAM, //used for primitive tyoes int,short,byte,char
        LONG_STREAM, //used for primitive type long
        DOUBLE_STREAM,      //used for primitive type double and float
    }

    public static void main(String... args){

        PrimStream s = PrimStream.DOUBLE_STREAM;
        switch(s){
            case NON_PRIMITIVE_STREAM:
                Stream<Integer> stream = Stream.of(1, 2, 3);
                out.println("Regular non primitive stream");
                out.println(stream.reduce(0, (t, n) -> t + n));
                out.println(Stream.of(1, 2, 3).reduce(0, Integer::sum));
                out.println("Regular non primitive stream to intStream using mapToInt");
                out.println(Stream.of(1,2,3).mapToInt(x -> x).sum());
                break;
            case INT_STREAM:
                out.println("Intstream");
                IntStream intStream = IntStream.of(1,2,3);
                OptionalDouble avg = intStream.average();
                out.println(avg.getAsDouble());


                break;
            case DOUBLE_STREAM:
                out.println("Double Stream");
                out.println("Empty Double Stream");
                DoubleStream empty = DoubleStream.empty();
                empty.forEach(out::println);
                out.println("3Value Double Stream");
                DoubleStream doubleStream = DoubleStream.of(1.1, 2.1, 3.1);
                doubleStream.forEach(out::println);
                out.println("Doublestream with Random generator");
                DoubleStream.generate(Math::random).limit(4).forEach(out::println);
                break;
            case LONG_STREAM:
                out.println("Long Stream");
                LongStream ls = LongStream.of(1,23,3003033030L);
                LongStream firstFour = LongStream.iterate(ls.sum(),n->n+1).limit(4);
                firstFour.forEach(out::println);
                out.println("Long Stream with range");
                LongStream.range(1,5).forEach(out::println);
                out.println("Long Stream with closed range");
                LongStream.rangeClosed(1,5).forEach(out::println);
                break;


        }






    }
}
