package src.CodeRound3;

/**
 * Created by stameying on 3/26/16.
 */
public class p10 {

    public static boolean isMatch(String s, String p) {
        if (p.length() == 0 && s.length() != 0) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++){
            if (p.charAt(j-1) == '*'){
                // j肯定比1大
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= p.length() ; j++){
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);
                if (sChar == pChar){
                    dp[i][j] = dp[i-1][j-1];
                }else if (pChar == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (pChar == '*'){
                    boolean case1 = dp[i][j-2]; // c*当成''
                    boolean case2 = (sChar==p.charAt(j-2)||p.charAt(j-2)=='.')?dp[i-1][j-1]:false; // c*当初'c'
                    boolean case3 = (sChar==p.charAt(j-2)||p.charAt(j-2)=='.')?dp[i-1][j]:false; // c*当初'cccc...'
                    dp[i][j] = ((case1||case2)||case3);
                }
            }
        }

        display2Dtable.display(dp);

        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";
        System.out.println(isMatch(s,p));
    }
}
