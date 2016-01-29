package EPI.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by stameying on 1/29/16.
 */
public class myatoi {

    public static int myAtoi(String str) {
        boolean negative = false;
        int negCnt = 0, posCnt = 0;
        int i = 0;
        for (; i < str.length(); i++){
            if (str.charAt(i) == '+'){
                if (posCnt == 0) posCnt++;
                else return 0;
            }
            else if (str.charAt(i) == '-'){
                if (negCnt == 0){
                    negative = !negative;
                    negCnt++;
                }else return 0;
            }
            else if (str.charAt(i) == ' ') continue;
            else break;
        }
        if (negCnt > 0 && posCnt > 0) return 0;
        int j = i;
        for (; j < str.length(); j++){
            if (!Character.isDigit(str.charAt(j))) break;
        }
        str = str.substring(i,j);
        int thresh = Integer.MAX_VALUE/10;
        System.out.println("str="+str + "; isnegative="+negative + ";thresh="+thresh);
        int res = 0;
        for (i = 0; i < str.length(); i++){
            int digit = str.charAt(i)-'0';
            if (res > thresh) return 0; //overflaw
            else if (res == thresh){
                if (digit <= 7 && !negative && i == str.length()-1) return res*10+digit;
                else if (digit <= 8 && negative && i == str.length()-1){
                    return -1*(res*10+digit);
                }
                else return 0;
            }else{
                res = res * 10 + digit;
            }
        }
        return negative?-res:res;
    }


    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));
        int[] temp = new int[2];
        List<Integer> nums = new ArrayList<>(Arrays.asList(temp));
    }
}
