package src.first_round;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 12/15/15.
 */
public class valid_sudoku {
    /**
     * @param board: the board
     @return: wether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character> checker;

        // check rows
        for (int i = 0; i < board.length; i++){
            checker = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    // check if it already exists
                    if (checker.contains(board[i][j])) return false;
                    else{
                        checker.add(board[i][j]);
                    }
                }
            }
        }

        // check columns
        for (int j = 0; j < board[0].length; j++){
            checker = new HashSet<Character>();
            for (int i = 0; i < board.length; i++){
                if (board[i][j] != '.'){
                    // check if it already exists
                    if (checker.contains(board[i][j])) return false;
                    else{
                        checker.add(board[i][j]);
                    }
                }
            }
        }

        // check box
        for (int i = 0; i < board.length; i+=3){
            for (int j = 0; j < board[0].length; j+=3){
                checker = new HashSet<Character>();
                for (int tempX = 0; tempX < 3; tempX++){
                    for (int tempY = 0; tempY < 3; tempY++){
                        if (board[i+tempX][j+tempY] != '.'){
                            if (checker.contains(board[i+tempX][j+tempY])) return false;
                            else{
                                checker.add(board[i+tempX][j+tempY]);
                            }
                        }
                    }
                }
            }
        }

        // check box2
        for (int index = 0; index < 9; index++){
            checker = new HashSet<Character>();
            for (int i = index / 3 * 3; i < index / 3 * 3 + 3; i++){
                for (int j = index % 3 * 3; j < index % 3 * 3 + 3; j++){
                    if (board[i][j] != '.'){
                        if (checker.contains(board[i][j])) return false;
                        else checker.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
