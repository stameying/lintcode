package src.CodeRound2;

/**
 * Created by stameying on 2/25/16.
 */
public class p174 {

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        int[][] path = new int[m][n];
        if (dungeon[0][0] >= 0) dp[0][0] = 1;
        else dp[0][0] = Math.abs(dungeon[0][0])+1;
        path[0][0] = dp[0][0];
        // first row
        for (int j = 1; j < n; j++){
            if (dungeon[0][j] >= 0){
                dp[0][j] = Math.max(1, dp[0][j-1]-dungeon[0][j]);
            }else{
                dp[0][j] = dp[0][j-1] - dungeon[0][j];
            }
            path[0][j] = Math.max(path[0][j-1],dp[0][j]);
        }

        // first col
        for (int i = 1; i < m; i++){
            if (dungeon[i][0] >= 0){
                dp[i][0] = Math.max(1,dp[i-1][0]-dungeon[i][0]);
            }else{
                dp[i][0] = dp[i-1][0] - dungeon[i][0];
            }
            path[i][0] = Math.max(path[i-1][0],dp[i][0]);
        }

        // dp
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (i == m && j == n) continue;
                if (dungeon[i][j] >= 0){
                    dp[i][j] = Math.max(1,Math.min(dp[i-1][j],dp[i][j-1])-dungeon[i][j]);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])-dungeon[i][j];
                }
                path[i][j] = Math.max( (dp[i-1][j] <= dp[i][j-1]?path[i-1][j]:path[i][j-1]),dp[i][j]);
            }
        }

        display2Dtable.display(dp);
        display2Dtable.display(path);
        if (m == 1 || n == 1) return Math.max(dp[m-1][n-1],path[m-1][n-1]);


        if (dp[m-2][n-1] <= dp[m-1][n-2] && path[m-2][n-1] <= path[m-2][n-1]){
//            System.out.println("case 1");
            if (dungeon[m-1][n-1] >= 0){
                dp[m-1][n-1] = Math.max(path[m-2][n-1], dp[m-2][n-1] - dungeon[m-1][n-1]);
            }else{
                dp[m-1][n-1] = Math.max(path[m-2][n-1], Math.abs(dungeon[m-1][n-1]));
            }
        }
        else if (dp[m-2][n-1] > dp[m-1][n-2] && path[m-2][n-1] > path[m-2][n-1]){
            if (dungeon[m-1][n-1] >= 0){
                dp[m-1][n-1] = Math.max(path[m-1][n-2], dp[m-1][n-2] - dungeon[m-1][n-1]);
            }else{
                dp[m-1][n-1] = Math.max(path[m-1][n-2], Math.abs(dungeon[m-1][n-1]));
            }
        }
        else{
            // special consideration
            if (dungeon[m-1][n-1] >= 0){
                if (path[m-2][n-1] <= path[m-2][n-1]) dp[m-1][n-1] = Math.max(1, dp[m-2][n-1] - dungeon[m-1][n-1]);
                else dp[m-1][n-1] = Math.max(1, dp[m-1][n-2] - dungeon[m-1][n-1]);
            }else{
                if (path[m-2][n-1] <= path[m-2][n-1]){
                    dp[m-1][n-1] = dp[m-2][n-1] - dungeon[m-1][n-1];
//                    System.out.println("!!");
                }
                else dp[m-1][n-1] = dp[m-1][n-2] - dungeon[m-1][n-1];
            }
        }
        display2Dtable.display(dp);
        display2Dtable.display(path);
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
//        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] dungeon = {{0,5},{-2,-3}};
        System.out.println("hp="+calculateMinimumHP(dungeon));
    }
}
