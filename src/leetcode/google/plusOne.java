package leetcode.google;

/**
 * Created by stameying on 1/12/16.
 */
public class plusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--){
            digits[i] += carry;
            if (digits[i] > 9){
                carry = 1;
                digits[i] %= 10;
            }else{
                return digits;
            }
        }
        if (carry == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }else{
            return digits;
        }
    }
}
