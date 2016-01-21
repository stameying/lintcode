package leetcode.google.best_time_to_buy_and_sell_stock;

import java.util.Arrays;

/**
 * Created by stameying on 1/21/16.
 */
public class best_time_to_buy_and_sell_stock_4 {

    public int maxProfit(int k, int[] prices){
        if (k==0 || prices.length <= 1) return 0;
        int[][] map = new int[k+1][prices.length];

        /*
        * Important!
        * If k is twice larger than the total days, which means we can do as many transaction as we want.
        * Then we can quick solve the question and we don't need to use dp any more
        * */
        if (k>prices.length/2) {
            int sum = 0;
            for(int i = 1;i < prices.length;i++){
                if(prices[i] > prices[i-1]){
                    sum += prices[i] - prices[i-1];
                }
            }
            return sum;
        }

        int max = 0;
        for (int i = 1; i <= k; i++){
            int maxDiff = map[i-1][0]-prices[0];
            for (int j = 1; j < prices.length; j++){
                int cur = Math.max(map[i][j-1],prices[j]+maxDiff);
                map[i][j] = cur;
                max = Math.max(max,cur);
                maxDiff = Math.max(maxDiff,map[i-1][j]-prices[j]);
            }
        }
        return max;
    }

    public int maxProfit2(int k, int[] prices) {
        if (k==0 || prices.length <= 1) return 0;
        int[] prev = new int[prices.length];
        int[] cur = new int[prices.length];
        int max = 0;
        /*
        * Important!
        * If k is twice larger than the total days, which means we can do as many transaction as we want.
        * Then we can quick solve the question and we don't need to use dp any more
        * */
        for (int i = 1; i <= k; i++){
            int maxDiff = prev[0]-prices[0];
            for (int j = 1; j < prices.length; j++){
                int local = Math.max(cur[j-1],prices[j]+maxDiff);
                cur[j] = local;
                max = Math.max(max,local);
                maxDiff = Math.max(maxDiff,prev[j]-prices[j]);
            }
            prev = Arrays.copyOf(cur,prices.length);
            cur = new int[prices.length];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {2,5,7,1,4,3,1,3};
        best_time_to_buy_and_sell_stock_4 test4 = new best_time_to_buy_and_sell_stock_4();
        System.out.println("Max profit = " + test4.maxProfit2(3,prices));
    }
}
