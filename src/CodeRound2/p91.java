package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/22/16.
 */
public class p91 {

    /**
     *
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.


     * */

    public static int numDecodings(String s) {
        if (s.length() == 0) return s.length();
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if (isValid(s.substring(0,1))) dp[1] = 1;
        else dp[1] = 0;
        for (int i = 2; i <= s.length(); i++){
            if (isValid(s.substring(i-1,i))) dp[i] += dp[i-1];
            if (isValid(s.substring(i-2,i))) dp[i] += dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static boolean isValid(String s){
        if (s.charAt(0) == '0') return false;
        if (s.length() == 1) return true;
        if (s.charAt(0) >= '3' || (s.charAt(0) == '2' && s.charAt(1) > '6')) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("100"));
    }

}
