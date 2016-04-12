package src.Google_Topic.Onsite;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by stameying on 4/3/16.
 */
public class quick_sort {
    public static Random r = new Random();
    public static void quicksort2(int[] nums){
        helper(nums,0,nums.length-1);
    }

    public static void helper(int[] nums, int left, int right){
        if (left >= right) return;
//        Random r = new Random();
        int pivotIdx = left + r.nextInt(right-left+1);
        int resIdx = partition(nums,left,right,pivotIdx);
        helper(nums,left,resIdx-1);
        helper(nums,resIdx+1,right);
    }

    public static int partition(int[] nums, int left, int right, int pivotIdx){
        int pivot = nums[pivotIdx];
        swap(nums,pivotIdx,right);
        int resIdx = left;
        for (int i = left; i < right; i++){
            if (nums[i] < pivot){
                swap(nums,resIdx++,i);
            }
        }
        swap(nums,resIdx,right);
        return resIdx;
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,6,1,3,0,-2,11};
        quicksort2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
