package src.first_round;

/**
 * Created by stameying on 12/20/15.
 */
public class fast_power {

    public int fastPower(int a, int b, int n) {
        // write your code here
        System.out.println("n="+n);
        if (a == b) return 0;
        if (a > b){
            a = a % b;
        }
        if (a == 1) return 1;
        if (n == 0){
            if (b == 1 || b == -1) return 0;
            else return 1;
        }
        else if (n == 1){
            return a % b;
        }else{
            return (fastPower(a,b,n/2) % b) * (fastPower(a,b,n-n/2) % b) % b;
        }
    }

    public static void main(String[] args) {
        fast_power test = new fast_power();
        System.out.println(test.fastPower(2,2147483647,2147483647));
    }
}
