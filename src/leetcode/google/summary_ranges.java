package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/12/16.
 */
public class summary_ranges {
    public class Solution{
        public List<String> summaryRanges(int[] nums){
            List<String> res = new ArrayList<String>();
            if (nums.length == 0) return res;
            int left = -1, cur = 0;
            while (cur < nums.length){
                while (cur < nums.length-1 && nums[cur] == nums[cur+1]-1) cur++;
                if (left+1 == cur){
                    res.add(nums[cur]+"");
                }else{
                    StringBuilder builder = new StringBuilder();
                    builder.append(nums[left+1]);
                    builder.append("->");
                    builder.append(nums[cur]);
                    res.add(builder.toString());
                }
                left = cur;
                cur++;
            }
            return res;
        }
    }
}
