package src.CodeRound2;

/**
 * Created by stameying on 3/4/16.
 */
public class p304 {

    public int[][] sumMatrix;
    public p304(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sumMatrix = new int[m+1][n+1];
        if (m == 0) return;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        System.out.println("x="+sumMatrix.length);
        int res1 = sumMatrix[row2+1][col2+1];
        int res2 = sumMatrix[row1][col1];
        int res3 = sumMatrix[row2+1][col1];
        int res4 = sumMatrix[row1][col2+1];
        return res1 + res2 - res3 - res4;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        p304 test = new p304(matrix);

        System.out.println(test.sumRegion(2,1,4,3));
    }
}
