package chapone.equalshashcodetostring;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 2/12/17.
 */
public class WaterHippo extends Hippo {
    @Override
    public boolean equals(Object h){

        if(h instanceof WaterHippo
                && ((WaterHippo) h).hashCode() == this.hashCode()){
            return true;
        }
        else
            return false;
    }

    //protected enum milliUnit extends Unit{ } //you cannot extend an enum - does not compile


    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

    public static void main(String... args){
        WaterHippo hippo1 = new WaterHippo();
        WaterHippo hippo2 = new WaterHippo();
        WaterHippo hippo3 = hippo1;
        WaterHippo hippo4 = new WaterHippo();
        Hippo hippo6 = hippo4;
        Hippo hippo7 = new Hippo();

        out.println(hippo1);
        out.println(hippo1.toString());

        //reflexive test
        if(hippo1.equals(hippo1))
            out.println("The equals method is reflexive");
        else
            out.println("The equals method is NOT reflexive");

        //Symmetric test
        if(hippo1.equals(hippo2) && hippo2.equals(hippo1))
            out.println("The equals method is Symmetric");
        else
            out.println("The equals method is NOT Symmetric");

        //Transitive Test
        if(hippo1.equals(hippo2) && hippo2.equals(hippo3) )
            out.println("Is Transitive?: " + hippo1.equals(hippo3));
        else
            out.println("h1 equals h2?: " + hippo1.equals(hippo2) + "\t h2 equals h3?: "+hippo2.equals(hippo3));

        //Consistent test
        boolean isConsistent = true;
        for(int i=0;i<20; i++){
               if(!hippo2.equals(hippo4)){
                isConsistent = false;
                break;
            }
        }
        out.println("Is Consistent?:" + isConsistent);

        //Non null reference x. x.equals(null) should return false
        if(!hippo4.equals(null))
            out.println("Non null reference x. x.equals(null) returns false as Expected");
        else
            out.println("Non null reference x. x.equals(null) returns true-- WRONG BEHAVIOUR");

        //Any extra tests
        if(hippo6.equals(hippo4))
            out.println("yes WaterHippo 6 and 4  are equal");
        else
            out.println("No WaterHippo 6 and 4  are not equal");

        if(hippo4.equals(hippo6))
            out.println("yes WaterHippo 4 and 6  are equal");
        else
            out.println("No WaterHippo 4 and 6 are not equal");


        out.println("hippo4.equals(hippo7) : calls waterhippos equal method and but h7 is hippo not water hippo so the result is :" + hippo4.equals(hippo7));
        out.println("hippo7.equals(hippo4) : calls hippos equal method(which is object's default method as hippo does  not override it) and the result is :" + hippo7.equals(hippo4));


    }
}
