package src.first_round;

/**
 * Created by stameying on 12/15/15.
 */
public class Trailing_Zeros {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    // count the number of 5s, 25s ...
    public long trailingZeros(long n) {
        // write your code here
        long count = 0;
        for (int base = 5; base <= n; base *= 5){
            count += n/base;
        }
        return count;
    }

}
