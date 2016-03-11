package src.CodeRound3;

/**
 * Created by stameying on 3/9/16.
 */
public class p221 {

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;
        int minimumMax = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else{
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                        if (max == 0) max = 1;
                    }else{
                        if (dp[i-1][j] != 0 && dp[i][j-1] != 0 && dp[i-1][j] != dp[i][j-1]){
                            dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                        }else if (dp[i][j-1] == 0 || dp[i-1][j] == 0 ) dp[i][j] = 1;
                        else{
                            // 一样的
                            int len = dp[i][j-1];
                            if (matrix[i-len][j-len] == '1'){
                                dp[i][j] = 1 + len;
                            }else{
                                dp[i][j] = len;
                            }
                        }

                        max = Math.max(max,dp[i][j]);
                        if (dp[i][j] > minimumMax) minimumMax = dp[i][j];
                    }
                }
            }
        }
        display2Dtable.display(dp);
        return max*max;
    }


    public static void main(String[] args) {
//        char[][] matrix = {"11111".toCharArray(),"11101".toCharArray(),"11110".toCharArray(),"01111".toCharArray(),"01111".toCharArray(),"10111".toCharArray(),"11111".toCharArray()};
//        maximalSquare(matrix);


        System.out.println(new Integer(-2).toBinaryString(-2));
    }
}
