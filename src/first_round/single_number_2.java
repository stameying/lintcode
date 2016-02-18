package src.first_round;

import java.util.Arrays;

/**
 * Created by stameying on 1/4/16.
 */
public class single_number_2 {
    /**
     * @param A : An integer array
     * @return : An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        int[] res = new int[32];
        for (int i = 0; i < A.length; i++){
            int num = A[i];
            for (int j = 0; j < 32; j++){
                int digit = num >> (31-j) & 1;
                res[j] = (res[j] + digit)%3;
            }
        }
        System.out.println(Arrays.toString(res));
        int number = 0;
        for (int i = 0; i < 32; i++){
            number <<= 1;
            number += res[i];
        }
        System.out.println(number);
        return number;
    }

    public static void main(String[] args) {
        single_number_2 test = new single_number_2();
        int[] arr = {1,1,2,2,3,3,3,2,4,1};
        test.singleNumberII(arr);
    }
}
