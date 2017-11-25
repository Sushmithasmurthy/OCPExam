package chapone.equalshashcodetostring;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 2/12/17.
 */
public class Hippo {
    protected String name;
    protected int weight;


    public void setWtUnit(Unit wtUnit) {
        this.wtUnit = wtUnit;
    }

    public Unit getWtUnit() {
        return wtUnit;
    }

    protected Unit wtUnit;

    public Hippo(){
        this.name = "defaultHippo";
        weight = 20;
        wtUnit = wtUnit.KG;
    }

    @Override
    public String toString(){
        return this.name.toString() +" " + this.weight + wtUnit.toString() + "s";
    }

    public static void main(String... args){
        Hippo hippo1 = new Hippo();
        Hippo hippo2 = new Hippo();
        out.println(hippo1);
        out.println(hippo1.toString());
        if(hippo1.equals(hippo2))
            out.println("yes hippo 1 and 2 are equal");
        else
            out.println("No hippo 1 and 2 are not equal");

        Hippo hippo3 = hippo1;

        if (hippo1.equals(hippo3))
            out.println("yes hippo 1 and 3  are equal");
        else
            out.println("No hippo 1 and 3 are not equal");

        for(int i=0;i<3;i++) {
            for (Unit u : Unit.values()) {
                out.println(u.ordinal() + " " + u.toString() + " "+ u.valueOf(u.toString()));
            }
        }
        out.println(Unit.valueOf("KG")); //case sensitive -throws IllegalArgumentException if the input string does not exist

        switch (hippo1.wtUnit){
            case KG:
                out.println("enums are implied look you are mentioning it as KG in case and not Unit.KG");
                break;
            case POUND:
                out.println("enums are implied look you are mentioning it as POUND in case and not Unit.POUND");
                break;
        }

        out.println(Unit.KG.getCountryStandardForWeight());
        hippo1.getWtUnit().setCountryStandardForWeight("BangladeshStd");
        out.println(hippo1.getWtUnit().getCountryStandardForWeight());
        out.println(Unit.KG.getCountryStandardForWeight());
    }
}
