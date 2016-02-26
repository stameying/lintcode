package src.amazon_oa;

import java.util.Arrays;

/**
 * Created by stameying on 2/25/16.
 */
public class p6_sort_array {


    /**
     *
     * 4 , 3, 2, 1 倒序
     *
     * */

    public static int[] sortArray(int[] arr) {
        int len = arr.length;
        int small, pos, i , j , temp;
        for (i = 0; i <= len - 1; i++) {
            for (j = i; j < len; j++) {
                temp = 0;
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }


    /**
     *
     * 4 , 3, 2, 1 倒序
     *
     * */
    public static int[] sortArray2(int arr[]) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            max = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                if (max < arr[j]) { max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
