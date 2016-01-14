package leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 1/13/16.
 */
public class fractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        String res = "";
        if ((numerator<0)^(denominator<0)) res += "-";
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        long quotient = num / den;
        res += String.valueOf(quotient);
        long reminder = (num % den);
        if (reminder == 0) return res;
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        res += ".";
        while (reminder != 0){
            if (map.containsKey(reminder)){
                int index = map.get(reminder);
                String part1 = res.substring(0, index);
                String part2 = res.substring(index, res.length());
                res = part1 + "(" + part2 + ")";
                return res;
            }
            map.put(reminder,res.length());
            res += (reminder*10/den)+"";
            reminder = reminder * 10 % den;
        }
        return res;
    }

    public static void main(String[] args) {
        fractionToDecimal test = new fractionToDecimal();
        System.out.println(test.fractionToDecimal(-1,-2147483648));
    }
}
