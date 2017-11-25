package chapfour.primitives;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;

/**
 * Created by SushmithaShamanth on 4/13/17.
 */
public class AdvStreamUSage {
    public static void main(String... args){
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");

        Stream<String> stream = cats.stream();
        cats.add("KC");
        out.println(stream.count());
    }

    private static void threeDigit(Optional<Integer> optional){
        if(optional.isPresent()){
            Integer num = optional.get();
            String s = "" + num;
            if(s.length() == 3)
                out.println(s);
        }
    }

    private static void threeDigitChained(Optional<Integer> optional){
        optional.map( x-> "" + x)
                .filter( x->x.length()==3)
                .ifPresent(out::println);

    }
}
