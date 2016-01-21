package leetcode.google.best_time_to_buy_and_sell_stock;

/**
 * Created by stameying on 1/21/16.
 */
public class best_time_to_buy_and_sell_stock_5 {

    /**
     * State:
     *    Buy[i] max profit if we buy before the ith day
     *    Sell[i] max profit if we sell before the ith day
     *
     * Function:
     *    Buy[i] = Max(Buy[i-1], Sell[i-2]-price[i])
     *    Sell[i] = Max(Sell[i-1], Buy[i-1]+price[i])
     *
     * Initial:
     *    Buy[0] = -prices[0]
     *    Sell[0] = 0
     *    Buy[1] = Max(-prices[0],-prices[1])
     *    Sell[1] = Max(0,-prices[0]+prices[1])
     * */
    public int maxProfixt(int[] prices){
        if (prices == null || prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0],-prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0,-prices[0]+prices[1]);
        for (int i = 2; i < prices.length; i++){
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        best_time_to_buy_and_sell_stock_5 test5 = new best_time_to_buy_and_sell_stock_5();
        System.out.println("Max profit = " + test5.maxProfixt(prices));
    }
}
