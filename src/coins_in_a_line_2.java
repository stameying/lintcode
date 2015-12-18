import java.util.Arrays;

/**
 * Created by stameying on 12/17/15.
 */
public class coins_in_a_line_2 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public static boolean firstWillWin(int[] values) {
        // write your code here
        int []dp = new int[values.length + 1];
        boolean []flag =new boolean[values.length + 1];
        int sum = 0;
        for(int now : values)
            sum += now;

        boolean res = sum < 2*MemorySearch(values.length, dp, flag, values);
        System.out.println(Arrays.toString(dp));
        return res;
    }
    static int MemorySearch(int n, int []dp, boolean []flag, int []values) {
        if(flag[n] == true)
            return dp[n];
        flag[n] = true;
        if(n == 0)  {
            dp[n] = 0;
        } else if(n == 1) {
            dp[n] = values[values.length-1];
        } else if(n == 2) {
            dp[n] = values[values.length-1] + values[values.length-2];
        } else if(n == 3){
            dp[n] = values[values.length-2] + values[values.length-3];
        } else {
            dp[n] = Math.max(
                    Math.min(MemorySearch(n-2, dp, flag,values) , MemorySearch(n-3, dp, flag, values)) + values[values.length-n],
                    Math.min(MemorySearch(n-3, dp, flag, values), MemorySearch(n-4, dp, flag, values)) + values[values.length-n] + values[values.length - n + 1]
            );
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] input = {4,2,3,3,2,4,1,5,3};
        firstWillWin(input);
    }
}
