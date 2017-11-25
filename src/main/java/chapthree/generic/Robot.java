package chapthree.generic;

import chaptwo.defaultinterfaces.CanRun;

/**
 * Created by SushmithaShamanth on 3/8/17.
 */


public class Robot implements RobotInterface, CanRun{

    @Override
    public void canRun() {

    }

    public String getName() {
        return name;
    }

    public Robot setName(String name) {
        this.name = name;
        return this;
    }

    private String name;

    public Robot(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public void powerOn() {
        System.out.println("PowerOn");
    }

    @Override
    public void powerOff() {
        System.out.println("PowerOff");
    }

    //<T> before Crate is the formal type parameter
    public static <T> Crate<T> staticShip(T t){
        return new Crate<T>();
    }
    public  <T> Crate<T> nonStaticShip(T t){
        return new Crate<T>();
    }
    public  <T> int intShip(T t){
        return 0;
    }

    public  <T> T tShip(T t){
        //T t = new T();//you cannot do new T()

        return t;
    }


    //public <T> noReturnShip(T t) //Does not compile as return type is missing

    //public T T noFormalTypeParameter(T t)// formal type parameter should be with in <>

}
