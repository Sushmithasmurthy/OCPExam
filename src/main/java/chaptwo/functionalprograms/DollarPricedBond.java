package chaptwo.functionalprograms;

import java.time.LocalDate;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class DollarPricedBond extends Bond {

    public double getDollarPriceOfBond() {
        return dollarPriceOfBond;
    }

    private double dollarPriceOfBond;

    public void setYieldFromPrice(double yieldFromPrice) {
        this.yieldFromPrice = yieldFromPrice;
    }

    public double getYieldFromPrice() {
        return yieldFromPrice;
    }

    private double yieldFromPrice;

    public DollarPricedBond(double dollarPriceOfBond, String cusip, double coupon, LocalDate maturityDate){
        super(cusip,coupon,maturityDate);
        this.dollarPriceOfBond = dollarPriceOfBond;
    }

}
