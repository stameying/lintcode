package src.first_round;

/**
 * Created by stameying on 1/6/16.
 */
public class Submatrix_Sum {

    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public static int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] arr = new int[matrix.length][matrix[0].length];
        int[][] res = new int[2][2];

        // O(n^2)
        for (int i = 0; i < matrix.length; i++){
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++){
                sum += matrix[i][j];
                arr[i][j] = sum;
//                System.out.print(sum+" ");
                if (sum == 0){
                    res[0][0] = i;
                    res[0][1] = 0;
                    res[1][0] = i;
                    res[1][1] = j;
                    return res;
                }
            }
//            System.out.println();
        }

        // vertical search
        for (int j = 0; j < matrix[0].length; j++){
            for (int k = 0; k <= j; k++){
                for (int i = 0; i < matrix.length; i++){
                    int sum = (k==j)?arr[i][j]:arr[i][j]-arr[i][k];
                    for (int m = i; m < matrix.length; m++){
                        if (m!=i) sum += (k==j)?arr[m][j]:(arr[m][j]-arr[m][k]);
//                        System.out.println(i+","+k+";"+m+","+j+";sum="+sum);
                        if (sum == 0){
                            res[0][0] = i;
                            res[0][1] = k==j?k:k+1;
                            res[1][0] = m;
                            res[1][1] = j;
                            return res;
                        }
                    }
                }
            }
        }

        return res;

    }


    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 5;
        matrix[0][2] = 7;
        matrix[1][0] = 3;
        matrix[1][1] = 7;
        matrix[1][2] = -8;
        matrix[2][0] = 4;
        matrix[2][1] = -8;
        matrix[2][2] = 9;
        int[][] res = submatrixSum(matrix);
        System.out.print("("+res[0][0]+","+res[0][1]+")\n");
        System.out.print("("+res[1][0]+","+res[1][1]+")\n");
    }
}
