package src.CodeRound3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 3/8/16.
 */
public class p254 {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) return res;
        List<Integer> cur = new ArrayList<>();
        helper(2,1,cur,n,res);
        return res;
    }

    public static void helper(int factor, int product, List<Integer> cur, int n, List<List<Integer>> res){
        if (n == 1){
            res.add(new ArrayList<>(cur));
            return;
        }
        if (factor >= n) return;

        //
        for (int i = factor; i <= Math.sqrt(n); i++){
            if (n == (n/i)*i){
                List<Integer> sol = new ArrayList<>(cur);
                sol.add(i);
                sol.add(n/i);
                res.add(sol);
                cur.add(i);
                helper(i,product*i,cur,n/i,res);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res =  getFactors(32);
        System.out.println(res);
    }
}
