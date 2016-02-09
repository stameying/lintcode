package Google_Topic;

/**
 * Created by stameying on 2/7/16.
 */
public class p24_hashing {
    public static final int modulus = 26;
    public static int hashing(String str){
        int kMult = 997;
        int val = 0;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            val = (val*kMult+ch)%modulus;
        }
        return val;
    }
}
