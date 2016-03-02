package src.CodeRound2;

/**
 * Created by stameying on 3/1/16.
 */
public class p255 {

    public static int findPos(int[] preorder, int start, int end, int target){
        // binary search
        while (start+1 < end){
            int mid = start + (end-start)/2;
            if (preorder[mid] <= target) start = mid;
            else end = mid;
        }
        if (preorder[start] > target) return start;
        if (preorder[end] > target) return end;
        return preorder[end];
    }

    public static void main(String[] args) {
        int[] nums = {6,4,2,1,3,5,9,8,7,10};
//        System.out.println(findPos(nums,0,nums.length-1,6));
        System.out.println(Math.ceil(5.0/2.0));
    }
}
