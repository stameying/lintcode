package src.CodeRound2;

/**
 * Created by stameying on 2/18/16.
 */
public class p5 {

    /**
     * Longest Palindromic Substring
     * */

    /**
     * Given a string S, find the longest palindromic substring in S.
     * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
     * */

    /**
     * O(n^2) time and O(n^2) space
     * */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1, maxStart = 0;

        // pre processing
        for (int i = 0; i < len; i++) dp[i][i] = true;
        for (int i = 0; i+1 < len; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                maxStart = i;
            }
        }

        // dp
        for (int tempLen = 3; tempLen <= len; tempLen++){
            for (int i = 0; i+tempLen <= len; i++){
                int j = i+tempLen-1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    maxLen = Math.max(maxLen,tempLen);
                    maxStart = i;
                }
            }
        }

        return s.substring(maxStart,maxStart+maxLen);
    }



}
