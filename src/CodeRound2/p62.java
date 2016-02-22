package src.CodeRound2;

import java.util.Arrays;

/**
 * Created by stameying on 2/21/16.
 */
public class p62 {

    public int uniquePaths(int m, int n) {
        int[] previous = new int[n];
        Arrays.fill(previous,0,n-1,1);
        for (int i = 1; i < m; i++){
            int[] next = new int[n];
            next[0] = 1;
            for (int j = 1; j < n; j++){
                next[j] = next[j-1]+previous[j];
            }
            previous = next;
        }
        return previous[n-1];
    }

    public static void main(String[] args) {
        int[] previous = new int[2];
        Arrays.fill(previous,0,2-1,1);
        System.out.println(Arrays.toString(previous));
    }
}
