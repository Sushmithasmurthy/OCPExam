package chapthree.generic;

/**
 * Created by SushmithaShamanth on 3/8/17.
 */
public class Crate<T> {

    private T contents;

    //private static Crate<T> staticVariableCrate; //5 Cannot use static variable as a generic type parameter.
    private static String staticVariable; //but you can for normal class

    public T emptyCrate(){
        System.out.println("Emptying :"+ contents.toString());
        return contents;
    }

    public void packCrate(T contents){
        System.out.println("Packing :" + contents.toString());
        this.contents = contents;
    }

    public static <T> Crate<T> ship(T t){
        //T tObj = new T(); //1.Call constructor with T as the type
        System.out.println("preparing :" + t.toString());

        return new Crate<T>();
    }




    public static void main(String... args) {
        Elephant sambha = new Elephant("samba");
        Crate<Elephant> elephantCrate = new Crate<>();
        elephantCrate.packCrate(sambha);
        elephantCrate.emptyCrate();

        Robot robo = new Robot("RajniRobo");
        Crate<Robot> robotCrate = ship(robo);
        //elephantCrate.packCrate(robo); //DOES not compile - As the elephant crate can hold only elephants
        robotCrate.packCrate(robo);
        robotCrate.emptyCrate();


        //Things you cant do with Generic object
        //Crate<T> tell = new Crate<>(); // 1.Call constructor with T as the type

        Elephant e = new Elephant("normal class");//You can for normal class

        //Crate<T> arrayOfCrates [] = {}; //2. Cannot create an array of this type
        Elephant[] elephantsArray = {};//You can for normal class

        //if(elephantCrate instanceof Crate<Elephant>){ } //3. Cannot call instance of
        //if(elephantCrate instanceof  Crate<T>){}//3. Cannot call instance of
        BabyElephant babyElephant = new BabyElephant();
        if (babyElephant instanceof Elephant) { }//You can for normal class

        //Crate<int> intCrate = new Crate<>(); //4 Cannot be used with Primitives




    }
}
