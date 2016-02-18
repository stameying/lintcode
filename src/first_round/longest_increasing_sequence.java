package src.first_round;

/**
 * Created by stameying on 12/24/15.
 */
public class longest_increasing_sequence {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        max = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] <= nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if (dp[i] > max) max = dp[i];
                }
            }
        }
        return max;
    }
}
