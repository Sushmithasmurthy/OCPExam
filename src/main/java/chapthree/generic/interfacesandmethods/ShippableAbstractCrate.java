package chapthree.generic.interfacesandmethods;

/**
 * Created by SushmithaShamanth on 3/16/17.
 */
//The type for class i.e T should match the type fo the interface T
public abstract class ShippableAbstractCrate<T> implements Shippable<T> {
    public abstract void ship(T t);

}
