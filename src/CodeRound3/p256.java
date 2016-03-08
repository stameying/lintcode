package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/7/16.
 */
public class p256 {

    public static int minCost(int[][] costs) {
        // dp 二维数组
        // if (costs.length == 0) return 0;
        // int[][] dp = new int[costs.length][3];
        // for (int i = 0; i < costs.length; i++){
        //     if (i == 0){
        //         for (int j = 0; j < 3; j++) dp[0][j] = costs[0][j];
        //     }else{
        //         dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
        //         dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
        //         dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        //     }
        // }
        // return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));


        if (costs.length == 0) return 0;

        // 空间优化
        int[] pre = new int[3];
        int[] next = new int[3];
        for (int i = 0; i < 2; i++){
            System.out.println(Arrays.toString(pre));
            if (i == 0) for (int j = 0; j < 3; j++) next[j] = costs[0][j];
            else{
                System.out.println("pre="+Arrays.toString(pre));
                System.out.println("pre min="+Math.min(pre[0],pre[1]));
                next[0] = Math.min(pre[1],pre[2]) + costs[i][0];
                next[1] = Math.min(pre[0],pre[2]) + costs[i][1];
                System.out.println("pre min="+Math.min(pre[0],pre[1]));
                next[2] = Math.min(pre[0],pre[1]) + costs[i][2];

                System.out.println(costs[i][0]+","+costs[i][1]+","+costs[i][2]);
                System.out.println(Arrays.toString(next));
            }
            pre = Arrays.copyOf(next,next.length);
        }

        return Math.min(pre[0],Math.min(pre[1],pre[2]));
    }

    public static void main(String[] args) {
//        int[][] nums = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
//        minCost(nums);

        int[] pre = new int[]{1,2};
        int[] next = new int[]{2,3};
        pre = Arrays.copyOf(next,next.length);
        next[0] = 10;
        System.out.println(Arrays.toString(pre));
    }
}
