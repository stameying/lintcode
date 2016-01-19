package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/18/16.
 */
public class generalized_abbreviation {

    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<String>();
        helper(0,word,"",res,false);
        return res;
    }

    public void helper(int pos, String word, String cur, List<String> res, boolean prevAbbr){
        if (pos == word.length()){
            res.add(cur);
            return;
        }
        if (prevAbbr == false){
            // can abbreviate
            for (int end = pos+1; end <= word.length(); end++){
                helper(end,word,cur+Integer.toString(end-pos),res,true);
            }
        }
        helper(pos+1,word,cur+word.charAt(pos),res,false);
    }
}
