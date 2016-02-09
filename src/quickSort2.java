import java.util.Arrays;
import java.util.Random;

/**
 * Created by stameying on 2/8/16.
 */
public class quickSort2 {
    public static Random r = new Random();
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    public static void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int pivotIndex = r.nextInt(right-left+1)+left;
        int newPivotIdx = partition(nums,left,right,pivotIndex);
        quickSort(nums,left,newPivotIdx-1);
        quickSort(nums,newPivotIdx+1,right);
    }

    public static int partition(int[] nums, int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];
        swap(nums,right,pivotIndex);
        int newPivotIdx = left;
        for (int i = left; i < right; i++){
            if (nums[i] < pivot){
                swap(nums,newPivotIdx++,i);
            }
        }
        swap(nums,right,newPivotIdx);
        return newPivotIdx;
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,3,9,1,4,2,3};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
