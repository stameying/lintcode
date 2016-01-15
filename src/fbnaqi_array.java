/**
 * Created by stameying on 1/14/16.
 */
public class fbnaqi_array {
    /*
    * 0,1,1,2,3,5,8 ...
    *
    * */

    // recursion
    public int fibonacci(int k){
        if (k == 0) return 0;
        if (k == 1) return 1;
        return fibonacci(k-1)+fibonacci(k-2);
    }

    // iteration
    public int fibonacci2(int k){
        int num1 = 0, num2 = 1;
        for (int i = 2; i <= k; i++){
            int temp = num2;
            num2+= num1;
            num1 = temp;
        }
        return num2;
    }

    // dp
    public int fibonacci3(int k){
        int[] dp = new int[k+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= k; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[k];
    }


    public static void main(String[] args) {
        fbnaqi_array test = new fbnaqi_array();
        // method1
        System.out.println(test.fibonacci(4));

        // method2
        System.out.println(test.fibonacci2(4));

        // method3
        System.out.println(test.fibonacci3(4));

    }
}
