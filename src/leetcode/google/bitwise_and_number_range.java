package leetcode.google;

/**
 * Created by stameying on 1/27/16.
 */
public class bitwise_and_number_range {

    /**
     * m <= n
     * */
    public static int bit1(int m, int n){
        while (m < n) n &= n-1;
        return m&n;
    }

    public static int bit2(int m, int n){
        int base = 1;
        while (m != n){
            m >>= 1;
            n >>= 1;
            base <<= 1;
        }
        return base*m;
    }

    public static void main(String[] args) {
        System.out.println(bit1(5,7));
        System.out.println(bit2(5,7));
    }
}
