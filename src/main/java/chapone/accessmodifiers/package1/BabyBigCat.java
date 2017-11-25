package chapone.accessmodifiers.package1;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 2/6/17.
 */
public class BabyBigCat extends BigCat {

    public static void main(String[] args){
        BigCat bc = new BigCat();
       // out.println(bc.privateId); //compiler error
        out.println(bc.defaultHasPaws);
        out.println(bc.protectedHasFur);
        out.println(bc.publicName);
    }
}
