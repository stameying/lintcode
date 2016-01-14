package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/13/16.
 */
public class Strobogrammatic_number2 {
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }

    public List<String> helper(int m, int n){
        if (m == 1){
            List<String> res = Arrays.asList("0","1","8");
            return res;
        }
        if (m == 0){
            List<String> res = Arrays.asList("");
            return res;
        }
        List<String> list = helper(m-2,n);
        List<String> res = new ArrayList<String>();
        for (String str: list){
            if (m != n){
                res.add("0"+str+"0");
            }
            res.add("1"+str+"1");
            res.add("6"+str+"9");
            res.add("8"+str+"8");
            res.add("9"+str+"6");
        }
        return res;
    }
}
