package src.CodeRound2;

/**
 * Created by stameying on 2/18/16.
 */
public class p9 {

    /***
     *
     * Determine whether an integer is a palindrome. Do this without extra space.
     */

    /*
    * Binary search, only check half
    * */

    public boolean isPalindrome(int x) {
        if (x < 0 || (x!=0 && x % 10 == 0)) return false;
        if (x <= 9) return true;
        int num = x;
        int res = 0;
        while (num > res){
            res = res * 10 + num%10;
            num/=10;
        }
        return ((res==num)||(res/10==num));
    }
}
