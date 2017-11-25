package chapthree.generic.bounds;

import chapthree.generic.BabyElephant;
import chapthree.generic.Elephant;
import chapthree.generic.Robot;
import chaptwo.defaultinterfaces.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 * Created by SushmithaShamanth on 3/18/17.
 */
public class BoundsExplained {

    public static void print(Object obj){
         System.out.println(obj.toString());

    }

    //Method without use of bounds wildcard
    public static void printlist(List<Object> objs){
        for(Object o: objs){
            System.out.println(o.toString());
        }
    }

    //Use of unbounded wildcard
    public static  void printUnBoundedWC(List<?> anyObj){
        for(Object a: anyObj){
            System.out.println(a);
        }
    }

    //Use of upper bounded wildcards
    public static void printUpperBoundedWC(List<? extends Exception> anyObj){ //any object that extends from Exception is allowed to be passed as argument.
        for(Exception e: anyObj){
            System.out.println(e.toString());
        }
    }

    private void anyFlyer(List<Flyer> anyFlyerList){

    }

    private void groupOfFlyers(List<? extends Flyer> groupOfFlyersList){

    }



    public static void main(String... args){

        String sObj = "singleStringObj";
        print(sObj); //Compiler does autoboxing and concverts string into Object

        List<String> s = new ArrayList<>();
        s.add("hello");
        s.add("hello2");
        //printlist(s);//Compiler exception - does not auto box List<String> to List<Object>

        printUnBoundedWC(s);

        List<Object> oList = new ArrayList<>();
        oList.add(new Object());
        oList.add("hello");
        printUnBoundedWC(oList);

        List<BabyElephant> bList = new ArrayList<>();
        bList.add(new BabyElephant());
        printUnBoundedWC(bList);

        List<Exception> rt = new ArrayList<>();
        rt.add(new IllegalArgumentException());
        rt.add(new RuntimeException());
        printUpperBoundedWC(rt);
        //printUpperBoundedWC(oList); //not allowed as upperbound is at Exception


        //printUpperBoundedWC(oList); //only objects of classses that extend from Exception can be passed.

        List<? extends Exception> exUpperBoundedList = new ArrayList<>();
        //exUpperBoundedList.add(new Exception()); java does not allow this
        //exUpperBoundedList.add(new ArithmeticException());java does not allow this

        List<? extends CanRun> canRunUpperBoundedList = new ArrayList<>();
        CanSprint cs = new CanSprint() {
            @Override
            public void sprint() {

            }

            @Override
            public void canRun() {

            }
        };
        CanRun cR = new Robot("Ia mRobo");
        //canRunUpperBoundedList.add(cR);  //java does not allow this
        CanRun ele = new  Elephant("sambha");
        //canRunUpperBoundedList.add(ele); //java does not allow this
       // canRunUpperBoundedList.add(cs); //java does not allow this

        List<CanRun> canRunList = new ArrayList<>();

        canRunList.add(cR);  //java does not allow this
        canRunList.add(ele); //java does not allow this
        canRunList.add(cs);


        //printUpperBoundedWC(s); //only objects of classes that extend from exception can be passed

        List<Exception> exceptionList = new ArrayList<>();
        exceptionList.add(new FileNotFoundException());
        exceptionList.add(new IOException());
        printUpperBoundedWC(exceptionList);

        BoundsExplained be = new BoundsExplained();
        List<Flyer> flyer = new ArrayList<>();
        List<Goose> gooseList = new ArrayList<>();
        List<HangGlider> hangGliderList = new ArrayList<>();

        be.anyFlyer(flyer);
        //be.anyFlyer(gooseList); // anyflyer allows only list of flyers as it is explicitly specifeid
        //be.anyFlyer(hangGliderList);// anyflyer allows only list of flyers as it is explicitly specifeid

        be.groupOfFlyers(flyer);
        be.groupOfFlyers(gooseList);
        be.groupOfFlyers(hangGliderList);

    }
}
