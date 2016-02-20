package src.CodeRound2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/19/16.
 */
public class p10 {

    /**
     * Regular Expression Matching
     *
     *
     *
     *
     '.' Matches any single character.
     '*' Matches zero or more of the preceding element.

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "a*") → true
     isMatch("aa", ".*") → true
     isMatch("ab", ".*") → true
     isMatch("aab", "c*a*b") → true
     *
     * */



    /**
     * Recursive
     * */
    public static boolean isMatch(String s, String p){
        if (p.length() == 0) return s.length() == 0;
        if (s.length() == 0){
            if (p.length() == 0) return true;
            else if (p.length() == 1) return false;
            else{
                if (p.charAt(1) == '*') return isMatch(s,p.substring(2));
                else return false;
            }
        }
        if (p.length() == 1){
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));
        }else{
            if (p.charAt(1) == '*'){
                while (s.length() > 0 && (p.charAt(0)==s.charAt(0) || p.charAt(0) == '.')){
                    if (isMatch(s,p.substring(2))) return true;
                    s = s.substring(1);
                }
                return isMatch(s,p.substring(2));
            }else{
                return (s.charAt(0)==p.charAt(0)||p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));
            }
        }
    }


    /**
     * DP
     * */

    public static boolean isMatch2(String s, String p){
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];

        // pre-processing
        dp[0][0] = true;
        for (int j = 1; j <= len1; j++){
            if (p.charAt(j-1) != '*') dp[0][j] = false;
            else dp[0][j] = dp[0][j-2];
        }

        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (p.charAt(j-1) != '*'){
                    dp[i][j] = dp[i-1][j-1] && ((p.charAt(j-1) == s.charAt(i-1)) || p.charAt(j-1) == '.');
                }else{
                    if (dp[i][j-1] || dp[i][j-2]) dp[i][j] = true; //匹配0和1个字符
                    else if (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')) dp[i][j] = true; //匹配多个字符
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        List<Integer> sol = new ArrayList<>(Arrays.asList(2,3,5));
        System.out.println(sol);
    }
}
