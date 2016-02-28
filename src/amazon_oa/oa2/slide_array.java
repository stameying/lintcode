package src.amazon_oa.oa2;

import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class slide_array {

    public static int slice_array(int[] nums){
        if (nums == null || nums.length <= 2) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 2;
        int res = 0;
        for (int i = 2; i < len; i++){
            int curDiff = nums[i]-nums[i-1];
            int prevDiff = nums[i-1]-nums[i-2];
            if (curDiff != prevDiff){
                res += (dp[i-1]>=3?getCount(dp[i-1]-2):0);
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1]+1;
            }
        }
        res += (dp[len-1]>=3?getCount(dp[len-1]-2):0);
//        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static int getCount(int n){
        return n*(n+1)/2;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,3,3,3,2,1,0};
        System.out.println(slice_array(nums));
    }
}
