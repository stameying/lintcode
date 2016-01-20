package leetcode.google;

import java.util.Arrays;

/**
 * Created by stameying on 1/19/16.
 */
public class super_ugly_number {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        int[] counter = new int[primes.length];
        int[] temp = new int[primes.length];
        for (int i = 1; i < n; i++){
            for (int j = 0; j < primes.length; j++){
                temp[j] = res[counter[j]]*primes[j];
            }
            System.out.println("current count = " + i);
            System.out.println(Arrays.toString(temp));
            System.out.println(Arrays.toString(counter));
            int min = findMin(temp);
            for (int j = 0; j < primes.length; j++){
                if (min == temp[j]){
                    counter[j]++;
                }
            }
            System.out.println(Arrays.toString(counter));
            res[i] = min;
        }
        return res[n-1];
    }

    public int findMin(int[] base){
        int min = base[0];
        for (int i = 1; i < base.length; i++){
            if (base[i] < min){
                min = base[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        super_ugly_number test = new super_ugly_number();
        int[] primes = {2, 7, 13, 19};
        System.out.println(test.nthSuperUglyNumber(12,primes));
    }
}
