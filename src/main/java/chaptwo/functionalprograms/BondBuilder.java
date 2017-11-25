package chaptwo.functionalprograms;

import java.time.LocalDate;

/**
 * Created by SushmithaShamanth on 3/4/17.
 * Uses builder pattern
 */
public class BondBuilder {
    private String cusip;
    private double coupon;//interest rate on bond
    private double price;
    private double yield; //yield to maturity
    private LocalDate maturityDate;

    public BondBuilder setCusip(String cusip){
        this.cusip = cusip;
        return this;
    }

    public BondBuilder setCoupon(double coupon){
        this.coupon = coupon;
        return this;
    }

    public BondBuilder setPrice(double price){
        this.price = price;
        return this;
    }

    public BondBuilder setYield(double yield){
        this.yield = yield;
        return this;
    }

    public BondBuilder setMaturityDate(LocalDate maturityDate){
        this.maturityDate = maturityDate;
        return this;
    }



}
