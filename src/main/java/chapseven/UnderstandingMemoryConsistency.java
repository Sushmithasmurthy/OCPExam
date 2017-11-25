package chapseven;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by SushmithaShamanth on 8/23/17.
 */
public class UnderstandingMemoryConsistency {

    public static void main(String... args){

        Map<String,Object> goodFoodData = new ConcurrentHashMap<>();
        goodFoodData.put("penguin",1);
        goodFoodData.put("Flamingo",2);

        System.out.println("UsingConncurrentHashMap");
        for(String key:goodFoodData.keySet()){
            goodFoodData.remove(key);
        }
        System.out.println("All good..Happy Face:) ");
        Map<String,Object> foodData = new HashMap<>();
        try {
            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);
            System.out.println("Without Using ConncurrentHashMap");
            for (String key : foodData.keySet()) {
                foodData.remove(key);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }



    }
}
//Another Alternative
/*Set<String> keys = new HashSet<>(foodData.keySet());
        for(String key: keys){e
            foodData.remove(key);
        }*/