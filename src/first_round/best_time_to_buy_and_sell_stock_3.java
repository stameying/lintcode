package src.first_round;

/**
 * Created by stameying on 12/16/15.
 */
public class best_time_to_buy_and_sell_stock_3 {

    public int maxProfit(int[] prices) {
        // write your code here
        int[] left_to_right_max_profit = new int[prices.length];
        generateFromLeftToRight(prices,left_to_right_max_profit);
        System.out.println("------------------------");
        int[] right_to_left_max_profit = new int[prices.length];
        generateFromRightToLeft(prices,right_to_left_max_profit);
        System.out.println("------------------------");
        int[] max_profit = new int[prices.length];
        generateMaxProfit(prices, left_to_right_max_profit,right_to_left_max_profit, max_profit);
        return 0;
    }

    public void generateFromLeftToRight(int[] prices, int[] left_to_right_max_profit){
        int lowDayPrice = prices[0];
        left_to_right_max_profit[0] = 0;
        displayPrice(prices);
        String line1 = "prifit: 0 ";
        String line2 = "lowPri: " + lowDayPrice + " ";
        for (int i = 1 ; i < prices.length; i++){
            // current maximum profit = 1: sell today
            //                          2: previous maximum profit
            left_to_right_max_profit[i] = Math.max(prices[i]-lowDayPrice, left_to_right_max_profit[i-1]);
            line1 += left_to_right_max_profit[i];
            line1 += " ";
            lowDayPrice = Math.min(lowDayPrice, prices[i]);
            line2 += lowDayPrice;
            line2 += " ";
        }
        System.out.println(line2);
        System.out.println(line1);
    }

    public void generateFromRightToLeft(int[] prices, int[] right_to_left_max_profit){
        int highDayPrice = prices[prices.length-1];
        right_to_left_max_profit[prices.length-1] = 0;
        displayPrice(prices);
        String line1 = "";
        String line2 = "";
        for (int i = prices.length-2; i >= 0; i--){
            right_to_left_max_profit[i] = Math.max(highDayPrice-prices[i], right_to_left_max_profit[i+1]);
            line1 = right_to_left_max_profit[i] + " " + line1;
            highDayPrice = Math.max(prices[i],highDayPrice);
            line2 = highDayPrice + " " + line2;
        }
        line1 = "profit: " + line1;
        line2 = "highPi: " + line2;
        line1 += "0";
        line2 += prices[prices.length-1];
        System.out.println(line2);
        System.out.println(line1);
    }

    public void generateMaxProfit(int[] prices, int[] left_to_right_max_profit,int[] right_to_left_max_profit, int[] max_profit){
        displayPrice(prices);
        String str = "MaxPro: ";
        for (int i = 0; i < prices.length; i++){
            if (i == 0){
                max_profit[0] = left_to_right_max_profit[0] + right_to_left_max_profit[0];
            }else{
                max_profit[i] = Math.max(left_to_right_max_profit[i]+right_to_left_max_profit[i], max_profit[i-1]);
            }
            str += max_profit[i];
            str += " ";
        }
        System.out.println(str);
    }


    public void displayPrice(int[] prices){
        String str = "prices: ";
        for (int i = 0; i < prices.length; i++){
            str += prices[i];
            if ( i != prices.length-1){
                str += " ";
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        int[] prices = {4,4,6,1,1,4,2,5};
        best_time_to_buy_and_sell_stock_3 test = new best_time_to_buy_and_sell_stock_3();
        test.maxProfit(prices);
    }

}
