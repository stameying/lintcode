package src.CodeRound2;

/**
 * Created by stameying on 2/29/16.
 */
public class p220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length-k; i++){
            for (int j = i+1; j < i+k; j++){
                if (Math.abs(nums[i]-nums[j]) <= t) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,7,10};
        System.out.println(containsNearbyAlmostDuplicate(nums,2,4));
    }
}
