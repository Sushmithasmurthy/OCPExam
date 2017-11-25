package chapeight;

import chaptwo.functionalprograms.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SushmithaShamanth on 10/18/17.
 */
public class ObjectIOStreamSerialize {

    private static final String animalFileName = "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/animalsList.txt";
    public static void main(String... args){
        List<SerializableAnimal> animals = new ArrayList<>();
        animals.add(new SerializableAnimal("Dog","Brownie",9,"VegAndNonVEg", Boolean.TRUE));
        animals.add(new SerializableAnimal("Cat","Blacky",8,"VegAndNonVEg", Boolean.TRUE));
        animals.add(new SerializableAnimal("Parrot","Pretty Polly",2,"VegAndNonVEg", Boolean.TRUE));
        animals.add(new SerializableAnimal("Fish","Lui",1,"VegAndNonVEg", Boolean.TRUE));
        animals.add(new SerializableAnimal("Fish","Dui",1,"VegAndNonVEg", Boolean.TRUE));
        animals.add(new SerializableAnimal("Fish","Yui",2,"VegAndNonVEg", Boolean.TRUE));
        animals.add(new SerializableAnimal("Duck", "UncleScrooge", 20,"VegAndNonVEg", Boolean.TRUE));

       writeAnimalsToFile(animals);

        readAnimalsFromFile()
                .stream()
                .forEach(x -> System.out.println(x));
    }

    private static void writeAnimalsToFile(List<SerializableAnimal> animals){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(animalFileName)
                ))){
            animals
                   .stream()
                    .forEach( x-> {
                                try {
                                    objectOutputStream.writeObject((Object)x);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    );
            objectOutputStream.flush();

        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    private static List<SerializableAnimal> readAnimalsFromFile(){
        List<SerializableAnimal> animalList = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(animalFileName)
                ))){
            Object obj;
            while((obj = objectInputStream.readObject()) != null){
                if(obj instanceof SerializableAnimal)
                animalList.add((SerializableAnimal)obj);
            }
            return animalList;
        }catch(EOFException eofex){ //this is the proper technique to handle- This is one of the few times when it is perfectly acceptable to swallow an exception
            return animalList;
        }
        catch(ClassNotFoundException|IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
