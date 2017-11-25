package chapsix.excerise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.MissingResourceException;

/**
 * Created by SushmithaShamanth on 5/23/17.
 */
public  class Excercise {

    static class SneezeException extends Exception{}
    public static void main(String... args) {
        Integer n =11;

      //  if(args.length<=3)
        //    assert  false;
       // System.out.print("hello +" + args[0]);
        String s= null;
       // assert s!=null;
       // assert n<0:"Ohno";
     //   assert (n<0 , "Ohno");

        try (Door d = new Door();
        Window w = new Window()){
            System.out.println("T");
            throw new SneezeException();
        }catch(Exception e){
            //e.printStackTrace();
            e = new SneezeException();

            System.out.println("E");
        }finally {
            System.out.println("F");
        }
    }

    static class Door implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("D");
        }
    }

    static class Window implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("W");
            throw new RuntimeException();

        }
    }
}
/*Answers (15/20)
1. C  -R
2. B,C-R
3. E-R
4. A,B,-R
5. C--R
6. G---R
7. C--R
8. B --W
9. A, D --R
10. A E --R
11. B , D, E --R
12, A ,D,E --R
13. A,--R
14. A,E --W
15. B,E --R
16. C --R
17. A,E --W
18. B,D,F --W
19. B,D --W
20. E --R

 */