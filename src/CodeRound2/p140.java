package src.CodeRound2;

import java.util.*;

/**
 * Created by stameying on 2/24/16.
 */
public class p140 {

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(0,s,new ArrayList<String>(), res,wordDict);
        return res;
    }

    public static void dfs(int pos, String s, List<String> cur, List<String> res, Set<String> wordDict){
        if (pos == s.length()){
            String str = "";
            for (int i = 0; i < cur.size(); i++){
                str += cur.get(i);
                if (i != cur.size()-1) str +=" ";
            }
            res.add(str);
            return;
        }
        for (int i = pos+1; i <= s.length(); i++){
            if (wordDict.contains(s.substring(pos,i))){
                cur.add(s.substring(pos,i));
                dfs(i,s,cur,res,wordDict);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "catsanddog";
        Set<String> dict = new HashSet<>(Arrays.asList("cat","cats","sand","and","dog"));
        System.out.println(wordBreak(str,dict));
    }
}
