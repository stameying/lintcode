package src.amazon_oa.oa2.second_trial;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Created by stameying on 2/28/16.
 */
public class p16_maze {


    public static final int[][] direction = new int[][]{new int[]{-1,0}, new int[]{1,0}, new int[]{0,1}, new int[]{0,-1}};
    public static int maze(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        if (matrix[0][0] == 9) return 1; // already in the target position
        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(getHash(0,0,n));
        matrix[0][0] = 1;
        int count = 0;
        while (!queue.isEmpty()){
            System.out.println(count++);
            int pos = queue.poll();
            int curX = pos/n;
            int curY = pos%n;
            if (matrix[curX][curY] == 9) return 1;
            for (int[] dir: direction){
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if (validMove(matrix,nextX,nextY)){
                    queue.offer(getHash(nextX,nextY,n));
                    matrix[curX][curY] = 1;
                }
            }
        }
        return -1;
    }

    public static int getHash(int x, int y, int colNum){
        return x*colNum+y;
    }

    public static boolean validMove(int[][] matrix, int x, int y){
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] == 1) return false;
        return true;
    }


    private final static int[] dx = {-1, 0, 0, 1};
    private final static int[] dy = {0, 1, -1, 0};
    public static int Solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)	return 0;
        if (matrix[0][0] == 9)	return 1;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        matrix[0][0] = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            System.out.println(count++);
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dx[i], cur[1] + dy[i]};
                if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n) {
                    if (matrix[next[0]][next[1]] == 9)
                        return 1;
                    else if (matrix[next[0]][next[1]] == 0) {
                        queue.offer(next);
                        matrix[next[0]][next[1]] = 1;
                    }
                }
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 9},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 9}
        };
        System.out.println("maze="+ (maze(maze)==1?"true":"false"));

        int[][] maze2 = new int[][] {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 9},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 9}
        };
        System.out.println("Solution="+(Solution(maze2)==1?"true":"false"));
    }
}
