package chaptwo.functionalprograms;

import java.time.LocalDate;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class Bond {


    private static final double faceValue = 1000; //par Value = face value
    private String cusip;
    private double coupon;//interest rate on bond
    private LocalDate maturityDate;

    public static double getFaceValue() {
        return faceValue;
    }

    public Bond(){

    }

    public Bond(String cusip, double coupon, LocalDate maturityDate) {
        this.cusip = cusip;
        this.coupon = coupon;

        this.maturityDate = maturityDate;
    }

    public String getCusip() {
        return cusip;
    }

    public double getCoupon() {
        return coupon;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }
}
