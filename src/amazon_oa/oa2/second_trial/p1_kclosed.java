package src.amazon_oa.oa2.second_trial;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Created by stameying on 2/28/16.
 */
public class p1_kclosed {

    public static class Point{
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Point(){}
    }


    public static Point[] closetK(Point[] points, Point origin, int k){
        if (points == null || points.length == 0 || k <= 0) return null;
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return Double.compare(getDistance(p2,origin),getDistance(p1,origin));
            }
        });

        for (int i = 0; i < points.length; i++){
            maxHeap.offer(points[i]);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        Point[] res = new Point[k];
        int idx = k-1;
        for (int i = 0; i < k; i++){
            res[idx--] = maxHeap.poll();
        }

        return res;
    }

    public static double getDistance(Point p1, Point p2){
        return Math.hypot(p1.x-p2.x,p1.y-p2.y);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,3);
        Point p3 = new Point(1,-3);
        Point p4 = new Point(-1,-1);
        Point p5 = new Point(-4,3);
        Point[] points = {p1,p2,p3,p4,p5};
        Point[] out = closetK(points,new Point(0,0),3);

        for (Point p : out){
            System.out.println("x,y = "+p.x+","+p.y);
        }
    }
}
