package chaptwo.creationalpatterns.immutableobjectpattern;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class ImmutableObjectBond{

    //1. Use a constructor to set all the properties of the object
    public ImmutableObjectBond(String cusip, double coupon, LocalDate maturityDate, List<String> books) {
        this.cusip = cusip;
        this.coupon = coupon;
        this.maturityDate = maturityDate;

        //6. When creating immutable objects any mutable input arguments are copied to the instance instead of being used directly
        if( books == null )
            throw new RuntimeException("book list is required");
        this.books = new ArrayList<>(books);
    }

    //2. Make all instance variables private and final
    private final String cusip; //immutable object
    private final double coupon; //primitive
    private final LocalDate maturityDate;   //immutable object
    private final List<String> books; //mutable object
    private final static double faceValue = 1000;

    //3. Dont define any setter methods
    //4. Dont allow referenced mutable objects to be modified or accessed directly
    public List<String> getBooks() {
        //4.Dont allow referenced mutable objects to be modified or accessed directly
        return new ArrayList<>(books);
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

    public static double getFaceValue() {
        return faceValue;
    }

    //5. Prevent methods from being overridden
    public final double CalculateYield(double price){
        int yearsToMaturity = Period.between(LocalDate.now(), this.getMaturityDate()).getYears();
        double yieldToMaturity = (coupon + ((faceValue-price)/yearsToMaturity))/((faceValue+price)/2);
        return yieldToMaturity;
    }

    //6. We cannot modify an immutable object instead you have to create a new one with new attributes
    public static void main(String... args){
        List<String> bookList = new ArrayList<>();
        bookList.add("ewwewe");
        bookList.add("sdwewe");
        String cusip = "SJDJDD811";
        double coupon = 5;
        LocalDate maturityDate = LocalDate.of(2023, Month.APRIL,1);
        ImmutableObjectBond imObj= new ImmutableObjectBond(cusip,coupon,maturityDate,bookList );
        //6. We cannot modify an immutable object instead you have to create a new one with new attributes
        ImmutableObjectBond anotherImmObj = new ImmutableObjectBond( cusip, coupon+1, maturityDate.plusYears(1),bookList);
        System.out.println(bookList.toString());
    }

}
