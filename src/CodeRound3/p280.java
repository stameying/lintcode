package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/7/16.
 */
public class p280 {
    public static void wiggleSort(int[] nums) {
        int idx = 1;
        for (; idx < nums.length; idx++){
            if (idx%2 == 1 && nums[idx] < nums[idx-1]){
                int temp = nums[idx-1];
                nums[idx-1] = nums[idx];
                nums[idx] = temp;
            }else if (idx%2 == 0 && nums[idx] > nums[idx-1]){
                int temp = nums[idx-1];
                nums[idx-1] = nums[idx];
                nums[idx] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
