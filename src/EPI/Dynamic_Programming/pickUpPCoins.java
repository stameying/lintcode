package EPI.Dynamic_Programming;

import java.util.List;

/**
 * Created by stameying on 2/4/16.
 */
public class pickUpPCoins {

    public static int pickUpCoins(int[] coins){
        return computeMax(coins, 0, coins.length-1, new int[coins.length][coins.length]);
    }

    public static int computeMax(int[] coins, int a, int b, int[][] dp){
        if (a > b) return 0;
        if (dp[a][b] == 0){
            int maxA = coins[a] + Math.min(computeMax(coins,a+2,b,dp), computeMax(coins,a+1,b-1,dp));
            int maxB = coins[b] + Math.min(computeMax(coins,a+1,b-1,dp), computeMax(coins,a,b-2,dp));
            dp[a][b] = Math.max(maxA,maxB);
        }
        return dp[a][b];
    }

    public static void main(String[] args) {
        int[] coins = {10,25,5,1,10,5};
    }
}
