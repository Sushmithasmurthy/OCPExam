package chapfour.primitives;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/11/17.
 */
public class OptionalUsage {

    public enum OptionalType{
        OPTIONAL_DOUBLE,
        OPTIONAL_INT,
        OPTIONAL_LONG
    }

    public static void main(String... args){
        OptionalType opType = OptionalType.OPTIONAL_DOUBLE;
        switch(opType){
            case OPTIONAL_DOUBLE:
                out.println("OptionalDouble usage");
                IntStream s = IntStream.of(1,2,3);
                OptionalDouble o = s.average();
                o.ifPresent(out::println);
                out.println(o.getAsDouble());

                out.println(o.orElseGet(() -> 2.0));

                DoubleStream d = DoubleStream.generate(Math::random);
                OptionalDouble min = d.peek(out::println).limit(5).min();
                out.println(min);
                break;
            case OPTIONAL_INT:


                break;
            case OPTIONAL_LONG:
                out.println("OptionalLong usage");
                LongStream l = LongStream.of(222222334343L, 10);
                long sum = l.sum();
                out.println(sum);
                break;
        }




    }

}
