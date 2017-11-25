package chaptwo.functionalprograms;

import com.sun.javafx.css.CalculatedValue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;
import java.util.function.ObjDoubleConsumer;
/**
 * Created by SushmithaShamanth on 3/1/17.
 */
public class PredicateMainProgram {

    public static void main(String... args){

        int age= 3;
        Animal dog = new Animal(age);
        PredicateMainProgram p = new PredicateMainProgram();
        if(p.callPredicateTestMethod(dog, a -> a.getAge() <= 5)){
            System.out.println("puppy");
        }
        else if(p.callPredicateTestMethod(dog, a -> a.getAge() > 5 && a.getAge() < 10)) {
            System.out.println("adult");
        }
        else
            System.out.println("old Animal");



        String cusip = "682001EU2";
        double coupon = 5;
        double faceValue = 1000;
        double price = 120;
        LocalDate maturityDate = LocalDate.of(2023, 2, 1);
        DollarPricedBond dp = new DollarPricedBond(price,cusip,coupon,maturityDate);
        //Bond b = (Bond)dp;
        //ObjDoubleConsumer<Bond> ob = (Bond b, double pr) -> PredicateMainProgram.setYieldToMaturity(b, pr);// Lambda function calling a method
        ObjDoubleConsumer<Bond> ob = PredicateMainProgram::setYieldToMaturity; //same lamdas but also uses Method reference
        p.calculateAndSave(dp, price, ob);
        System.out.println(dp.getYieldFromPrice());



    }

    public boolean callPredicateTestMethod(Animal a, Predicate<Animal> pred){
        return pred.test(a);

    }

    public void calculateAndSave(Bond b, double price ,ObjDoubleConsumer obj){
            obj.accept(b, price);
    }

    public static void setYieldToMaturity(Bond b, double price) {
        if (b instanceof DollarPricedBond) {
            DollarPricedBond db = (DollarPricedBond) b;
            double yearsToMaturity = Period.between(LocalDate.now(), b.getMaturityDate()).getYears();
            double temp = db.getFaceValue()-price/yearsToMaturity;
            double temp2 = (db.getFaceValue()+price)/2;
            double yielToMaturity = db.getCoupon() + (temp/temp2);
            System.out.println("yield to Maturity : " + yielToMaturity);
            db.setYieldFromPrice(yielToMaturity);
        }
    }



}
