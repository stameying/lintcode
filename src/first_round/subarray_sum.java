package src.first_round;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stameying on 12/15/15.
 */
public class subarray_sum {
    /**
    * QUESTION:
     * Given an integer array, find a subarray where the sum of numbers is zero.
     * * Your code should return the index of the first number and the index of the last number.
    * */

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */

    /*
    * Key :
     * if nums[  0  .. x ] = a
     *    nums[  0  .. y ] = a
     * => nums[ x+1 .. y ] == 0
    * */
    public ArrayList<Integer> subarraySum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        if (nums.length <= 1){
            ArrayList<Integer> sol = new ArrayList<Integer>();
            sol.add(0, 0);
            sol.add(1, 0);
            return sol;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (i != 0 && sum == 0){
                ArrayList<Integer> sol = new ArrayList<Integer>();
                sol.add(0, 0);
                sol.add(1, i);
                return sol;
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }else{ // we find a solution
                // get first index
                int start = map.get(sum)+1;
                int end = i;
                ArrayList<Integer> sol = new ArrayList<Integer>();
                sol.add(0, start);
                sol.add(1, end);
                return sol;
            }
        }
        return null;
    }


    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    /*
    *  O(n^2) time, time exceeds
    * */
    public ArrayList<Integer> subarraySum1(int[] nums) {
        // write your code here
        if (nums.length <= 1){
            ArrayList<Integer> sol = new ArrayList<Integer>();
            sol.add(0);
            sol.add(0);
            return sol;
        }
        int[][] dp = new int[nums.length][nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++){
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < len; i++){
            for (int j = i-1; j >= 0; j--){
                dp[i][j] = dp[i-1][j] + nums[i];
                if (dp[i][j] == 0){
                    // we find a solution
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(0,i);
                    sol.add(1,j);
                    return sol;
                }
            }
        }
        return new ArrayList<Integer>();
    }




}
