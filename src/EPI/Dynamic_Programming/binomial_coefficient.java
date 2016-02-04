package EPI.Dynamic_Programming;

/**
 * Created by stameying on 2/4/16.
 */
public class binomial_coefficient {

    public static int computeBinomialCoefficient(int n, int k){
        int[][] dp = new int[n+1][k+1];
        int res = compute(n,k,dp);
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    public static int compute(int n, int k, int[][] dp){
        if (k == 0 || n == k) return 1;
        if (dp[n][k] == 0){
            int withoutK = compute(n-1,k,dp);
            int withK = compute(n-1,k-1,dp);
            dp[n][k] = withK+withoutK;
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        computeBinomialCoefficient(7,3);
    }
}
