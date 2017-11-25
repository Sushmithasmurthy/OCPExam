package chapfive;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by SushmithaShamanth on 4/29/17.
 */
public class TimeWithReferenceToGMT {

    public static void main(String... args){
        out.println("If offset on a time zone is +0200 : it means thsi time is 2 hours ahead of GMT\n");
        ZonedDateTime zt = ZonedDateTime.now();

        List<ZoneId>  zonesGreaterThanGMT = Arrays.asList(
                ZoneId.of("Europe/Paris"),
                ZoneId.of("Asia/Kolkata")
        );
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd 'T' HH:mm ZZ");

        zonesGreaterThanGMT.stream().forEach( x-> out.println( df.format(ZonedDateTime.now(x))+" "+ x));

        out.println("\n"+ df.format(ZonedDateTime.now(ZoneId.of("GMT")))+ " GMT \n");
        List<ZoneId>  zonesLessThanGMT = Arrays.asList(
                ZoneId.of("US/Pacific"),
                ZoneId.of("America/New_York")
        );
        out.println("If offset on a time zone is -0200 : it means thsi time is 2 hours before GMT\n");
        zonesLessThanGMT.stream().forEach( x-> out.println(df.format(ZonedDateTime.now(x))+" "+x));




    }
}

