package src.amazon_oa.oa2.second_trial;

import java.util.Arrays;

/**
 * Created by stameying on 2/27/16.
 */
public class p5_sum_window {

    public static int[] sumWindow(int[] array, int k){
        if (array == null || array.length == 0 || k <= 0) return new int[0];
        int len = array.length, sum = 0, pre = -1;
        int[] res = new int[len+1-k];
        for (int i = 0; i < k-1; i++){
            sum += array[i];
        }
        for (int i = k-1; i < len; i++){
            sum += array[i];
            res[++pre] =  sum;
            sum -= array[pre];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {4,2,73,11,-5};
        System.out.println(Arrays.toString(sumWindow(array,1)));
    }
}
