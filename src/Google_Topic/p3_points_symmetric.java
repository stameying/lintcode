package Google_Topic;

import java.util.*;

/**
 * Created by stameying on 2/6/16.
 */
public class p3_points_symmetric {

	/*
	http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=139913&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
	*/
	public static class points implements Comparable<points>{
		double x,y;
		public points(double x, double y){
			this.x = x;
			this.y = y;
		}

        @Override
        public int compareTo(points p){
            return Double.compare(this.x,p.x);
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof points)) return false;
            return this==obj || (this.x==((points) obj).x && this.y == ((points) obj).y);
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.x,this.y);
        }
	}

	public static class compare implements Comparator<points> {
		@Override
		public int compare(points p1, points p2){
			return Double.compare(p1.x, p2.x);
		}

		public static final compare POINTS_COMPARATOR = new compare();
	}

	public static boolean checkPoints(List<points> graph){
		if (graph.size() == 0 || graph.size() == 1) return false;
		Collections.sort(graph, compare.POINTS_COMPARATOR);
		Set<points> pointsMap = new HashSet<>();
		for (points p: graph){
			pointsMap.add(p);
		}
		points midPoint = null;
		if (graph.size()%2 == 0){
			// even number of points
			points p1 = graph.get(graph.size()/2-1);
			points p2 = graph.get(graph.size()/2);
			midPoint = new points((p1.x+p2.x)/2.0,(p1.y+p2.y)/2.0);
		}else{
			midPoint = graph.get(graph.size()/2);
		}
		for (points p1 : graph){
			double checkX = 2*midPoint.x-p1.x;
            double checkY = p1.y;
            System.out.println("p.x = " + p1.x + " p.y = " + p1.y);
            System.out.println("checkX = " + checkX + " checkY = " + checkY);
			if (!pointsMap.contains(new points(checkX,checkY))) return false;
		}
		return true;
	}

    public static void main(String[] args) {
        List<points> g = new ArrayList<>();
        g.add(new points(1.0,3.0));
        g.add(new points(3.0,3.0));
        g.add(new points(0.0,0.0));
        g.add(new points(4.0,0.0));
        System.out.println(checkPoints(g));
    }

}
