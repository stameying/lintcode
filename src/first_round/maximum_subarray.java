package src.first_round;

/**
 * Created by stameying on 12/12/15.
 */
public class maximum_subarray {
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums.length == 0) return nums[0];
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++){
            cur = Math.max(cur+nums[i],nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {-2,2,-3,4,-1,2,1,-5,3};
        maximum_subarray test = new maximum_subarray();
        System.out.println(test.maxSubArray(input));
    }
}
