package chapthree.comparableVscomparator;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class Bond implements Comparable<Bond>{
    private Double price;
    public Double getPrice(){
        return this.price;
    }
    public Bond(Double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return this.price.toString();
    }

    @Override
    public int compareTo(Bond b){
        return (int)(this.price - b.getPrice());
    }

    public static  <U extends Exception> void printException(U u){
        System.out.println(u.getMessage());
    }
    public static void main(String... args){
        List<Bond> bonds = new ArrayList<>();
        bonds.add(new Bond(100D));
        bonds.add(new Bond(99d));
        bonds.add(new Bond(101d));
        bonds.add(new Bond(101d));
        bonds.add(new Bond(99.99));

        out.println(bonds);
        Collections.sort(bonds);
        out.println(bonds);

        Bond.printException(new FileNotFoundException("A"));
        Bond.printException(new Exception("B"));
        //Bond.<Throwable>printException(new Exception("C")); //Thowable is of type java.lang.throwable
        Bond.<NullPointerException>printException(new NullPointerException("D"));
        //Bond.printException(new Throwable("E"));

        Vector<? extends Number> list = new Vector<Integer>();


    }
}
