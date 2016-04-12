package src.Google_Topic.Onsite;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by stameying on 4/3/16.
 */
public class random_generator_equal_fren {


    public static int getValue(int[] nums, int num){
        int left = 0, right = nums.length-1;
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            if (nums[mid] == num) return mid;
            else if (num < nums[mid]) right = mid;
            else left = mid;
        }
        if (nums[left] >= num) return left;
        else return right;
    }


    public static void main(String[] args) {
        int[] nums = {10,20,30};
        int[] freq = {2,5,6};

        Random random = new Random();
        for (int i = 0; i < 5; i++){
            int num = random.nextInt(6)+1;

            System.out.println("random index = " + num);
            System.out.println("对应的值是 => " + getValue(freq,num) + " = " + nums[getValue(freq,num)]);


//            int idx = Arrays.binarySearch(freq,num);
//            if (idx >= 0){
//                System.out.println("random index = " + num);
//                System.out.println("对应的值是 => " + idx + " = " + nums[idx]);
//            }else{
//                idx = -(idx+1);
//                System.out.println("random index = " + num);
//                System.out.println("对应的值是 => " + idx + " = " + nums[idx]);
//            }

        }



    }
}
