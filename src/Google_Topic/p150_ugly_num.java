package Google_Topic;

import java.util.Arrays;

/**
 * Created by stameying on 2/16/16.
 */
public class p150_ugly_num {

    public static int nthUglyNumber(int n) {
        if (n <= 0) return 1;
        int[] table = new int[n];
        table[0] = 1;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        for (int i = 1; i < n; i++){
            int candidate1 = table[idx1]*2;
            int candidate2 = table[idx2]*3;
            int candidate3 = table[idx3]*5;
            int max = Math.min(candidate1,Math.min(candidate2,candidate3));
            table[i] = max;
            if (max == candidate1){
                idx1++;
            }
            if (max == candidate2){
                idx2++;
            }
            if (max == candidate3){
                idx3++;
            }
        }
        return table[n-1];
    }

    public static void main(String[] args) {
//        System.out.println(nthUglyNumber(7));
        String[] words = {"dc","df","cf"};
//        Arrays.sort(words,String.CASE_INSENSITIVE_ORDER);
//        System.out.println(Arrays.toString(words));
    }
}
