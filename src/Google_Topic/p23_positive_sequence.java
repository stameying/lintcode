package Google_Topic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 2/7/16.
 */
public class p23_positive_sequence {

    public static boolean checkIfExistsSequence(int[] nums, int target){
        if (nums.length == 0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            sum+=num;
            int remain = sum-target;
            if (map.containsKey(remain)){
                // we find a solution
                int left = map.get(remain)+1;
                int right = i;
                System.out.println("[" + left + "," + right + "] sum = " + target);
                for (int temp = left; temp <= right; temp++){
                    System.out.print(nums[temp]+" ");
                }
                return true;
            }else{
                map.put(sum,i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-5,-4,-3,-2,-1};
        System.out.println(checkIfExistsSequence(nums,-9));
    }
}
