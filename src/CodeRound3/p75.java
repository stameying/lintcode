package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/8/16.
 */
public class p75 {

    public static void sortColors(int[] nums) {
        int redIdx = -1, whiteIdx = -1, blueIdx = nums.length;
        for (int i = 0; i < nums.length && redIdx <= blueIdx; i++){
//            System.out.print(Arrays.toString(nums));
            int color = nums[i];
//            System.out.println(" cur color="+color);
            if (color == 0){
                swap(nums,i,++redIdx);
                whiteIdx++;
            }else if (color == 1){
//                System.out.println("swap = " + i + "," + (whiteIdx+1));
                continue;
            }else{
                swap(nums,i,--blueIdx);
                i--;
            }
        }
    }

    public static void swap(int[] nums, int left, int right){
//        nums[left] ^= nums[right];
//        nums[right] ^= nums[left];
//        nums[left] ^= nums[right];

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,0,1,2,1};
        sortColors(nums);

//        swap(nums,0,0);
        System.out.println(Arrays.toString(nums));
    }
}
