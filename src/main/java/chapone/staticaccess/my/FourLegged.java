package chapone.staticaccess.my;

/**
 * Created by SushmithaShamanth on 2/21/17.
 */
public class FourLegged {
    String walk = "walk";
    static class BabyRhino extends FourLegged{
        String walk = "toglle";
    }
    public static void main(String... args){
        FourLegged f = new BabyRhino();
        BabyRhino b = new BabyRhino();
        System.out.print(f.walk);
        System.out.print(b.walk);
    }
}
