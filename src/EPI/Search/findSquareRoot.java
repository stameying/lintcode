package EPI.Search;

/**
 * Created by stameying on 1/31/16.
 */
public class findSquareRoot {

    public static int squareRoot(int n){
        int low = 0, high = n/2;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (mid * mid == n) return mid;
            else if (mid * mid > n){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high;
    }

    /**
     * x >= 0
     * */
    public static double squareRoot(double x){
        double left, right;
        if (x < 1.0){
            left = x;
            right = 1.0;
        }else{
            left = 1.0;
            right = x;
        }

        while (compare(left,right) == Ordering.SMALLER){
            double mid = left + 0.5*(right-left);
            double midSquare = mid*mid;
            if (compare(midSquare,x) == Ordering.EQUAL){
                return mid;
            }else if (compare(midSquare.x) == Ordering.LARGER){
                right = mid;
            }else{
                left = mid;
            }
        }
        return left;
    }

    public static enum Ordering {SMALLER, EQUAL, LARGER};

    public static Ordering compare(double a, double b){
        final double EPSILON = 0.00001;
        double diff = (a-b)/b;
        return diff < -EPSILON? Ordering.SMALLER: (diff > EPSILON? Ordering.LARGER:Ordering.EQUAL);
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(17));
    }
}
