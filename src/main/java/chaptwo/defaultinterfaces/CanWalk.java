package chaptwo.defaultinterfaces;

/**
 * Created by SushmithaShamanth on 3/6/17.
 */
public interface CanWalk {
    default void walk(){
        System.out.println("Wlaking");
    }
}
