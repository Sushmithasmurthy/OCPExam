package chapsix;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 5/22/17.
 */
public class MoreOnSuppressedExceptions implements  AutoCloseable {
    @Override
    public void close() throws IllegalStateException{
        throw new IllegalStateException(
                "I am in Close of block and mostlikely i will get suppressed"
        );
    }

    public static  void main(String... args){
        try(MoreOnSuppressedExceptions m1 = new MoreOnSuppressedExceptions(); //M1 gets closed second since java closes in reverse order of creation
            MoreOnSuppressedExceptions m2 = new MoreOnSuppressedExceptions()){//M2 gets closed first
            out.println("I am in try block");
            //throw new IllegalStateException("I am throwing in try block");
            throw new RuntimeException("I am throwing in try block but if i am not caught" +
                    " then i will also display any suppressed exception details " +
                    "but if finally block is also throwing exception i will be suppressed again");
        }catch(IllegalStateException e){
            out.println("caught: " + e.getMessage());
            for(Throwable t : e.getSuppressed()){
                out.println("Suppressed: " + t.getMessage());
            }
        }finally {
            //Commenting the below line because if this is thrown everything else will get ssuppressed
           // throw new RuntimeException("and Runtimeexception in finally block");
        }
    }
}
