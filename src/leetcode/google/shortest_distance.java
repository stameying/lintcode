package leetcode.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by stameying on 1/25/16.
 */
public class shortest_distance {
    static final int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int shortest_distance(int[][] grid){
        int shortestDis = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    int[] land = new int[2];
                    land[0] = i;
                    land[1] = j;
                    int distance = 0;
                    Queue<int[]> localQueue = new LinkedList<>();
                    localQueue.offer(land);
                    int[][] visited = new int[grid.length][grid[0].length];
                    int depth = -1;
                    int size = localQueue.size();
                    while (!localQueue.isEmpty()){
                        depth++;
                        System.out.println("depth="+depth);
                        for (int q = 0; q < size; q++){
                            int[] cur = localQueue.poll();
                            if (cur[0] < 0 || cur[0] >= grid.length || cur[1] < 0 || cur[1] >= grid[0].length) continue;
                            if (grid[cur[0]][cur[1]] == 1 ){ // find a non-visited building
                                if (visited[cur[0]][cur[1]] == 0){
                                    distance += depth;
                                    visited[cur[0]][cur[1]] = 1;
//                                    System.out.println("; distance =" + distance);
                                }else continue;
                            }else if (grid[cur[0]][cur[1]] == 2){
                                visited[cur[0]][cur[1]] = 1;
                            } // meet an obstacle
                            else{//meed a free land
                                visited[cur[0]][cur[1]] = 1;
                                for (int[] dir: direction){
                                    int x = cur[0]+dir[0];
                                    int y = cur[1]+dir[1];
                                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length ||  visited[x][y] == 1) continue;
                                    int[] temp = new int[2];
                                    temp[0] = x;
                                    temp[1] = y;
                                    localQueue.offer(temp);
                                }
                            }
                        }
//                        System.out.println("size="+size);
                        size = localQueue.size();
                    }
//                    System.out.println(" res distance = " + distance);
                    if (distance < shortestDis) shortestDis = distance;
                }
            }
        }
        return shortestDis;
    }


    public static int shortestDistance(int[][] grid) {
        int rows = grid.length;
        if(rows == 0) return -1;
        int cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        int[][] nums = new int[rows][cols];
        int buildingNum = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                buildingNum++;
                bfs(grid,i,j,dist,nums);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum){
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        if (min < Integer.MAX_VALUE) return min;
        else return -1;
    }

    public static void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums){
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        boolean[][] visited = new boolean[rows][cols];
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] point = queue.poll();
                for (int[] dir: direction){
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0){
                        visited[x][y] = true;
                        dist[x][y] += level;
                        nums[x][y]++;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(shortestDistance(grid));
    }
}
