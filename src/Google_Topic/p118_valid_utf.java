package Google_Topic;

/**
 * Created by stameying on 2/14/16.
 */
public class p118_valid_utf {

    public static boolean valid(byte[] bytes){
        int expectLen = 0;
        if (bytes.length == 0) return false;
        else if ((bytes[0] & 0b10000000) == 0b10000000) expectLen = 1;
        else if ((bytes[0] & 0b11100000) == 0b11100000) expectLen = 2;
        else if ((bytes[0] & 0b11110000) == 0b11110000) expectLen = 3;
        else if ((bytes[0] & 0b11111000) == 0b11111000) expectLen = 4;
        else if ((bytes[0] & 0b11111100) == 0b11111100) expectLen = 5;
        else if ((bytes[0] & 0b11111110) == 0b11111110) expectLen = 6;
        else return false;

        if (expectLen != bytes.length) return false;
        for (int i = 1; i < expectLen; i++){
            if ((bytes[i] & 0b11000000) != 0b11000000) return false;
        }
        return true;
    }
}
