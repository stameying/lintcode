/**
 * Created by stameying on 12/20/15.
 */
public class divide_two_integers {

    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor==1 && dividend == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return divide((long)dividend, (long)divisor);
    }

    public int divide(long dividend, long divisor){
        if (dividend < 0 && divisor < 0){
            return divide(-1*dividend,-1*divisor);
        }else if (dividend < 0 && divisor > 0){
            return -1*divide(-1*dividend,divisor);
        }else if (dividend > 0 && divisor < 0){
            return -1*divide(dividend, -1*divisor);
        }
        long count = 0;
        int numShift = 0;
        while ((divisor<<numShift) <= dividend) numShift++;
        while (dividend >= divisor){
            if (dividend >= divisor<<(numShift-1)){
                count += 1<<(numShift-1);
                dividend -= divisor<<(numShift-1);
            }
            numShift--;
        }
        if (count >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (count <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)count;
    }

    public static void main(String[] args) {
        divide_two_integers test = new divide_two_integers();
        System.out.println(test.divide(78,4));
    }
}
