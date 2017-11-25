package chaptwo.creationalpatterns.singletonpattern;

import java.time.LocalDateTime;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class SingleInstantiatedAtDeclaration {
    private int quantity=0;

    //1. private constructor
    private SingleInstantiatedAtDeclaration(){ }

    //2. private static final instance
    //3. Instantiate instance at declaration
    private static final SingleInstantiatedAtDeclaration instance = new SingleInstantiatedAtDeclaration();

    //4. public static get instance method
    public static SingleInstantiatedAtDeclaration getInstance(){
        return instance;
    }

    public void message(Object o){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now + " " + o);
    }

    public synchronized void addQuantity(int amount){
        quantity +=amount;
    }

    public synchronized boolean removeQuantity(int amount){
        if(quantity<amount) return false;
        quantity -=amount;
        return  true;
    }

    public synchronized int getQuantity(){
        return quantity;
    }
}
