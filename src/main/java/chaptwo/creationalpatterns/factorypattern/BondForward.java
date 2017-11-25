package chaptwo.creationalpatterns.factorypattern;

/**
 * Created by SushmithaShamanth on 3/5/17.
 */
// 1. create Abstract base class
public abstract class BondForward {
    private String cusip;


    public BondForward(String cusip){
        this.cusip = cusip;
    }

    public String getCusip(){
        return cusip;
    }

    //2.Create abstract methods that will be implemented in child class
    public abstract void isCusipCreated();
}
