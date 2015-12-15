import java.util.ArrayList;

/**
 * Created by stameying on 12/14/15.
 */
public class product_array_exclude_self {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        left[0] = 1;
        right[A.size()-1] = 1;
        for (int i = 1; i < A.size(); i++){
            left[i] = left[i-1] * A.get(i-1);
            right[A.size()-1-i] = right[A.size()-i] * A.get(A.size()-i);
        }
        ArrayList<Long> res = new ArrayList<Long>();
        for (int i = 0; i < A.size(); i++){
            res.add((long)(left[i]*right[i]));
        }
        return res;
    }
}
