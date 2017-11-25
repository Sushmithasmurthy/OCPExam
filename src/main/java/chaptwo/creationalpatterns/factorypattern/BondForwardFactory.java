package chaptwo.creationalpatterns.factorypattern;

/**
 * Created by SushmithaShamanth on 3/5/17.
 */
public class BondForwardFactory {
    //1. Create static method that returns object of base class type.
    public static BondForward getBondForward(String bondType){
        //2. Instantiate the object based on the input parameter.
        switch(bondType){
            case "CorporateBond":
                return new CorporateBond("corp_cusip");
            case "IGBond":
                return new CorporateBond("ig_cusip");
            case " ":
                return new MunicipalBond("muni_cusip");
            case "taxableBond":
                return new MunicipalBond("taxable_muni_cusip");
        }
        //3. Throw unsupportedOperationException if the input parameter does not match any type.
        throw new UnsupportedOperationException("Unsopported Bond forward: "+bondType);
    }
}
