package EPI.Dynamic_Programming;

/**
 * Created by stameying on 2/3/16.
 */
public class fibonacci {
    public static int fibonacci(int n){
        if (n <= 1) return n;
        int prevprev = 0, prev = 1;
        for (int i = 2; i <= n; i++){
            int next = prevprev+prev;
            prevprev = prev;
            prev = next;
        }
        return prev;
    }

    public static int fibonacci2(int n){
        if (n <= 1) return n;
        return fibonacci2(n-1)+fibonacci2(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci2(5));
    }
}
