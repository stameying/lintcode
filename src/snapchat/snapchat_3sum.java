package snapchat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/11/16.
 */
public class snapchat_3sum {

    public snapchat_3sum(){

    }

    public List<List<Integer>> get3Sum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        dfs(0,nums,res);
        return res;
    }

    public void dfs(int pos, int[] nums, List<List<Integer>> res){
        for (int i = pos; i < nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(nums[i]);
                    sol.add(nums[left]);
                    sol.add(nums[right]);
                    res.add(sol);
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (right > left && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
            while (i < nums.length-2 && nums[i] == nums[i+1]) i++;
        }
    }

    public static void main(String[] args) {
        int[] num = {-1 ,0 ,1 ,2 ,-1 ,-4};

    }
}
