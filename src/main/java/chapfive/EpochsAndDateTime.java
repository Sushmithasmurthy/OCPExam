package chapfive;

import static java.lang.System.out;

import java.time.*;

/**
 * Created by SushmithaShamanth on 4/30/17.
 */
public class EpochsAndDateTime {

    public static void main(String... args){
        out.println("LocalDate has toEpochDay:" + LocalDate.now().toEpochDay());

        out.println("LocalDate has era also: "+ LocalDate.now().getEra());


        Long epo = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(4));
        out.println("LocalDateTime has toEpochSecond:" + epo );
        out.println("LocalDateTime from Epoch second:"
                +  LocalDateTime.ofEpochSecond(epo,0,ZoneOffset.ofHours(4)));

        out.println("ZonedDateTime has toEpochSecond:" +  ZonedDateTime.now(ZoneId.systemDefault()).toEpochSecond());



    }
}
