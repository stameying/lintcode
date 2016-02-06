package EPI.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by stameying on 2/5/16.
 */
public class flipColor {

    public static void flipColor(List<List<Boolean>> A, int x, int y){
        int[][] dir = new int[][]{new int[]{0,1}, new int[]{0,-1}, new int[]{-1,0}, new int[]{1,0}};
        boolean color = A.get(x).get(y);
        Queue<Coordinate> q = new LinkedList<>();
        A.get(x).set(y, !color);
        q.add(new Coordinate(x,y));
        while (!q.isEmpty()){
            Coordinate cur = q.poll();
            for (int[] d: dir){
                Coordinate next = new Coordinate(cur.x+d[0],cur.y+d[1]);
                if (next.x >= 0 && next.y >= 0 && next.x < A.size() && next.y < A.get(0).size() && A.get(next.x).get(next.y) == color){
                    A.get(x).set(next.y,!color);
                    q.offer(next);
                }
            }
        }
    }
}
