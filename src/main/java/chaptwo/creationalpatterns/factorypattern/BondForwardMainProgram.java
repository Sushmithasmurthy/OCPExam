package chaptwo.creationalpatterns.factorypattern;

/**
 * Created by SushmithaShamanth on 3/5/17.
 */
public class BondForwardMainProgram {
    public static void main(String... args){
        BondForward corpbond = BondForwardFactory.getBondForward("CorporateBond");
        corpbond.isCusipCreated();
        BondForward munibond = BondForwardFactory.getBondForward("MunicpalBond");
        munibond.isCusipCreated();
    }
}
