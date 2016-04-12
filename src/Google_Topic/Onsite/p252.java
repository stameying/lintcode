package src.Google_Topic.Onsite;

import leetcode.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by stameying on 4/3/16.
 */
public class p252 {

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals,IntervalComparator.IC);
        for (int i = 1; i < intervals.length; i++){
            Interval pre = intervals[i-1];
            Interval cur = intervals[i];
            if (cur.start < pre.end) return false;
        }
        return true;
    }

    public static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2){
            int res = Integer.compare(i1.start,i2.start);
            if (res != 0) return res;
            return Integer.compare(i1.end,i2.end);
        }
        public static final IntervalComparator IC = new IntervalComparator();
//        public static final p252 test = new p252();
    }

}
