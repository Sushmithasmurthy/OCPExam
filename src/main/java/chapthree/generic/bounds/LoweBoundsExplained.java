package chapthree.generic.bounds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
/**
 * Created by SushmithaShamanth on 3/19/17.
 */
public class LoweBoundsExplained {
    public static void main(String... args){
        LoweBoundsExplained l = new LoweBoundsExplained();
        List<String> strings = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        strings.add("quackString");
      //  l.addSound(strings);//not allowed
        l.addSound(objects);

        l.addSoundWithLBWC(strings);
        l.addSoundWithLBWC(objects);

        l.addSoundWithGeneric(strings);
        l.addSoundWithGeneric(objects);

        l.addSoundWithUNBWC(strings);
        l.addSoundWithUNBWC(objects);

        l.addSoundWithUPBWC(strings);
        l.addSoundWithUPBWC(objects);

        //Crazy problem with Lower bound exception- explained below:
        System.out.println("Crazy problem with Lower bound exception- explained below:");
        //says that amy class that is a superclass of IOException is allowed
        List<? super IOException> exObjList = new ArrayList<>();
        ////Does not compile- contradictory because - EXception is a supercalss of IOException
        //exObjList.add(new Exception());
        exObjList.add(new IOException()); //This is fine
        //This  compiles which is not fine because Filenotfoundexception
        // is extends from IOException and basically the exceptionObject list should
        // not accept this - but it does
        exObjList.add(new FileNotFoundException());


    }

    private <T> void addSoundWithGeneric(List<T> objs){
       // objs.add("quack"); //Unbounded generics are immutable
        //objs.add(new Object());//Unbounded generics are immutable
    }
    private <T> void addSoundWithUNBWC(List<?> objs){
       // objs.add("quack");//Unbounded generics are immutable
       // objs.add(new Object());//Unbounded generics are immutable
    }

    private <T> void addSoundWithUPBWC(List<? extends Object> objs){
       // objs.add("quack"); //Upperbounder generics are immutable
      //  objs.add(new Object());//Upperbounder generics are immutable
    }

    private void addSound(List<Object> objs){
        objs.add("quack");
    }

    /* Lower bound Wild card allows two things
    1. You can pass list of both strings and objects to this method
    2. With in the method you can add more data to the input list- making the list immutable
     */
    private void addSoundWithLBWC(List<? super String> objs){
        objs.add("quack");
    }

    public static <T> T identity(T t){

        return t;
    }
}
