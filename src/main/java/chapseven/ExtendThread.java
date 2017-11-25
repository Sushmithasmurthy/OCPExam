package chapseven;

/**
 * Created by SushmithaShamanth on 6/11/17.
 */
public class ExtendThread extends Thread{
    @Override
    public void run(){
        System.out.println("Printing inventory");
    }

    public static void main(String... args){
        System.out.println("begin");
        new ExtendThread().start();
        new Thread(new ImplementRunnable()).start();
        new ExtendThread().start();

       // new ExtendThread().start();
        System.out.println("end");
    }
}
