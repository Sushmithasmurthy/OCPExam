package chapnine;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by SushmithaShamanth on 11/11/17.
 */
public class AccessingPAthComponents {
    public static void main(String... args) throws IOException {

        Path absPath = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/java/chapnine"); //This is an absolute path
        Path relativePath = Paths.get("./childpackage/Randomfile.txt"); //This is relative path
        Path relativePathInDiffDirectory = Paths.get("../excercise/MainProgram"); //This is relative path
        Path relativePathWithNoParentInPath = Paths.get("MainProgram"); //This is relative path
        Path absPathOFRoot = Paths.get("/");
        /* "/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/java/chapnine/AccessingPAthComponents.java"*/
        System.out.println("Get parent from Absolute path " +absPath.getParent());
        System.out.println("Get parent from Relative path " +relativePath.getParent());
        System.out.println("Get parent from Relative path in a different directory " +relativePathInDiffDirectory.getParent());
        System.out.println("Get parent relativePathWithNoParentInPath " +relativePathWithNoParentInPath.getParent());
        System.out.println("Get parent absPathOFRoot " +absPathOFRoot.getParent());


        System.out.println("Get root from Absolute path " +absPath.getRoot());
        System.out.println("Get root from Relative path " +relativePath.getRoot()); //null
        System.out.println("Get root from Relative path in a different directory " +relativePathInDiffDirectory.getRoot());//null
        System.out.println("Get root relativePathWithNoParentInPath " +relativePathWithNoParentInPath.getRoot()); //null
        System.out.println("Get root absPathOFRoot " +absPathOFRoot.getRoot());





    }
}
