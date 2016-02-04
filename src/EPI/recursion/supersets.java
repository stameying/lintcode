package EPI.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/3/16.
 */
public class supersets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < (1<<nums.length); i++){
            int bitArray = i;
            List<Integer> subset = new ArrayList<>();
            while (bitArray != 0){
                int temp2 = bitArray&~(bitArray-1);
                System.out.println("=>"+temp2);
                int temp = (int)(Math.log(bitArray&~(bitArray-1))/Math.log(2));
                System.out.println(temp);
                subset.add(nums[temp]);
                bitArray &= bitArray-1;
            }
            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(1<<3);
        System.out.println(subsets(nums));
    }
}
