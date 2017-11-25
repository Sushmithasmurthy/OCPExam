package chapfive.excercise;

import static java.lang.System.out;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by SushmithaShamanth on 4/30/17.
 */
public class MainProgram {
    public static void main(String... args){
        out.println(new Locale("hi"));
        out.println(new Locale("hi","IN"));
        out.println(new Locale("IN"));
        out.println(new Locale("IN", "hi"));

        LocalDateTime d = LocalDateTime.of(2015,5,10,11,22,33);
        Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        out.println(d.format(f));

        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone);
        ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
        long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2);
        int clock1 = dateTime1.getHour();
        int clock2 = dateTime2.getHour();
        out.println(hours + ", " +clock1 + "," +clock2);

        ZoneId z14 = ZoneId.of("US/Eastern");
        LocalDate ldt14 = LocalDate.of(2016, 3, 13);
        LocalTime ltm14 = LocalTime.of(2, 15);
        ZonedDateTime zdtm14 = ZonedDateTime.of(ldt14, ltm14, z14);
        out.println("Q14 result: " + zdtm14);

        String m1_15 = Duration.of(1, ChronoUnit.MINUTES).toString();
        out.println(m1_15);
        String m2_15 = Duration.ofMinutes(1).toString();
        out.println(m2_15);
        String s_15= Duration.of(60, ChronoUnit.SECONDS).toString();
        out.println(s_15);

        String d_15 = Duration.ofDays(1).toString();
        out.println(d_15);
        String p_15 = Period.ofDays(1).toString();
        out.println(p_15);

        out.println("A : " + (m1_15 == m2_15));
        out.println("B : " + m1_15.equals(m2_15));
        out.println("C : " + m1_15.equals(s_15));
        out.println("D : " + (d_15 == p_15));
        out.println("E : " + d.equals(p));

        LocalDate d_16 = LocalDate.now();
        out.println(d_16);
        LocalTime t_16 = LocalTime.now();
        LocalDateTime dt_16 = LocalDateTime.now();
        ZoneId zId_16 = ZoneId.systemDefault();
        ZonedDateTime z_16 = ZonedDateTime.of(dt_16, zId_16);
        long epo_16 = 0;
        out.println(Instant.now());
        out.println(Instant.ofEpochSecond(epo_16));
        out.println(z_16.toInstant());




    }

    private static void print(Properties props){
        props.keySet()
                .stream()
                .map(k->k)
                .forEach(out::println);

        props.keySet()
                .stream()
                .map(k->props.get(k))
                .forEach(out::println);
    }

}
/* Answers 11/20
1. A,B,C,D --W(Wrong)
2. Not sure --W
3. B,C --W
4. B --R
5. E --W
6. D, F  --R
7. D --R
8. F --R
9. B --R
10. E --R
11. B --R
12. B, D --W
13. BA --W
14, A,C,D --R
15. B, C ---R
16. A, B,F --R
17. A --W
18. D--R
19. A,B,C --R
20. A, E --w








 */
