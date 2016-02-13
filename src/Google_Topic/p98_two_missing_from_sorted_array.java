package Google_Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/11/16.
 */
public class p98_two_missing_from_sorted_array {

    public static List<Integer> findMissing(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        helper(nums,0,nums.length-1,k,res);
        return res;
    }

    public static void helper(int[] nums, int start, int end, int k, List<Integer> res){
        if (start > end) return;
        int leftMid = start + (end-start)/2;
        int target = nums[leftMid];
        while (leftMid > start && nums[leftMid-1] == nums[leftMid]) leftMid--;
        int leftCount = leftMid-start;
        if (leftCount == 0){
            int rightMid = leftMid;
            while (rightMid < end && nums[rightMid + 1] == target) rightMid++;
            if (rightMid - leftMid + 1 == k-1){
                res.add(nums[leftMid]);
                helper(nums,rightMid+1,end,k,res);
            }
        }else if (leftCount % k == 0){
            helper(nums,leftMid, end, k ,res);
        }else if (leftCount % k == k-1){
            if (end-start+1 == k-1){
                res.add(nums[start]);
                return;
            }
            helper(nums,start, leftMid-1,k,res);
            helper(nums,leftMid, end,k,res);
        }else if (leftCount % k == k-2){
            if (end-start+1 == 2 * (k-1)){
                res.add(nums[start]);
                res.add(nums[leftMid-1]);
            }
            helper(nums,start,leftMid-1,k,res);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4,  5, 5, 6, 6, 7, 8, 8};
        int k = 2;
        List<Integer> result = findMissing(nums, k);
        System.out.println(result);
    }
}
