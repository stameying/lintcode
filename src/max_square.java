/**
 * Created by stameying on 12/28/15.
 */
public class max_square {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < matrix[0].length; j++){
            if (matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    int maxRange = dp[i-1][j-1];
                    int tempRange = 0;
                    for (int k = 1; k <= maxRange; k++ ){
                        if (matrix[i-k][j] == '1' && matrix[i][j-k] == '1'){
                            tempRange++;
                        }else{
                            break;
                        }
                    }
                    dp[i][j] = 1+tempRange;
                    if (dp[i][j] > max){
                        max = dp[i][j];
                    }
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        max_square test = new max_square();
        char[][] matrix = {{'1','1'},{'1','1'}};
        test.maximalSquare(matrix);

    }
}
