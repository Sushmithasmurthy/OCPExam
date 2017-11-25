package chaptwo.creationalpatterns.singletonpattern;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class LazyInstantiatedSingleton {

    //1. private constructor
    private LazyInstantiatedSingleton(){}

    //2. private static insatnce
    private static LazyInstantiatedSingleton instance;

    //3. Lazy instantiate the instance in getInstance method
    //4. public static get instance method
    public LazyInstantiatedSingleton getInstance(){
        if(instance == null)
            instance = new LazyInstantiatedSingleton(); //Not thread safe
        return instance;
    }



}
