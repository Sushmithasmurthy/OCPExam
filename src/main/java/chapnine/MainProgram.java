package chapnine;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.*;

/**
 * Created by SushmithaShamanth on 11/2/17.
 */
public class MainProgram {

    public static void main(String... args)
            throws IOException
    {


       /* System.out.println(FileSystems.getDefault().getPath(".").toRealPath());
        System.out.println(Paths.get(".").toRealPath());
        Path p1 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/java/chapnine/MainProgram.java");
        Path p2 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/animalsList.txt");
        */
        //Files.deleteIfExists(Paths.get("2"));
        Path p3 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/java/ScratchPad");
        System.out.println(Files.size(p3) + " in Bytes");

        FileTime fileTimeObject = Files.getLastModifiedTime(p3);

        System.out.println(fileTimeObject);

        System.out.println(fileTimeObject.toMillis());
      //  Files.setLastModifiedTime(p3, FileTime.from(Instant.now()));
        System.out.println(Files.getLastModifiedTime(p3));
        System.out.println(Files.getOwner(p3));


        UserPrincipal owner = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("SushmithaShamanth");

        System.out.println(Files.size(Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/bill-strategy-pattern-master.zip")) + "in Byes");

        BasicFileAttributes bf = Files.readAttributes(p3, BasicFileAttributes.class);
        System.out.println(bf.toString());

    //    Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
      //  System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());
        Path dir = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources");
      //  BasicFileAttributes attrib = Files.readAttributes(dir, BasicFileAttributes.class);
        Path p1 = Paths.get("/Users/SushmithaShamanth/Kang");
        //Files.createSymbolicLink(p1,dir);
        //if(Files.isDirectory(p1) && Files.isSymbolicLink(p1))
          //  Files.createDirectory(p1.resolve("joey"));

        Path p4 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/java/chapten");
     //   boolean myBoolean = Files.walk(p4).findFirst().isPresent();

     //   Path path = Paths.get("turkey");
       /* if(Files.isSameFile(path,Paths.get("/Users/SushmithaShamanth/turkey")))
            Files.createDirectory(path.resolve("info"));*/


        Path p8a = Paths.get("/pets/../cat.txt");
        Path p8b = Paths.get("./dog.txt");

        System.out.println(p8a.resolve(p8b));

        System.out.println(p8b.resolve(p8a));
      //  Files.move(Paths.get("monkey.txt"), Paths.get("/animals"), StandardCopyOption.ATOMIC_MOVE,LinkOption.NOFOLLOW_LINKS);
        System.out.println("TEst 13");
        Path p13 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam");
        Files.find( p13, 0,(p,a)-> !a.isSymbolicLink()).map( p ->p.toString())
                .collect(Collectors.toList())
                .stream()
                .filter(x->x.toString().endsWith(".xml"))
                .forEach(System.out::println);
        Path p16 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/HousingData.csv");
        System.out.println("TEst 16");
        Files.lines(p16)
                .flatMap(p -> Stream.of(p.split(",")))
                .map(s -> s.toLowerCase())
                .forEach(System.out::println);
        System.out.println("TEst 17");
        Files.walk(Paths.get("..").toRealPath().getParent(),1)
                .map( p -> p.toAbsolutePath().toString())
                .filter(s->s.endsWith(".java"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Path p18 = Paths.get("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/./").resolve(Paths.get("HousingData.csv"));
        Path p18a = new File("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/././another/../HousingData.csv").toPath();
            System.out.println(Paths.get("/Users/SushmithaShamanth/.").toRealPath());
//        System.out.println(Files.isSameFile(p18,p18a));
  //      System.out.println(" "+ p18.equals(p18a));

//        System.out.println(" " + p18.normalize().equals(p18a.normalize()));

        //Files.walk().
        System.out.println("TEst 20");
        Path p20 = Paths.get(".").normalize();
        System.out.println(p20.toAbsolutePath());
        int count = 0;
        for(int i=0;i < p20.getNameCount();i++){
            count++;
        }
        System.out.println(count);

    }
}
//Answers 9/20
/*
1.F- R
2.C-W
3.A-W
4.C-R
5.B,C,D -R
6.C-R
7.D-W
8.A-R
9.B,C,E -W
10.C, --W
11.A -R
12.A,B,F -W
13.B -- R--as depth is set to 0.
14.C--W
15.D,E,F - R
16.A,F --W
17.A,E,F,G -W
18.Not sure -W
19.A,E,C -R
20. B-R



Rough work:
/kang  --> /mammal/kangaroo

/kang
YEs && yes
/../joey

/mammal/kangaore/joey


*/