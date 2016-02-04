package EPI.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/3/16.
 */
public class numCombinations {

    public static int numOfCombinations(int finalScore, List<Integer> scores){
        int[][] dp = new int[scores.size()][finalScore+1];
        for (int i = 0; i < scores.size(); i++){
            dp[i][0] = 1;
            for (int j = 1; j <= finalScore; j++){
                int withOutThisPlay = i-1>=0?dp[i-1][j]:0;
                int withThisPlay = j>=scores.get(i)?dp[i][j-scores.get(i)]:0;
                dp[i][j] = withOutThisPlay+withThisPlay;
            }
        }
        return dp[scores.size()-1][finalScore];
    }

    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(2,3,7));
        System.out.println(numOfCombinations(12,scores));
    }
}
