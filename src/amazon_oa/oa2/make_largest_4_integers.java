package src.amazon_oa.oa2;

import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class make_largest_4_integers {

    public static int[] make_largest(int A, int B, int C, int D){
        int[] nums = new int[]{A,B,C,D};
        Arrays.sort(nums);
        swap(nums,0,1);
        swap(nums,2,3);
        swap(nums,0,3);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
        make_largest(1,2,3,4);
    }
}
