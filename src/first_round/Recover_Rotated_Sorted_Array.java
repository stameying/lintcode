package src.first_round;

import java.util.ArrayList;

/**
 * Created by stameying on 12/14/15.
 */
public class Recover_Rotated_Sorted_Array {
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int break_point = 0;
        for (int i = 0; i < nums.size()-1; i++){
            if (nums.get(i) > nums.get(i+1)){
                break_point = i;
                break;
            }
        }
        // all increase array
        if (break_point == nums.size()-1) return;

        reverse_array(nums,0,break_point);
        reverse_array(nums,break_point+1,nums.size()-1);
        reverse_array(nums,0,nums.size()-1);
    }

    public void reverse_array(ArrayList<Integer> nums, int left, int right){
        while (left < right){
            int temp = nums.get(left);
            nums.set(left,nums.get(right));
            nums.set(right,temp);
            left++;
            right--;
        }
    }


}
