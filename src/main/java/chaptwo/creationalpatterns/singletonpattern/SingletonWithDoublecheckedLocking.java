package chaptwo.creationalpatterns.singletonpattern;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class SingletonWithDoublecheckedLocking {
    //1. private constructor
    private SingletonWithDoublecheckedLocking(){}

    //2.private static volatile instance -
    // volatile means The value of this variable will never be cached thread-locally:
    // all reads and writes will go straight to "main memory";
    //Access to the variable acts as though it is enclosed in a
    // synchronized block, synchronized on itself.
    private  static volatile SingletonWithDoublecheckedLocking instance;

    //3. instantiate instance within get instance
    //4. public static getinstance containinmg synchronised access to instance
    public static SingletonWithDoublecheckedLocking getInstance(){
        if(instance==null) {
            synchronized (instance) {
                if(instance == null)
                instance = new SingletonWithDoublecheckedLocking();
            }
        }
        return instance;
    }

}
