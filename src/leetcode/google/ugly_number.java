package leetcode.google;

import java.util.Arrays;

/**
 * Created by stameying on 1/19/16.
 */
public class ugly_number {

    public static long kthPrimeNumber(int k) {
        // write your code here
        long[] res = new long[k+1];
        int i1 = 0, i2 = 0, i3 = 0;
        res[0] = 1;
        for (int i = 1; i <= k; i++){
            long t1 = res[i1]*3;
            long t2 = res[i2]*5;
            long t3 = res[i3]*7;
            long min = Math.min(Math.min(t1,t2),t3);
            if (min == t1) i1++;
            if (min == t2) i2++;
            if (min == t3) i3++;
            res[i] = min;
        }
        System.out.println(Arrays.toString(res));
        return res[k];
    }

    public static void main(String[] args) {
        System.out.println(kthPrimeNumber(11));
    }
}
