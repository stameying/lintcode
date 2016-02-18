package src.first_round;

/**
 * Created by stameying on 2/3/16.
 */
public class differenceByOneBit {

    /**
     * Test if two numbers differ only by 1 bit
     * */
    public static boolean differsByOneBit(int x, int y){
        int difference = x ^ y;
        return difference != 0 && (difference & (difference-1)) == 0;
    }

    public static void main(String[] args) {
        // 1100 => 12, 1000 => 8 should return true
        System.out.println(differsByOneBit(12,8));

    }
}
