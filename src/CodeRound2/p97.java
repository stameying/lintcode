package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/22/16.
 */
public class p97 {

    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

     For example,
     Given:
     s1 = "aabcc",
     s2 = "dbbca",

     When s3 = "aadbbcbcac", return true.
     When s3 = "aadbbbaccc", return false.
     *
     *
     * */

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++){
            if (s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = dp[i-1][0];
        }
        for (int j = 1; j <= len2; j++){
            if (s2.charAt(j-1) == s3.charAt(j-1)) dp[0][j] = dp[0][j-1];
        }

        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                int pos = i+j-1;
                dp[i][j] = false;
                if (s3.charAt(pos) == s1.charAt(i-1)) dp[i][j] |= dp[i-1][j];
                if (s3.charAt(pos) == s2.charAt(j-1)) dp[i][j] |= dp[i][j-1];
            }
        }
        for (int i = 0; i <= len1; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        System.out.println(isInterleave(s1,s2,s3));
    }
}
