package chapeight;

import java.io.Serializable;

/**
 * Created by SushmithaShamanth on 10/18/17.
 */
public class SerializableAnimal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;
    private String name;
    private int age;
    private transient String foodType = "Any food"; //Consytuctor and any default initializations are ignored during deserialization process.
    private transient Boolean isFav;


    public SerializableAnimal(String type,String name,int age,String foodType,Boolean isFav){
        this.age= age;
        this.name= name;
        this.type = type;
        this.foodType = foodType;
        this.isFav = isFav;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "Age: " + this.age + " Name: " +this.name + " Type: "+this.type+ " isFav: "+this.isFav+ " foodType: "+this.foodType;
    }


}
