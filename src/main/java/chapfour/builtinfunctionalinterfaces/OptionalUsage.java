package chapfour.builtinfunctionalinterfaces;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Supplier;

import static java.lang.System.out;


/**
 * Created by SushmithaShamanth on 4/4/17.
 */
public class OptionalUsage {
    public static Optional<Double> average(int... scores){
        int sum =0;
        if(scores.length == 0) return Optional.empty();
        for(int score:scores){
            sum +=score;
        }
                return Optional.of((double) sum/scores.length);
    }

    public static void main(String... args) {

            int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            Optional<Double> f = average(a);
            f.ifPresent(System.out::println);
            if (f.isPresent())
                out.println(f.get());
            out.println("Phase 2");
            Optional<Double> f2 = average();
            //f2.get();
            if (f2.isPresent())
                out.println(f2.get());
            Supplier<Double> s1 = () -> 2.0;
            out.println(f2.orElseGet(s1));
            String value = "89";
            Optional o = (value == null) ? Optional.empty() : Optional.of(value);
            out.println(o.get());
            value = null;
            Optional t = Optional.ofNullable(value);
            out.println(t.orElse("blue"));

            Optional<String> t2 = Optional.ofNullable(value);
            Supplier<IllegalArgumentException> c = () -> new IllegalArgumentException();
            out.println(t2.orElseThrow(c));

            Optional t3 = Optional.ofNullable(value);
            //out.println(t3.orElseThrow(() -> new IllegalArgumentException())); //It should not be a generic Optional of type object


      }


}
