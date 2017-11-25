package chaptwo.objectcomposition;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class Penguin {
    private Flippers flippers;
    private WebbedFeet webbedFeet;

    public Penguin(){
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void ActivatePenguin(){
        this.flippers.flap();
        this.webbedFeet.kick();
    }

    public static void main(String... args){
        Penguin p = new Penguin();
        p.ActivatePenguin();
    }
}
