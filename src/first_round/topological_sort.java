package src.first_round;

import java.util.*;

/**
 * Created by stameying on 1/7/16.
 */
public class topological_sort {

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<Integer,Integer> nodeMap = new HashMap<Integer,Integer>();
        for (DirectedGraphNode node: graph){
            if (!nodeMap.containsKey(node.label)){
                nodeMap.put(node.label,0);
            }
            for (DirectedGraphNode neighbor: node.neighbors){
                if (nodeMap.containsKey(neighbor.label)){
                    nodeMap.put(neighbor.label,nodeMap.get(neighbor.label)+1);
                }else{
                    nodeMap.put(neighbor.label,1);
                }
            }
        }

        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
//        // bfs
//        while ( graph.size() > 0){
//            ArrayList<DirectedGraphNode> deleteList = new ArrayList<DirectedGraphNode>();
//            for (int i = 0; i < graph.size(); i++){
//                if (nodeMap.get(graph.get(i).label) == 0){
//                    DirectedGraphNode cur = graph.get(i);
//                    res.add(cur);
//                    deleteList.add(cur);
//                    for (int j = 0; j < cur.neighbors.size(); j++){
//                        nodeMap.put(cur.neighbors.get(j).label,nodeMap.get(cur.neighbors.get(j).label)-1);
//                    }
//                }
//            }
//            for (int i = 0; i < deleteList.size(); i++){
//                graph.remove(deleteList.get(i));
//            }
//        }


        // bfs
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node: graph){
            if (nodeMap.get(node.label) == 0) queue.offer(node);
        }
        while (!queue.isEmpty()){
            DirectedGraphNode cur = queue.poll();
            res.add(cur);
            for (DirectedGraphNode neighbor: cur.neighbors){
                nodeMap.put(neighbor.label, nodeMap.get(neighbor.label)-1);
                if (nodeMap.get(neighbor.label) == 0) queue.offer(neighbor);
            }
        }

        return res;

    }


    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {
        // dfs
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        Set<Integer> visited = new HashSet<Integer>();
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        for (int i = 0; i < graph.size(); i++){
            if (!visited.contains(graph.get(i).label)){
                topSortUtil(graph.get(i),visited,stack);
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public void topSortUtil(DirectedGraphNode node, Set<Integer> visited, Stack<DirectedGraphNode> stack){
        visited.add(node.label);
        for (DirectedGraphNode neighbor: node.neighbors){
            if (!visited.contains(neighbor.label)){
                topSortUtil(neighbor,visited,stack);
            }
        }
        stack.push(node);
    }
}
