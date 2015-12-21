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


    /**
     * A even better method, mathmatical method
     * */
    public int digitCounts3(int k, int n) {
        // write your code here
        return getCountByMath(n,k);
    }


    /**
     * let d(i) presents the digit on ith place
     * case1 : d(i) > k, then the count of k on this digit = the number before ith place * d(i)
     * case2 : d(i) == k, then the count of k on this digit = the number before ith place * d(i) + the number after ith place + 1
     * case3 : d(i) < k, then the count of k on this digit = (the number before ith place+1) * d(i)
     * */
    public int getCountByMath(int n, int k){
        int count = 0;
        int base = 1;
        int low = 0, high = 0, cur = 0;
        while ( n/base != 0){
            low = n % base;
            cur = (n/base) % 10;
            high = n / (base * 10);
            System.out.println("cur num = " + n + " && low = " + low + " cur = " + cur + " high = " + high + " k = " + k);
            if (cur < k){
                count += high * base;
            }else if (cur == k){
                count += high * base + low + 1;
            }else{
                /* special case for k = 0, when counting the highest digit, like n = 99 and k = 0,
                    now d(0) = 9, high = 0, cur = 9, low = 9, k = 0
                    we don't add the count cuz 01, 02, 03... doesn't exist
                */
                if (k > 0 || high > 0){
                    count += (high+1) * base;
                }
            }
            base *= 10;
        }
        return count;
    }


    public static void main(String[] args) {
        Digit_Counts test = new Digit_Counts();
        System.out.println(test.digitCounts3(0,99));
    }

}
