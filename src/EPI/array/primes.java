package EPI.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by stameying on 1/28/16.
 */
public class primes {

    // generate primes up to n
    public static List<Integer> generatePrimes(int n){
        List<Integer> res = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1,true));
        isPrime.set(0,false);
        isPrime.set(1,false);
        for (int p = 2; p <= n; p++){
            if (isPrime.get(p)){
                res.add(p);
                // sieve p's multiples
                for (int j = p; j <= n; j+=p){
                    isPrime.set(j,true);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generatePrimes(18));
    }
}
