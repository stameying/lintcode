package leetcode.google;

/**
 * Created by stameying on 1/20/16.
 */
public class longestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] helpMap = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < helpMap.length; i++){
            for (int j = 0; j < helpMap[0].length; j++){
                helpMap[i][j] = -1;
            }
        }
        int maxLen = 0;
        for (int i = 0; i < helpMap.length; i++){
            for (int j = 0; j < helpMap[0].length; j++){
                if (helpMap[i][j] == -1){
                    // a candidate
                    int left = j>0?(matrix[i][j]>matrix[i][j-1]?dfs(matrix,helpMap,i,j-1,i,j)+1:0):0;
                    int right = j<matrix[0].length-1?(matrix[i][j]>matrix[i][j+1]?dfs(matrix,helpMap,i,j+1,i,j)+1:0):0;
                    int up = i>0?(matrix[i][j]>matrix[i-1][j]?dfs(matrix,helpMap,i-1,j,i,j)+1:0):0;
                    int down = i<matrix.length-1?(matrix[i][j]>matrix[i+1][j]?dfs(matrix,helpMap,i+1,j,i,j)+1:0):0;
                    int cur = Math.max(left,right);
                    cur = Math.max(cur,up);
                    cur = Math.max(cur,down);
                    helpMap[i][j] = cur;
                    if (cur > maxLen){
                        maxLen = cur;
                    }
                }
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int[][] help, int x, int y, int prevX, int prevY){
        if (x < 0 || y < 0 || x == matrix.length || y == matrix[0].length) return -1;
        if (help[x][y] == -1){
            int left = y-1>=0&&y-1!=prevY?(matrix[x][y]>matrix[x][y-1]?dfs(matrix,help,x,y-1,x,y)+1:0):0;
            int right = y+1<matrix[0].length&&y+1!=prevY?(matrix[x][y]>matrix[x][y+1]?dfs(matrix,help,x,y+1,x,y)+1:0):0;
            int up = x-1>=0&&x-1!=prevX?(matrix[x][y]>matrix[x-1][y]?dfs(matrix,help,x-1,y,x,y)+1:0):0;
            int down = x+1<matrix.length&&x+1!=prevX?(matrix[x][y]>matrix[x+1][y]?dfs(matrix,help,x+1,y,x,y)+1:0):0;
            int cur = Math.max(left,right);
            cur = Math.max(cur,up);
            cur = Math.max(cur,down);
            help[x][y] = cur;
            return cur;
        }else{
            return help[x][y]+1;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 9;
        matrix[0][1] = 9;
        matrix[0][2] = 4;
        matrix[1][0] = 6;
        matrix[1][1] = 6;
        matrix[1][2] = 8;
        matrix[2][0] = 2;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        longestIncreasingPath test = new longestIncreasingPath();
        int res = test.longestIncreasingPath(matrix);
        System.out.println(res);

    }

}
