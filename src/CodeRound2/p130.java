package src.CodeRound2;

/**
 * Created by stameying on 2/23/16.
 */
public class p130 {

    public static final int[][] direction = new int[][]{new int[]{-1,0},new int[]{1,0},new int[]{0,-1},new int[]{0,1}};

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        // start from four outside edges
        for (int i = 0; i < board.length; i++){
            // first col and last col
            if (board[i][0] == 'O'){
                dfs(board,i,0,-1,-1);
            }
            if (board[i][board[0].length-1] == 'O'){
                dfs(board,i,board[0].length-1,-1,-1);
            }
        }

        for (int j = 0; j < board[0].length; j++){
            // first row and last row
            if (board[0][j] == 'O'){
                dfs(board,0,j,-1,-1);
            }
            if (board[board.length-1][j] == 'O'){
                dfs(board,board.length-1,j,-1,-1);
            }
        }

        display2Dtable.display(board);

        // flip
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y, int prex, int prey){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') return;
        board[x][y] = '#';
        for (int[] dir: direction){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            System.out.println("next = " + nextX + "," + nextY + " cur = " + x + "," + y);
            if (nextX != prex  || nextY != prey){
                dfs(board,nextX,nextY,x,y);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{"OOOOXX".toCharArray(),"OOOOOO".toCharArray(),"OXOXOO".toCharArray(),"OXOOXO".toCharArray(),"OXOXOO".toCharArray(),"OXOOOO".toCharArray()};
        solve(board);
    }
}
