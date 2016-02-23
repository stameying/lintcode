package src.CodeRound2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/22/16.
 */
public class p77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(1,k,n,cur,res);
        return res;
    }

    public static void helper(int num, int k, int n, List<Integer> cur, List<List<Integer>> res){
        if (k == 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = num; i <= n; i++){
            cur.add(num);
            helper(i+1,k-1,n,cur,res);
            cur.remove(cur.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        combine(1,1);
    }
}
