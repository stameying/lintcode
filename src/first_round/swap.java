package src.first_round;

/**
 * Created by stameying on 2/8/16.
 */
public class swap {

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
