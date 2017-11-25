package chapthree.collections;

import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 3/25/17.
 */
public class TreeSetUSage implements Comparable<TreeSetUSage> {
    private Integer id;
    public TreeSetUSage(Integer id){
        this.id = id;
    }

    @Override
    public int compareTo(TreeSetUSage t){
        return this.getId() - t.getId();
    }

    @Override
    public String toString(){
        return this.getId().toString();
    }
    public static void main(String... args){
        Set<TreeSetUSage> trees = new TreeSet<>();
        trees.add(new TreeSetUSage(20));
        trees.add(new TreeSetUSage(10));
        trees.add(new TreeSetUSage(12));
        trees.add(new TreeSetUSage(10));
        out.println(trees);
    }

    public Integer getId(){
        return this.id;
    }
}
