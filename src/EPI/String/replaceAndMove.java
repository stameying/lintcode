package EPI.String;

import java.util.Arrays;

/**
 * Created by stameying on 1/29/16.
 */
public class replaceAndMove {

    public static int replaceandmove(char[] nums, int size){
        // forward
        int writeIndex = 0, aCount = 0;
        for (int i = 0; i < size; i++){
            if (nums[i] != 'b'){
                nums[writeIndex++] = nums[i];
            }
            if (nums[i] == 'a'){
                aCount++;
            }
        }

        // replace 'a' by 'dd'
        int curIndex = writeIndex-1;
        writeIndex = writeIndex+aCount-1;
        int finalSize = writeIndex+1;
        while (curIndex > 0){
            if (nums[curIndex] == 'a'){
                nums[writeIndex--] = 'd';
                nums[writeIndex--] = 'd';
            }else{
                nums[writeIndex--] = nums[curIndex];
            }
            curIndex--;
        }
        return finalSize;
    }

    public static void main(String[] args) {
        char[] nums = new char[5];
        nums[0] = 'a';
        nums[1] = 'b';
        nums[2] = 'a';
        nums[3] = 'c';
        int res = replaceandmove(nums,4);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
