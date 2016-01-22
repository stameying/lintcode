package leetcode.google;

import java.util.*;

/**
 * Created by stameying on 1/21/16.
 */
public class valid_tree {

    /**
     * A dfs method
     * */
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length+1) return false;
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        if (hasCycle(adjList,visited,0,-1)) return false;
        for (int i = 0; i < n; i++){
            if (!visited[i]) return false;
        }
        return true;
    }

    /**
     * A bfs method
     * */


    public boolean validTree2(int n, int[][] edges) {
        if (n != edges.length+1) return false;
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            if (visited[node]) return false;
            visited[node] = true;
            for (Integer neighbor: adjList.get(node)){
                if (!visited[neighbor]){
                    queue.offer(neighbor);
                }
            }
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]) return false;
        }
        return true;
    }

    public boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int cur, int prev){
        visited[cur] = true;
        for (int i = 0; i < adjList.get(cur).size(); i++){
            int v = adjList.get(cur).get(i);
            if ( (visited[v] && prev != v) || (!visited[v] && hasCycle(adjList,visited,v,cur))) return true; // there is cycle
        }
        return false;
    }
}
