package leetcode.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by stameying on 1/22/16.
 */
public class maxNumbers {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[nums1.length+nums2.length];
        int[] curMax = new int[k];
        for (int i = 0; i <= k; i++){
            if (i > nums1.length || k-i > nums2.length) continue;
            int[] number1 = generateNum(nums1,i);
            int[] number2 = generateNum(nums2,k-i);
            int[] num = new int[k];
            num = combine(number1,number2);
            if (greater(curMax,num,0,0) == -1) curMax = num;
        }
        return curMax;
    }

    /**
     * Generate the largest possible number sequence from int array with k digits
     * */
    public int[] generateNum(int[] nums, int k){
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < nums.length; i++){
                while (!stack.isEmpty() && nums[i] > stack.peek() && (stack.size()+nums.length-i > k)){
                    stack.pop();
                }
                if (stack.size() < k) stack.push(nums[i]);
            }
            int[] res =new int[k];
            while (!stack.isEmpty()) res[--k] = stack.pop();
        return res;
    }


    /**
     * Generate the maximum number by merging two arrays of integer
     * */
    public int[] combine(int[] number1, int[] number2){
        int pos1 = 0, pos2 = 0;
        int cur = 0;
        int[] res = new int[number1.length+number2.length];
        while (pos1 < number1.length || pos2 < number2.length){
            int compareRes = greater(number1,number2,pos1,pos2);
            if (compareRes == 1 || compareRes == 0){
                res[cur++] = number1[pos1++];
            }else if (compareRes == -1){
                res[cur++] = number2[pos2++];
            }
        }
        return res;
    }

    public int greater(int[] num1, int[] num2, int pos1, int pos2){
        while (pos1 < num1.length && pos2 < num2.length && num1[pos1] == num2[pos2]){
            pos1++;
            pos2++;
        }
        if (pos1 == num1.length && pos2 == num2.length) return 0;
        else if (pos1 == num1.length && pos2 != num2.length) return -1;
        else if (pos1 != num1.length && pos2 == num2.length) return 1;
        else{
            if (num1[pos1] > num2[pos2]) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) {
        maxNumbers test = new maxNumbers();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        System.out.println(Arrays.toString(test.maxNumber(nums1,nums2,5)));
    }
}
