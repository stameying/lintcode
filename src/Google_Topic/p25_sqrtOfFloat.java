package Google_Topic;

/**
 * Created by stameying on 2/7/16.
 */
public class p25_sqrtOfFloat {

    private static int precise = 0;
    public static double sqrt(double x, int p){
        precise = p;
        double left, right;
        if (x < 1.0){
            left = x;
            right = 1.0;
        }else{
            left = 1.0;
            right = x;
        }

        while (compare(left,right) == Ordering.SMALLER){
            double mid = left + 0.5 * (right-left);
            double square = mid * mid;
            if (compare(square,x) == Ordering.EQUAL) return mid;
            else if (compare(square,x) == Ordering.LARGER) right = mid;
            else left = mid;
        }
        return left;
    }

    public static enum Ordering {SMALLER,EQUAL,LARGER}

    public static Ordering compare(double a, double b){
        double EPSILON = 0.00001;
        double diff = (a-b)/b;
        return diff < -EPSILON? Ordering.SMALLER:(diff > EPSILON? Ordering.LARGER:Ordering.EQUAL);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2,2));
    }
}
