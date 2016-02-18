package src.first_round;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 1/7/16.
 */
public class Surrounded_Regions {

    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here

        // fill first and last line
        for (int j = 0; j < board[0].length; j++){
            if (board[0][j] == '0') fill(board,0,j);
            if (board[board.length-1][j] == '0') fill(board,board.length-1,j);
        }

        // fill first and last col
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == '0') fill(board,i,0);
            if (board[i][board[0].length-1] == '0') fill(board,i,board[0].length-1);
        }

        // recover board
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '0') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = '0';
            }
        }
    }

    public void fill(char[][] board, int x , int y){
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) return;
        int code = encode(x,y,board[0].length);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(code);
        int k = board[0].length;
        while (!queue.isEmpty()){
            int curCode = queue.poll();
            int row = decodeX(curCode, k);
            int col = decodeY(curCode, k);
            board[row][col] = '#';
            // check up, down, left and right
            if (row >= 1 && board[row-1][col] == '0'){
                queue.offer(encode(row-1,col,k));
            }
            if (row < board.length-1 && board[row+1][col] == '0'){
                queue.offer(encode(row+1,col,k));
            }
            if (col >= 1 && board[row][col-1] == '0'){
                queue.offer(encode(row,col-1,k));
            }
            if (col < k-1 && board[row][col+1] == '0'){
                queue.offer(encode(row,col+1,k));
            }
        }
    }

    public int encode(int x, int y, int k){
        return x*k+y;
    }

    public int decodeX(int code, int k){
        return code/k;
    }

    public int decodeY(int code, int k){
        return code%k;
    }
}
