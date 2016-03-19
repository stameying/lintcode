package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/16/16.
 */
public class p324 {

    public static void main(String[] args) {
        int[] nums = {2,6,4,1,3};
        int[] copy = nums.clone();
        Arrays.sort(copy);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(copy));
    }
}
