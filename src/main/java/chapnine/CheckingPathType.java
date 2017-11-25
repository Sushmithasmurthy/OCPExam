package chapnine;

import java.nio.file.*;
import java.util.Comparator;

/**
 * Created by SushmithaShamanth on 11/11/17.
 */
public class CheckingPathType {

    public static void main(String... args){
        Path absPathOfFileInCurrentDirectory = Paths.get("CheckingPathType");
        System.out.println("Absolute path of a file in current directory: " + absPathOfFileInCurrentDirectory.toAbsolutePath());


        Path absPathOfAFileInDiffDirectory = Paths.get("apple.txt");

        System.out.println("Abs path of a file in a different directory : " + absPathOfAFileInDiffDirectory.toAbsolutePath());

    }
}
