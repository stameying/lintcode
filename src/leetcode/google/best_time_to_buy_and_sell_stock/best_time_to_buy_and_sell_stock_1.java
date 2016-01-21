package leetcode.google.best_time_to_buy_and_sell_stock;

/**
 * Created by stameying on 1/21/16.
 */
public class best_time_to_buy_and_sell_stock_1 {


    /**
     * curProfit keep track of current profit,
     * maxProfit keep track of max profit so far.
     * If we meet a new low price, reset low price and reset curProfit to see if we can find a better deal.
     * Since buy must happen before sell.
     * */
    public int maxProfit(int[] prices){
        if (prices == null || prices.length <= 1) return 0;
        int low = prices[0], maxProfit = 0, curProfit = 0;
        for (int i = 1; i < prices.length; i++){
            curProfit = prices[i] - low;
            maxProfit = Math.max(curProfit,maxProfit);
            if (prices[i] < low){
                low = prices[i];
                curProfit = 0;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {2,4,1,7,5,3};
        best_time_to_buy_and_sell_stock_1 test1 = new best_time_to_buy_and_sell_stock_1();
        System.out.println("Max profit = " + test1.maxProfit(prices));
    }
}
