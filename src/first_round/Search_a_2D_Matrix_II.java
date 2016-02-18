package src.first_round;

/**
 * Created by stameying on 1/4/16.
 */
public class Search_a_2D_Matrix_II {

    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    /**
     * 自右上向左下
     * 如果当前 >= target, 往左 ;
     * 如果当前 < target, 往右
     * */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix.length == 0) return 0;
        int res = 0;
        int x = 0, y = matrix[0].length-1;
        while ( x < matrix.length && y >= 0){
            if (matrix[x][y] >= target){
                if (matrix[x][y] == target) res++;
                y--;
            }else{
                x++;
            }
        }
        return res;
    }

}
