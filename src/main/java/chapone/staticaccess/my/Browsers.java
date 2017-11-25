package chapone.staticaccess.my;

import static java.lang.System. *;
/**
 * Created by SushmithaShamanth on 2/21/17.
 */
public class Browsers {
    static class Browser{
        public void go(){
            out.println("Inside Browser");
        }
    }

    static class Firefox extends Browser{
        public void go(){ //method hiding - as both the methods are static
            out.println("Inside firefox");
        }
    }

    static class IE extends Browser{
        @Override
        public void go(){
            out.println("Inside IE");
        }
    }

    public static void main(String... args){
        Browser b = new Firefox();
        b.go();
        //IE e = (IE) b; // this will give classcast exception
        //e.go();

        Browser bie = new IE();
        bie.go();

        Browser browser = new Browser();
        browser.go();
         if(null instanceof Browser)
             out.print(true);
        else
             out.print(false);
    }
}
