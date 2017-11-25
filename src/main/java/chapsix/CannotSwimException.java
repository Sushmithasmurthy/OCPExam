package chapsix;

/**
 * Created by SushmithaShamanth on 5/22/17.
 *   //Most 3 common constructors in an exception class
 */
public class CannotSwimException extends Exception {
    public CannotSwimException(){
        super(); //remember default constructors are provided on its own if you dont wire a wonstructor
    }

    public CannotSwimException(Exception e){
        super(e);
    }

    public CannotSwimException(String message){
        super(message);
    }

    public static void main(String... args){
        try{
            throw new CannotSwimException();
        }catch(CannotSwimException e){
            e.printStackTrace();
        }
    }
}
