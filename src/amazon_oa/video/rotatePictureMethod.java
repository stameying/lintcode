package src.amazon_oa.video;

import java.util.Arrays;

/**
 * Created by stameying on 3/12/16.
 */
public class rotatePictureMethod {


    public static int[][] rotatePictureMethod2(int[][] matrix, int flag){
        // INSERT YOUR CODE here
        /**
         * handle empty case
         * */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        if (flag == -1){
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    res[n-1-j][i] = matrix[i][j];
                }
            }
            return res;
        }else{
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    res[j][m-1-i] = matrix[i][j];
                }
            }
            return res;
        }
        
    }



    public static int[][] rotatePictureMethod(int[][] matrix, int flag){
        // INSERT YOUR CODE here
        /**
         * handle empty case
         * */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int[][] helperMatrix = rotateHelper(matrix);
        flip(helperMatrix,flag);
        return helperMatrix;
    }


    /**
     * 写method的时候主要要有 static
     * */
    public static void flip(int[][] helperMatrix, int flag){
        int m = helperMatrix.length, n = helperMatrix[0].length;
        if (flag == 1){
            /* rotate right
            1 2 3 4    1 5     5 1
            5 6 7 8    2 6     6 2
                       3 7     7 3
                       4 8     8 4
             */

            /**
            * flip的时候要要注意只要flip一半
            * */
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n/2; j++){
                    swap(helperMatrix,i,j,i,n-1-j);
                }
            }
        }else{
            for (int i = 0; i < m/2; i++){
                for (int j = 0; j < n; j++){
                    swap(helperMatrix,i,j,i,n-1-j);
                }
            }
        }
    }

    /**
     * 这种swap的方法不适用于位置一样的
     * */
    public static void swap(int[][] matrix, int curX, int curY, int nextX, int nextY){
        matrix[curX][curY] ^= matrix[nextX][nextY];
        matrix[nextX][nextY] ^= matrix[curX][curY];
        matrix[curX][curY] ^= matrix[nextX][nextY];
    }

    public static int[][] rotateHelper(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        /**
         * 这里要注意 空间是反过来的
         *
         */
        int[][] helpMatrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                helpMatrix[i][j] = matrix[j][i];
            }
        }
        return helpMatrix;
    }


    public static void display(int[][] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static void display(char[][] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static void display(boolean[][] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }





    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1,2,3,4},new int[]{5,6,7,8}};
        int[][] res = rotatePictureMethod2(matrix,1);
        display(res);
    }
}
