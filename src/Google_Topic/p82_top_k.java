package Google_Topic;

import java.util.List;
import java.util.Random;

/**
 * Created by stameying on 2/10/16.
 */
public class p82_top_k {

//    public static List<String> topN(int k){
//
//    }


    public static int quickSelet(int[] nums, int k){
        return quickSelectHelper(nums,0,nums.length-1,k);
    }

    public static int quickSelectHelper(int[] nums, int left, int right, int k){
        if (left >= right) return nums[right];
        Random r = new Random();
        int pivotIndex = r.nextInt(right-left+1)+left;
        int newPivotIndex = partition(nums,left,right,pivotIndex);
        if (newPivotIndex == k-1) return nums[newPivotIndex];
        else if (newPivotIndex < k-1) return quickSelectHelper(nums,newPivotIndex+1,right,k);
        else return quickSelectHelper(nums,left,newPivotIndex-1,k);
    }

    public static int partition(int[] nums, int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];
        swap(nums,right,pivotIndex);
        int newPivotIdx = left;
        for (int i = left; i < right; i++){
            if (nums[i] > pivot) swap(nums,newPivotIdx++,i);
        }
        swap(nums,newPivotIdx,right);
        return newPivotIdx;
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(quickSelet(nums,3));
    }
}
