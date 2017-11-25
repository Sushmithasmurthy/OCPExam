package chapthree.comparableVscomparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class SortRabbits {
    static class Rabbit{
        int id;
        @Override
        public String toString(){
            return Integer.toString(this.id);
        }
        public Rabbit(int id){
            this.id = id;
        }
    }


    public static void main(String... args){
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(100));
        rabbits.add(new Rabbit(90));
        rabbits.add(new Rabbit(10));
        rabbits.add(new Rabbit(190));
        rabbits.add(new Rabbit(19));
        rabbits.add(new Rabbit(9));
        Comparator<Rabbit> rc = new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                return o1.id -o2.id;
            }
        };
        out.println(rabbits);
        Collections.sort(rabbits, rc);
        out.println(rabbits);

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("red",12));
        ducks.add(new Duck("blue",20));
        ducks.add(new Duck("green",10));
        ducks.add(new Duck("purple",15));
        ducks.add(new Duck("yellow", 45));
        ducks.add(new Duck("brown", 90));
        ducks.add(new Duck("red", 30));

        out.println(ducks);
        Collections.sort(ducks);
        out.println(ducks);
        int i = Collections.binarySearch(ducks, new Duck("red", 2));
        out.println(ducks.get(i));

        Consumer<List<Duck>> c = Collections::sort;
        Consumer<List<Duck>> lc = l->Collections.sort(l);

    }

}
