package src.amazon_oa.oa1;

/**
 * Created by stameying on 2/26/16.
 */
public class longest_palindrome {

    public static String longestPalindrome(String s){
        if (s == null) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0, start = 0;
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
            if (maxLen == 0){
                maxLen = 1;
                start = i;
            }
        }
        for (int i = 0; i < len-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                if (maxLen == 1){
                    maxLen = 2;
                    start = i;
                }
            }
        }
        for (int tempLen = 3; tempLen <= len; tempLen++){
            for (int i = 0; i+tempLen <= len; i++){
                int j = i+tempLen-1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if (tempLen > maxLen){
                        maxLen = tempLen;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start,start+maxLen);
    }
}
