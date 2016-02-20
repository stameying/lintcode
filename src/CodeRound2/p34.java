package src.CodeRound2;

/**
 * Created by stameying on 2/19/16.
 */
public class p34 {

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.

     Your algorithm's runtime complexity must be in the order of O(log n).

     If the target is not found in the array, return [-1, -1].

     For example,
     Given [5, 7, 7, 8, 8, 10] and target value 8,
     return [3, 4].
     *
     * */


    /**
     * 很好的方法 在重复的元素里找到最小的target index或者最大的target index
     * */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length-1;
        while (left + 1< right){
            int mid = left + (right-left)/2;
            if (nums[mid] >= target) right = mid;
            else left = mid+1;
        }
        if (nums[left] == target) res[0] = left;
        else if (nums[right] == target) res[0] = right;
        else res[0] = -1;
        left = 0;
        right = nums.length-1;
        while (left +1 < right){
            int mid = left + (right-left)/2;
            if (nums[mid] <= target) left = mid;
            else right = mid-1;
        }
        if (nums[right] == target) res[1] = right;
        else if (nums[left] == target) res[1] = left;
        else res[1] = -1;
        return res;
    }
}
