package chapone.innerclasses;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 2/13/17.
 */
public class Outer {
    private String greeting = "Hi";

    private int pageNumber;
    private class BookReader{
        public int getPage(){
            return pageNumber;
        }
    }

    private int xms =24;
    public int getX(){
        String mess = "x is: "; //if you dont use final then it cannot be access from local inner class only in java 7 - this is no longer a requirement in java 8
        //in  java 8 message should be effectively final
        class Inner{
            private int xms = Outer.this.xms;
            public void printX(){
                out.print(mess + xms);
            }
        }
        Inner in = new Inner();
        in.printX();
        return xms;
    }

    protected class Inner{
        //public static int x= 10; //inner classes cannot have static declaration
        public void go(){
            out.print(xms);
        }
    }

    public static class StaticInnerClass{
    //Only an inner class can be static -an outer class can be final or abstract only

        private static int count;
        public void printHello(){
            count++;

            out.println("Staticinnerclass + " + count);

        }
    }

    //Member innerClass
    public class MemberInner{
        public int repeat =3;

        public MemberInner() {

        }

        public void go(){

            for(int i=0;i<repeat;i++){
             out.println(greeting);
            }
            MemberInner2 m2 = new MemberInner2();

            m2.letGo();
        }

        public class MemberInner2{

            abstract class SaleTodayOnly{
                abstract void printRevenue();
            }

            public void letGo() {
                for (int i = 0; i < repeat; i++) {
                    out.println("i am memInner2");
                }

                SaleTodayOnly anonym = new SaleTodayOnly() {
                    @Override
                    void printRevenue() {
                        out.println("i am anonym class");
                    }
                };
                anonym.printRevenue();

                lettingItGo(new SaleTodayOnly() {
                    @Override
                    void printRevenue() {
                        out.println("i am anonym class passed in function");
                    }
                });

            }

            public void lettingItGo(SaleTodayOnly s){
                s.printRevenue();
            }
        }
    }

    public void callInner(){
        MemberInner memberInner = new MemberInner();
        memberInner.go();

        class LocalInner{
            public void whatAreYou(){
                out.println("I am your local inner class");
            }
        }

        LocalInner li = new LocalInner();
        li.whatAreYou();

    }

    public static void main(String... args){
        Outer outer = new Outer();
        outer.callInner();
        MemberInner mb = outer.new MemberInner();
        MemberInner.MemberInner2 mb2 = mb.new MemberInner2();
        StaticInnerClass cs = new StaticInnerClass();
        cs.printHello();
        cs.printHello();

        StaticInnerClass bs = new StaticInnerClass();
        bs.printHello();
        cs.printHello();
        bs.printHello();

        new Outer().getX();

    }
}
