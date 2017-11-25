package chapseven;

/**
 * Created by SushmithaShamanth on 6/11/17.
 */
public class ImplementRunnable implements Runnable {
    @Override
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("printing record: " +i);
        }
    }

    public static void main(String... args){
        new Thread( new ImplementRunnable()).start();
    }
}
