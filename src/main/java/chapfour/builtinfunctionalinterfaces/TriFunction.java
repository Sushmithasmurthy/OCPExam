package chapfour.builtinfunctionalinterfaces;

/**
 * Created by SushmithaShamanth on 4/4/17.
 */
public interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
