package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/20/16.
 */
public class binarySearch_find_smallest_index_of_target_in_sorted_array_with_duplicate {

    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        // search left bound
        int left = 0, right = nums.length-1;
        while (left+1<right){
            int mid = left+(right-left)/2;
            if (nums[mid] >= target) right = mid;
            else left = mid+1;
        }
        if (nums[left] == target) res[0] = left;
        else if (nums[right] == target) res[0] = right;
        else res[0] = -1;
        System.out.println("left="+left+"right="+right);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(searchRange(nums,1)));
    }
}
