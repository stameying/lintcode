package leetcode.google;

/**
 * Created by stameying on 1/12/16.
 */
public class Strobogrammatic_Number {

    public boolean isStrobogrammatic(String nums) {
        if (nums.length() == 0) return true;
        int left = 0, right = nums.length()-1;
        while (left < right){
            char ch1 = nums.charAt(left);
            char ch2 = nums.charAt(right);
            left++;
            right--;
            if (ch1 == '0' && ch2 == '0') continue;
            else if (ch1 == '1' && ch2 == '1') continue;
            else if (ch1 == '8' && ch2 == '8') continue;
            else if (ch1 == '6' && ch2 == '9') continue;
            else if (ch1 == '9' && ch2 == '6') continue;
            else{
                return false;
            }
        }
        if (left == right){
            char mid_char = nums.charAt(left);
            if (mid_char == '0' || mid_char == '1' || mid_char == '8') return true;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Math.round(Math.log(10) / Math.log(3)));
        System.out.println("he".substring(2)+"h");
    }
}
