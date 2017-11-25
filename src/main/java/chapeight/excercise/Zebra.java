package chapeight.excercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SushmithaShamanth on 11/1/17.
 */
public class Zebra implements Serializable {
    private static final long serialUID= 1L;
   // private transient String name="George";
    private static String birthPlace = "Africa";
  //  private transient Integer age;

    private List<Zebra> friends = new ArrayList<>();
    private Object tail = null;
  //  {age =10;}

    public Zebra(){
//        this.name = "Sophia";
    }
}

