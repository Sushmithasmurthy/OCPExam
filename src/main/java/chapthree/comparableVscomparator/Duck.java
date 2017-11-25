package chapthree.comparableVscomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class Duck implements Comparable<Duck> {
    private String name;
    private int wt;

    public Duck(String name) {
        this.name = name;
        this.wt = 0;
    }

    public Duck(String name, int wt) {
        this.name = name;
        this.wt = wt;
    }

    @Override
    public int compareTo(Duck bd){
        return this.name.compareTo(bd.name);
    }

    @Override
    public String toString(){
        return this.name+":"+this.wt;
    }

    public String getName(){
        return this.name;
    }

    public int getWt(){
        return this.wt;
    }

    public static  void main(String... args){
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("red",30));
        ducks.add(new Duck("blue",20));
        ducks.add(new Duck("green",10));
        ducks.add(new Duck("purple",15));
        ducks.add(new Duck("yellow", 45));
        ducks.add(new Duck("brown", 90));
        ducks.add(new Duck("red", 12));

        out.println(ducks);
        Collections.sort(ducks);
        out.println(ducks);

        Comparator<Duck> byWeight = new Comparator<Duck>() { /*comparator is a functional interface as the number of abstract methods in it is atmost 1*/
            @Override
            public int compare(Duck o1, Duck o2) {
                return o1.wt -o2.wt;
            }
        };

        //Collections.sort(ducks, byWeight);
        Collections.sort(ducks, (x,y)-> x.getWt() - y.getWt() );

        //Sort by descending order of wt;
        Collections.sort(ducks,(x,y) -> y.getWt() - x.getWt());
        out.println(ducks);



    }
}
