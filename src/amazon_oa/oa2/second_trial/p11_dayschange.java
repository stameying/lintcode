package src.amazon_oa.oa2.second_trial;

import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class p11_dayschange {


    public static int[] dayschange(int[] days, int n){
        if (days == null || days.length == 0 || n < 0) return new int[0];
        int len = days.length;
        int[] helperArray = new int[len+2];
        helperArray[0] = 0;
        helperArray[len+1] = 0;
        for (int i = 1; i <= len; i++){
            helperArray[i] = days[i-1];
        }
        int pre = 0;
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= len; j++){
                int temp = helperArray[j];
                helperArray[j] = pre ^ helperArray[j+1];
                pre = temp;
            }
        }


        // important copy array back
        int[] res = new int[len];
        for (int i = 1; i <= len; i++){
            res[i-1] = helperArray[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] days = new int[] {1, 0, 0, 0, 0, 1, 0, 0};

        System.out.println(Arrays.toString(dayschange(days,2)));
    }
}
