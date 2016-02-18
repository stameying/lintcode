package src.first_round;

/**
 * Created by stameying on 1/8/16.
 */
public class updateBits {

    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask = 0;
        if (j < 31){
            mask = ~((1 << (j+1))-(1<<i));
        }else{
            mask = (1 << i) - 1;
        }
        return (m << i) + (mask & n);
    }

    public static void main(String[] args) {
        int n = 1;
        int m = -1;
        updateBits test = new updateBits();
        test.updateBits(35,41,3,9);
    }

}
