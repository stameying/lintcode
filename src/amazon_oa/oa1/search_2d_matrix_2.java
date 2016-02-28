package src.amazon_oa.oa1;

/**
 * Created by stameying on 2/25/16.
 */
public class search_2d_matrix_2 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        // search from top right corner
        int x = 0, y = matrix[0].length-1;
        int maxRow = matrix.length;
        while (x < maxRow && y >= 0){
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) y--; // moving left
            else x++; //moving down
        }
        return false;
    }
}
