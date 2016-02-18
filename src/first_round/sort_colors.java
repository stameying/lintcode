package src.first_round;

import java.util.Arrays;

/**
 * Created by stameying on 1/5/16.
 */
public class sort_colors {

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0, right = nums.length-1;
        int cur = 0;
        while (cur <= right){
            if (nums[cur] == 1) cur++; // white, then move to the next one
            else if (nums[cur] == 0){
                // red
                if (cur > left){
                    swap(nums,cur,left);
                    left++;
                }else{
                    cur++;
                    left++;
                }
            }else{
                // blue, swap with right
                if (cur < right){
                    swap(nums,cur,right);
                    right--;
                }else{
                    return;
                }
            }
        }
        return;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,2,1,0,1,0,1,0,0,0,2};
        sort_colors test = new sort_colors();
        test.sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }
}
