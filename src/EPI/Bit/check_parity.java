package EPI.Bit;

/**
 * Created by stameying on 1/24/16.
 */
public class check_parity {

    public static short parity(long x){
        short res = 0;
        while (x != 0){
            res ^= (x&1);
            x >>>= 1;
        }
        return res;
    }

    public static short parity2(long x){
        short res = 0;
        while (x != 0){
            res ^= 1;
            x = (x&(x-1));
        }
        return res;
    }

//    public static short parity3(long x){
//        final int WORD_SIZE = 16;
//        final int BIT_MASK = 0xFFFF;
//
//    }





    public static void main(String[] args) {
        System.out.println(parity2(3));
    }

}
