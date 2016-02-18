package src.first_round;

import java.util.*;

/**
 * Created by stameying on 1/4/16.
 */
public class Route_Between_Two_Nodes_in_Graph {
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    /*
    * BFS
    * */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Set<Integer> visitedNode = new HashSet<Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        while ( !queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            if (cur.label == t.label) return true;
            if (!visitedNode.contains(cur.label)){
                for (DirectedGraphNode neighbor: cur.neighbors){
                    if (!visitedNode.contains(neighbor.label)){
                        queue.offer(neighbor);
                    }
                }
                visitedNode.add(cur.label);
            }
        }
        return false;
    }

    /*
    * DFS
    * */
    public boolean hasRoute2(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Set<Integer> visitedNode = new HashSet<Integer>();
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        stack.push(s);
        while (!stack.isEmpty()){
            DirectedGraphNode cur = stack.pop();
            if (cur.label == t.label) return true;
            if (!visitedNode.contains(cur)){
                for (DirectedGraphNode neighbor: cur.neighbors){
                    if (!visitedNode.contains(neighbor)){
                        stack.push(neighbor);
                    }
                }
                visitedNode.add(cur.label);
            }
        }
        return false;
    }

}

