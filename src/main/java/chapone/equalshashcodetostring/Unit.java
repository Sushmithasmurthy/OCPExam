package chapone.equalshashcodetostring;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 2/12/17.
 */
public enum Unit{
    POUND("USStandard"){
        public void printHours(){
            out.println("10-20");
        }
    }, KG{
        public void printHours(){
            out.println("30-40");
        }
    }, LTR("UKStd");

    public void printHours(){
        out.println("40-50");
    }

    public String getCountryStandardForWeight() {
        return countryStandardForWeight;
    }

    public void setCountryStandardForWeight(String countryStandardForWeight) {
        this.countryStandardForWeight = countryStandardForWeight;
    }

    private String countryStandardForWeight; //can be of any access

    Unit(){ //Contructcor cannot be public or protected but it can be default or private
        this.countryStandardForWeight = "IndianStandard";
    }

    private Unit(String value){ //Contructcor cannot be public or protected but it can be default or private
        this.countryStandardForWeight = value;
    }

    public static void main(String... args){
        //Unit uk = new Unit("getting crazy"); //enum types cannot be instantiated.
        Unit.POUND.setCountryStandardForWeight("Britain");
        out.println(Unit.POUND.getCountryStandardForWeight());
        out.println("********" + Unit.POUND.ordinal()+ "********");
        POUND.printHours();
        KG.printHours();
        LTR.printHours();

    }
};