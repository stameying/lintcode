package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 3/14/16.
 */
public class p312 {

    public static int maxCoins(int[] nums) {


        /**
         [3, 1, 5, 8]

         0    0    0    0    0    0
         0    3    30   159  167  0
         0    0    15   135  159  0
         0    0    0    40   48   0
         0    0    0    0    40   0
         0    0    0    0    0    0


         */
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for (int i = 1; i <= n; i++){
            arr[i] = nums[i-1];
        }


        int[][] dp = new int[n+2][n+2];
        // dp
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n-k+1; i++){
                int j = i+k-1;
                for (int pos = i; pos <= j; pos++){
                    System.out.println("i="+i+",j="+j+",k="+k);
                    display2Dtable.display(dp);
                    dp[i][j] = Math.max(dp[i][j], dp[i][pos-1]+ arr[i-1] * arr[pos] * arr[j+1] + dp[pos+1][j]);
                }
            }
        }

        return dp[1][n];
    }

    public static int maxCoins2(int[] nums) {
        int[] array = new int[nums.length+2];
        array[0] = array[nums.length+1] = 1;

        for (int i = 0; i < nums.length; i++){
            array[i+1] = nums[i];
        }

        System.out.println(Arrays.toString(array));

        int n = array.length;
        int[][] dp = new int[n][n];
        for (int k = 1; k <= nums.length; k++){
            for (int i = 1; i <= array.length-k-1; i++){
                int j = i+k-1;
                for (int x = i; x <= j; x++){
                    System.out.println("i="+i+",j="+j);
                    dp[i][j] = Math.max(dp[i][x-1]+array[i-1]*array[x]*array[j+1]+dp[x+1][j],dp[i][j]);
                }
            }
        }
        display2Dtable.display(dp);
        return dp[1][nums.length];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        maxCoins2(nums);
    }
}
