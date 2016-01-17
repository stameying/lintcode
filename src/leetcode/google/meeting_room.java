package leetcode.google;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Created by stameying on 1/16/16.
 */
public class meeting_room {

    public class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            int cur = 0, max = 0;
            point[] points = new point[intervals.length*2];
            int pos = 0;
            for (Interval interval: intervals){
                points[pos++] = new point(interval.start,true);
                points[pos++] = new point(interval.end,false);
            }
            Arrays.sort(points,new Comparator<point>(){
                public int compare(point p1, point p2){
                    if (p1.val < p2.val) return -1;
                    else if (p1.val > p2.val) return 1;
                    else{
                        // end comes before start
                        if (p1.isStart == true && p2.isStart == true) return 0;
                        else if (p1.isStart == false && p2.isStart == true) return -1;
                        else if (p1.isStart == true && p2.isStart == false) return 1;
                        else return 0;
                    }
                }
            });
            for (int i = 0; i < points.length; i++){
                if (points[i].isStart == true){
                    cur++;
                    max = Math.max(max,cur);
                }else{
                    cur--;
                }
            }
            return max;
        }
    }

    class point{
        boolean isStart;
        int val;
        public point(int val, boolean isStart){
            this.val = val;
            this.isStart = isStart;
        }
    }

    class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
