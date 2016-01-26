package leetcode.google;

/**
 * Created by stameying on 1/25/16.
 */
public class shortest_palindrome {

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int len = s.length(), tail = len;
        StringBuilder builder = new StringBuilder();
        while (tail > 1){
            if (isPalindrome(s.substring(0,tail))){
                builder = builder.append(s.substring(tail,len)).reverse();
                break;
            }
            tail--;
        }
        if (builder.length() == 0){
            builder = builder.append(s.substring(tail, len)).reverse();
        }
        return builder.append(s).toString();
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aacecaaa";
        System.out.println(shortestPalindrome(str));
    }

}
