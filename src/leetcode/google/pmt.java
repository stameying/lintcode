package leetcode.google;

import java.util.Arrays;

/**
 * Created by stameying on 1/25/16.
 */
public class pmt {

    public static int[] pmt(String str){
        char[] arr = str.toCharArray();
        int[] res = new int[str.length()];
        int i = 1, j = 0;
        while ( i < arr.length){
            if (arr[i] == arr[j]){
                res[i++] = ++j;
            }else{
                if (j==0){
                    res[i] = 0;
                    i++;
                }else{
                    j = res[j-1];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(pmt("aabbaabbaa")));
    }
}
