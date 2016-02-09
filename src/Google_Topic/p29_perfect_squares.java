package Google_Topic;

/**
 * Created by stameying on 2/7/16.
 */
public class p29_perfect_squares {

    /**
     * Leetcode 279
     * */

    public static int numSquares(int n){
        while (n % 4 == 0) n/=4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a*a <= n; a++){
            int b = (int)Math.sqrt(n-a*a);
            if (a*a + b*b == n){
                int res = 0;
                if (a > 0) res++;
                if (b > 0) res++;
                return res;
            }
        }
        return 3;
    }


    public static int numSquaresDP(int n){
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++){
            dp[i] = i;
            for (int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        int[] res = new int[]{1,2};
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++){
            System.out.print(numSquaresDP(i) + "  ");
        }
    }
}
