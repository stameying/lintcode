package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/20/16.
 */
public class p43 {
    /**
     * 大数相乘
     * */
    public static String multiply(String num1, String num2) {
        char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] res = new int[n1.length+n2.length];
        int len1 = n1.length;
        int len2 = n2.length;
        for (int i = 0; i < res.length; i++) res[i] = 0;
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                res[i+j] += (int)(n1[i]-'0')*(int)(n2[j]-'0');
            }
        }
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < res.length; i++){
            if (res[i] >= 10){
                res[i+1] += res[i]/10;
                res[i] %= 10;
            }
        }

        // insert res back to stringbuilder
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int i = res.length-1; i>=0; i--){
            if (res[i] == 0 && flag) continue;
            else flag = false;
            builder.append(res[i]);
        }
        if (builder.length() == 0) return "0";
        return builder.toString();
    }

    public static void main(String[] args) {
        String num1 = "5", num2 = "12";
        System.out.println(multiply(num1,num2));
    }
}
