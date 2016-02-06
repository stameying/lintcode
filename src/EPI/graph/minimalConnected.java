package EPI.graph;

import java.util.List;

/**
 * Created by stameying on 2/5/16.
 */
public class minimalConnected {

    public static  class GraphVertex{
        public static enum Color {WHITE, GRAY, BLACK};
        public Color color;
        public List<GraphVertex> edges;
    }

    public static boolean isMinimcallyConnected(List<GraphVertex> G){
        return G.isEmpty() || !hasCycle(G.get(0),null);
    }

    public static boolean hasCycle(GraphVertex cur, GraphVertex pre){
        if (cur.color == GraphVertex.Color.GRAY) return true;

        cur.color = GraphVertex.Color.GRAY;
        for (GraphVertex next: cur.edges){
            if (next != pre && next.color != GraphVertex.Color.BLACK){
                if (hasCycle(next,cur)) return true;
            }
        }
        cur.color = GraphVertex.Color.BLACK;
        return false;
    }
}
