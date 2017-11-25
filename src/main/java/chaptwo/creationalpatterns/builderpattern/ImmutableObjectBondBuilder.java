package chaptwo.creationalpatterns.builderpattern;

import chaptwo.creationalpatterns.immutableobjectpattern.ImmutableObjectBond;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * Created by SushmithaShamanth on 3/5/17.
 */
public class ImmutableObjectBondBuilder {

    //1. private instance variables.
    private  String cusip; //immutable object
    private  double coupon; //primitive
    private  LocalDate maturityDate;   //immutable object
    private  List<String> books; //mutable object

    //2. setter variables returning this builder object - we can modify this class as we build it
    public ImmutableObjectBondBuilder setCusip(String cusip){
        this.cusip = cusip;
        return this;
    }

    public ImmutableObjectBondBuilder setCoupon(double coupon){
        this.coupon = coupon;
        return this;
    }

    public ImmutableObjectBondBuilder setMaturityDate(LocalDate maturityDate){
        this.maturityDate = maturityDate;
        return this;
    }

    public ImmutableObjectBondBuilder setBooks(List<String> bookList){
        this.books = bookList;
        return this;
    }

    //3. build method instantiates the original immutable object and
    // return the immutable object instance to the calling method
    public ImmutableObjectBond build(){
        return new ImmutableObjectBond(cusip,coupon,maturityDate,books);
    }


    public static void main(String... args){
        List<String> bookList = new ArrayList<>();
        bookList.add("7218212");
        bookList.add("1218212");

        // you can create immutable object by creating teh builder object and chaining the setter methods and
        // then calling the build method of the builder class which returns the immutable object
        ImmutableObjectBond immutableObjectBond = new ImmutableObjectBondBuilder()
                .setCusip("232dsdsd")
                .setCoupon(5)
                .setMaturityDate(LocalDate.of(2025, Month.APRIL,1))
                .setBooks(bookList).
                        build();
    }
}
