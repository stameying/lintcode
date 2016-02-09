package Google_Topic;

import java.util.Arrays;

/**
 * Created by stameying on 2/8/16.
 */
public class p43_ksubsets {

    public static int[] minimum_set(int[] nums, int k){
        if (k >= nums.length) return nums;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int startPos = 0;
        for (int i = 0; i+k <= nums.length; i++){
            int curDiff = nums[i+k-1]-nums[i];
            if (curDiff < minDiff){
                minDiff = curDiff;
                startPos = i;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = nums[startPos+i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,15,3,4,7,9};
        System.out.println(Arrays.toString(minimum_set(arr,3)));
    }
}
