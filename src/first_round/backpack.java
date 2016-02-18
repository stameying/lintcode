package src.first_round;

/**
 * Created by stameying on 12/16/15.
 */
public class backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */

    /*
    * boolean d[i][j]: From the first i items, can we select some items so that their weight equals to j.
    * boolean d[i][j] = d[i-1][j] || d[i-1][j-A[i-1]]
    * */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        for (int i = 1; i <= A.length; i++){
            for (int j = m; j >= 0; j--){
                if (j-A[i-1] > 0 && dp[j-A[i-1]]){
                    dp[j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--){
            if (dp[i] ) return i;
        }
        return 0;
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[][] d = new int[A.length+1][m+1];
        for (int i = 0; i <= A.length; i++){
            for (int j = 0; j <= m; j++){
                if (i==0 || j == 0){
                    d[i][j] = 0;
                }else{
                    if (A[i-1] <= j){
                        d[i][j] = Math.max(d[i-1][j],d[i-1][j-A[i-1]] + V[i-1]);
                    }else{
                        d[i][j] = d[i-1][j];
                    }
                }
            }
        }
        return d[A.length][m];
    }

}
