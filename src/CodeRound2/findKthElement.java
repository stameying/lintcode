package src.CodeRound2;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by stameying on 2/18/16.
 */
public class findKthElement {

    /**
     * Find kth largest or smallest element in a unsorted array,
     * based on comparator
     * */


    private static class smallerComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2){
            return Integer.compare(i1,i2);
        }

        public static final smallerComparator SMALLERCOMPARATOR = new smallerComparator();
    }

    private static class largerComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2){
            return Integer.compare(i2,i1);
        }

        public static final largerComparator LARGERCOMPARATOR = new largerComparator();
    }


    public static int findKthElement(int[] nums, int k, Comparator<Integer> cmp){
        return quickSelect(nums,0,nums.length-1,k,cmp);
    }

    public static int quickSelect(int[] nums, int left, int right, int k, Comparator<Integer> cmp){
        Random random = new Random();
        while (left <= right){
            int pivotIdx = random.nextInt(right-left+1)+left;
            System.out.println("pivot Idx = " + pivotIdx);
            int newPivotIdx = partition(nums,left,right,pivotIdx,cmp);
            if (newPivotIdx == k-1) return nums[newPivotIdx];
            else if (newPivotIdx < k-1) left = newPivotIdx+1;
            else right = newPivotIdx-1;
        }
        return -1;
    }

    public static int partition(int[] nums, int left, int right, int pivotIdx, Comparator<Integer> cmp){
        int pivot = nums[pivotIdx];
        swap(nums,pivotIdx,right);
        int newPivotIdx = left;
        for (int i = left; i < right; i++){
            if (cmp.compare(nums[i],pivot) < 0){
                swap(nums,newPivotIdx++,i);
            }
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
        int[] nums = {9,3,2,4,8}; // 2 3 4 8 9
        System.out.println("3th smallest number is " + quickSelect(nums,0,nums.length-1,4, smallerComparator.SMALLERCOMPARATOR));
    }


}
