package src.first_round;

import java.util.*;

/**
 * Created by stameying on 12/17/15.
 */
public class Clone_Graph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return null;
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<Integer> visitedNode = new HashSet<Integer>();
        queue.offer(node);
        boolean copyHead = false;
        int copyHeadlabel = 0;
        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            if (!copyHead){
                copyHeadlabel = cur.label;
                copyHead = true;
            }
            if (visitedNode.contains(cur.label)) continue;
            else{
                UndirectedGraphNode temp;
                if (map.containsKey(cur.label)){
                    temp = map.get(cur.label);
                }else{
                    temp = new UndirectedGraphNode(cur.label);
                    map.put(cur.label, temp);
                }
                for (UndirectedGraphNode neighbor: cur.neighbors){
                    if (map.containsKey(neighbor.label)){
                        temp.neighbors.add(map.get(neighbor.label));
                    }else{
                        UndirectedGraphNode tempNeighbor = new UndirectedGraphNode(neighbor.label);
                        map.put(neighbor.label,tempNeighbor);
                        temp.neighbors.add(tempNeighbor);
                    }
                    queue.offer(neighbor);
                }
                System.out.print("current node is " + temp.label + " and its neighbors are : " );
                System.out.print("[ ");
                for (UndirectedGraphNode neighbor: temp.neighbors){
                    System.out.print(neighbor.label + " ");
                }
                System.out.print("]\n");
                visitedNode.add(cur.label);
            }
        }
        return map.get(copyHeadlabel);
    }

    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(-1);
        node2.neighbors.add(node1);

        Clone_Graph test = new Clone_Graph();
        UndirectedGraphNode node = test.cloneGraph(node2);

    }
}
