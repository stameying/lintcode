import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 12/14/15.
 */
public class minimum_subarray {
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums.size() == 0) return 0;
        if (nums.size() == 1) return nums.get(0);
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        int min = dp[0];
        for (int i = 1; i < nums.size() ; i++){
            // keep track of local minimum
            dp[i] = Math.min(dp[i-1]+nums.get(i),nums.get(i));
            // keep track of global minimum
            min = Math.min(min,dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        minimum_subarray test = new minimum_subarray();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(-1);
        nums.add(-2);
        nums.add(1);
        System.out.println(test.minSubArray(nums));
    }
}
