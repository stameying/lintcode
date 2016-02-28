package src.amazon_oa.oa2;

import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class day {

    public static int[] changeday(int[] days, int n){
        if (days == null || days.length == 0) return days;
        int len = days.length;
        int[] daysHelper = new int[len+2];
        daysHelper[0] = 0;
        daysHelper[len+1] = 0;
        // copy Arr
        for (int i = 1; i <= len; i++) daysHelper[i] = days[i-1];

        int pre = 0;
        //
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= len; j++){
                int temp = daysHelper[j];
                daysHelper[j] = pre ^ daysHelper[j+1];
                pre = temp;
            }
        }

        int[] res = new int[len];
        for (int i = 1; i <= len; i++) res[i-1] = daysHelper[i];
        return res;
    }

    public static int[] Solution(int[] days, int n) {
        if (days == null || n <= 0)	return days;
        int length = days.length;
        int[] rvalue = new int[length + 2];
        rvalue[0] = rvalue[length+1] = 0;
        int pre = rvalue[0];
        for (int i = 1; i <= length; i++)
            rvalue[i] = days[i-1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= length; j++) {
                int temp = rvalue[j];
                rvalue[j] = pre ^ rvalue[j+1];
                pre = temp;
            }
        }
        return Arrays.copyOfRange(rvalue, 1, length+1);
    }

    public static void main(String[] args) {
        int[] days = new int[] {1, 0, 0, 0, 0, 1, 0, 0};

        System.out.println(Arrays.toString(Solution(days,2)));
        System.out.println(Arrays.toString(changeday(days,2)));

        //int[] rvalue = solution8.Solution(new int[] {1}, 1);
    }
}
