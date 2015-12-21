/**
 * Created by stameying on 12/20/15.
 */
public class distinct_subsequence {

    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (T.length() == 0) return 1;
        if (S.length() == 0) return 0;
        int m = S.length(), n = T.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = 1; // any string has a substring of ""
        }
        for (int j = 1; j <= n; j++){
            dp[0][j] = 0; // "" does not have any substring except itself
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (S.charAt(i-1) == T.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }


//    public int numDistinct(String S, String T) {
//        int M = S.length();
//        int N = T.length();
//        int[][] num = new int[M + 1][N + 1];
//        for (int i = 0; i <= N; i++)
//            num[0][i] = 0;
//        for (int i = 0; i <= M; i++)
//            num[i][0] = 1;
//        for (int i = 1; i <= M; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (S.charAt(i - 1) != T.charAt(j - 1)) {
//                    num[i][j] = num[i - 1][j];
//                } else {
//                    num[i][j] = num[i - 1][j] + num[i - 1][j - 1];
//                }
//                System.out.print(num[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return num[M][N];
//
//    }

    public static void main(String[] args) {
        distinct_subsequence test = new distinct_subsequence();
        test.numDistinct("rabbbit", "rabbit");
    }
}
