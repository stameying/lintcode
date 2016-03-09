package src.CodeRound3;

/**
 * Created by stameying on 3/8/16.
 */
public class p48 {


    public static void rotate(int[][] matrix) {
        help(matrix);
        display2Dtable.display(matrix);
        flip(matrix);
        display2Dtable.display(matrix);
    }

    public static void help(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < i; j++){
                swap(matrix,i,j,j,i);
            }
        }
    }

    public static void swap(int[][] matrix, int i, int j, int k, int m){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][m];
        matrix[k][m] = temp;
    }

    public static void flip(int[][] matrix){
        //左右对换
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length/2; j++){
                swap(matrix,i,j,i,matrix[0].length-1-j);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
