package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/26/16.
 */
public class p214 {

    public static int[] buildPMT(char[] arr){
        int j = 0, i = 1;
        int[] pmt = new int[arr.length];
        int cnt = 0;
        while (i < arr.length && cnt++ < 30){
            System.out.println("char1=" +arr[i]+",char2="+arr[j]);
            if (arr[i] == arr[j]){
                pmt[i++] = ++j;
            }else{
                if (j == 0){
                    pmt[i++] = 0;
                }else{
                    j = pmt[j-1];
                }
            }
//            System.out.println(Arrays.toString(pmt));
        }
        return pmt;
    }

    public static void main(String[] args) {
        char[] arr = "abababca".toCharArray();
        System.out.println(Arrays.toString(buildPMT(arr)));

    }
}
