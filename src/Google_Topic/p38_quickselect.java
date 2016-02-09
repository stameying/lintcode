package Google_Topic;

import java.util.Random;

/**
 * Created by stameying on 2/8/16.
 */
public class p38_quickselect {

    public static int findKthLargest(int[] nums, int k){
        return findKth(nums,k);
    }

    public static int findKth(int[] nums, int k ){
        int left = 0, right = nums.length-1;
        Random r = new Random(0);
        while (left <= right){
            int pivotIdx = r.nextInt(right-left+1)+left;
            int newPivotIdx = partition(nums,left,right,pivotIdx);
            if (newPivotIdx == k-1){
                return nums[newPivotIdx];
            }else if (newPivotIdx > k-1){
                right = newPivotIdx-1;
            }else{
                left = newPivotIdx+1;
            }
        }
        return -1;
    }

    public static int partition(int[] nums, int left, int right, int pivotIdx){
        int pivot = nums[pivotIdx];
        int newPivotIdx = left;
        swap(nums,right,pivotIdx);
        for (int i = left; i < right; i++){
            if (nums[i] < pivot){
                swap(nums,i,newPivotIdx++);
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
}
