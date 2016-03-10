package src.CodeRound3;

/**
 * Created by stameying on 3/9/16.
 */
public class p73 {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean firstRowZero = false, firstColZero = false;
        for (int j = 0; j < matrix.length; j++){
            if (matrix[0][j] == 0) firstRowZero = true; System.out.println(j); break;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{0,2,3,4},{5,6,7,8}};
        setZeroes(matrix);
    }
}
