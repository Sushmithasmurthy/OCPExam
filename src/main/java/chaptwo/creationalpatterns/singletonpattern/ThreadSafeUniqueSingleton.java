package chaptwo.creationalpatterns.singletonpattern;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class ThreadSafeUniqueSingleton {
    //1. private constructor
    private ThreadSafeUniqueSingleton(){}

    //2. private static  instance
    private static ThreadSafeUniqueSingleton instance;

    //3.Lazy instantiate in get instance
    //4. public synchronized static get instance
    public synchronized static ThreadSafeUniqueSingleton getInstance(){ //Thread safe
        if(instance == null)
            instance = new ThreadSafeUniqueSingleton();
        return instance;
    }
}
