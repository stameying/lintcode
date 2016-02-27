package src.CodeRound2;

/**
 * Created by stameying on 2/26/16.
 */
public class p190 {

    public static int reverseBits(int n) {
        int mask = 0;
        int res = 0;
        for (int i = 0; i < 32; i++){
            mask = 1 << i;
            int digit = n & mask;
            if (digit != 0) digit = 1;
            System.out.println("digit="+digit);

            res = (digit << (31-i)) ^ res;
            System.out.println("res="+res);
        }
        return res;
    }

    public static void main(String[] args) {
        reverseBits(2);
//        System.out.println(1<<31);
    }
}
