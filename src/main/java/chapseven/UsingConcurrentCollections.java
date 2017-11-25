package chapseven;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by SushmithaShamanth on 8/23/17.
 */
public class UsingConcurrentCollections {
    private Map<String,Object> foodData = new ConcurrentHashMap<>();

    public void put(String key, String value){
        foodData.put(key,value);
    }

    public Object get(String key){
        return foodData.get(key);
    }
}
