package EPI.Dynamic_Programming;

/**
 * Created by stameying on 2/4/16.
 */
public class climb_stair {

    public static int climb(int n, int k){
        return compute(n, k, new int[n+1]);
    }

    public static int compute(int n, int k, int[] dp){
        if ( n <= 1) return 1;
        if (dp[n] == 0){
            for (int i = 1; i <= k && n-i >= 0; i++){
                dp[n] += compute(n-i,k,dp);
            }
        }
        return dp[n];
    }
}
