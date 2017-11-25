package chapthree.generic;

import chaptwo.defaultinterfaces.CanRun;

/**
 * Created by SushmithaShamanth on 3/8/17.
 */


public class Elephant implements CanRun {
    public String getName() {
        return name;
    }

    public Elephant setName(String name) {
        this.name = name;
        return this;
    }

    public Elephant(String name){
        this.name = name;
    }
    private String name;

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public void canRun() {

    }
}
