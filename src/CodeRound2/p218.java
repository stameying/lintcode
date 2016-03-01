package src.CodeRound2;
import java.util.*;

/**
 * Created by stameying on 2/29/16.
 */
public class p218 {

    private static class Edge{
        public int x;
        public int height;
        public boolean isStart;

        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();

        List<Edge> edges = new ArrayList<>();

        for (int[] building: buildings){
            Edge startEdge = new Edge(building[0],building[2],true);
            edges.add(startEdge);
            Edge endEdge = new Edge(building[1],building[2],false);
            edges.add(endEdge);
        }

        Collections.sort(edges, new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2){
                if (e1.x != e2.x){
                    return Integer.compare(e1.x,e2.x); //起始点不一样
                }
                if (e1.isStart && e2.isStart){
                    return Integer.compare(e2.height,e1.height); // 两个起始点, 起始点一样,  高的优先
                }
                if (!e1.isStart && !e2.isStart){
                    return Integer.compare(e1.height,e2.height); // 两个结束点, 起始点一样,  矮的优先
                }

                //一个起始点,一个结束点
                return e1.isStart? -1 : 1;

            }
        });


        PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

        for (Edge edge: edges){
            if (edge.isStart){
                if (heightHeap.isEmpty() || edge.height > heightHeap.peek()){
                    res.add(new int[]{edge.x, edge.height});
                }
                heightHeap.add(edge.height);
            }else{
                heightHeap.remove(edge.height);
                if (heightHeap.isEmpty()){
                    res.add(new int[]{edge.x,0});
                }else if (edge.height > heightHeap.peek()){
                    res.add(new int[]{edge.x,heightHeap.peek()});
                }
            }
        }

        return res;
    }
}
