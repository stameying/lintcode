package src.first_round;

import java.util.Arrays;

/**
 * Created by stameying on 12/14/15.
 */
public class partition_Array_By_OddEven {
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums.length <= 1) return;
        int left = 0, right = nums.length-1;
        while (left < right){
            while (nums[left] % 2 == 1 && left < right) left++;
            while (nums[right] %2 == 0 && left < right) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return;
    }

    public static void main(String[] args) {
        partition_Array_By_OddEven test = new partition_Array_By_OddEven();
        int[] nums = {1,2,3,4,5,6,7,6,7,5,2};
        test.partitionArray(nums);
        System.out.print(Arrays.toString(nums));
    }
}
