package EPI.challenge;

/**
 * Created by stameying on 2/8/16.
 */
public class greatest_common_divisor {

    public static long GCD(long x, long y){
        if (x == y) return x;
        else if ((x&1)==0 && (y&1)==0) return (GCD(x>>1,y>>1))<<1;
        else if ((x&1)==0 && (y&1)!=0) return GCD(x>>1,y);
        else if ((x&1)!=0 && (y&1)==0) return GCD(x,y>>1);
        else if (x > y) return GCD(x-y,y);
        else return GCD(x,y-x);
    }

    public static void main(String[] args) {
        System.out.println("GCD = " + GCD(24,300));
    }
}
