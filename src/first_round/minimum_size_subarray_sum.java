package src.first_round;

/**
 * Created by stameying on 12/29/15.
 */
public class minimum_size_subarray_sum {

    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    /*
    * O(n^2) space complexity & P(k*n) time
    * */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        if (nums.length == 0) return -1;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i];
            if (dp[i][i] == s) return 1;
        }
        for (int len = 2; len <= nums.length; len++){
            for (int i = 0; i+len <= nums.length; i++){
                dp[i][i+len-1] = dp[i][i+len-2] + nums[i+len-1];
                if (dp[i][i+len-1] >= s) return len;
            }
        }
        printArr(dp);
        return -1;
    }


    /*
    * Save memory but time complexity can still be improved by sliding window
    * */
    public int minimumSize2(int[] nums, int s){
        if (nums.length == 0) return -1;
        int[] dp = new int[nums.length];
        for (int len = 1; len <= nums.length; len++){
            for (int i = nums.length-1; i+1-len >= 0; i--){
                if (len == 1) dp[i] = nums[i];
                else dp[i] = dp[i-1] + nums[i];
//                if (dp[i] >= s) return len;
            }
            printArr2(dp);
        }

        return -1;
    }

    /*
     * Sliding window O(n)
     * */
    public int minimumSize3(int[] nums, int s) {
        // write your code here
        if (nums.length == 0) return -1;
        int left = 0, right = 0;
        int sum = 0, min = nums.length+1;
        while (right < nums.length){
            sum += nums[right];
            while (sum >= s){
                min = Math.min(min,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (min == nums.length+1) return -1;
        else return min;
    }


    public void printArr(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]);
                if (j != dp.length-1) System.out.print(",");
            }
            System.out.println();
        }
    }

    public void printArr2(int[] dp){
        for (int i = 0; i < dp.length; i++){
            System.out.print(dp[i]);
            if (i != dp.length-1) System.out.print(",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        minimum_size_subarray_sum test = new minimum_size_subarray_sum();
        int[] nums = {2,3,1,2,4,3};
        test.minimumSize2(nums,7);
    }
}
