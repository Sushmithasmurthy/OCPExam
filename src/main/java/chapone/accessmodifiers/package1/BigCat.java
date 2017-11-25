package chapone.accessmodifiers.package1;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 2/6/17.
 */
public class BigCat {
    private int privateId;
    boolean defaultHasPaws;
    protected boolean protectedHasFur = true;
    public String publicName= "cat";

    public void toddle(){

    }
    public static void main(String[] args){
        BigCat bc = new BigCat();
        out.println(bc.privateId);
        out.println(bc.defaultHasPaws);
        out.println(bc.protectedHasFur);
        out.println(bc.publicName);
    }

}
