package chaptwo.functionalprograms;

/**
 * Created by SushmithaShamanth on 3/1/17.
 */
public class MainProgram {

    public static void main(String... args){
        ActualClass blah = new ActualClass("name", false);

        ILambda il = (ActualClass dc) -> dc.isCrazy();
        RandomMethod(blah, il );

        RandomMethod(blah, bc -> bc.isCrazy());

        RandomMethod(blah,(ActualClass bc) ->{ return bc.isCrazy(); } );

        RandomMethod(blah, bc->{return bc.isCrazy();});

        ActualClass anotherActualClass = new ActualClass("have", true);
        RandomMethod(blah, ac -> anotherActualClass.isCrazy());
        anotherActualClass.setIsCrazy(true);
        blah.setIsCrazy(true);

        RandomMethod(blah, dc -> {
            int a = 10;
            if (dc.isCrazy() && anotherActualClass.isCrazy())
                a++;
            else
                a--;
            System.out.println("you are inside a multiline lambda with value of a:" + a);
            return dc.isCrazy();
        });

        RandomMethod(blah, bc -> bc.isCrazy());


        ILambda il2 = (ActualClass dc) -> dc.isCrazy();
        TestSomething( il2);

        TestSomething( bc -> true );

        TestSomething( (ActualClass bc) -> {

            return bc.isCrazy();
        });

        TestSomething( bc -> {
            return bc.isCrazy();
        });

        ActualClass anotherActualClass1 = new ActualClass("have", true);
        TestSomething(ac -> anotherActualClass.isCrazy());
        anotherActualClass.setIsCrazy(true);
        blah.setIsCrazy(true);

        TestSomething(dc -> {
            int a = 10;
            ActualClass bdc = new ActualClass("dcclass", false);
            if (dc.isCrazy() && anotherActualClass.isCrazy() && bdc.isCrazy())
                a++;
            else
                a--;
            System.out.println("you are inside a multiline lambda with value of a:" + a);
            return dc.isCrazy();
        });

        TestSomething( bc -> bc.isCrazy());
    }

    public static void RandomMethod(ActualClass ac, ILambda al){
        if(!al.test(ac))
            System.out.println("Not crazy");
        else
            System.out.println("Crazy!!");
    }

    public static void TestSomething( ILambda al){
        ActualClass ac = new ActualClass("whoknows", true);
        if(!al.test(ac))
            System.out.println("Not crazy");
        else
            System.out.println("Crazy!!");
    }
}
