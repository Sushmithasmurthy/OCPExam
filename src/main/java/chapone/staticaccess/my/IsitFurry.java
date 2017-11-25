package chapone.staticaccess.my;

import java.util. *;
/**
 * Created by SushmithaShamanth on 2/21/17.
 */
public class IsitFurry {
    static class Chipmunk{}
    public static void main(String... args){
        Chipmunk c = new Chipmunk();
        ArrayList<Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result =0;
        if(c instanceof Chipmunk) result +=1;
        //if(l instanceof  Chipmunk) result +=2;
        if(r instanceof Chipmunk) result +=4; // this runnable is an interface
        System.out.println(result);

    }

}
