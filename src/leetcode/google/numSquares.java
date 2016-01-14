package leetcode.google;

/**
 * Created by stameying on 1/13/16.
 */
public class numSquares {


    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++){
            dp[i] = i;
            for (int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * 四合平方理论
     * */
    public int numSquares2(int n) {
        while (n % 4 == 0) n/=4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a*a <= n; a++){
            int b = (int)Math.sqrt(n - a * a);
            int res = 0;
            if (a*a + b*b == n){
                if (a > 0) res++;
                if (b > 0) res++;
                return res;
            }
        }
        return 3;
    }

//    public int numSquares(int n) {
//        if (n == 1) return 1;
//        int res = 0;
//        while (n > 0){
//            int root = getLargestRoot(n);
//            System.out.println("root="+root);
//            n -= Math.pow(root,2);
//            res++;
//        }
//        return res;
//    }
//
//    public int getLargestRoot(int n){
//        if (n == 1) return 1;
//        int left = 0, right = n;
//        while (left <= right){
//            int mid = left + (right-left)/2;
//            if (mid * mid == n) return mid;
//            else if (mid * mid < n){
//                left++;
//            }else{
//                right--;
//            }
//        }
//        return left-1;
//    }


    public static void main(String[] args) {
        numSquares test = new numSquares();
        test.numSquares(12);
    }
}
