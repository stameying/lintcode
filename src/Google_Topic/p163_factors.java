package Google_Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/17/16.
 */
public class p163_factors {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3) return res;
        factorHelper(-1,n,new ArrayList<>(), res); // first parameter make sure we add large element first from second place
        return res;
    }

    public static void factorHelper(int lower, int n, List<Integer> cur, List<List<Integer>> res){
        if (lower != -1){
            cur.add(n);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size()-1);
        }
        int upper = (int)Math.sqrt(n);
        for (int factor = Math.max(lower,2); factor <= upper; factor++){
            if (n%factor == 0){
                cur.add(factor);
                factorHelper(factor,n/factor,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }


    public static void main(String[] args) {

        System.out.println(getFactors(32));
    }
}
