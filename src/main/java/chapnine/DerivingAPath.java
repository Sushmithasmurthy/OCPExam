package chapnine;

import java.nio.file.*;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 11/11/17.
 */
public class DerivingAPath {
    public static void main(String... args){
        Path relativePathObj1 = Paths.get("chapnine/childpackage/Randomfile.txt") ;
        Path realtivePathObj2 = Paths.get("DerivingPath");
        System.out.println("Both objects are relative Paths: " + relativePathObj1.relativize(realtivePathObj2).toString());
        System.out.println("Both objects are relative Paths: " + realtivePathObj2.relativize(relativePathObj1).toString());
        out.println("******************************");

        /* DO more examples of relativize*/
        Path p1 = Paths.get("src/main/resources");
        Path p2 = Paths.get("src/test/java");
        out.println(p1.relativize(p2));
        out.println(p2.relativize(p1));
        out.println("******************************");

        Path p3 = Paths.get("OCPExam/src/main/java");
        Path p4 = Paths.get("OCPExam/src/main/java");
        System.out.println("If both the paths are same it will not return anything");
        Path a = p3.relativize(p4);
        Path b = p4.relativize(p3);
        out.println(a);
        out.println(b);
        out.println("******************************");

        Path p5 = Paths.get("OCPExam/src/main/resources/animalsList.txt");
        Path p6 = Paths.get("OCPExam/src/main/java/chapnine/DerivingAPath.java");
        out.println(p5.relativize(p6));
        out.println(p6.relativize(p5));
        out.println("******************************");

        Path p7 = Paths.get("IdeaProjects/OCPExam/target/classes/chapeight/BufferedInputAndOutputStreams.class");
        Path p8 = Paths.get("IdeaProjects/OCPExam/src/main/resources");
        out.println(p7.relativize(p8));
        out.println(p8.relativize(p7));
        out.println("******************************");



        Path p9 = Paths.get("IdeaProjects/OCPExam/src/main/java/chapnine/AccessingPAthComponents.java");
        Path p10 = Paths.get("IdeaProjects/OCPExam/src/test/java");
        out.println(p9.relativize(p10));
        out.println(p10.relativize(p9));

        out.println("Generate Absolute Path");

        Path ab1= Paths.get("/Users/SushmithaShamanth/IdeaProjects//OCPExam/src/main/java/chapnine/DerivingAPath.java");
        Path ab2 = Paths.get("/Library/Java/JavaVirtualMachines/1.8.0_51.jdk/Contents/Home/lib/ant-javafx.jar/");

        out.println(ab1.relativize(ab2));
        out.println(ab2.relativize(ab1));
        out.println((ab1.relativize(ab2)).normalize());






    }
}
