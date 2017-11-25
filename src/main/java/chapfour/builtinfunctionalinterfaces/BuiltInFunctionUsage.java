package chapfour.builtinfunctionalinterfaces;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.function.*;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/1/17.
 */
public class BuiltInFunctionUsage {
    private enum funcs {
        SUPPLIER,
        CONSUMER,
        BI_CONSUMER,
        PREDICATE,
        BI_PREDICATE,
        FUNCTION,
        BI_FUNCTION,
        USER_DEFN_FUNCTION,
        UNARY_OPERATOR,
        BINARY_OPERATOR
    }

    public static void main(String... args) {
        BuiltInFunctionUsage b = new BuiltInFunctionUsage();

        funcs d = funcs.BINARY_OPERATOR;
        switch (d) {
            case SUPPLIER:
                //Implementing supplier
                Supplier<LocalDate> s1 = LocalDate::now;
                Supplier<LocalDate> s2 = () -> LocalDate.now();
                LocalDate d1 = s1.get();
                LocalDate d2 = s2.get();
                out.println(d1);
                out.println(d2);

                Supplier<StringBuilder> sb1 = StringBuilder::new;
                Supplier<StringBuilder> sb2 = () -> new StringBuilder("a");
                out.println(sb1.get().append("bc"));
                out.println(sb2.get());

                break;
            case CONSUMER:
                Consumer<StringBuilder> cs = (s) -> s.append("12");
                StringBuilder n = new StringBuilder("sa");
                cs.accept(n);
                out.println(n);

                Consumer<String> csb = System.out::println;
                Consumer<String> cst = (s) -> System.out.println(s);
                csb.accept("blah");
                cst.accept("bleh");

                break;

            case BI_CONSUMER:
                BiConsumer<String, Integer> bi1 = (x,y) -> System.out.println(x +y );
                BiConsumer<StringBuilder, StringBuilder> bi2 = StringBuilder::append;
                StringBuilder s23 = new StringBuilder("hello");
                StringBuilder s26 = new StringBuilder("Goody");
                bi1.accept("ewe",3);
                bi2.accept(s23, s26);
                out.println(s23);
                out.println(s26);

                Map<String,Integer> m = new HashMap<>();
                BiConsumer<String, Integer> b1 = m::put;
                BiConsumer<String, Integer> b2 = (x,y) -> m.put(x,y);
                b1.accept("Fish", 10);
                b2.accept("star", 6);
                out.println(m);

            case PREDICATE:
                Predicate<String> p1 = (s)-> s.startsWith("he");
                String s8 = "ahkaj";
                Predicate<String> p2 = s8::contains;

                out.println(p1.test("e"));
                out.println(p2.test("k"));
                out.println("use default methods on predicate");

                Predicate<String> egg = s->s.contains("egg");
                Predicate<String> brown = s-> s.contains("brown");
                Predicate<String> brownEggs = egg.and(brown);
                Predicate<String> otherEggs = egg.and(brown.negate());

                out.println(brownEggs.test("eggPink"));
                out.println(brownEggs.test("eggbrown"));
                out.println(otherEggs.test("eggbrown"));
                out.println(otherEggs.test("eggBlue"));

                break;

            case BI_PREDICATE:
                BiPredicate<String, String> bip1 = (s,p)-> s.startsWith(p);
                Map<String, Integer> mp = new HashMap<>();
                mp.put("bala", 1);
                BiPredicate<String, Integer> bip2 =  mp::remove;
                out.println(bip1.test("shamila","s"));
                out.println(bip2.test("bala", 1));
                break;
            case FUNCTION:
                Function<String, Integer> func1 =  String::length;
                out.println(func1.apply("hello Peio"));

                Function<String, Integer> f2 = x-> x.length();
                out.println(f2.apply("hello"));
                break;
            case BI_FUNCTION:
                BiFunction<String, String, String> bif1 = String::concat;
                BiFunction<String,String, String> bif2 = (s,t)->s.concat(t);
                out.println(bif1.apply("Sush","mitha"));
                out.println(bif2.apply("Sham", "anth"));
                break;
            case USER_DEFN_FUNCTION:
                TriFunction<String, String, Integer, String> tri1 = (x,y,z)-> {
                    String result;
                    if(x.contains(y))
                        result = x.concat(y);
                    else
                        result = x.concat(z.toString());
                    return result;
                };
                out.println(tri1.apply("sush", "s", 23));
                break;
            case UNARY_OPERATOR:
                UnaryOperator<Integer> u1 = Integer::new;
                UnaryOperator<Integer> u2 = x-> ++x;
                out.println(u1.apply(23));
                out.println(u2.apply(34));
                break;
            case BINARY_OPERATOR:
                BinaryOperator<Integer> bu1 = (x,y) -> (x*y)+123;
                out.println(bu1.apply(10, 99));

                break;

        }
    }

}
