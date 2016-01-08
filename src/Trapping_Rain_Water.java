/**
 * Created by stameying on 1/7/16.
 */
public class Trapping_Rain_Water {

    /**
     * @param heights: an array of integers
     * @return: a integer
     */

    /**
     * O(n) time and O(n) space
     * */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights.length <= 2) return 0;
        int[] L = new int[heights.length];
        int[] R = new int[heights.length];
        int h = heights[0];
        for (int i = 1; i < heights.length; i++){
            L[i] = Math.max(h,heights[i]) ;
            if (heights[i] > h) h = heights[i];
        }
        h = heights[heights.length-1];
        for (int j = heights.length-1; j >= 0; j--){
            R[j] = Math.max(h,heights[j]);
            if (heights[j] > h) h = heights[j];
        }
        int count = 0;
        for (int i = 1; i < heights.length-1; i++){
            count+= Math.max(Math.min(L[i],R[i])-heights[i],0);
        }
        return count;
    }


    /**
     * O(n) time and O(1) space
     * */

    public int trapRainWater2(int[] heights) {
        // write your code here
        if (heights.length <= 2) return 0;
        int lbar = 0, rbar = 0;
        int i = 0, j = heights.length-1;
        int res = 0;
        while (i <= j){
            lbar = Math.max(lbar,heights[i]);
            rbar = Math.max(rbar,heights[j]);
            // if left bar is lower than right, then the left bar dominates
            if (lbar < rbar){
                res += (lbar-heights[i++]);
            }else{
                res += (rbar-heights[j--]);
            }
        }
        return res;
    }
}
