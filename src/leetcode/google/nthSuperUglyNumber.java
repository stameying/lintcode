package leetcode.google;

import java.util.Arrays;

/**
 * Created by stameying on 1/19/16.
 */
public class nthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        int[] base = new int[primes.length];
        for (int i = 0; i < primes.length; i++){
            base[i] = primes[i];
        }
        int count = 1;
        int res = 0;
        while (count < n){
            count++;
            System.out.println("current count = " + count);
            System.out.println(Arrays.toString(base));
            int pos = findMin(base);
            res = base[pos];
            System.out.println("this round min = " + res);
            base[pos] += primes[pos];
        }
        return res;
    }

    public int findMin(int[] base){
        int min = base[0];
        int pos = 0;
        for (int i = 1; i < base.length; i++){
            if (base[i] < min){
                min = base[i];
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        nthSuperUglyNumber test = new nthSuperUglyNumber();
        int[] primes = {2,7,13,19};
        test.nthSuperUglyNumber(12,primes);
    }
}
