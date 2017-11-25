package chapfour.primitives;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

import static java.lang.System.out;
/**
 * Created by SushmithaShamanth on 4/11/17.
 */
public class SummaryStatisticsUsage {
    public static void main(String... args){
        out.println("IntSummary Statistics Usage");

        IntStream in =IntStream.of(1,2,3,4);
        IntSummaryStatistics stats = in.summaryStatistics();
        if(stats.getCount() ==0 )throw new RuntimeException();
        out.println(stats.getAverage());
        out.println(stats.getMax() - stats.getMin());


    }
}
