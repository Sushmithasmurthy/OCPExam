package chapnine;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 11/14/17.
 */
public class JoiningPathObjects {
    public static void main(String... args){
        Path p1 = Paths.get("OCPExam/src");
        Path p2 = Paths.get("chapnine");
        out.println(p1.resolve(p2));
        out.println(p2.resolve(p1));

        out.println("**************************");
        Path p3 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam");
        Path p4 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/Ocaexam");

        out.println(p3.resolve(p4));
        out.println(p4.resolve(p3));


    }
}
