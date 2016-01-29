package leetcode.google.best_time_to_buy_and_sell_stock;

import java.util.Arrays;

/**
 * Created by stameying on 1/21/16.
 */
public class best_time_to_buy_and_sell_stock_3 {

    /**
     * 维护两个Array : left and right
     * left[i] 表示 从 0..i 间最大的利润
     * right[i] 表示从 i..n 间最大的利润
     * 所以 i的最大利润即为 left[i] + right[i]
     * */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        left[0] = 0;
        int cur = 0, max = 0, low = prices[0];
        // calculate left
        for (int i = 1; i < prices.length; i++){
            cur = prices[i]-low;
            max = Math.max(cur,max);
            left[i] = max;
            low = Math.min(low,prices[i]);
        }
        System.out.println("left array:" + Arrays.toString(left));

        cur = 0;
        max = 0;
        int high = prices[prices.length-1];
        // calculate right
        for (int i = prices.length-2; i >= 0; i--){
            cur = high-prices[i];
            max = Math.max(max,cur);
            right[i] = max;
            high = Math.max(high,prices[i]);
        }
        System.out.println("right array:" + Arrays.toString(right));

        max = 0;
        for (int i = 0; i < prices.length; i++){
            max = Math.max(max,left[i]+right[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {12,11,13,9,12,8,14,13,15};
        best_time_to_buy_and_sell_stock_3 test3 = new best_time_to_buy_and_sell_stock_3();
        System.out.println("Max profit = " + test3.maxProfit(prices));
    }
}
