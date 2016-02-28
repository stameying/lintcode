package src.amazon_oa.oa2.second_trial;
import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class p4_fourIntegers {

    public static int[] fourIntegers(int A, int B, int C, int D){
        int[] arr = new int[]{A,B,C,D};
        Arrays.sort(arr);
        // 1 2 3 4
        // 3 2 1 4
        // 3 4 1 2
        // 2 4 1 3
        swap(arr,0,2);
        swap(arr,1,3);
        swap(arr,0,3);
        return arr;
    }

    public static void swap(int[] nums, int left, int right){
        nums[left] ^= nums[right];
        nums[right] ^= nums[left];
        nums[left] ^= nums[right];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fourIntegers(1,2,3,4)));
    }
}
