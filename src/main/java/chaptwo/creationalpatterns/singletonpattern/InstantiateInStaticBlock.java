package chaptwo.creationalpatterns.singletonpattern;

/**
 * Created by SushmithaShamanth on 3/4/17.
 */
public class InstantiateInStaticBlock {
    //1. private constructor
    private InstantiateInStaticBlock(){}

    //2. private static final instance
    private static final InstantiateInStaticBlock instance;

    //3. instantiate the instance in static block
    static {
        instance = new InstantiateInStaticBlock();
    }

    //4.public static get instance method
    public static InstantiateInStaticBlock getInstance(){
        return instance;
    }


}
