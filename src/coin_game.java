/**
 * Created by stameying on 2/1/16.
 */
public class coin_game {

    public static boolean firstWillWin(int n) {
        // write your code here
        if (n == 0) return false;
        if (n == 1) return true;
        boolean[] res = new boolean[n+1];
        res[0] = false;
        res[1] = true;
        res[2] = true;
        for (int i = 3; i <= n; i++){
            res[i] = !res[i-1] || !res[i-2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(firstWillWin(7));
    }
}
