import java.util.Arrays;

/**
 * Created by stameying on 12/23/15.
 */
public class longestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A.length()==0 || B.length()==0) return 0;
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i) == B.charAt(0)){
                dp[i][0] = 1;
            }else{
                if (i != 0){
                    dp[i][0] = dp[i-1][0];
                }else{
                    dp[i][0] = 0;
                }

            }
        }
        for (int j = 0; j < B.length(); j++){
            if (A.charAt(0) == B.charAt(j)){
                dp[0][j] = 1;
            }else{
                if (j == 0){
                    dp[0][j] = 0;
                }else{
                    dp[0][j] = dp[0][j-1];
                }
            }
        }
        for (int i = 1; i < A.length(); i++){
            for (int j = 1; j < B.length(); j++){
                if (A.charAt(i) != B.charAt(j)){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }else{
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[A.length()-1][B.length()-1];
    }

    public static void main(String[] args) {
        String str1 = "bedaacbade";
        String str2 = "dccaeedbeb";
        longestCommonSubsequence test = new longestCommonSubsequence();
        test.longestCommonSubsequence(str1,str2);
    }
}
