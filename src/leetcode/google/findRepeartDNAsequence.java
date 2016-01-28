package leetcode.google;

import java.util.*;

/**
 * Created by stameying on 1/27/16.
 */
public class findRepeartDNAsequence {

    public List<String> findSequence(String str){
        Map<Character, Integer> DNA = new HashMap<>();
        DNA.put('A',0);
        DNA.put('B',1);
        DNA.put('C',2);
        DNA.put('D',3);
        List<String> res = new ArrayList<>();
        if (str == null || str.length() < 10) return res;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i+10 <= str.length(); i++){
            int val = 0;
            for (int j = 0; j < 10; j++){
                val = (val<<2) | DNA.get(str.charAt(i+j));
            }
            if (!visited.contains(val)){
                res.add(str.substring(i,i+10));
                visited.add(val);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
