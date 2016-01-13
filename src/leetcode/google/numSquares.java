package leetcode.google;

/**
 * Created by stameying on 1/13/16.
 */
public class numSquares {

    public int numSquares(int n) {
        if (n == 1) return 1;
        int res = 0;
        while (n > 0){
            int root = getLargestRoot(n);
            System.out.println("root="+root);
            n -= Math.pow(root,2);
            res++;
        }
        return res;
    }

    public int getLargestRoot(int n){
        if (n == 1) return 1;
        int left = 0, right = n;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (mid * mid == n) return mid;
            else if (mid * mid < n){
                left++;
            }else{
                right--;
            }
        }
        return left-1;
    }


    public static void main(String[] args) {
        numSquares test = new numSquares();
        test.numSquares(12);
    }
}
