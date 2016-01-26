package EPI.Bit;

/**
 * Created by stameying on 1/24/16.
 */
public class closestIntSameBitCount {
    static final int NUM_UNSIGN_BITS = 63;
    public static long closestIntSameBitCount(long x){
        for (int i = 0; i < NUM_UNSIGN_BITS; ++i){
            if (((x>>>i)&1) != ((x >>> (i+1))&1)){
                x ^= (1L << i) | (1L<<(i+1));
                return x;
            }
        }
        throw new IllegalArgumentException("All bits are 0 or 1");
    }

    public static void main(String[] args) {
        System.out.println(closestIntSameBitCount(7));
    }
}
