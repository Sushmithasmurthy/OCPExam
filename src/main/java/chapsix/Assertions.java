package chapsix;

/**
 * Created by SushmithaShamanth on 5/23/17.
 */
public class Assertions {
    public static void main(String... args){
        int numGuests = -5;
      //  assert numGuests>0; //java.lang.AssertionError
        System.out.println(numGuests);
        test(Seasons.WINTER);
    }

    public static void test(Seasons s){
        switch(s){
            case SPRING:
            case FALL:
                System.out.println("Shorter hours");
                break;
            case SUMMER:
                System.out.println("Longer Hours");
                break;
            default:
                assert false:"Invalid Season";
        }
    }

}
