package src.first_round;

/**
 * Created by stameying on 12/15/15.
 */
public class Triangle {

    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here

        /*
        * if from top to bottom, extra space = 1 + 2 + ... n = n^2
        * another way is from bottom to top, where the extra space is always n
        * */
        int[] cache = triangle[triangle.length-1];
        int len = cache.length;
        for (int i = triangle.length-2; i >= 0; i--){
            for (int j = 0; j < len-1; j++){
                cache[j] = Math.min(cache[j],cache[j+1])+triangle[i][j];
            }
            len--;
        }
        return cache[0];
    }


}
