package chapone.equalshashcodetostring;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 2/13/17.
 */
public class Employee {
    private int employeeId;
    public String firstName, lastName;
    public int yearStarted;

    enum Flavours{
        VANILLA, CHOCOLATE, STRAWBERRY{
            public void blah(){

            }
        };

    }

    @Override public int hashCode(){
        return employeeId;
    }

    public boolean equals(Employee e){
        return this.employeeId == e.employeeId;
    }

    public static void main(String... args){
        Employee one = new Employee();
        one.employeeId = 101;
        Employee two = new Employee();
        two.employeeId = 101;
        if(one.equals(two)) out.println("Success");
        else
            out.println("Failure");

        out.println(Flavours.CHOCOLATE.ordinal());
        Flavours f = Flavours.STRAWBERRY;
        switch(f){
            //case 0: out.print("vanilla"); // does not compile
            case STRAWBERRY:
            //case 1: out.println("choclate");
            //case 3:
            out.print("Strawberry");
                break;
            default:out.print("missing");
        }
    }
}
