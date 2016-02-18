package src.first_round;

import java.util.Arrays;

/**
 * Created by stameying on 1/5/16.
 */
public class sort_color_II {

    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    /*
    * Count sort
    * */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[] bucket = new int[k];
        for (int color: colors){
            bucket[color-1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++){
            while(bucket[i]>0){
                colors[index++]=i+1;
                bucket[i]--;
            }
        }
    }

    public void sortColors22(int[] colors, int k) {
        // write your code here
        for (int i = 0; i < colors.length; i++){
            while (colors[i] > 0){
                int num = colors[i];
                if (colors[num-1] > 0){
                    colors[i] = colors[num-1];
                    colors[num-1] = -1;
                }else if (colors[num-1] <= 0){
                    colors[num-1]--;
                    colors[i] = 0;
                }
            }
        }

        int index = colors.length-1;
        for (int i = k-1; i >= 0; i--){
            int count = -colors[i];
            if (count == 0) continue;
            while (count > 0){
                colors[index--] = i+1;
                count--;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,1,1,2,2};
        sort_color_II test = new sort_color_II();
        test.sortColors22(arr,2);
        System.out.print(Arrays.toString(arr));
    }
}
