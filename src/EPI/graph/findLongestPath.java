package EPI.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stameying on 2/6/16.
 */
public class findLongestPath {
    private static class GraphVertex{
        public List<GraphVertex> edges = new ArrayList<>();
        public int maxDistance = 1;
        public boolean visited = false;
    }

    public static int findLargestNumberTeams(List<GraphVertex> G){
        Deque<GraphVertex> orderedVertices = buildTopologicalOrdering(G);
        return findLongestPath(orderedVertices);
    }

    public static Deque<GraphVertex> buildTopologicalOrdering(List<GraphVertex> graph){
        Deque<GraphVertex> orderedVertices = new LinkedList<>();
        for (GraphVertex g: graph){
            if (!g.visited){
                DFS(g, orderedVertices);
            }
        }
        return orderedVertices;
    }

    public static int findLongestPath(Deque<GraphVertex> orderedVertices){
        int maxDistance = 0;
        while (!orderedVertices.isEmpty()){
            GraphVertex u = orderedVertices.poll();
            maxDistance = Math.max(maxDistance, u.maxDistance);
            for (GraphVertex v: u.edges){
                v.maxDistance = Math.max(v.maxDistance, u.maxDistance+1);
            }
        }
        return maxDistance;
    }

    private static void DFS(GraphVertex cur, Deque<GraphVertex> orderedVertices){
        cur.visited = true;
        for (GraphVertex next : cur.edges){
            if (!next.visited){
                DFS(next,orderedVertices);
            }
        }
        orderedVertices.offer(cur);
    }
}
