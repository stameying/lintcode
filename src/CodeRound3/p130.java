package src.CodeRound3;

/**
 * Created by stameying on 3/21/16.
 */
public class p130 {

    public static final int[][] direction = new int[][]{new int[]{-1,0},new int[]{1,0},new int[]{0,-1},new int[]{0,1}};

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    dfs(board,i,j);
                }
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }


    }

    public static void dfs(char[][] board, int x, int y){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if (board[x][y] == 'X' || board[x][y] == '#') return;
        System.out.println("x="+x+",y="+y);
        board[x][y] = '#';
        for (int[] dir: direction){
            int nextX = dir[0] + x;
            int nextY = dir[1] + y;
            dfs(board,nextX,nextY);
        }
        return;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{"XXXX".toCharArray(),"XOOX".toCharArray(),"XXOX".toCharArray(),"XOXX".toCharArray()};
        solve(board);
    }
}
