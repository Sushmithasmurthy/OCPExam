package chaptwo.polymorphism;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class Lemur extends Primate implements HasTail{

    private int age;

    public boolean isTailStriped(){
        return true;
    }

    public Lemur(int age){
        this.age = age;

    }

    public static void main(String... args){
        Lemur lemur = new Lemur(3);
        Primate p = lemur;
        HasTail h = lemur;

        out.println("age"+lemur.age);
        out.println("has hair:" + p.hasHair());

        out.println("is taile striped:" +h.isTailStriped());
    }
}
