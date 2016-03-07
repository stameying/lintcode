package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 3/4/16.
 */
public class big_number_add {

    public static String bigIntegerAdd(String num1, String num2){
        char[] arr1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] arr2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int[] res = new int[Math.max(arr1.length,arr2.length)+1];
        for (int i = 0; i < res.length; i++){
            int digitA = i < arr1.length? (arr1[i]-'0') : 0;
            int digitB = i < arr2.length? (arr2[i]-'0') : 0;
            res[i] = digitA+digitB;
        }


        System.out.println(Arrays.toString(res));

        for (int i = 0; i < res.length; i++){
            if (res[i] >= 10){
                res[i+1] += res[i]/10;
                res[i]%=10;
            }
        }

        System.out.println(Arrays.toString(res));

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = res.length-1; i >= 0; i--) {
            if (res[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "99";

        System.out.println(bigIntegerAdd(num1,num2));
    }
}
