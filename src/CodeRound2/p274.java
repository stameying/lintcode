package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 3/2/16.
 */
public class p274 {

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) count[n]++;
            else count[citations[i]]++;
        }
        System.out.println(Arrays.toString(count));
        for (int i = n; i > 0; i--) {
            if (count[i] >= i) return i;
            count[i-1] += count[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 6, 1, 5};
        hIndex(nums);
    }
}
