package chapthree.collections;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by SushmithaShamanth on 3/22/17.
 */
public class CommonCollectionMethods {

    private static enum Op{ARRAY_LIST,HASH_SET,HASH_MAP,ARRAY_DQ};
    public static void main(String... args){
        Op o = Op.HASH_MAP;
        switch (o) {
            case ARRAY_LIST:
                System.out.println("******List Operations******");
                List<String> stringList = new ArrayList<>();
                stringList.add("duplicate");
                stringList.add("is");
                System.out.println(stringList.add("allowed in List"));
                System.out.println(stringList);
                System.out.println(stringList.remove("is"));
                System.out.println(stringList.remove("blah"));
                System.out.println(stringList.isEmpty() ? "Empty List" : stringList.size());
                System.out.println(stringList.contains("blah"));
                System.out.println(stringList.contains("duplicate"));
                stringList.clear();
                System.out.println(stringList);

                Queue<Integer> a = new LinkedList<>();
                a.add(10);
                a.add(20);

                a.remove(1);

                System.out.println(a);

                List<String> l = Arrays.asList("1","2","3");
                Iterator iter = l.iterator();
                while(iter.hasNext()){
                    System.out.print(iter.next());
                }
                break;

            case HASH_SET:
                System.out.println("******Set Operations******");
                Set<String> stringSet = new HashSet<>();
                stringSet.add("duplicate");
                stringSet.add("not");
                System.out.println(stringSet.add("allowed in Set"));
                System.out.println(stringSet.add("allowed in Set"));
                System.out.println(stringSet);
                System.out.println(stringSet.remove("allowed in Set"));
                System.out.println(stringSet.remove("blah"));
                System.out.println(stringSet.isEmpty() ? "Empty Set" : stringSet.size());
                System.out.println(stringSet.contains("blah"));
                System.out.println(stringSet.contains("duplicate"));
                stringSet.clear();
                System.out.println(stringSet);

                Set<String> s = new HashSet<>();
                s.add("sush");
                s.add("blah");
                s.add("plae");
                s.add("qqwq");
                s.forEach(System.out::println);
                break;

            case HASH_MAP:
                System.out.println("******HashMap Operations******");
                Map<String, String> mapString = new HashMap<>();
                System.out.println("Map do not have add method");
                mapString.put("duplicate", "duplicate");
                mapString.put("key", "value");
                System.out.println("hashmap put returns: " + mapString.put("duplicate key not allowed in mapString", "duplicate value allowed in mapString"));
                System.out.println("hashmap duplicate put returns: " + mapString.put("duplicate key not allowed in mapString", "test 2"));
                System.out.println(mapString);
                System.out.println(mapString.remove("not allowed in mapString", "allowed in mapString"));
                System.out.println(mapString.remove("duplicate"));
                System.out.println(mapString.remove("duplicate"));
                System.out.println(mapString.isEmpty() ? "Empty Set" : mapString.size());
                System.out.println(mapString.containsKey("blah"));
                System.out.println(mapString.containsValue("value"));
                mapString.clear();
                System.out.println(mapString);
                Map m = new HashMap<>();
                m.put(123, "121");
                m.put("123", "sds");
                //System.out.println(m.contains("")) contains method does not exist in map
                Map<Integer, Integer> m2 = new HashMap<>();
                m2.put(1,10);
                m2.put(2,20);
                m2.put(3, null);
                System.out.println(m2);
                m2.merge(1, 3, (p, q) -> p + q);
                m2.merge(3, 3, (p, q) -> p + q);
                System.out.println(m2);

                break;

            case ARRAY_DQ:
                System.out.println("******ArrayDeque Operations******");
                Queue<String> qString = new ArrayDeque<>();
                qString.add("duplicate");
                qString.add("is");
                System.out.println(qString.add("allowed in dq"));
                System.out.println(qString.add("allowed in dq"));
                System.out.println(qString);
                System.out.println(qString.remove("allowed in dq")); //first occurrence of "allowed in dq" is removed
                System.out.println(qString);
                System.out.println(qString.isEmpty()?"Empty queue":qString.size());
                qString.contains("duplicate");
                qString.clear();
                System.out.println(qString);
                break;


        }



    }



}
