package src.first_round;

import java.util.*;

/**
 * Created by stameying on 12/31/15.
 */
public class countOfAirplanes {

    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }

        Collections.sort(airplanes, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });

        Point[] points = new Point[airplanes.size()*2];
        for (int i = 0; i < airplanes.size(); i++) {
            points[i*2] = new Point(airplanes.get(i).start, true);
            points[i*2 + 1] = new Point(airplanes.get(i).end, false);
        }

        for (int i = 0; i < points.length-1; i+=2){
            System.out.print("["+ points[i].time + "," + points[i+1].time + "] ");
        }

        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point i1, Point i2) {
                return Integer.compare(i1.time, i2.time);
            }
        });

        int res = 0;
        int cur = 0;
        for (Point p : points) {
            if (!p.isStart) {
                cur--;
            } else {
                cur++;
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    class Point {
        int time;
        boolean isStart;
        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static void main(String[] args) {
        countOfAirplanes test = new countOfAirplanes();
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(2,3);
        Interval i3 = new Interval(5,8);
        Interval i4 = new Interval(4,7);
        ArrayList<Interval> arr = new ArrayList<Interval>();
        arr.add(i2);
        arr.add(i1);
        arr.add(i3);
        arr.add(i4);
        test.countOfAirplanes(arr);
    }
}
