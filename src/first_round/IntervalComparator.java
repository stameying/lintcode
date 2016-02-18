package src.first_round;

import java.util.Comparator;

/**
 * Created by stameying on 12/13/15.
 */
public class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval interval1, Interval interval2){
        return interval1.start - interval2.start;
    }
}
