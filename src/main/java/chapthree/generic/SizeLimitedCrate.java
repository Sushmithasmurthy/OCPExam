package chapthree.generic;

/**
 * Created by SushmithaShamanth on 3/8/17.
 */
public class SizeLimitedCrate<T, U> extends Crate<T>{
    private T contents;
    private U sizeLimit;
    public SizeLimitedCrate(T contents, U sizeLimit){
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }


    public static void main(String... args){
        Elephant e = new Elephant("Samba");
        Integer noOfPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer>  elephantSizeLimitedCrate = new SizeLimitedCrate<>(e, noOfPounds);
        elephantSizeLimitedCrate.packCrate(e);
        elephantSizeLimitedCrate.emptyCrate();

    }
}
