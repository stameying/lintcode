package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/23/16.
 */
public class display2Dtable {

    public static void display(int[][] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static void display(char[][] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    public static void display(boolean[][] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
