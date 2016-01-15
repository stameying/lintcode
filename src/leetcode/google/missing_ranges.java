package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/14/16.
 */
public class missing_ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums.length == 0) return res;
        if (lower < nums[0]){
            int right = nums[0]-1;
            res.add(right==lower?String.valueOf(lower):String.valueOf(lower)+"->"+String.valueOf(right));
        }
        int left = nums[0];
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] == nums[i+1]-1) left++;
            else{
                res.add(left+1==nums[i+1]-1?String.valueOf(left+1):String.valueOf(left+1)+"->"+String.valueOf(nums[i+1]-1));
                left = nums[i+1];
            }
        }
        res.add(left+1==upper?String.valueOf(upper):String.valueOf(left+1)+"->"+String.valueOf(upper));
        return res;
    }

    public static void main(String[] args) {
        missing_ranges test = new missing_ranges();
        int[] nums = {0,1,3,50,75};
        List<String> res = test.findMissingRanges(nums,0,99);
        for (int i = 0; i < res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
    }
}
