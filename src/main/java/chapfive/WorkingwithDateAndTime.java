package chapfive;
import java.time.*;
import java.time.temporal.ChronoUnit;
import static java.lang.System.out;


/**
 * Created by SushmithaShamanth on 4/16/17.
 */
public class WorkingwithDateAndTime {
    public static void main(String... args){
        Instant now = Instant.now();
        LocalDate ldt  = LocalDate.of(2017, Month.APRIL, 30);
        out.println(ldt);

        LocalTime lt = LocalTime.of(20, 10, 1, 1);
        out.println(lt);

        ZonedDateTime zdtm = ZonedDateTime.now();
        out.println(zdtm);

        ZoneId z = ZoneId.of("GMT");
        out.println(ZonedDateTime.now(z));

        LocalDateTime l = LocalDateTime.now();
        out.println(l);

        LocalDateTime ldtm = LocalDateTime.now();
        out.println("Current Date/Time is :"+ldtm);
        //Manipulating Date and times
        out.println(ldtm.plusDays(10));
        out.println(ldtm.plusMonths(1));
        out.println(ldtm.plusYears(10));
        out.println(ldtm.plusMinutes(10));


        out.println("Working with Periods");
        LocalDate start = LocalDate.of(2015, Month.JANUARY,1);
        LocalDate end = LocalDate.of(2015,Month.MARCH,30);
        LocalDate upto = start;
        Period p = Period.ofMonths(1);
        out.println(Period.of(1, 2, 3));
        while(upto.isBefore(end)){
            out.println("give new toy: "+ upto);
            upto = upto.plus(p);
        }
        out.println(Duration.ofDays(30));
        out.println(Duration.ofHours(1));
        out.println(Duration.ofMinutes(1));
        out.println(Duration.ofSeconds(1));
        out.println(Duration.ofNanos(1));
        Long billion = 1_000_000_000L;
        out.println("Nanos is  1 billionth of a second:" + 1/billion );

        out.println("Working with Chrono unit");
        LocalTime one = LocalTime.of(5,15);
        LocalTime two = LocalTime.of(6,30);
        LocalDate date = LocalDate.of(2016,1,20);

        out.println("ChronoUnit.HOURS  " + ChronoUnit.HOURS.between(one,two));
        out.println("ChronoUnit.MINUTES  " + ChronoUnit.MINUTES.between(one, two));
       /* out.println("ChronoUnit.MINUTES.between LocalTime and LocalDate Time throws an exception:"
                    + ChronoUnit.MINUTES.between(one, date)); //Throws DatTimeException*/

        out.println("Working with instants");
        Instant later = Instant.now();
        Duration duration = Duration.between(now,later);
        out.println(duration.toMillis());

        out.println("Convert Zonedatetime into instant");
        LocalDate localDate = LocalDate.of(2015,Month.APRIL,12);
        LocalTime localTime = LocalTime.of(10,20);

        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate,
                localTime, ZoneId.of("US/Eastern"));

        out.println("Instant datetime from zoneddatetime "+ Instant.from(zonedDateTime));
        out.println("Instant datetime from zoneddatetime "+ zonedDateTime.toInstant());
       // out.println("Instant datetime from localDateTime"+ Instant.from(localDateTime));

        out.println("Zoned datetime in GMT " + ZonedDateTime.now(ZoneId.of("GMT")));

        out.println("Using instant to do Math:(remember you can do it only for a day or smaller) ");
        out.println("next day: " + Instant.now().plus(1, ChronoUnit.DAYS));//Works
        out.println("next hour: " + Instant.now().plus(1,ChronoUnit.HOURS));//Works
        //Below Throws an exception as its greater than a day
        //out.println("next week: " + Instant.now().plus(1,ChronoUnit.WEEKS));

        out.println("Day light savings start time: (Notice GMT offset)" +ZonedDateTime.of(2017,3,12,1,00,00,0,ZoneId.of("US/Eastern")));
        out.println("Try adding 1 hour to 12March 1:00 AM- you will see 2:00AM when u use LocalDatetime");
        out.println(LocalDateTime.of(2017,Month.MARCH,12,1,00,00).plusHours(1));
        out.println("Try adding 1 hour to 12March 1:00 AM for Zoneddatetime where Zone is US/Eastern- you will see 3:00AM instead of 2:00 AM");
        out.println(ZonedDateTime.of(2017, 3, 12,
                1, 0, 0, 0,
                ZoneId.of("US/Eastern"))
                .plusHours(1));



    }
}
