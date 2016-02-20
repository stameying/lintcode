package src.CodeRound2;

/**
 * Created by stameying on 2/19/16.
 */
public class p29 {

    /**
     * Divide Two Integers
     * */

    /**
     * Divide two integers without using multiplication, division and mod operator.
        If it is overflow, return MAX_INT.
     * */

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean neg = (dividend<0)^(divisor<0);
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor);
        long res = 0;
        while (m>=n){
            int shift = 0;
            while (m > (n<<shift+1)) shift++;
            m -= n<<shift;
            res += (1<<shift);
        }
        res = (neg)? ~(res-1):res;
        res = Math.min(Integer.MAX_VALUE, res);
        res = Math.max(Integer.MIN_VALUE, res);
        return (int)res;
    }


    public static void main(String[] args) {
        int num = 2;
        System.out.println(2<<num+1);
    }
}
