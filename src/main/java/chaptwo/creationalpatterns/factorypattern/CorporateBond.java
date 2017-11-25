package chaptwo.creationalpatterns.factorypattern;

/**
 * Created by SushmithaShamanth on 3/5/17.
 */
public class CorporateBond extends BondForward {

    public CorporateBond(String cusip){
        super(cusip);
    }

    public void isCusipCreated(){
        if(getCusip().isEmpty())
            System.out.println("Corporate Bond cusip not yet created");
        else
            System.out.println("Corporate bond cusip Id : " + getCusip());
    }
}
