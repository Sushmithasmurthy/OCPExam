package chapthree.generic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 3/26/17.
 */
public class Hello<T> {
    T t;
    public Hello(T t){
        this.t = t;
    }
    public String toString(){
        return t.toString();
    }

    public static void main(String[] args){
        out.println(new Hello<String>("hi"));
        out.print(new Hello("there"));


        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(23));
        numbers.add(22L);

        TreeSet<String> tree = new TreeSet<>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        out.println(tree.ceiling("On"));
    }
}
