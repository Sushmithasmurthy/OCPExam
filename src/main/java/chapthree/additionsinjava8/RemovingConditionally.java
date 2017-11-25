package chapthree.additionsinjava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 3/26/17.
 */
public class RemovingConditionally {

    public static void main(String... args){
        //List<String> smallList = Arrays.asList("simba", "pumba", "timbina", "champ");
        List<String> smallList = new ArrayList<>();
        smallList.add("simba");
        smallList.add("pumba");
        smallList.add("timbina");
        smallList.add("champ");
        smallList.removeIf(s -> s.startsWith("s")); //if its list converetd from Arrays as list then you cannot remove elements
        out.println(smallList);

        List<String> sList = Arrays.asList("simba", "pumba", "timbina", "champ");
        sList.replaceAll(s->s+"s");

        sList.forEach(System.out::println);
        System.out.println("----------");
        sList.forEach(x->System.out.println(x));

    }
}
