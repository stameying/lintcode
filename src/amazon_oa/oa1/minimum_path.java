package src.amazon_oa.oa1;

/**
 * Created by stameying on 2/25/16.
 */
public class minimum_path {

    public static int max_value_in_min_value_in_path(int[][] map){
        if (map == null || map.length == 0) return 0;
        int m = map.length, n = map[0].length;
        int[][] dp = new int[m][n];

        // from right bottom to left top
        dp[m-1][n-1] = map[m-1][n-1];
        for (int i = m-2; i >= 0; i--){
            dp[i][n-1] = Math.min(dp[i+1][n-1],map[i][n-1]);
        }

        for (int j = n-2; j >= 0; j--){
            dp[m-1][j] = Math.min(dp[m-1][j+1],map[m-1][j]);
        }

        for (int i = m-2; i >= 0; i--){
            for (int j = n-2; j >= 0; j--){
                dp[i][j] = Math.min(Math.max(dp[i+1][j],dp[i][j+1]), map[i][j]);
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        int[][] map = {{8,4,7},{3,3,9},{4,5,6}};
        System.out.println(max_value_in_min_value_in_path(map));
    }
}
