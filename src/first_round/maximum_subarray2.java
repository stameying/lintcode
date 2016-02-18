package src.first_round;

/**
 * Created by stameying on 12/28/15.
 */
public class maximum_subarray2 {

    public int maxTwoSubArrays(int[] nums) {
        // write your code

        displayArr(nums);

        int[] dp1 = new int[nums.length];
        getMaxSubarrayFromLeft(dp1,nums);
        displayArr(dp1);


        int[] dp2 = new int[nums.length];
        getMaxSubarrayFromRight(dp2,nums);
        displayArr(dp2);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++){
            if (dp1[i]+dp2[i+1] > max) max = dp1[i]+dp2[i+1];
        }
        System.out.println("\n"+max);
        return max;
    }

    public void getMaxSubarrayFromLeft(int[] dp, int[] nums){
        int localmax = nums[0], max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            localmax = Math.max(nums[i],localmax+nums[i]);
            max = Math.max(max,localmax);
            dp[i] = max;
        }
    }

    public void getMaxSubarrayFromRight(int[] dp, int[] nums){
        int localmax = nums[nums.length-1], max = nums[nums.length-1];
        dp[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i>=0; i--){
            localmax = Math.max(nums[i],localmax+nums[i]);
            max = Math.max(localmax,max);
            dp[i] = max;
        }
    }


    public static void displayArr(int[] dp){
        System.out.println();
        for (int i = 0; i < dp.length; i++){
            System.out.print(dp[i] + ",");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,2,-1,2};
        maximum_subarray2 test = new maximum_subarray2();
        test.maxTwoSubArrays(arr);
    }
}
