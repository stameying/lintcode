package leetcode.google.best_time_to_buy_and_sell_stock;

/**
 * Created by stameying on 1/21/16.
 */
public class best_time_to_buy_and_sell_stock_2 {

    public int maxProfit(int[] prices){
        if (prices == null || prices.length <= 1) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            maxProfit += Math.max(prices[i]-prices[i-1],0);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {2,4,1,7,5,3};
        best_time_to_buy_and_sell_stock_2 test2 = new best_time_to_buy_and_sell_stock_2();
        System.out.println("Max profit = " + test2.maxProfit(prices));
    }
}
