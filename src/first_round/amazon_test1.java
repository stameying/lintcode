package src.first_round;

/**
 * Created by stameying on 2/8/16.
 */
public class amazon_test1 {

    private static final int[][] direction = new int[][]{new int[]{-1,0},
            new int[]{-1,-1},
            new int[]{0,-1},
            new int[]{-1,1},
            new int[]{0,1},
            new int[]{1,1},
            new int[]{1,0},
            new int[]{1,-1}};
    public static boolean checkIfExist(char[][] board, String target){
        if (board.length == 0) return false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == target.charAt(0)){
                    int[][] pathMap = new int[board.length][board[0].length];
                    if (dfs(board,target,i,j,0,pathMap)) return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String target, int x, int y, int pos, int[][] pathMap){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || pathMap[x][y] == 1) return false;
        if (pos == target.length()) return true;
        if (board[x][y] == target.charAt(pos)){
            pathMap[x][y] = 1;
            for (int[] dir: direction){
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (dfs(board,target,nextX,nextY,pos+1,pathMap)) return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {"TTRO".toCharArray(),"LANZ".toCharArray(),"EEMA".toCharArray(),"XSZX".toCharArray()};
        System.out.println(checkIfExist(board,"SEATTLE"));
    }
}
