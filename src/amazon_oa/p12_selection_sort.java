package src.amazon_oa;

import java.util.Arrays;

/**
 * Created by stameying on 2/25/16.
 */
public class p12_selection_sort {

    public static void sort(int[] arr){
        int x, y, n = arr.length;
        for (x = 0; x < n; x++) {
            int index_of_min = x;
            for (y = x; y < n; y++) {
                if (arr[index_of_min] > arr[y]) { // 不是arr[x]
                    index_of_min = y; // 不是x
                }
            }
            // 这一段应该在外面
            int temp = arr[x];
            arr[x] = arr[index_of_min];
            arr[index_of_min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
