package src.amazon_oa.oa2;

import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class window_sum {

    public static int[] window_sum(int[] nums, int k){
        if (nums == null || nums.length < k) return new int[0];
        int len = nums.length, pre = -1, sum = 0;
        int[] res = new int[len-k+1];
        for (int i = 0; i < k-1; i++){
            sum += nums[i];
        }
        for (int i = k-1; i < len; i++){
            sum += nums[i];
            res[++pre] = sum;
            sum -= nums[pre];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,73,11,-5};
        System.out.println(Arrays.toString(window_sum(nums,2)));
    }
}
