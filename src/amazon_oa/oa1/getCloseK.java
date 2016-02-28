package src.amazon_oa.oa1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/25/16.
 */
public class getCloseK {

    private static class Point{
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class PointWithDistance{
        public Point p;
        public double distance;

        public PointWithDistance(Point p, double distance) {
            this.p = p;
            this.distance = distance;
        }
    }

    private static class MaxHeapComparator implements Comparator<PointWithDistance>{
        @Override
        public int compare(PointWithDistance p1, PointWithDistance p2){
            return Double.compare(p2.distance,p1.distance);
        }

        public static final MaxHeapComparator MAXCOMPARATOR = new MaxHeapComparator();
    }

    public static Point[] getCloseK(Point[] points, Point origin, int k){

        PriorityQueue<PointWithDistance> maxHeap = new PriorityQueue<>(k, MaxHeapComparator.MAXCOMPARATOR);

        PointWithDistance[] pointsArray = new PointWithDistance[points.length];
        int index = 0;
        for (Point p: points){
            double distance = Math.hypot(p.x-origin.x,p.y-origin.y);
//            System.out.println("x,y = "+p.x+","+p.y + " d = " + distance);
            pointsArray[index++] = new PointWithDistance(p,distance);
        }

        for (PointWithDistance p: pointsArray){
            if (maxHeap.size() < k){
                maxHeap.offer(p);
            }else{
                if (p.distance < maxHeap.peek().distance){
                    maxHeap.poll();
                    maxHeap.offer(p);
                }
            }
        }

        // res
        Point[] res = new Point[k];
        int resIdx = 0;
        while (!maxHeap.isEmpty()){
            res[resIdx++] = maxHeap.poll().p;
        }
        return res;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,3);
        Point p3 = new Point(1,-3);
        Point p4 = new Point(-1,-1);
        Point p5 = new Point(-4,3);
        Point[] points = {p1,p2,p3,p4,p5};
        Point[] out = getCloseK(points,new Point(0,0),3);

        for (Point p : out){
            System.out.println("x,y = "+p.x+","+p.y);
        }
    }
}
