package chaptwo.functionalprograms;

/**
 * Created by SushmithaShamanth on 3/1/17.
 */
//Functional interface is an interface that has exactly one method and nothing else
    //It can contain
    //1. One and one one abstract method
    //2. public static final variables
    //3. Can contain other default methods
    //4. Can contain other static methods


@FunctionalInterface
public interface Sprint {
    public void sprint(Animal animal);

    public static final int MAX_SPEED = 100;

    //2. Interface can have default methods
    public default void land(){
        System.out.println("You are in fly interface's default method");
    }


    //3. Interface can have static methods
    public static  double calculateSpeed(float distance, double time){
        return distance/time;
    }

}


