package EPI.Bit;

/**
 * Created by stameying on 1/24/16.
 */
public class swapbit {

    public static long swapbit(long x, int i, int j){
        if (((x>>>i)&1) != ((x>>>j)&1)){
            // if two bits are different, then swap
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
}
