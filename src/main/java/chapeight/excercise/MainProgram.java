package chapeight.excercise;

import java.awt.*;
import java.io.*;
/**
 * Created by SushmithaShamanth on 10/25/17.
 */
public class MainProgram {


    public static void main(String... args) throws IOException{
       /* try(InputStream is = new BufferedInputStream(
                new FileInputStream("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/source.txt")
        )) {
            InputStream wrapper = new BufferedInputStream(is);
            InputStream wrap = new ObjectInputStream(is);
        }*/
        MainProgram m = new MainProgram();
        m.echo();
        Console console = System.console();
        if(console!=null) {
            console.writer().print("ewe");
            console.readLine();
            console.readPassword();



            String line;
            Writer w = console.writer();
            if((line = console.readLine())!= null)
                w.append(line);
            w.flush();
        }



    }
    public static void deleteTree(File file){
        if(!file.isFile()){
            for(File entry: file.listFiles())
                deleteTree(entry);

        }
        else
            file.delete();

    }

    private void echo() throws IOException{
        try(FileReader fileReader = new FileReader("/Users/SushmithaShamanth/IdeaProjects/OCPExam/src/main/resources/destBufferedReaderWriter18_Oct_2017_00_14_32.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            System.out.println(bufferedReader.readLine());
        }
        Object o = new Object();
        o = "d";
        StringBuilder sb = new StringBuilder("s");
        sb.append((char)o);
    }



}


//Answers 12/23
//1. A,D -R
//2. B,E,F --R
//3. C,D --R
//4. C,D --W
//5. B, D,E --R
//6. A, E --R
//7. D-- R
//8. A,  E  -W
//9. A, D --W
//10.C -W
//11.C,E,G -- R
//12.D --W
//13. E,A,C --R
//14. E -- R
//15. A-- R
//16. D,F --R
//17. A,B,G --W
//18. E --W
//19. C, D, B, G --W
//20. A.B,C,D --W
//21. A,C -- R
//22. H --W
//23. D --W