package chapsix;

import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 5/22/17.
 */
public class AutoCloseableResource  implements AutoCloseable{
    @Override
    public void close() throws IOException{
        out.println("I can automatically close and after that i throw IOexception");
        throw new IOException(); //You should not do this - This is a bad practise.
    }

    //The result is surprising
    //The exception thrown in close block is suppressed and only Illegalstateexception is thrown
    //However if you comment out --throw new IllegalStateException(); then the IOException thrown by close method is called
    public static void main(String... args){
        try(AutoCloseableResource ars = new AutoCloseableResource()){
            out.println("I am in try block");
            throw new IllegalStateException();
        }catch(IllegalStateException|IOException e){ //If you dont catch this IOexception the try code line will throw an error
            out.println("you are in catch block catching" + e.toString() );
            e.printStackTrace();
        }finally {
            out.println("finally you are in finally block");
        }
    }
}
