/**
 * Created by stameying on 12/17/15.
 */
public class Container_With_Most_Water {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        /**
        * move the short board
        * */
        int max = 0, left = 0, right = heights.length-1;
        while (left < right){
            max = Math.max(max, (right-left)*Math.min(heights[left],heights[right]));
            if (heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

}
