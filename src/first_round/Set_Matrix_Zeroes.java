package src.first_round;

/**
 * Created by stameying on 1/4/16.
 */
public class Set_Matrix_Zeroes {

    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    /**
     * 4 step solution
     * */
    public void setZeroes(int[][] matrix) {
        // write your code hereterminalter
        if (matrix.length == 0) return;
        /*
        * Step 1: mark first row and column with two boolean variables
        * */
        boolean firstRowContainZero = false, firstColContainZero = false;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstColContainZero = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++){
            if (matrix[0][j] == 0){
                firstRowContainZero = true;
                break;
            }
        }

        /*
        * Step 2: mark rest of the matrix using first row and first column
        * */
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    // represent this column needs to be set to zero
                    matrix[0][j] = 0;
                    // represent this row needs to be set to zero
                    matrix[i][0] = 0;
                }
            }
        }

        /*
        * Step 3: use the marks in first row and col to set the corresponding row or col to zero
        * */
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length ; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        /*
        * Step 4: use the two boolean variables to set first row and col to zero
        * */
        if (firstColContainZero){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if (firstRowContainZero){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
