import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/5/16.
 */
public class single_number_III {

    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);

        if (A.length == 0) return res;

        // t = x ^ y
        int t = 0;
        for (Integer i: A){
            t ^= i;
        }

        // generate mask
        int mask = t & ~(t-1);

        // divide numbers of A into 2 groups
        int number1 = 0, number2 = 0;
        for (int num: A){
            if ((num & mask) == 0) number1 ^= num;
            else number2 ^= num;
        }

        res.set(0,number1);
        res.set(1,number2);

        return res;
    }
}
