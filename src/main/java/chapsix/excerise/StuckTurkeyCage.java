package chapsix.excerise;

/**
 * Created by SushmithaShamanth on 5/23/17.
 */
public class StuckTurkeyCage implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }

    public static void main(String... args)throws Exception{
        try(StuckTurkeyCage t = new StuckTurkeyCage()){
            System.out.println("put turkeys in");
        }
    }
}
