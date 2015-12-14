import java.util.Collections;
import java.util.List;

/**
 * Created by stameying on 12/13/15.
 */
public class merge {
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() == 0 || intervals.size() == 1) return intervals;
        Collections.sort(intervals,new IntervalComparator());
        for (int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            Interval prev = intervals.get(i-1);
            if (cur.start <= prev.end){
                Interval temp = new Interval(prev.start,Math.max(prev.end,cur.end));
                intervals.remove(i);
                intervals.set(i-1,temp);
                i--;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {

    }

}
