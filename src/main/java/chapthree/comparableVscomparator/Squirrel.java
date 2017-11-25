package chapthree.comparableVscomparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class Squirrel {
    private String species;
    private int weight;

    public Squirrel(String species, int weight){
        if(species == null || weight <= 0){
            throw new IllegalArgumentException();
        }
        this.species = species;
        this.weight = weight;
    }

    public String toString(){
        return this.species+":"+ this.weight;
    }

    public static  void main(String... args){
        List<Squirrel> squirrels = new ArrayList<>();
        squirrels.add(new Squirrel("app",10));
        squirrels.add(new Squirrel("cap",23));
        squirrels.add(new Squirrel("zap",1));
        squirrels.add(new Squirrel("cap",20));
        squirrels.add(new Squirrel("tap", 15));

        out.println(squirrels);
        //First way - to compare by species name- if species names are equal then compare by their weight
       /* Collections.sort(squirrels, (x, y) -> {
            if (x.getSpecies().equals(y.getSpecies())) {
                return x.getWeight() - y.getWeight();
            } else {
                return x.getSpecies().compareTo(y.getSpecies());
            }
        });
        out.println(squirrels);*/

        //Second way
        Collections.sort(squirrels, new ChainingComparator());
        out.println(squirrels);

    }


    public String getSpecies(){
        return this.species;
    }

    public int getWeight(){
        return this.weight;
    }


}
class ChainingComparator implements Comparator<Squirrel> {
    @Override
    public int compare(Squirrel s1, Squirrel s2){
        Comparator<Squirrel> c = Comparator.comparing( s-> s.getSpecies());
        c= c.thenComparingInt( s->s.getWeight());
        return c.compare(s1, s2);
    }
}
