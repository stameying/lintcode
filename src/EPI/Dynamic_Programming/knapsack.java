package EPI.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/4/16.
 */
public class knapsack {

    private static class Item{
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimumSubjectToCapacity(List<Item> items, int capacity){
        int[][] dp = new int[items.size()][capacity+1];
        if (items.size() == 0) return 0;
        for (int i = 0; i < items.size(); i++){
            for (int j = 1; j <= capacity; j++){
                int withOutCurItem = i!=0?dp[i-1][j]:0;
                int withCurItem = ((j>=items.get(i).weight)?((i!=0)?dp[i-1][j-items.get(i).weight]:0)+items.get(i).value:0);
                dp[i][j] = Math.max(withCurItem,withOutCurItem);
            }
        }
        return dp[items.size()-1][capacity];
    }

    public static void main(String[] args) {
        Item i1 = new Item(5,60);
        Item i2 = new Item(3,50);
        Item i3 = new Item(4,70);
        Item i4 = new Item(2,30);
        List<Item> list = new ArrayList<>(Arrays.asList(i1,i2,i3,i4));
        System.out.println(optimumSubjectToCapacity(list,5));
    }
}
