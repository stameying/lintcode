package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/12/16.
 */
public class Flip_Game {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 2) return res;
        for (int i = 0; i < s.length()-1; i++){
            if (s.charAt(i)=='+' && s.charAt(i+1) == '+'){
                // find a valid flip position
                String temp = s.substring(0,i)+"--"+s.substring(i+2);
                res.add(temp);
            }
            if (s.charAt(i+1) == '-') i++;
        }
        return res;
    }
}
