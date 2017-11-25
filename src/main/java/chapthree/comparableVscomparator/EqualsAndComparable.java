package chapthree.comparableVscomparator;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class EqualsAndComparable implements Comparable<EqualsAndComparable> {
    private String name;
    private int id;

    public EqualsAndComparable(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return this.id + ":" + this.name;
    }
    @Override
    public int compareTo(EqualsAndComparable eq){
        return this.name.compareTo(eq.getName());
    }

    @Override
    public boolean equals(Object eq){
        if(eq instanceof EqualsAndComparable) {
            return this.id == ((EqualsAndComparable) eq).getId();
        }
        else
            return false;
    }

    public static void main(String... args){
        List<EqualsAndComparable> obs = new ArrayList<>();
        obs.add(new EqualsAndComparable("ace", 100));
        obs.add(new EqualsAndComparable("case",10));
        obs.add(new EqualsAndComparable("base",80));

        out.println(obs);
        Collections.sort(obs);
        out.println(obs);
    }

}
