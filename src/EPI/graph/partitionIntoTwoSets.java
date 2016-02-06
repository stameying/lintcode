package EPI.graph;

import java.util.*;

/**
 * Created by stameying on 2/5/16.
 */
public class partitionIntoTwoSets {

    public static class GraphVertex{
        public int d = -1;
        public List<GraphVertex> edges = new ArrayList<>();
    }

    public static boolean isAnyPlacementFesible(List<GraphVertex> graph){
        for (GraphVertex v : graph){
            if (v.d == -1){
                v.d = 0;
                if (!BFS(v)) return false;
            }
        }
        return true;
    }

    public static boolean BFS(GraphVertex s){
        Queue<GraphVertex> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()){
            GraphVertex cur = q.poll();
            for (GraphVertex next: cur.edges){
                if (next.d == -1){
                    next.d = cur.d+1;
                    q.offer(next);
                }else if (next.d == cur.d) return false;
            }
        }

        String str = "hi";
        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));
        return true;
    }

    public static void main(String[] args) {
        String str = "hi";
        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));
        StringBuilder builder = new StringBuilder();

    }
}
