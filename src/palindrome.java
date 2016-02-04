import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 2/3/16.
 */
public class palindrome {

    public static int palindrome(String str){
        if (str == null) return 0;
        if (str.length() == 0) return 0;
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
            if (!set.contains(str.charAt(i)+"")) set.add(str.charAt(i)+"");
        }
        for (int i = 0; i < len-1; i++){
            if (str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                if (!set.contains(str.substring(i,i+2))) set.add(str.substring(i,i+2));
            }
        }
        for (int tempLen = 3; tempLen <= len; tempLen++){
            for (int i = 0; i+tempLen <= len; i++){
                int j = i+tempLen-1;
                if (str.charAt(i)== str.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if (!set.contains(str.substring(i,j+1))) set.add(str.substring(i,j+1));
                    StringBuilder builder = new StringBuilder();
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        String str = "aabaa";
        System.out.println(palindrome(str));
    }
}
