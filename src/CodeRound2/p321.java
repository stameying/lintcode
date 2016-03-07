package src.CodeRound2;
import java.util.Arrays;
import java.util.Stack;
/**
 * Created by stameying on 3/6/16.
 */
public class p321 {

    public static int[] maxArray(int[] nums, int len){
        int[] res = new int[len];
        int curLen = len;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() < num && stack.size()+nums.length-i > len){
                stack.pop();
            }
            stack.push(num);
        }
        while (!stack.isEmpty()){
            res[--curLen] = stack.pop();
        }

        return res;
    }


    public static int[] merge(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length+nums2.length];
        int i = 0, j = 0;
        int curIndx = 0;
        while ( i < nums1.length && j < nums2.length){
            if (greater(nums1,i,nums2,j)){
                res[curIndx++] = nums1[i++];
            }else{
                res[curIndx++] = nums2[j++];
            }
        }
        while (i < nums1.length){
            res[curIndx++] = nums1[i++];
        }
        while (j < nums2.length){
            res[curIndx++] = nums2[j++];
        }
        return res;
    }

     public static boolean greater(int[] candidate, int pos1, int[] res, int pos2){
         int i = pos1, j = pos2;
         while (i < candidate.length && j < res.length){
             int digit1 = candidate[i];
             int digit2 = res[j];
             // System.out.println("digit1="+digit1+"digit2="+digit2);
             if (digit1 == digit2){
                 i++;
                 j++;
                 continue;
             }else if (digit1 > digit2) return true;
             else return false;
         }
         if (i == candidate.length && j == res.length) return true;
         else if (i == candidate.length && j < res.length) return candidate[i-1] > res[j];
         else if (i < candidate.length && j == res.length) return candidate[i] > res[j-1];
         else return true;
     }

    public static boolean greater2(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,4,4};
        int[] nums2 = {4,4};
        System.out.println(greater(nums1,0,nums2,0));
//        System.out.println(Arrays.toString(merge(nums1,nums2)));
    }
}
