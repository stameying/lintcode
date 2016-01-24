package leetcode.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by stameying on 1/23/16.
 */
public class word_break_2 {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        boolean[] dp = new boolean[s.length()+1];
        List<String> cur = new ArrayList<String>();
        dp[0] = true;
        dfs(1,s,wordDict,dp,cur,res);
        return res;
    }

    public void dfs(int pos, String s, Set<String> wordDict, boolean[] dp, List<String> cur, List<String> res){
        if (pos == s.length() && dp[s.length()]){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < cur.size(); i++){
                builder.append(cur.get(i));
                if (i != cur.size()-1) builder.append(" ");
            }
            res.add(builder.toString());
            return;
        }
        for (int j = 0; j < pos; j++){
                if (dp[j] && wordDict.contains(s.substring(j,pos))){
                    String word = s.substring(j,pos);
                    cur.add(word);
                    dp[pos] = true;
                    dfs(pos,s,wordDict,dp,cur,res);
                    dp[pos] = false;
                    cur.remove(cur.size()-1);
                }
        }

        return;
    }

    public static void main(String[] args) {
        Set<String> dic = new HashSet<>();
        dic.add("cat");
        dic.add("cats");
        dic.add("sand");
        dic.add("and");
        dic.add("dog");
        word_break_2 test = new word_break_2();
        List<String> res = test.wordBreak("catsanddog",dic);
        for (String str: res){
            System.out.println(str);
        }
    }

}
