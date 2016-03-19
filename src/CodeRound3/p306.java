package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/15/16.
 */
public class p306 {


    public static String BigIntegerAdd(String num1, String num2){
        int[] res = new int[Math.max(num1.length(),num2.length())+1];
        char[] arr1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] arr2 = new StringBuilder(num2).reverse().toString().toCharArray();
        for (int i = 0; i < Math.max(arr1.length,arr2.length); i++){
            int digit1 = i < arr1.length? (int)(arr1[i]-'0'): 0;
            int digit2 = i < arr2.length? (int)(arr2[i]-'0'): 0;
            res[i] = digit1+digit2;
        }

        int carry = 0;
        for (int i = 0; i < res.length; i++){
            res[i] += carry;
            if (res[i] >= 10){
                carry = res[i]/10;
                res[i] %= 10;
            }else{
                carry = 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = res.length-1; i>= 0; i--) builder.append(res[i]);
        String str = builder.toString();
        int pos = 0;
        while (pos < str.length() && builder.charAt(pos) == '0') pos++;
        return str.substring(pos);
    }


    public static void main(String[] args) {
//        String num1 = "349";
//        String num2 = "34911";
//        System.out.println(BigIntegerAdd(num1,num2));

        String str = "1 +     2";

        System.out.println(Arrays.toString(str.split(" ")));
    }
}
