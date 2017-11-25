package chaptwo.creationalpatterns.factorypattern;

/**
 * Created by SushmithaShamanth on 3/5/17.
 */
public class MunicipalBond extends BondForward{
    public MunicipalBond(String cusip){
        super(cusip);
    }

    public void isCusipCreated(){
        if(getCusip().isEmpty())
            System.out.println("Municipal Bond cusip not yet created");
        else
            System.out.println("Municipal Bond cusip Id : " + getCusip());
    }
}
