package src.CodeRound2;

/**
 * Created by stameying on 2/23/16.
 */
public class p132 {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s = "aab",
     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

     Show Tags
     Show Similar Problems

     *
     * */

    public static int minCut(String s) {
        int[] minCut = new int[s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            minCut[i] = i;
            for (int j = 0; j < i; j++){
                if (s.charAt(i) == s.charAt(j) && (i-j <= 1 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    if (j == 0) minCut[i] = 0;
                    else minCut[i] =  Math.min(minCut[i],minCut[j-1]+1);
                }
            }
        }
        display2Dtable.display(dp);
        return minCut[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(minCut("dde"));
    }
}
