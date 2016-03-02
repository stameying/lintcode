package src.CodeRound2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 3/1/16.
 */
public class p65 {


    public static boolean validAsAllInteger(String s){
        if (s.length() == 0 ) return true;
        if (s.length() == 1 && s.charAt(0) == '0') return true;
        if (s.charAt(0) == '0') return false;
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] nums = {"00","011","10"};
        List<Boolean> res = new ArrayList<>();
        for (String num: nums){
            res.add(validAsAllInteger(num));
        }
        System.out.println(res);
    }
}
