package chapthree.comparableVscomparator;

import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SushmithaShamanth on 3/26/17.
 */
public class MyComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b){
        return b.toLowerCase().compareTo(a.toLowerCase()); //descending order
    }


    public static void main(String... args){
        String[] values = {"123", "Abb", "aab"};
        Arrays.sort(values,new MyComparator());
        for (String s : values){
            System.out.println(s+ " ");

        }

        Map<Integer, Integer> map = new HashMap<>(10);
        for(int i=1;i<=10;i++){
            map.put(i,i*i);
        }
        System.out.println(map.get(4));


    }
}
