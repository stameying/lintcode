package src.CodeRound3;

import java.util.Random;

/**
 * Created by stameying on 3/9/16.
 */
public class p215 {

    public static int findKthLargest(int[] nums, int k) {
        // 一种方法是直接排序，但是时间复杂度是nlogn

        // 建一个min heap of size k
        // O(nlogk 的时间, k的空间)

        // PriorityQueue<Integer> heap = new PriorityQueue<>();
        // for (int num: nums){
        //     if (heap.size() < k) heap.offer(num);
        //     else{
        //         if (num > heap.peek()){
        //             heap.poll();
        //             heap.offer(num);
        //         }
        //     }
        // }
        // return heap.poll();

        /*
        还有一种 是 k select
        */
        k--;
        return selectKthElement(nums,k,0,nums.length-1);
    }

    public static int selectKthElement(int[] nums, int k, int left, int right){
        if (left == right) return nums[left];
        Random r = new Random();
        System.out.println("left="+left+",right="+right);
        int pivotIdx = left+r.nextInt((right-left+1));
        int pIdx = partition(nums,left,right,pivotIdx);
        if (pIdx == k) return nums[pIdx];
        else if (pIdx > k) return selectKthElement(nums,k,left,pIdx-1);
        else return selectKthElement(nums,k,pIdx+1,right);
    }

    public static int partition(int[] nums, int left, int right, int pivotIdx){
        int pivot = nums[pivotIdx];
        swap(nums,right,pivotIdx);
        int newPivotIdx = left;
        for (int i = left; i < right; i++){
            if (nums[i] > pivot){
                swap(nums,i,newPivotIdx++);
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
        int[] nums = {2,1};
        System.out.println(findKthLargest(nums,2));
    }
}
