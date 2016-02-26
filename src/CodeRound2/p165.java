package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/25/16.
 */
public class p165 {


    public static int compareVersion(String version1, String version2) {
        if (version1.length() == 0 && version2.length() > 0) return -1;
        if (version1.length() != 0 && version2.length() == 0) return 1;
        if (version1.length() == 0 && version2.length() == 0) return 0;
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int i = 0, j = 0;
        for (; i < v1.length && j < v2.length; i++,j++){
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[j]);
            int res = Integer.compare(num1,num2);
            if (res != 0) return res;
        }
        if (i < v1.length) return 1;
        if (j < v2.length) return -1;
        return 0;
    }

    public static void main(String[] args) {
        String num1 = "1.2";
//        num1 = num1.replace('.',' ');
        String[] v1 = num1.split("\\.");
        System.out.println(Arrays.toString(v1));
    }
}
