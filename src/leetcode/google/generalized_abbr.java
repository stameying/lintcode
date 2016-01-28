package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/26/16.
 */
public class generalized_abbr {

    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        dfs(word,res,"",0,false);
        return res;
    }

    public void dfs(String word, List<String> res, String cur, int pos, boolean prevAbbr){
        if (pos == word.length()){
            res.add(cur);
            return;
        }
        if (!prevAbbr){
            for (int i = 1; pos+i <= word.length(); i++){
                dfs(word,res,cur+i,pos+i,true);
            }
        }
        dfs(word,res,cur+word.charAt(pos),pos+1,false);
    }

    public static void main(String[] args) {
        generalized_abbr test = new generalized_abbr();
        System.out.println(test.generateAbbreviations("word"));
    }
}
