package src.first_round;

/**
 * Created by stameying on 12/14/15.
 */
public class numOfIslands {
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j]){
                    count++;
                    mergeIsland(grid, i,j);
                }
            }
        }
        return count;
    }

    public void mergeIsland(boolean[][] grid, int x, int y){
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length) return;
        if (grid[x][y]) grid[x][y] = false;
        else return;
        mergeIsland(grid, x-1, y);
        mergeIsland(grid, x+1, y);
        mergeIsland(grid, x, y-1);
        mergeIsland(grid, x, y+1);
    }

    public static void main(String[] args) {

    }
}
