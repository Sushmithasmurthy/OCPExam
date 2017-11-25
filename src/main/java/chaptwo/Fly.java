package chaptwo;

/**
 * Created by SushmithaShamanth on 3/1/17.
 */
public interface Fly {
    //1. public static final variable
    public static final int MAX_SPEED = 100;

    //2. Interface can have default methods
    public default void land(){
        System.out.println("You are in fly interface's default method");
    }

    //3. Interface can have static methods
    public static  double calculateSpeed(float distance, double time){
        return distance/time;
    }


    //4. Interface can have abstract methods they dont need to be declared abstract
    public int getWingSpan() throws Exception;

    //5. static methods in ana interface should have a body
    //public static  double calculatePower();

    //6. interface can have instance variables that are not static and final -
    // as compiler will automasticxally insert public static final
    int MIN_SPEED = 100;

    //7. Methods with implementation should be declared static or default -
    // if not it results in compile time error
    /*public  void FlySwiftly(){
        System.out.println("You are in fly interface's non default non static method");
    }*/


   /* private int a;

    private default void landbland(){
        System.out.println("can it have private method");
    }

    final boolean yesOrNo(){
        return false;
    }*/

}
