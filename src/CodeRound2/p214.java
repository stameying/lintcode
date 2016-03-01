package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/29/16.
 */
public class p214 {

    /**
     * partial matching table
     * */

    public static String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s).reverse();
        builder.insert(0,s+"#");
        System.out.println(builder.toString());
        int[] arr = new int[builder.length()];
        arr[0] = 0;
        int j = 0, i = 1;
        for (; i < builder.length(); i++){
            if (builder.charAt(i) == builder.charAt(j)){
                arr[i] = ++j;
            }else{
                if (j == 0){
                    arr[i] = 0;
                }else{
                    j = arr[j-1];
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        StringBuilder res = new StringBuilder();
        res.append(s.substring(arr[arr.length-1])).reverse().append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "aabba";
        System.out.println(shortestPalindrome(s));
    }
}
