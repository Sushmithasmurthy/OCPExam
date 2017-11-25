package chapthree.collections;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 3/26/17.
 */
public class MapsUsage {
    public static void main(String... args){
        BinaryOperator<String> mapper = (x,y)-> x.length()>y.length()?x:y;
     Map<String,String> favourites = new HashMap<>();
        favourites.put("Jenny", "Bus Tour");
        favourites.put("Tom", "Tram");
       // favourites.put("keyToBeR", "Tram");
        out.println(favourites);
        /*
        If the specified key is not already associated with a value or is associated with null,
        associates it with the given non-null value. Otherwise, replaces the associated value with
        the results of the given remapping function, or removes if the result is null. This method may be of use when combining multiple mapped values for a key. For example, to either create or append a String msg to a value mapping:
         */
        String jenny = favourites.merge("Jenny", "Skyride", mapper);
        String tom = favourites.merge("Tom", "Skyride", mapper);

        String s = favourites.merge("keyToBeR", "Tram", (x,y)->null);


        out.println(jenny);
        out.println(tom);
        out.println(favourites);
        favourites.computeIfPresent("Tom", (x, y) -> (x == "blah") ? y : x);
        out.println(favourites);
        favourites.computeIfAbsent("Harry", (x) -> "HarryValue");
        out.println(favourites);
        Map<String, ? extends Number> hm = new HashMap<String, Integer>();

    }



}
