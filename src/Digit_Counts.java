/**
 * Created by stameying on 12/20/15.
 */
public class Digit_Counts {

    /*
    * param k : As description.
    * param n : As description.
    * return: An integer denote the count of digit k in 1..n
    */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++){
            count += getCount(i,k);
        }
        return count;
    }

    public int getCount(int num, int k){
        if (num < 10){
            if (num == k) return 1;
            else return 0;
        }else{
            int digit = num % 10;
            if (digit == k){
                return 1 + getCount(num/10,k);
            }else{
                return getCount(num/10,k);
            }
        }

    }

    /**
     * this one is better than the one I come up with,
     * it convert integer to string
     * */
    public int digitCounts2(int k, int n) {
        // write your code here
        int count = 0;
        char kChar = (char)(k + '0');
        for (int i = 0; i <= n; i++){
            char[] iChars = Integer.toString(i).toCharArray();
            for (char ch: iChars){
                if (ch == kChar) count++;
            }
        }
        return count;
    }
}
