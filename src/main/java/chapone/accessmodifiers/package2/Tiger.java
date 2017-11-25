package chapone.accessmodifiers.package2;

import static java.lang.System.out;
import chapone.accessmodifiers.package1.BigCat;

/**
 * Created by SushmithaShamanth on 2/6/17.
 */
public class Tiger extends BigCat {
    public static void main(String[] args){
        BigCat bc = new BigCat();
      //  out.println(bc.privateId); //compiler error
     //   out.println(bc.defaultHasPaws); //compiler error
      //  out.println(bc.protectedHasFur); //compiler error
        out.println(bc.publicName);
        Tiger tg = new Tiger();
        out.println(tg.protectedHasFur);
    }
}
