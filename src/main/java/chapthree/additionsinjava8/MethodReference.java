package chapthree.additionsinjava8;

import chapthree.comparableVscomparator.Duck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class MethodReference {

    public static void main(String... args){
        List<String> ls = Arrays.asList("lamdas","stream", "methodref");


        Consumer<List<String>> c = Collections::sort;
        Consumer<List<String>> lc = l->Collections.sort(l);

        String str = "abc";
        Predicate<String> p1 = str::startsWith;
        Predicate<String> lp1 = x -> str.startsWith(x); //uses local variable str and parameter x
        Predicate<String> p2 = str::contains;
        Predicate<String> lp2 = x -> str.contains(x);
        Predicate<String> p3 = str::endsWith;
        Predicate<String> lp3 = x -> str.endsWith(x);
        Predicate<String> p4 = str::equals;
        Predicate<String> lp4 = x -> str.equals(x);
        Predicate<String> p5 = str::equalsIgnoreCase;
        Predicate<String> lp5 = x -> str.equalsIgnoreCase(x);

        Predicate<String> p6 = String::isEmpty;
        Predicate<String> lp6 = x->x.isEmpty(); //uses parameter x

        Supplier<String> sup = String::new; // Supplier doe not take any input arguemnet but returns 'T' in Supplier<T>
        Supplier<String> lsup = () -> new String();









    }
}
