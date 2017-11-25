package chapthree.comparableVscomparator;

import static java.lang.System.out;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class LegacyBond implements Comparable{
    private Double price;
    public Double getPrice(){
        return this.price;
    }
    public LegacyBond(Double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return this.price.toString();
    }

    @Override
    public int compareTo(Object b){
        return (int)(this.price - ((LegacyBond)b).getPrice());
    }

    public static void main(String... args){
        List<LegacyBond> bonds = new ArrayList<>();
        bonds.add(new LegacyBond(100D));
        bonds.add(new LegacyBond(99d));
        bonds.add(new LegacyBond(101d));
        bonds.add(new LegacyBond(101d));
        bonds.add(new LegacyBond(99.99));

        out.println(bonds);
        Collections.sort(bonds);
        out.println(bonds);
    }
}