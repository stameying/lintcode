package src.CodeRound2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/21/16.
 */
public class p47 {

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public List<List<Integer>>  permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);//后面对付重复数字用。
        // ArrayList<Integer> list = new ArrayList<>();
        dfs(result, 0, nums);
        return result;
    }
    private void dfs(List<List<Integer>>  result, int position, int[] nums){
        if (position == nums.length) {
            List<Integer> sol = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                sol.add(nums[i]);
            }
            result.add(sol);
            return;
        }
        for (int i = position; i < nums.length; i++) {
            if (i != position && nums[i] == nums[position]) {
                continue;
            }
            if (i > position && nums[i] == nums[i-1]){
                continue;
            }
            swap(nums, position, i);
            //System.out.println("Swap to" + nums + " i = " + i + " position = " + position);
            dfs(result, position+1, nums);
            swap(nums, position, i);
        }
    }
}
